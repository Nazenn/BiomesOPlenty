/*******************************************************************************
 * Copyright 2014, the Biomes O' Plenty Team
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * 
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package biomesoplenty.common.item;

import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBiomeEssence extends Item
{
    public ItemBiomeEssence() {}
    
    @Override
    public boolean hasContainerItem(ItemStack itemStack)
    {
        return true;
    }
    
    // TODO: really?  this looks well dodgy.
    @Override
    public ItemStack getContainerItem(ItemStack itemStack)
    {
        return itemStack;
    }    
    
    public BiomeGenBase getBiome(ItemStack itemStack)
    {
        if (itemStack.hasTagCompound() && itemStack.getTagCompound().hasKey("biomeID"))
        {
            return BiomeGenBase.getBiome(itemStack.getTagCompound().getInteger("biomeID"));
        }
        return null;
    }
    
    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List infoList, boolean advancedItemTooltips)
    {
        BiomeGenBase biome = this.getBiome(itemStack);
        if (biome != null)
        {
            infoList.add(biome.biomeName);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getColorFromItemStack(ItemStack itemStack, int tintIndex)
    {
        BiomeGenBase biome = this.getBiome(itemStack);
        return biome == null ? 0xFFFFFF : biome.color;
    }
    
    @Override
    public boolean hasEffect(ItemStack itemStack)
    {
        return true;
    }

    
}
package com.js.noname.item;

import com.js.noname.handler.CreativeTabHandler;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemSeedFood;
import net.minecraft.item.ItemStack;

public class ItemTomato extends ItemSeedFood{

	private String filename = "noname:tomato";
	
	public ItemTomato(int id, int healAmount, float saturation, int cropId, int soilId) {
		super(id, healAmount, saturation, cropId, soilId);
		
		this.setCreativeTab(CreativeTabHandler.tabNoname);
		this.setUnlocalizedName("tomato");
	}

	public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 10;
    }
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg){
		this.itemIcon = reg.registerIcon(filename);
	}
	
}

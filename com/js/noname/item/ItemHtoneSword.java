package com.js.noname.item;

import com.js.noname.handler.CreativeTabHandler;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemHtoneSword extends ItemSword{

	private String filename = "noname:htone_sword";
	
	public ItemHtoneSword(int id, EnumToolMaterial material) {
		super(id, material);
		this.getIsRepairable(new ItemStack(ModItems.itemHtoneIngot), new ItemStack(ModItems.itemHtoneIngot));
		this.setCreativeTab(CreativeTabHandler.tabNoname);
		this.setUnlocalizedName("swordHtone");
	}


	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg){
		this.itemIcon = reg.registerIcon(filename);
	}
}

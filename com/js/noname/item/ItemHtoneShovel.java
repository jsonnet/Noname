package com.js.noname.item;

import com.js.noname.handler.CreativeTabHandler;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSpade;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemHtoneShovel extends ItemSpade{
	
	private String filename = "noname:htone_shovel";

	public ItemHtoneShovel (int id, EnumToolMaterial material){
		super(id, material);
		this.setUnlocalizedName("shovelHtone");
		this.setCreativeTab(CreativeTabHandler.tabNoname);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg) {
	this.itemIcon = reg.registerIcon(filename);
	}
}

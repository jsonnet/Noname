package com.js.noname.item;

import com.js.noname.handler.CreativeTabHandler;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemHtoneIngot extends Item {

	private String filename = "noname:htone_ingot";
	
	public ItemHtoneIngot(int id) {
		super(id);
		this.setMaxStackSize(64);
		this.setUnlocalizedName("ingotHtone");
		this.setCreativeTab(CreativeTabHandler.tabNoname);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg){
		this.itemIcon = reg.registerIcon(filename);
	}
	
}

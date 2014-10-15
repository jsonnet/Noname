package com.js.noname.item;

import com.js.noname.handler.CreativeTabHandler;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemHtoneNugget extends Item {
	
	private String filename = "noname:htone_nugget";
	
	public ItemHtoneNugget(int id) {
		super(id);
		this.setMaxStackSize(64);
		this.setUnlocalizedName("nuggetHtone");
		this.setCreativeTab(CreativeTabHandler.tabNoname);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg){
		this.itemIcon = reg.registerIcon(filename);
	}
}

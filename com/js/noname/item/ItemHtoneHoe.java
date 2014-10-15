package com.js.noname.item;

import com.js.noname.handler.CreativeTabHandler;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemHoe;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemHtoneHoe extends ItemHoe {

	private String filename = "noname:htone_hoe";
	
	public ItemHtoneHoe(int id, EnumToolMaterial material) {
		super(id, material);
		this.setCreativeTab(CreativeTabHandler.tabNoname);
		this.setUnlocalizedName("hoeHtone");
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg) {
		this.itemIcon = reg.registerIcon(filename);
	}

}

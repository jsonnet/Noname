package com.js.noname.item;

import com.js.noname.handler.CreativeTabHandler;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemHtonePickaxe extends ItemPickaxe {

	private String filename = "noname:htone_pickaxe";
	
	public ItemHtonePickaxe(int id, EnumToolMaterial material) {
		super(id, material);
		
		this.setCreativeTab(CreativeTabHandler.tabNoname);
		this.setUnlocalizedName("pickaxeHtone");
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg) {
		this.itemIcon = reg.registerIcon(filename);
	}
	 
}

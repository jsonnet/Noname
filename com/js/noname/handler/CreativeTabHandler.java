package com.js.noname.handler;

import com.js.noname.item.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreativeTabHandler extends CreativeTabs {
	
	String iconstr;
	public static CreativeTabs tabNoname = new CreativeTabHandler(CreativeTabs.getNextID(), "Noname Mod Basic", "basic");
	public static CreativeTabs tabNoname2 = new CreativeTabHandler(CreativeTabs.getNextID(), "Noname Mod Industrial", "industrial");

	
	public CreativeTabHandler(int id, String par2Str, String iconstr) {
		super(id, par2Str);
		this.iconstr = iconstr;
	}
  
	@SideOnly(Side.CLIENT)
	public ItemStack getIconItemStack() {
		if(iconstr == "basic") {
			return new ItemStack(ModItems.itemHtoneIngot);
		} else {
			return new ItemStack(ModItems.itemBattery);
		}
	}
	
	
	@Override
	public String getTranslatedTabLabel() {
		return "Noname/JSCraft";
	}
}
package com.js.noname.handler;

import com.js.noname.item.ModItems;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel) {
		
		if(fuel.itemID == ModItems.itemEnrichedCoal.itemID) return 3200;
		//return fuel.stackSize;
		return 0;
	}

}

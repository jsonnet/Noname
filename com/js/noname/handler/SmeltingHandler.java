package com.js.noname.handler;

import com.js.noname.block.ModBlocks;
import com.js.noname.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class SmeltingHandler {
	
	public static void initSmeltingRecepies() {
		
		GameRegistry.addSmelting(ModBlocks.blockHtoneOre.blockID, new ItemStack(ModItems.itemHtoneIngot), 0.7F);
		GameRegistry.addSmelting(ModBlocks.blockNetherGlass.blockID, new ItemStack(ModBlocks.blockHardenedNetherGlass), 0.2F);
		GameRegistry.addSmelting(Block.sandStone.blockID, new ItemStack(Block.glass), 0.2F);
		
	}
}

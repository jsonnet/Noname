package com.js.noname.handler;

import com.js.noname.block.ModBlocks;
import com.js.noname.item.ItemBattery;
import com.js.noname.item.ItemHtoneIngot;
import com.js.noname.item.ModItems;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class CraftingHandler{

	public static void initCraftingRecipes() {
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockHtone), new Object[] {"XXX", "XXX", "XXX", 'X', ModItems.itemHtoneIngot});
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockRechargeStationIdle, 2), new Object[] {"XXX","XYX","XXX", 'X', ModItems.itemHtoneIngot, 'Y', ModItems.itemBattery});
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockHeater), new Object[] {"#B#" ,"/F/" ,"#R#", '#',Block.fenceIron, 'B', Item.blazePowder, '/', Item.blazeRod, 'F', Block.furnaceIdle, 'R', Item.redstone});
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockNetherGlass, 8), new Object[] {"XXX", "XSX", "XXX", 'X', Block.glass, 'S', ItemHtoneIngot.netherStar});
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockUTnt, 2), new Object[] {"GSG", "SHS", "GSG", 'G', Item.gunpowder, 'S', Block.sand, 'H', ModItems.itemHtoneIngot});
		GameRegistry.addRecipe(new ItemStack(ModItems.itemHtoneIngot, 9), new Object[] {"#", '#', ModBlocks.blockHtone});
		GameRegistry.addRecipe(new ItemStack(ModItems.itemFurnaceStick, 1), new Object[] {" F", "S ", 'F', Block.furnaceIdle, 'S', Item.stick} );
		GameRegistry.addRecipe(new ItemStack(ModItems.itemCraftingStick, 1), new Object[] {" C", "S ", 'C', Block.workbench, 'S', Item.stick} );
		GameRegistry.addRecipe(new ItemStack(ModItems.itemHtoneNugget, 9), new Object[] {"#", '#', ModItems.itemHtoneIngot});
		GameRegistry.addRecipe(new ItemStack(ModItems.itemHtoneIngot), new Object[] {"XXX", "XXX", "XXX", 'X', ModItems.itemHtoneNugget});
		GameRegistry.addRecipe(new ItemStack(ModItems.itemBattery, 1, ModItems.itemBattery.getMaxDamage()), new Object[] {" X ", "HXH", "HXH", 'X', Item.redstone, 'H', ModItems.itemHtoneIngot});
		GameRegistry.addRecipe(new ItemStack(Item.dyePowder, 2, 6), new Object[] {"#", '#', ModBlocks.blockCyanFlower});
		GameRegistry.addRecipe(new ItemStack(Item.dyePowder, 2, 14), new Object[] {"#", '#', ModBlocks.blockOrangeFlower});
		GameRegistry.addRecipe(new ItemStack(Item.dyePowder, 2, 5), new Object[] {"#", '#', ModBlocks.blockPurpleFlower});
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockConcrete, 4), new Object[] {"SIS", "ISI", "SIS", 'S', Block.stone, 'I', Item.ingotIron});
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockConcrete, 8), new Object[] {"SIS", "ISI", "SIS", 'S', Block.stone, 'I', ModItems.itemHtoneIngot});
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockStairConcrete, 4), new Object[] {"C  ", "CC ", "CCC", 'C', ModBlocks.blockConcrete} );
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockStairConcrete, 4), new Object[] {"  C", " CC", "CCC", 'C', ModBlocks.blockConcrete} );
		GameRegistry.addRecipe(new ItemStack(ModItems.itemHtoneAxe, 1), new Object[] {"HH ", "HS ", " S ", 'H', ModItems.itemHtoneIngot, 'S', Item.stick} );
		GameRegistry.addRecipe(new ItemStack(ModItems.itemHtoneHoe, 1), new Object[] {"HH ", " S ", " S ", 'H', ModItems.itemHtoneIngot, 'S', Item.stick} );
		GameRegistry.addRecipe(new ItemStack(ModItems.itemHtonePickaxe, 1), new Object[] {"HHH", " S ", " S ", 'H', ModItems.itemHtoneIngot, 'S', Item.stick} );
		GameRegistry.addRecipe(new ItemStack(ModItems.itemHtoneShovel, 1), new Object[] {" H ", " S ", " S ", 'H', ModItems.itemHtoneIngot, 'S', Item.stick} );
		GameRegistry.addRecipe(new ItemStack(ModItems.itemHtoneSword, 1), new Object[] {" H ", " H ", " S ", 'H', ModItems.itemHtoneIngot, 'S', Item.stick} );
		GameRegistry.addRecipe(new ItemStack(ModItems.itemDrill, 1), new Object[] {"  H", " C ", "B  ", 'H', ModItems.itemHtoneIngot, 'C', Item.comparator, 'B', ModItems.itemBattery} );
		GameRegistry.addRecipe(new ItemStack(ModItems.itemArmorHtoneHelmet, 1), new Object[] {"HHH", "H H", 'H', ModItems.itemHtoneIngot,} );
		GameRegistry.addRecipe(new ItemStack(ModItems.itemArmorHtonePlate, 1), new Object[] {"H H", "HHH", "HHH", 'H', ModItems.itemHtoneIngot} );
		GameRegistry.addRecipe(new ItemStack(ModItems.itemArmorHtoneLegs, 1), new Object[] {"HHH", "H H", "H H", 'H', ModItems.itemHtoneIngot,} );
		GameRegistry.addRecipe(new ItemStack(ModItems.itemArmorHtoneBoots, 1), new Object[] {"H H", "H H", 'H', ModItems.itemHtoneIngot,} );
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockLavastone, 1), new Object[] {"SSS", "SBS", "SSS", 'S', Block.stone, 'B', Item.bucketLava } );
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockWaterstone, 1), new Object[] {"SSS", "SBS", "SSS", 'S', Block.stone, 'B', Item.bucketWater} );
        GameRegistry.addRecipe(new ItemStack(ModBlocks.blockFramedGlass, 8), new Object[] {"GGG", "GSG", "GGG", 'G', Block.glass, 'S', Item.stick} );
        GameRegistry.addRecipe(new ItemStack(ModBlocks.blockHtoneBars, 16), new Object[] {"HHH", "HHH", 'H', ModItems.itemHtoneIngot} );
	}	
}

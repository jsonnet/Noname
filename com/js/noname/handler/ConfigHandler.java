package com.js.noname.handler;

import java.io.File;

import com.js.noname.block.BlockIds;
import com.js.noname.item.ItemIds;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.oredict.RecipeSorter.Category;
import net.minecraftforge.common.Property;

public class ConfigHandler {
	
	public static Configuration config;
	
	public static boolean testBool = true;
	public static String testString = "nix";
	
	public static void init(File configFile) {
    
		final String BOOLEANS = config.CATEGORY_GENERAL + " boolean";
		final String CATEGORY_ITEMMACHINE = config.CATEGORY_ITEM + " machine";
		final String CATEGORY_BLOCKMACHINE = config.CATEGORY_BLOCK + " machine";
		
		config = new Configuration(configFile);
        
        config.load();
        
        ItemIds.itemHtoneIngot = config.get(Configuration.CATEGORY_ITEM, "ingotHtone", ItemIds.itemHtoneIngot_Default).getInt() - 256;
	    ItemIds.itemHtoneNugget = config.get(Configuration.CATEGORY_ITEM, "nuggetHtone", ItemIds.itemHtoneNugget_Default).getInt() - 256;
	    ItemIds.itemHtoneAxe = config.get(Configuration.CATEGORY_ITEM, "axeHtone", ItemIds.itemHtoneAxe_Default).getInt() - 256;
	    ItemIds.itemHtonePickaxe = config.get(Configuration.CATEGORY_ITEM, "pickaxeHtone", ItemIds.itemHtonePickaxe_Default).getInt() - 256;
	    ItemIds.itemHtoneSword = config.get(Configuration.CATEGORY_ITEM, "swordHtone", ItemIds.itemHtoneSword_Default).getInt() - 256;
	    ItemIds.itemHtoneShovel = config.get(Configuration.CATEGORY_ITEM, "shovelHtone", ItemIds.itemHtoneShovel_Default).getInt() - 256;
	    ItemIds.itemHtoneHoe = config.get(Configuration.CATEGORY_ITEM, "hoeHtone", ItemIds.itemHtoneHoe_Default).getInt() - 256;
	    ItemIds.itemFurnaceStick = config.get(Configuration.CATEGORY_ITEM, "furnaceStick", ItemIds.itemFurnaceStick_Default).getInt() - 256;
	    ItemIds.itemCraftingStick = config.get(Configuration.CATEGORY_ITEM, "craftingStick", ItemIds.itemCraftingStick_Default).getInt() - 256;
	    ItemIds.itemTomato = config.get(Configuration.CATEGORY_ITEM, "tomato", ItemIds.itemTomato_Default).getInt() - 256;
	    ItemIds.itemEnrichedCoal = config.get(Configuration.CATEGORY_ITEM, "enrichedCoal", ItemIds.itemEnrichedCoal_Default).getInt() - 256;
	    ItemIds.itemBucketGas = config.get(Configuration.CATEGORY_ITEM, "bucketGas", ItemIds.itemBucketGas_Default).getInt() - 256;
	    ItemIds.itemBucketMoltenStone = config.get(Configuration.CATEGORY_ITEM, "bucketMoltenStone", ItemIds.itemBucketMoltenStone_Default).getInt() - 256;
	    ItemIds.itemArmorHtoneHelmet = config.get(Configuration.CATEGORY_ITEM, "armorHtoneHelmet", ItemIds.itemArmorHtoneHelmet_Default).getInt() - 256;
	    ItemIds.itemArmorHtonePlate = config.get(Configuration.CATEGORY_ITEM, "armorHtonePlate", ItemIds.itemArmorHtonePlate_Default).getInt() - 256;
	    ItemIds.itemArmorHtoneLegs = config.get(Configuration.CATEGORY_ITEM, "armorHtoneLegs", ItemIds.itemArmorHtoneLegs_Default).getInt() - 256;
	    ItemIds.itemArmorHtoneBoots = config.get(Configuration.CATEGORY_ITEM, "armorHtoneBoots", ItemIds.itemArmorHtoneBoots_Default).getInt() - 256;
	    
	    ItemIds.itemDrill = config.get(CATEGORY_ITEMMACHINE, "drill", ItemIds.itemDrill_Default, "Electric Drill").getInt() - 256;
	    ItemIds.itemBattery = config.get(CATEGORY_ITEMMACHINE, "battery", ItemIds.itemBattery_Default, "Electric Battery").getInt() - 256;
	    
	    BlockIds.blockHtoneOre = config.get(Configuration.CATEGORY_BLOCK, "oreHtone", BlockIds.blockHtoneOre_Default).getInt();
	    BlockIds.blockHtoneNetherOre = config.get(Configuration.CATEGORY_BLOCK, "oreNetherHtone", BlockIds.blockHtoneNetherOre_Default).getInt();
	    BlockIds.blockHtone = config.get(Configuration.CATEGORY_BLOCK, "blockHtone", BlockIds.blockHtone_Default).getInt();
	    BlockIds.blockOven = config.get(Configuration.CATEGORY_BLOCK, "blockOven", BlockIds.blockOven_Default).getInt();
	    BlockIds.blockNetherGlass = config.get(Configuration.CATEGORY_BLOCK, "netherGlass", BlockIds.blockNetherGlass_Default).getInt();
	    BlockIds.blockHardenedNetherGlass = config.get(Configuration.CATEGORY_BLOCK, "hardenedNetherGlass", BlockIds.blockHardenedNetherGlass_Default).getInt();
	    BlockIds.blockUTnt = config.get(Configuration.CATEGORY_BLOCK, "uTnt", BlockIds.blockUTnt_Default).getInt();
	    BlockIds.blockCyanFlower = config.get(Configuration.CATEGORY_BLOCK, "flowerCyan", BlockIds.blockCyanFlower_Default).getInt();
	    BlockIds.blockOrangeFlower = config.get(Configuration.CATEGORY_BLOCK, "flowerOrange", BlockIds.blockOrangeFlower_Default).getInt();
	    BlockIds.blockPurpleFlower = config.get(Configuration.CATEGORY_BLOCK, "flowerPurple", BlockIds.blockPurpleFlower_Default).getInt();
	    BlockIds.blockConcrete = config.get(Configuration.CATEGORY_BLOCK, "blockConcrete", BlockIds.blockConcrete_Default).getInt();
	    BlockIds.blockHalfSlabConcrete = config.get(Configuration.CATEGORY_BLOCK, "blockSlabConcrete", BlockIds.blockHalfSlabConcrete_Default).getInt();
	    BlockIds.blockStairConcrete = config.get(Configuration.CATEGORY_BLOCK, "blockStairConcrete", BlockIds.blockStairConcrete_Default).getInt();
	    BlockIds.blockTomato = config.get(Configuration.CATEGORY_BLOCK, "plantedTomato", BlockIds.blockTomato_Default, "The Block you place down on dirt").getInt();
	    BlockIds.blockLavastone = config.get(Configuration.CATEGORY_BLOCK, "lavastone", BlockIds.blockLavastone_Default).getInt();
	    BlockIds.blockWaterstone = config.get(Configuration.CATEGORY_BLOCK, "waterstone", BlockIds.blockWaterstone_Default).getInt();
	    BlockIds.blockFramedGlass = config.get(Configuration.CATEGORY_BLOCK, "framedglass", BlockIds.blockFramedGlass_Default).getInt();
	    BlockIds.blockHtoneBars = config.get(Configuration.CATEGORY_BLOCK, "htonebars", BlockIds.blockHtoneBars_Default).getInt();
	    
	    BlockIds.blockHeater = config.get(CATEGORY_BLOCKMACHINE, "heater", BlockIds.blockHeater_Default, "Heater for a furnace").getInt();
	    BlockIds.blockRechargeStationIdle = config.get(CATEGORY_BLOCKMACHINE, "rechargeStation", BlockIds.blockRechargeStationIdle_Default, "Charge your electric stuff").getInt();
	    BlockIds.blockRebuilderIdle = config.get(CATEGORY_BLOCKMACHINE, "rebuilder", BlockIds.blockRebuilderIdle_Default, "Repair nearly brocken stuff").getInt();   
	    BlockIds.blockFurnaceIdle = config.get(CATEGORY_BLOCKMACHINE, "furnace", BlockIds.blockFurnaceIdle_Default, "Smelt quicker").getInt();
	    
	    testBool = config.get(BOOLEANS, "easyflightmode", true, "Set to false to get fall damage when no levels available").getBoolean(true);
	    testString = config.get(BOOLEANS, "howtocall", "test", "test0").getString();
	    
	    if(config.hasChanged()) config.save();
	}
	
}

 package com.js.noname.block;

import com.js.noname.fluid.ModFluids;
import com.js.noname.handler.CreativeTabHandler;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.*;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModBlocks {

	public static Block blockHtoneOre;
	public static Block blockHtoneNetherOre;
	public static Block blockHtone;
	public static Block blockHeater;
	public static Block blockRechargeStationIdle;
	public static Block blockRechargeStationActive;
	public static Block blockFurnaceIdle;
	public static Block blockFurnaceActive;
	public static Block blockRebuilderIdle;
	public static Block blockRebuilderActive;
	public static Block blockOven;
	public static Block blockNetherGlass;
	public static Block blockHardenedNetherGlass;
	public static Block blockUTnt;
	public static Block blockCyanFlower;
	public static Block blockOrangeFlower;
	public static Block blockPurpleFlower;
	public static Block blockConcrete;
	public static Block blockHalfSlabConcrete;
	public static Block blockDoubleSlabConcrete;
	public static Block blockStairConcrete;
	public static Block blockTomato;
	public static Block blockLavastone;
	public static Block blockWaterstone;
	public static Block blockFramedGlass;
	public static Block blockHtoneBars;
    
	public static Block blockFluidGas;
	public static Block blockFluidMoltenStone;
	
	public static void init() {
		
		blockHtoneOre = new BlockHtoneOre(BlockIds.blockHtoneOre);
		blockHtoneNetherOre = new BlockHtoneNetherOre(BlockIds.blockHtoneNetherOre);
		blockHtone = new BlockHtone(BlockIds.blockHtone, Material.iron);
		blockHeater = new BlockMachineHeater(BlockIds.blockHeater, Material.piston);
		blockNetherGlass = new BlockNetherGlass(BlockIds.blockNetherGlass, Material.glass);
		blockHardenedNetherGlass = new BlockHardenedNetherGlass(BlockIds.blockHardenedNetherGlass, Material.glass, true);
		blockUTnt = new BlockUTnt(BlockIds.blockUTnt);
		blockCyanFlower = new BlockCyanFlower(BlockIds.blockCyanFlower);
		blockOrangeFlower = new BlockOrangeFlower(BlockIds.blockOrangeFlower);
		blockPurpleFlower = new BlockPurpleFlower(BlockIds.blockPurpleFlower);
		blockConcrete = new BlockConcrete(BlockIds.blockConcrete, Material.rock);
		//blockHalfSlabConcrete = new BlockSlabConcrete(BlockIds.blockHalfSlabConcrete_Default, false, Material.rock);
		//blockDoubleSlabConcrete = new BlockSlabConcrete(BlockIds.blockDoubleSlabConcrete, true, Material.rock);
		blockStairConcrete = new BlockStairConcrete(BlockIds.blockStairConcrete, blockConcrete);
		blockTomato = new BlockTomato(BlockIds.blockTomato);
		blockLavastone = new BlockLavastone(BlockIds.blockLavastone, Material.rock);
		blockWaterstone = new BlockWaterstone(BlockIds.blockWaterstone, Material.rock);
		blockFramedGlass = new BlockFramedGlass(BlockIds.blockFramedGlass, Material.glass, true);
		blockHtoneBars = new BlockHtoneBars(BlockIds.blockHtoneBars, "noname:htone_bars", "noname:htone_bars", Material.iron, true);
		
		blockRechargeStationIdle = new BlockMachineRechargeStation(BlockIds.blockRechargeStationIdle, Material.iron, false).setUnlocalizedName("rechargestation_idle");
		blockRechargeStationActive = new BlockMachineRechargeStation(BlockIds.blockRechargeStationActive, Material.iron, true).setUnlocalizedName("rechargestation_active");
		blockOven = new BlockOvenpart(BlockIds.blockOven, Material.rock);
		blockFurnaceIdle = new BlockMachineFurnace(BlockIds.blockFurnaceIdle, Material.iron, false).setUnlocalizedName("furnace_idle");
		blockFurnaceActive = new BlockMachineFurnace(BlockIds.blockFurnaceActive, Material.iron, true).setUnlocalizedName("furnace_active");
		blockRebuilderIdle = new BlockMachineRebuilder(BlockIds.blockRebuilderIdle, Material.iron, false).setUnlocalizedName("rebuilder_idle");
		blockRebuilderActive = new BlockMachineRebuilder(BlockIds.blockRebuilderActive, Material.iron, true).setUnlocalizedName("rebuilder_active");
	
		registerBlock(blockHtoneOre, "Htone Ore");
		registerBlock(blockHtoneNetherOre, "Htone Nether Ore");
		registerBlock(blockHtone, "Block of Htone");
		registerBlock(blockHeater, "Heater");
		registerBlock(blockRechargeStationIdle, "Recharge Station");
		registerBlock(blockRechargeStationActive, "Recharge Station");
		registerBlock(blockFurnaceIdle, "Electric Furnace");
		registerBlock(blockFurnaceActive, "Electric Furnace");
		registerBlock(blockRebuilderIdle, "Rebuilder");
		registerBlock(blockRebuilderActive, "Rebuilder");
		registerBlock(blockOven, "Oven Part");
		registerBlock(blockNetherGlass, "Nether Glass");
		registerBlock(blockHardenedNetherGlass, "Hardened Nether Glass");
		registerBlock(blockUTnt, "UTnt");
		registerBlock(blockCyanFlower, "Cyan Flower");
		registerBlock(blockOrangeFlower, "Orange Flower");
		registerBlock(blockPurpleFlower, "Purple Flower");
		registerBlock(blockConcrete, "Concrete");
		//registerBlock(blockHalfSlabConcrete, "Concrete Slab");
		//registerBlock(blockDoubleSlabConcrete, "Concrete Slab");
		registerBlock(blockStairConcrete, "Concrete Stair");
		registerBlock(blockTomato, "Tomato");
        registerBlock(blockLavastone, "Lavastone");
        registerBlock(blockWaterstone, "Waterstone");
        registerBlock(blockFramedGlass, "Framed Glass");
        registerBlock(blockHtoneBars, "Htone Bars");
	}
	
	public static void initFluidBlocks(){
		blockFluidGas = new BlockFluidGas(ModFluids.idFluidGas);
		blockFluidMoltenStone = new BlockFluidMoltenStone(ModFluids.idFluidMoltenStone).setTextureName("stone");
		
		registerBlock(blockFluidGas, "Liquid Gas");
		registerBlock(blockFluidMoltenStone, "Molten Stone");
	}
	
	public static void registerBlock(Block block, String name) {
		GameRegistry.registerBlock(block, block.getUnlocalizedName());
		LanguageRegistry.addName(block, name);
		//MinecraftForge.setBlockHarvestLevel(block, "pickaxe", 0);
	}
	
}

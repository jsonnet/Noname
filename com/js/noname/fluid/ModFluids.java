package com.js.noname.fluid;

import com.js.noname.block.ModBlocks;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class ModFluids {

	public static Fluid fluidGas;
	public static Fluid fluidMoltenStone;
	
	public static Material materialFluidGas;
	public static Material materialFluidMoltenStone;
	
	public static final int idFluidGas = 240;
	public static final int idFluidMoltenStone = 241;
	
	public static void init() {
		
		fluidGas = new Fluid("gas").setBlockID(idFluidGas).setGaseous(true).setDensity(200);
		fluidMoltenStone = new Fluid("moltenstone").setBlockID(idFluidMoltenStone).setDensity(600);
		
		registerFluid(fluidGas, "Gas");
		registerFluid(fluidMoltenStone, "Molten Stone");
		
		materialFluidGas = (new MaterialLiquid(MapColor.ironColor));
		materialFluidMoltenStone = new MaterialLiquid(MapColor.clayColor);
		
		ModBlocks.initFluidBlocks();
	}
	
	public static void registerFluid(Fluid fluid, String name) {
		FluidRegistry.registerFluid(fluid);
	}
	
}

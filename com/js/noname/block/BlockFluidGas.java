package com.js.noname.block;

import com.js.noname.fluid.ModFluids;
import com.js.noname.handler.CreativeTabHandler;
import com.js.noname.reference.Names;
import com.js.noname.reference.Textures;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.BlockFluidClassic;

public class BlockFluidGas extends BlockFluidClassic {

	public BlockFluidGas(int id) {
		super(id, ModFluids.fluidGas, Material.water);
			//ModFluids.materialFluidGas
		this.setUnlocalizedName(Names.Blocks.FLUIDGAS);
		this.setCreativeTab(CreativeTabHandler.tabNoname2);
		this.setTextureName(Textures.Blocks.PATHFLUIDGAS);
		this.setLightOpacity(3);
	}

}

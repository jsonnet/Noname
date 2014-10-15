package com.js.noname.block;

import com.js.noname.fluid.ModFluids;
import com.js.noname.handler.CreativeTabHandler;
import com.js.noname.reference.Names;
import com.js.noname.reference.Textures;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.BlockFluidClassic;

public class BlockFluidMoltenStone extends BlockFluidClassic {

	public BlockFluidMoltenStone(int id) {
		super(id, ModFluids.fluidMoltenStone, Material.water);
			//ModFluids.materialFluidMoltenStone
		this.setUnlocalizedName(Names.Blocks.FLUIDMOLTENSTONE);
		this.setCreativeTab(CreativeTabHandler.tabNoname2);
		this.setTextureName(Textures.Blocks.PATHFLUIDMOLTENSTONE);
		this.setLightOpacity(1);
	}

}
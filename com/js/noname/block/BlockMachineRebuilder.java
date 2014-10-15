package com.js.noname.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import com.js.noname.handler.CreativeTabHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class BlockMachineRebuilder extends Block{

	private boolean isActive;
	
	public BlockMachineRebuilder(int id, Material material, boolean isActive) {
		super(id, material);
		
		this.isActive = isActive;
		this.setStepSound(soundStoneFootstep);
		this.setResistance(10.0F);
		this.setHardness(2.0F);
		
		if(!isActive){
			this.setCreativeTab(CreativeTabHandler.tabNoname2);
			this.setLightValue(0.3F);
		}
	}
	
	public int idDropped(int par1, Random par2Random, int par3){
		return ModBlocks.blockRebuilderIdle.blockID;
	} 
	
	@SideOnly(Side.CLIENT)
	public int idPicked(World par1World, int par2, int par3, int par4)
	{
		return ModBlocks.blockRebuilderIdle.blockID;
	}

	public void onBlockAdded(World world, int x, int y, int z){
		super.onBlockAdded(world, x, y, z);
		this.setDefaultDirection(world, x, y, z);
	}
	
	private void setDefaultDirection(World par1World, int par2, int par3, int par4){
		if (!par1World.isRemote){
			int l = par1World.getBlockId(par2, par3, par4 - 1);
			int i1 = par1World.getBlockId(par2, par3, par4 + 1);
			int j1 = par1World.getBlockId(par2 - 1, par3, par4);
			int k1 = par1World.getBlockId(par2 + 1, par3, par4);
			byte b0 = 3;

			if (Block.opaqueCubeLookup[l] && !Block.opaqueCubeLookup[i1]){
				b0 = 3;
			}

			if (Block.opaqueCubeLookup[i1] && !Block.opaqueCubeLookup[l]){
				b0 = 2;
			}

			if (Block.opaqueCubeLookup[j1] && !Block.opaqueCubeLookup[k1]){
				b0 = 5;
			}

			if (Block.opaqueCubeLookup[k1] && !Block.opaqueCubeLookup[j1]){
				b0 = 4;
			}
			par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 2);
		}
	}

}

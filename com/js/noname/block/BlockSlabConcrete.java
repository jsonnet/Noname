package com.js.noname.block;

import java.util.Random;

import com.js.noname.handler.CreativeTabHandler;
import com.js.noname.reference.Names;
import com.js.noname.reference.Textures;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;

public class BlockSlabConcrete extends BlockHalfSlab{
	
	public BlockSlabConcrete(int id, boolean isfullblock, Material material) {
		super(id, isfullblock, material);
		
		this.setResistance(20.0F);
		this.setStepSound(soundStoneFootstep);
		this.setHardness(6.0F);
		
		if(!isfullblock){
			this.setCreativeTab(CreativeTabHandler.tabNoname);
			this.setUnlocalizedName(Names.Blocks.SLABCONCRETE);
			this.useNeighborBrightness[id] = true;
		}else{
			this.setUnlocalizedName("doubleslabconcrete");
		}
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg) {
		this.blockIcon = reg.registerIcon(Textures.Blocks.PATHCONCRETE);
	}

	public String getFullSlabName(int i) {
		return super.getUnlocalizedName();
	}

	@SideOnly(Side.CLIENT)
	public int idPicked(World world, int x, int y, int z){
		return ModBlocks.blockHalfSlabConcrete.blockID;
	}
    
	@SideOnly(Side.CLIENT)
    public int idDropped(int par1, Random par2Random, int par3){
		return ModBlocks.blockHalfSlabConcrete.blockID;
	} 
}

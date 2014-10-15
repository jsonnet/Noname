package com.js.noname.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import com.js.noname.handler.CreativeTabHandler;
import com.js.noname.reference.Names;
import com.js.noname.reference.Textures;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraftforge.common.MinecraftForge;

public class BlockConcrete extends Block{
	
	public BlockConcrete(int id, Material material) {
		super(id, material);
		
		this.setUnlocalizedName(Names.Blocks.CONCRETE);
		this.setResistance(20.0F);
		this.setStepSound(soundStoneFootstep);
		this.setCreativeTab(CreativeTabHandler.tabNoname);
		this.setHardness(6.0F);
		//MinecraftForge.setBlockHarvestLevel(this, toolClass, harvestLevel);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg) {
		this.blockIcon = reg.registerIcon(Textures.Blocks.PATHCONCRETE);
	}

}

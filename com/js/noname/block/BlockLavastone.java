package com.js.noname.block;

import com.js.noname.handler.CreativeTabHandler;
import com.js.noname.reference.Names;
import com.js.noname.reference.Textures;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockLavastone extends Block {

	public BlockLavastone(int id, Material material) {
		super(id, material);
		
		this.setUnlocalizedName(Names.Blocks.LAVASTONE);
		this.setCreativeTab(CreativeTabHandler.tabNoname);
		this.setHardness(2.5F);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg) {
		this.blockIcon = reg.registerIcon(Textures.Blocks.PATHLAVASTONE);
	}

}

package com.js.noname.block;

import com.js.noname.handler.CreativeTabHandler;
import com.js.noname.reference.Names;
import com.js.noname.reference.Textures;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockHtone extends Block {
	
	public BlockHtone(int id, Material material) {
		super(id, material);
		
		this.setUnlocalizedName(Names.Blocks.HTONE);
		this.setStepSound(soundMetalFootstep);
		this.setResistance(20.0F);
		this.setCreativeTab(CreativeTabHandler.tabNoname);
		this.setHardness(5.5F);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg) {
		this.blockIcon = reg.registerIcon(Textures.Blocks.PATHHTONE);
	}
	
}

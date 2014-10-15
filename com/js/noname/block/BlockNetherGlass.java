package com.js.noname.block;

import com.js.noname.handler.CreativeTabHandler;
import com.js.noname.reference.Names;
import com.js.noname.reference.Textures;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockNetherGlass extends Block{
	
	public BlockNetherGlass(int id, Material material) {
		super(id, material);
		
		this.setUnlocalizedName(Names.Blocks.NETHERGLASS);
		this.setCreativeTab(CreativeTabHandler.tabNoname);
		this.setStepSound(soundGlassFootstep);
		this.setResistance(8.0F);
		this.setHardness(1.0F);
		this.setLightValue(0.4F);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg) {
		this.blockIcon = reg.registerIcon(Textures.Blocks.PATHNETHERGLASS);
	}

}

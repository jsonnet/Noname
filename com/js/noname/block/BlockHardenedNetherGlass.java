package com.js.noname.block;

import java.util.Random;

import com.js.noname.handler.CreativeTabHandler;
import com.js.noname.reference.Names;
import com.js.noname.reference.Textures;

import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockHardenedNetherGlass extends BlockGlass{
	
	public BlockHardenedNetherGlass(int id, Material material, boolean par3) {
		super(id, material, par3);
		
		this.setUnlocalizedName(Names.Blocks.HARDENEDNETHERGLASS);
		this.setCreativeTab(CreativeTabHandler.tabNoname);
		this.setStepSound(soundGlassFootstep);
		this.setResistance(40.0F);
		this.setHardness(3.0F);
		this.setLightValue(0.8F);
	}
	
	public int quantityDropped(Random par1Random){
		return 1;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg) {
		this.blockIcon = reg.registerIcon(Textures.Blocks.PATHHNETHERGLASS);
	}

}

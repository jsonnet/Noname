package com.js.noname.block;

import com.js.noname.handler.CreativeTabHandler;
import com.js.noname.reference.Names;
import com.js.noname.reference.Textures;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockFramedGlass extends BlockGlass{

	public BlockFramedGlass(int id, Material material, boolean par3) {
		super(id, material, par3);
		
		this.setCreativeTab(CreativeTabHandler.tabNoname);
		this.setUnlocalizedName(Names.Blocks.FRAMEDGLASS);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg) {
		this.blockIcon = reg.registerIcon(Textures.Blocks.PATHFRAMEDGLASS);
	}

}

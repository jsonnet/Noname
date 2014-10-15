package com.js.noname.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import com.js.noname.handler.CreativeTabHandler;
import com.js.noname.reference.Names;
import com.js.noname.reference.Textures;

import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockCyanFlower extends BlockFlower{
	
	public BlockCyanFlower(int par1) {
		super(par1);
		this.setUnlocalizedName(Names.Blocks.FLOWERCYAN);
		this.setCreativeTab(CreativeTabHandler.tabNoname);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg) {
		this.blockIcon = reg.registerIcon(Textures.Blocks.PATHFLOWERCYAN);
	}

}

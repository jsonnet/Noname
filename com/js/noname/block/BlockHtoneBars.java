package com.js.noname.block;

import com.js.noname.handler.CreativeTabHandler;
import com.js.noname.reference.Names;
import com.js.noname.reference.Textures;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

public class BlockHtoneBars extends BlockPane{

	@SideOnly(Side.CLIENT)
    private Icon theIcon;
	
	public BlockHtoneBars(int id, String par2Str, String par3Str, Material material, boolean par5) {
		super(id, par2Str, par3Str, material, par5);
		
		this.setUnlocalizedName(Names.Blocks.HTONEBARS);
		this.setCreativeTab(CreativeTabHandler.tabNoname);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg) {
		this.blockIcon = reg.registerIcon(Textures.Blocks.PATHHTONEBARS);
		this.theIcon = reg.registerIcon(Textures.Blocks.PATHHTONEBARS);
	}

}

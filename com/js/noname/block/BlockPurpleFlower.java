package com.js.noname.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import com.js.noname.handler.CreativeTabHandler;
import com.js.noname.reference.Names;
import com.js.noname.reference.Textures;

import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockPurpleFlower extends BlockFlower {
	
	public BlockPurpleFlower(int par1) {
		super(par1);
		this.setUnlocalizedName(Names.Blocks.FLOWERPURPLE);
		this.setCreativeTab(CreativeTabHandler.tabNoname);
		//GameRegistry.addRecipe(new ItemStack(", 2), new Object[]{"#", '#', ModBlocks.blockPurpleFlower});
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg) {
		this.blockIcon = reg.registerIcon(Textures.Blocks.PATHFLOWERPURPLE);
	}

}

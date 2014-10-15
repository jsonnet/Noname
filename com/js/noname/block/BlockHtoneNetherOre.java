package com.js.noname.block;

import com.js.noname.handler.CreativeTabHandler;
import com.js.noname.reference.Names;
import com.js.noname.reference.Textures;

import net.minecraft.block.BlockOre;
import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockHtoneNetherOre extends BlockOre {

	public BlockHtoneNetherOre(int id) {
		super(id);
		
		this.setUnlocalizedName(Names.Blocks.ORENETHERHTONE);
		this.setStepSound(soundStoneFootstep);
		this.setResistance(20.0F);
		this.setCreativeTab(CreativeTabHandler.tabNoname);
		this.setHardness(4.0F);
		this.setLightValue(0.2F);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg) {
		this.blockIcon = reg.registerIcon(Textures.Blocks.PATHORENETHERHTONE);
	}
	
}

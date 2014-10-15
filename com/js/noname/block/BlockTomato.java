package com.js.noname.block;

import com.js.noname.item.ModItems;
import com.js.noname.reference.Names;
import com.js.noname.reference.Textures;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

public class BlockTomato extends BlockCrops {

	@SideOnly(Side.CLIENT)
	private Icon[] iconArray;
	
	public BlockTomato(int id) {
		super(id);
		
		this.setUnlocalizedName(Names.Blocks.TOMATO);
	}
	
	public int getSeedItem(){
		return ModItems.itemTomato.itemID;
	}
	
	public int getCropItem(){
		return ModItems.itemTomato.itemID;
	}
	
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata){
		if(metadata < 7){
			if(metadata == 6){
				metadata = 5;
			}
			return iconArray[metadata >> 1];
		}
		
		return iconArray[3];
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg){
		this.iconArray = new Icon[4];
		
		for(int i = 0; i < this.iconArray.length; i++){
			this.iconArray[i] = reg.registerIcon(Textures.Blocks.PATHTOMATO + (i+1));
		}
	}
}

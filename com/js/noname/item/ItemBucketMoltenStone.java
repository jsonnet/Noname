package com.js.noname.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;

import com.js.noname.handler.CreativeTabHandler;
import com.js.noname.reference.Textures;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBucketMoltenStone extends ItemBucket{
	
	public ItemBucketMoltenStone(int id, int liquidId) {
		super(id, liquidId);
		
		this.setUnlocalizedName("bucketmoltenstone");
		this.setCreativeTab(CreativeTabHandler.tabNoname);
		this.setMaxStackSize(1);
		this.setContainerItem(Item.bucketEmpty);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg) {
		this.itemIcon = reg.registerIcon(Textures.Items.PATHBUCKETMOLTENSTONE);
	}

}

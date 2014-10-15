package com.js.noname.item;

import com.js.noname.handler.CreativeTabHandler;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemFurnaceStick extends Item {
	
	private String filename = "noname:furnace_stick_off";

	public ItemFurnaceStick(int id) {
		super(id);
		this.setMaxStackSize(1);
		this.setUnlocalizedName("furnaceStick");
		this.setCreativeTab(CreativeTabHandler.tabNoname);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player){
		
		return itemstack;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg){
		this.itemIcon = reg.registerIcon(filename);
	}
	

}

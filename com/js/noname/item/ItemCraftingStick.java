package com.js.noname.item;

import java.util.List;

import com.js.noname.MainNoname;
import com.js.noname.handler.CreativeTabHandler;
import com.js.noname.handler.GuiHandler;
import com.js.noname.reference.Textures;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCraftingStick extends Item {

	public ItemCraftingStick(int id) {
		super(id);
		this.setMaxStackSize(1);
		this.setUnlocalizedName("craftingStick");
		this.setMaxDamage(30);
		this.setCreativeTab(CreativeTabHandler.tabNoname);
	}
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player, NetHandler netHandler){
		
		netHandler.getPlayer().displayGUIWorkbench(0, 0, 0);
		return itemstack;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg){
		this.itemIcon = reg.registerIcon(Textures.Items.PATHCRAFTINGSTICK);
	}
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List dataList, boolean b) {
	    dataList.add("A simple workbench on a stick !");
	}
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
    {
		if(itemstack.getItemDamage() < 30){
    		itemstack.setItemDamage(itemstack.getItemDamage()+1);
    	}else{
    		itemstack.stackSize--;
    	}
		//if (!world.isRemote)
        //{
			player.displayGUIWorkbench(0, 0, 0);
			player.openGui(MainNoname.instance, GuiHandler.guiIdRechargeStation, world, 0, 0, 0);
			FMLNetworkHandler.openGui(player, MainNoname.instance, GuiHandler.guiIdRechargeStation, world, 0, 0, 0);
		//}
		return itemstack;
    }
}

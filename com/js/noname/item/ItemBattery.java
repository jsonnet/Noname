package com.js.noname.item;

import java.util.LinkedList;
import java.util.List;

import com.js.noname.handler.CreativeTabHandler;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumGameType;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBattery extends Item {
	
	public Integer capacity;
	
	public static final String[] batteryItemNames = new String[] {"empty","25","50","75","full"};
	private Icon[] batteryIcons;
	
	public ItemBattery(int id, int maxPower) {
		super(id);
		
		this.setMaxStackSize(1);
		this.setMaxDamage(maxPower);
		this.setCreativeTab(CreativeTabHandler.tabNoname2);
		this.setUnlocalizedName("battery");
		this.capacity = maxPower;
	}
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister reg)
    {
        //this.batteryIcons = new Icon[batteryItemNames.length];

        //for (int i = 0; i < batteryItemNames.length; ++i)
		//{
        //    this.batteryIcons[i] = reg.registerIcon("battery" + "_" + batteryItemNames[i]);
        //}
		//this.itemIcon = reg.registerIcon("battery" + "_" + "empty");
    }
	
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int par1)
    {
        //int j = MathHelper.clamp_int(par1, 0, 4);
        return null; //this.batteryIcons[j];
    }
	
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
		EntityPlayer player = (EntityPlayer) par2EntityPlayer;
		
        if (!par3World.isRemote)
        {
            if (!par2EntityPlayer.capabilities.isCreativeMode)
            {
            	par1ItemStack.setItemDamage(par1ItemStack.getItemDamage()+1);
            }
            return true;
        }
        else
        {
            return false;
        }
    }
	
	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {
		super.onUpdate(par1ItemStack, par2World, par3Entity, par4, par5);
		int i;
		EntityPlayer player = (EntityPlayer) par3Entity;

		ItemStack flyingRingItemStack = new ItemStack(ModItems.itemBattery, 1);

		for(i = 0; i <= 8; i++) {
			if(player.inventory.mainInventory[i] != null && player.inventory.mainInventory[i].isItemEqual(flyingRingItemStack)){
				if(player.experienceLevel > 3){
					player.experienceLevel = player.experienceLevel - 2;
					player.capabilities.allowFlying = true;
					flyingRingItemStack.setItemDamage(flyingRingItemStack.getItemDamage()+100);
					if(player.experienceLevel < 1) player.capabilities.disableDamage = false; //NO XP: More Damage to Item ?
					break;
				}
			}else{
				player.capabilities.allowFlying = false;
				player.setGameType(EnumGameType.SURVIVAL);
			}
			if(i == 8) i = 0;
		}
	}
}

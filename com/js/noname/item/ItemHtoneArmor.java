package com.js.noname.item;

import com.js.noname.handler.CreativeTabHandler;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemHtoneArmor extends ItemArmor {

	private String texturePath = "noname:textures/models/armor/";
	
	public ItemHtoneArmor(int id, EnumArmorMaterial material, int par3, int par4) {
		super(id, material, par3, par4);
		
		this.setMaxDamage(1);
		this.setCreativeTab(CreativeTabHandler.tabNoname);
		this.isRepairable();
		this.setTextureOfName(par4);
	}
	
	private void setTextureOfName(int armorPart){
		if(armorType == 0 || armorType == 1 || armorType == 3){
			this.texturePath += "htone_layer_1.png";
		}else{
			this.texturePath += "htone_layer_2.png";
		}
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg){
		this.itemIcon = reg.registerIcon("noname:" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".")+1));
	}
	
	public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, int layer){
		return this.texturePath;
	}
}

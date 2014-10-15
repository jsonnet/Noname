package com.js.noname.item;

import com.js.noname.handler.CreativeTabHandler;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemEnrichedCoal extends Item {
	
	private String filename = "noname:enrichedcoal";
	
	public ItemEnrichedCoal(int id) {
		super(id);
		
		this.setCreativeTab(CreativeTabHandler.tabNoname);
		this.setUnlocalizedName("enrichedcoal");
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg) {
		this.itemIcon = reg.registerIcon(filename);
	}
	
	@SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack)
    {
        return true;
    }
}

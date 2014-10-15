package com.js.noname.handler;

import com.js.noname.MainNoname;
import com.js.noname.container.ContainerRechargeStation;
import com.js.noname.gui.GuiRechargeStation;
import com.js.noname.tileentity.TileEntityRechargeStation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class GuiHandler implements IGuiHandler {
	public GuiHandler() {
		NetworkRegistry.instance().registerGuiHandler(MainNoname.instance, this);
	}

	public static final int guiIdRechargeStation = 8;
	
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getBlockTileEntity(x, y, z);

		if(entity != null){
			switch (id) {
				case guiIdRechargeStation:
					if (entity instanceof TileEntityRechargeStation) {
						return new ContainerRechargeStation(player.inventory, (TileEntityRechargeStation) entity);
					} 
					
					return null;
				default:
					return null;
			}
		}
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getBlockTileEntity(x, y, z);

		if(entity != null){
			switch (id) {
				case guiIdRechargeStation:
					if (entity instanceof TileEntityRechargeStation) {
						return new GuiRechargeStation(player.inventory, (TileEntityRechargeStation) entity);
					} 
					
					return null;
				default:
					return null;
			}
		}

		return null;
	}	
}

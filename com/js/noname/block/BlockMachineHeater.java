package com.js.noname.block;

import com.js.noname.handler.CreativeTabHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMachineHeater extends Block {

	private String filename = "noname:heater_off";
	private String filename2 = "noname:heater_on";
	private boolean powered;

	private boolean isActive;

	public BlockMachineHeater(int id, Material material) {
		super(id, material);
		this.powered = false;

		if (powered) {
			this.setLightValue(0.8F);
		}

		this.setUnlocalizedName("blockHeater");
		this.setCreativeTab(CreativeTabHandler.tabNoname2);
		this.setStepSound(soundStoneFootstep);
		this.setResistance(10.0F);
		this.setHardness(2.0F);
	}

	public boolean canConnectRedstone(World world, int x, int y, int z, int side) {
		return true;
	}

	public void onNeighborBlockChange(World world, int x, int y, int z,
			int NeighborID) {
		if (!world.isRemote) {
			if (this.powered && !world.isBlockIndirectlyGettingPowered(x, y, z)) {
				this.powered = false;
				world.setBlockMetadataWithNotify(x, y, z, 0, 2); // hier: 0 = metadata
			} else if (!this.powered
					&& world.isBlockIndirectlyGettingPowered(x, y, z)) {
				this.powered = true;
				world.setBlockMetadataWithNotify(x, y, z, 1, 2); // hier: 1 = metadata
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg) {
		// Set up look for Metadata 0 = off; 1 = on
		if (this.powered) {
			this.blockIcon = reg.registerIcon(filename2);
		} else {
			this.blockIcon = reg.registerIcon(filename);
		}
	}

}

package com.js.noname.block;

import com.js.noname.handler.CreativeTabHandler;
import com.js.noname.reference.Names;
import com.js.noname.reference.Textures;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockOvenpart extends Block {

	// multiblock
	public BlockOvenpart(int id, Material material) {
		super(id, material);

		this.setUnlocalizedName(Names.Blocks.OVENPART);
		this.setCreativeTab(CreativeTabHandler.tabNoname2);
		this.setStepSound(soundStoneFootstep);
		this.setResistance(10.0F);
		this.setHardness(2.0F);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg) {
		this.blockIcon = reg.registerIcon(Textures.Blocks.PATHOVENPART);
	}

	public boolean isMultiBlockStructure(World world, int x, int y, int z) {
		if (checkNorth(world, x, y, z))/* North */
			return true;
		if (checkEast(world, x, y, z))/* East */
			return true;
		if (checkSouth(world, x, y, z))/* South */
			return true;
		if (checkWest(world, x, y, z))/* West */
			return true;
		System.out.print("multiblock");
		return false;
	}

	private static boolean checkNorth(World world, int x, int y, int z) {
		if (world.getBlockId(x + 0, y + 0, z + -1) == BlockIds.blockOven) {
			if (world.getBlockId(x + 0, y + 1, z + 0) == BlockIds.blockOven) {
				if (world.getBlockId(x + 0, y + 1, z + -1) == BlockIds.blockOven) {
					if (world.getBlockId(x + 1, y + 0, z + 0) == BlockIds.blockOven) {
						if (world.getBlockId(x + 1, y + 0, z + -1) == BlockIds.blockOven) {
							if (world.getBlockId(x + 1, y + 1, z + 0) == BlockIds.blockOven) {
								if (world.getBlockId(x + 1, y + 1, z + -1) == BlockIds.blockOven) {
									if (world.getBlockId(x + 2, y + 0, z + 0) == BlockIds.blockOven) {
										if (world.getBlockId(x + 2, y + 0, z + -1) == BlockIds.blockOven) {
											if (world.getBlockId(x + 2, y + 1, z + 0) == BlockIds.blockOven) {
												if (world.getBlockId(x + 2, y + 1, z + -1) == BlockIds.blockOven) {
													return true;
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return false;
	}

	private static boolean checkEast(World world, int x, int y, int z) {
		if (world.getBlockId(x + 1, y + 0, z + 0) == BlockIds.blockOven) {
			if (world.getBlockId(x + 0, y + 1, z + 0) == BlockIds.blockOven) {
				if (world.getBlockId(x + 1, y + 1, z + 0) == BlockIds.blockOven) {
					if (world.getBlockId(x + 0, y + 0, z + 1) == BlockIds.blockOven) {
						if (world.getBlockId(x + 1, y + 0, z + 1) == BlockIds.blockOven) {
							if (world.getBlockId(x + 0, y + 1, z + 1) == BlockIds.blockOven) {
								if (world.getBlockId(x + 1, y + 1, z + 1) == BlockIds.blockOven) {
									if (world.getBlockId(x + 0, y + 0, z + 2) == BlockIds.blockOven) {
										if (world.getBlockId(x + 1, y + 0, z + 2) == BlockIds.blockOven) {
											if (world.getBlockId(x + 0, y + 1, z + 2) == BlockIds.blockOven) {
												if (world.getBlockId(x + 1, y + 1, z + 2) == BlockIds.blockOven) {
													return true;
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return false;
	}

	private static boolean checkSouth(World world, int x, int y, int z) {
		if (world.getBlockId(x + 0, y + 0, z + 1) == BlockIds.blockOven) {
			if (world.getBlockId(x + 0, y + 1, z + 0) == BlockIds.blockOven) {
				if (world.getBlockId(x + 0, y + 1, z + 1) == BlockIds.blockOven) {
					if (world.getBlockId(x + -1, y + 0, z + 0) == BlockIds.blockOven) {
						if (world.getBlockId(x + -1, y + 0, z + 1) == BlockIds.blockOven) {
							if (world.getBlockId(x + -1, y + 1, z + 0) == BlockIds.blockOven) {
								if (world.getBlockId(x + -1, y + 1, z + 1) == BlockIds.blockOven) {
									if (world.getBlockId(x + -2, y + 0, z + 0) == BlockIds.blockOven) {
										if (world.getBlockId(x + -2, y + 0, z + 1) == BlockIds.blockOven) {
											if (world.getBlockId(x + -2, y + 1, z + 0) == BlockIds.blockOven) {
												if (world.getBlockId(x + -2, y + 1, z + 1) == BlockIds.blockOven) {
													return true;
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return false;
	}

	private static boolean checkWest(World world, int x, int y, int z) {
		if (world.getBlockId(x + -1, y + 0, z + 0) == BlockIds.blockOven) {
			if (world.getBlockId(x + 0, y + 1, z + 0) == BlockIds.blockOven) {
				if (world.getBlockId(x + -1, y + 1, z + 0) == BlockIds.blockOven) {
					if (world.getBlockId(x + 0, y + 0, z + -1) == BlockIds.blockOven) {
						if (world.getBlockId(x + -1, y + 0, z + -1) == BlockIds.blockOven) {
							if (world.getBlockId(x + 0, y + 1, z + -1) == BlockIds.blockOven) {
								if (world.getBlockId(x + -1, y + 1, z + -1) == BlockIds.blockOven) {
									if (world.getBlockId(x + 0, y + 0, z + -2) == BlockIds.blockOven) {
										if (world.getBlockId(x + -1, y + 0, z + -2) == BlockIds.blockOven) {
											if (world.getBlockId(x + 0, y + 1, z + -2) == BlockIds.blockOven) {
												if (world.getBlockId(x + -1, y + 1, z + -2) == BlockIds.blockOven) {
													return true;
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return false;
	}
}

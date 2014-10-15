package com.js.noname.block;

import java.util.Random;

import com.js.noname.MainNoname;
import com.js.noname.handler.CreativeTabHandler;
import com.js.noname.handler.GuiHandler;
import com.js.noname.tileentity.TileEntityRechargeStation;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMachineRechargeStation extends BlockContainer {

	private boolean isActive;

	private final Random maceratorRand = new Random();
	private static boolean keepMaceratorInventory;

	private String filename1 = "noname:rechargestation_top";
	private String filename2 = "noname:rechargestation_bottom";
	private String filename3 = "noname:rechargestation_front_off";
	private String filename4 = "noname:rechargestation_front_on";
	private String filename5 = "noname:rechargestation_side_off";
	private String filename6 = "noname:rechargestation_side_on";
	
	private Icon RSIconSide;
	private Icon RSIconFront;
	private Icon RSIconTop;
	private Icon RSIconBottom;

	public BlockMachineRechargeStation(int id, Material material, boolean isActive) {
		super(id, material);

		this.isActive = isActive;
		this.setStepSound(soundStoneFootstep);
		this.setResistance(10.0F);
		this.setHardness(2.0F);
		
		if(!isActive){
			this.setCreativeTab(CreativeTabHandler.tabNoname2);
			this.setLightValue(0.3F);
		}
	}
	
	public static void updateFurnaceBlockState(boolean par0, World par1World, int par2, int par3, int par4)
	{
		int l = par1World.getBlockMetadata(par2, par3, par4);
		TileEntity tileentity = par1World.getBlockTileEntity(par2, par3, par4);
		keepMaceratorInventory = true;

		if (par0)
		{
			par1World.setBlock(par2, par3, par4, ModBlocks.blockRechargeStationActive.blockID);
		}
		else
		{
			par1World.setBlock(par2, par3, par4, ModBlocks.blockRechargeStationIdle.blockID);
		}

		keepMaceratorInventory = false;
		par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);

		if (tileentity != null)
		{
			tileentity.validate();
			par1World.setBlockTileEntity(par2, par3, par4, tileentity);
		}
	}
	
	public void onNeighborBlockChange(World world, int x, int y, int z,
			int NeighborID) {
		if (!world.isRemote) {
			if (this.isActive && !world.isBlockIndirectlyGettingPowered(x, y, z)) {
				this.isActive = false; // + Change TileEntity
			} else if (!this.isActive && world.isBlockIndirectlyGettingPowered(x, y, z)) {
				this.isActive = true; // + Change TileEntity
			}
		}
	}
	
	public int idDropped(int par1, Random par2Random, int par3){
		return ModBlocks.blockRechargeStationIdle.blockID;
	} 
	
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int par2) {
		return side == 1 ? this.RSIconTop : (side == 0 ? this.RSIconBottom : (side != par2 ? this.RSIconSide : this.RSIconFront));
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg) {
		this.RSIconFront = reg.registerIcon(this.isActive ? filename4 : filename3);
		this.RSIconSide = reg.registerIcon(this.isActive ? filename6 : filename5);
		this.RSIconTop = reg.registerIcon(filename1);
		this.RSIconBottom = reg.registerIcon(filename2);
	}

	public void onBlockAdded(World world, int x, int y, int z){
		super.onBlockAdded(world, x, y, z);
		this.setDefaultDirection(world, x, y, z);
	}
	
	private void setDefaultDirection(World par1World, int par2, int par3, int par4){
		if (!par1World.isRemote){
			int l = par1World.getBlockId(par2, par3, par4 - 1);
			int i1 = par1World.getBlockId(par2, par3, par4 + 1);
			int j1 = par1World.getBlockId(par2 - 1, par3, par4);
			int k1 = par1World.getBlockId(par2 + 1, par3, par4);
			byte b0 = 3;

			if (Block.opaqueCubeLookup[l] && !Block.opaqueCubeLookup[i1]){
				b0 = 3;
			}

			if (Block.opaqueCubeLookup[i1] && !Block.opaqueCubeLookup[l]){
				b0 = 2;
			}

			if (Block.opaqueCubeLookup[j1] && !Block.opaqueCubeLookup[k1]){
				b0 = 5;
			}

			if (Block.opaqueCubeLookup[k1] && !Block.opaqueCubeLookup[j1]){
				b0 = 4;
			}
			par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 2);
		}
	}
	
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack){
        int l = MathHelper.floor_double((double)(par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0){
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
        }

        if (l == 1){
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
        }

        if (l == 2){
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
        }

        if (l == 3){
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
        }
        
        if (par6ItemStack.hasDisplayName()){
			((TileEntityRechargeStation)par1World.getBlockTileEntity(par2, par3, par4)).setGuiDisplayName(par6ItemStack.getDisplayName());
		}
    }

	@Override
	public TileEntity createNewTileEntity(World par1World){
		return new TileEntityRechargeStation();
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if(world.isRemote) {
			FMLNetworkHandler.openGui(player, MainNoname.instance, GuiHandler.guiIdRechargeStation, world, x, y, z);
		}
		
		return true;
	}
	/**
	public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
		{
			if (!keepMaceratorInventory)
			{
				TileEntityRechargeStation TileEntityRechargeStation = (TileEntityRechargeStation)par1World.getBlockTileEntity(par2, par3, par4);

				if (TileEntityMacerator != null)
				{
					for (int j1 = 0; j1 < TileEntityRechargeStation.getSizeInventory(); ++j1)
					{
						ItemStack itemstack = TileEntityRechargeStation.getStackInSlot(j1);

						if (itemstack != null)
						{
							float f = this.maceratorRand.nextFloat() * 0.8F + 0.1F;
							float f1 = this.maceratorRand.nextFloat() * 0.8F + 0.1F;
							float f2 = this.maceratorRand.nextFloat() * 0.8F + 0.1F;

							while (itemstack.stackSize > 0)
							{
								int k1 = this.maceratorRand.nextInt(21) + 10;

								if (k1 > itemstack.stackSize)
								{
									k1 = itemstack.stackSize;
								}

								itemstack.stackSize -= k1;
								EntityItem entityitem = new EntityItem(par1World, (double)((float)par2 + f), (double)((float)par3 + f1), (double)((float)par4 + f2), new ItemStack(itemstack.itemID, k1, itemstack.getItemDamage()));

								if (itemstack.hasTagCompound())
								{
									entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
								}

								float f3 = 0.05F;
								entityitem.motionX = (double)((float)this.maceratorRand.nextGaussian() * f3);
								entityitem.motionY = (double)((float)this.maceratorRand.nextGaussian() * f3 + 0.2F);
								entityitem.motionZ = (double)((float)this.maceratorRand.nextGaussian() * f3);
								par1World.spawnEntityInWorld(entityitem);
							}
						}
					}

					par1World.func_96440_m(par2, par3, par4, par5);
				}
			}

			super.breakBlock(par1World, par2, par3, par4, par5, par6);
		}
		
		public int getComparatorInputOverride(World par1World, int par2, int par3, int par4, int par5)
		{
			return Container.calcRedstoneFromInventory((IInventory)par1World.getBlockTileEntity(par2, par3, par4));
		}
	*/
	public boolean hasComparatorInputOverride()
	{
		return true;
	}
	
	@SideOnly(Side.CLIENT)
	public int idPicked(World par1World, int par2, int par3, int par4)
	{
		return ModBlocks.blockRechargeStationIdle.blockID;
	}
}

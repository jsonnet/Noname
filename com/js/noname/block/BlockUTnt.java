package com.js.noname.block;

import java.util.Random;

import com.js.noname.entity.EntityUTNTPrimed;
import com.js.noname.handler.CreativeTabHandler;
import com.js.noname.reference.Names;
import com.js.noname.reference.Textures;

import net.minecraft.block.BlockTNT;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockUTnt extends BlockTNT{
	
	private Icon UTntSide;
	private Icon UTntTop;
	private Icon UTntBottom;
	
	public BlockUTnt(int id) {
		super(id);
		this.setCreativeTab(CreativeTabHandler.tabNoname);
		this.setHardness(0.0F);
		this.setStepSound(soundGrassFootstep);
		this.setUnlocalizedName(Names.Blocks.UTNT);
	}
	
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int par2){
		return side == 0 ? this.UTntBottom : (side == 1 ? this.UTntTop : this.UTntSide);
	}
	 
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister reg)
    {
    	this.UTntSide = reg.registerIcon(Textures.Blocks.PATHUTNT + "_side");
    	this.UTntTop = reg.registerIcon(Textures.Blocks.PATHUTNT + "_top");
    	this.UTntBottom = reg.registerIcon(Textures.Blocks.PATHUTNT + "_bottom");
    }
	
	public void onBlockAdded(World world, int x, int y, int z){
		super.onBlockAdded(world, x, y, z);

		if (world.isBlockIndirectlyGettingPowered(x, y, z)){
	    	this.onBlockDestroyedByPlayer(world, x, y, z, 1);
	    	world.setBlockToAir(x, y, z);
		}
	}

	public void onNeighborBlockChange(World world, int x, int y, int z, int id){
		if (world.isBlockIndirectlyGettingPowered(x, y, z)){
        this.onBlockDestroyedByPlayer(world, x, y, z, 1);
            world.setBlockToAir(x, y, z);
        }
    }

    public int quantityDropped(Random par1Random){
        return 1;
    }

    public void onBlockDestroyedByExplosion(World world, int x, int y, int z, Explosion par5Explosion){
        if (!world.isRemote){
            EntityUTNTPrimed entityutntprimed = new EntityUTNTPrimed(world, (double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), par5Explosion.getExplosivePlacedBy());
            entityutntprimed.fuse = world.rand.nextInt(entityutntprimed.fuse / 4) + entityutntprimed.fuse / 8;
            world.spawnEntityInWorld(entityutntprimed);
        }
    }

    public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int metaData){
        this.primeTnt(world, x, y, z, metaData, (EntityLivingBase)null);
    }

    public void primeTnt(World world, int x, int y, int z, int par5, EntityLivingBase par6EntityLivingBase){
        if (!world.isRemote){
            if ((par5 & 1) == 1){
                EntityUTNTPrimed entityutntprimed = new EntityUTNTPrimed(world, (double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), par6EntityLivingBase);
                world.spawnEntityInWorld(entityutntprimed);
                world.playSoundAtEntity(entityutntprimed, "random.fuse", 1.0F, 1.0F);
            }
        }
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9){
        if (par5EntityPlayer.getCurrentEquippedItem() != null && par5EntityPlayer.getCurrentEquippedItem().itemID == Item.flintAndSteel.itemID){
            this.primeTnt(world, x, y, z, 1, par5EntityPlayer);
            world.setBlockToAir(x, y, z);
            par5EntityPlayer.getCurrentEquippedItem().damageItem(1, par5EntityPlayer);
            return true;
        }else{
            return super.onBlockActivated(world, x, y, z, par5EntityPlayer, par6, par7, par8, par9);
        }
    }

    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity){
        if (entity instanceof EntityArrow && !world.isRemote){
            EntityArrow entityarrow = (EntityArrow)entity;

            if (entityarrow.isBurning()){
                this.primeTnt(world, x, y, z, 1, entityarrow.shootingEntity instanceof EntityLivingBase ? (EntityLivingBase)entityarrow.shootingEntity : null);
                world.setBlockToAir(x, y, z);
            }
        }
    }

    public boolean canDropFromExplosion(Explosion par1Explosion){
        return false;
    }

}

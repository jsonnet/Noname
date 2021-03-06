package com.js.noname.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityUTNTPrimed extends Entity{

	public int fuse;
	private EntityLivingBase tntPlacedBy;
	
	public EntityUTNTPrimed(World world) {
		super(world);
		this.preventEntitySpawning = true;
        this.setSize(0.98F, 0.98F);
        this.yOffset = this.height / 2.0F;
	}
	
	public EntityUTNTPrimed(World world, double par2, double par4, double par6, EntityLivingBase entity){
		this(world);
		this.setPosition(par2, par4, par6);
		float f = (float)(Math.random() * Math.PI * 2.0D);
		this.motionX = (double)(-((float)Math.sin((double)f)) * 0.02F);
		this.motionY = 0.20000000298023224D;
	 	this.motionZ = (double)(-((float)Math.cos((double)f)) * 0.02F);
	    this.fuse = 30;
	 	this.prevPosX = par2;
	 	this.prevPosY = par4;
		this.prevPosZ = par6;
	    this.tntPlacedBy = entity;
	}

	public void onUpdate(){
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.motionY -= 0.03999999910593033D;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9800000190734863D;
        this.motionY *= 0.9800000190734863D;
        this.motionZ *= 0.9800000190734863D;

        if (this.onGround){
            this.motionX *= 0.699999988079071D;
            this.motionZ *= 0.699999988079071D;
            this.motionY *= -0.5D;
        }

        if (this.fuse-- <= 0){
            this.setDead();

            if (!this.worldObj.isRemote){
                this.explode();
            }
        }else{
            this.worldObj.spawnParticle("smoke", this.posX, this.posY + 0.5D, this.posZ, 0.0D, 0.0D, 0.0D);
        }
    }

	protected void entityInit() {}
	
    private void explode(){
        float f = 8.0F;
        this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, f, true);
    }
    
    protected void writeEntityToNBT(NBTTagCompound par1NBTTagCompound){
        par1NBTTagCompound.setByte("Fuse", (byte)this.fuse);
    }

    protected void readEntityFromNBT(NBTTagCompound par1NBTTagCompound){
        this.fuse = par1NBTTagCompound.getByte("Fuse");
    }

    @SideOnly(Side.CLIENT)
    public float getShadowSize(){
        return 0.0F;
    }

    public EntityLivingBase getTntPlacedBy(){
        return this.tntPlacedBy;
    }
    
    protected boolean canTriggerWalking(){
        return false;
    }

    public boolean canBeCollidedWith(){
        return !this.isDead;
    }

}

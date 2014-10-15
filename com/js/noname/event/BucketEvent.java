package com.js.noname.event;

import com.js.noname.block.ModBlocks;
import com.js.noname.item.ModItems;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.FillBucketEvent;

public class BucketEvent {
	
	@ForgeSubscribe
	public void onFillBucketEvent(FillBucketEvent event){
		if(event.current.itemID != Item.bucketEmpty.itemID) return;
		
		ItemStack fullBucket = getLiquid(event.world, event.target);
		
		if(fullBucket == null) return;
		
		event.world.setBlockToAir(event.target.blockX, event.target.blockY, event.target.blockZ);
		event.result = fullBucket;
		event.setResult(Result.ALLOW);
	}
	
	private ItemStack getLiquid(World world, MovingObjectPosition pos){
		int blockID = world.getBlockId(pos.blockX, pos.blockY, pos.blockZ);
		if(blockID == ModBlocks.blockFluidGas.blockID) return new ItemStack(ModItems.itemBucketGas);
		if(blockID == ModBlocks.blockFluidMoltenStone.blockID) return new ItemStack(ModItems.itemBucketMoltenStone);
		
		return null;
	}
}

package com.js.noname;

import java.util.Random;

import com.js.noname.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenerator implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
		case -1:
			generateNether(world, random, chunkX * 16, chunkZ * 16);
			break;
		case 0:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
			break;
		case 1:
			generateEnd(world, random, chunkX * 16, chunkZ * 16);
			break;
		}
	}
	
	private void generateNether(World world, Random random, int x, int y) {
		addOreSpawn(ModBlocks.blockHtoneNetherOre, world, random, x, y, 16, 16, 3 + random.nextInt(4), 18, 20, 80); // 20 & 80 too low/high
	}

	private void generateSurface(World world, Random random, int x, int y) {
		addOreSpawn(ModBlocks.blockHtoneOre, world, random, x, y, 16, 16,4 + random.nextInt(5), 24, 20, 80);
	}

	private void generateEnd(World world, Random random, int x, int y) {
		// coming soon
	}

	public void addOreSpawn(Block block, World world, Random random,int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY) {
		for (int i = 0; i < chancesToSpawn; i++) {
			int posX = blockXPos + random.nextInt(maxX);
			//System.out.println(posX);
			int posY = minY + random.nextInt(maxY - minY);
			//System.out.println(posY);
			int posZ = blockZPos + random.nextInt(maxZ);
			//System.out.println(posZ);
			(new WorldGenMinable(block.blockID, maxVeinSize)).generate(world, random, posX, posY, posZ);
		}
	}
}

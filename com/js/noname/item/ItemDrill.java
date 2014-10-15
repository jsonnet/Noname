package com.js.noname.item;

import com.js.noname.handler.CreativeTabHandler;
import com.js.noname.reference.Textures;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTool;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemDrill extends ItemTool {
	
	public static final Block[] blocksEffectiveAgainst = {Block.cobblestone, Block.stoneDoubleSlab, Block.stoneSingleSlab,
		Block.stone, Block.sandStone, Block.cobblestoneMossy, Block.oreIron, Block.blockIron, Block.oreCoal, Block.blockGold,
		Block.oreGold, Block.oreDiamond, Block.blockDiamond, Block.ice, Block.netherrack, Block.oreLapis, Block.blockLapis,
		Block.oreRedstone, Block.oreRedstoneGlowing, Block.rail, Block.railDetector, Block.railPowered, Block.railActivator,
		Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField,
		Block.slowSand, Block.mycelium, Block.planks, Block.bookShelf, Block.wood, Block.chest, Block.stoneDoubleSlab,
		Block.stoneSingleSlab, Block.pumpkin, Block.pumpkinLantern, Block.glass, Block.obsidian, Block.bedrock};
	
	public ItemDrill(int id, EnumToolMaterial material) {
		super(id, 8.0F, material, blocksEffectiveAgainst);
		
		this.setUnlocalizedName("drill");
		this.setCreativeTab(CreativeTabHandler.tabNoname2);
		this.setMaxStackSize(1);
		
		MinecraftForge.setToolClass(this, "pickaxe", 3);
	}
	
	public boolean canHarvestBlock(Block par1Block)
    {
        return par1Block == Block.obsidian ? this.toolMaterial.getHarvestLevel() == 3 : (par1Block != Block.blockDiamond && par1Block != Block.oreDiamond ? (par1Block != Block.oreEmerald && par1Block != Block.blockEmerald ? (par1Block != Block.blockGold && par1Block != Block.oreGold ? (par1Block != Block.blockIron && par1Block != Block.oreIron ? (par1Block != Block.blockLapis && par1Block != Block.oreLapis ? (par1Block != Block.oreRedstone && par1Block != Block.oreRedstoneGlowing ? (par1Block.blockMaterial == Material.rock ? true : (par1Block.blockMaterial == Material.iron ? true : par1Block.blockMaterial == Material.anvil)) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2);
        //par1Block == Block.snow ? true : par1Block == Block.blockSnow
    }
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg) {
		this.itemIcon = reg.registerIcon(Textures.Items.PATHDRILL);
	}
}

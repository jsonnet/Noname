package com.js.noname.item;

import com.js.noname.block.ModBlocks;
import com.js.noname.fluid.ModFluids;

import net.minecraft.block.Block;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModItems {
		
	public static Item itemHtoneAxe;
	public static Item itemHtoneIngot;
	public static Item itemHtonePickaxe;
	public static Item itemFurnaceStick;
	public static Item itemHtoneSword;
	public static Item itemHtoneNugget;
	public static Item itemCraftingStick;
	public static Item itemHtoneShovel;
	public static Item itemHtoneHoe;
	public static Item itemBattery;
	public static Item itemDrill;
	public static Item itemTomato;
	public static Item itemEnrichedCoal;
	public static Item itemBucketGas;
	public static Item itemBucketMoltenStone;
	public static Item itemArmorHtoneHelmet;
	public static Item itemArmorHtonePlate;
	public static Item itemArmorHtoneLegs;
	public static Item itemArmorHtoneBoots;
	
	public static EnumToolMaterial toolMaterialHtone;
	public static EnumArmorMaterial armorMaterialHtone;
	
public static void init() {
	
	toolMaterialHtone = EnumHelper.addToolMaterial("Htone", 3, 1800, 14.0F, 4.0F, 18);
	armorMaterialHtone = EnumHelper.addArmorMaterial("Htone", 35, new int[]{4, 9, 7, 4}, 18);
	
	itemHtoneIngot = new ItemHtoneIngot(ItemIds.itemHtoneIngot);
	itemHtoneNugget = new ItemHtoneNugget(ItemIds.itemHtoneNugget);
	itemHtoneAxe = new ItemHtoneAxe(ItemIds.itemHtoneAxe, toolMaterialHtone);
	itemHtonePickaxe = new ItemHtonePickaxe(ItemIds.itemHtonePickaxe, toolMaterialHtone);
	itemHtoneSword = new ItemHtoneSword(ItemIds.itemHtoneSword, toolMaterialHtone);
	itemHtoneShovel = new ItemHtoneShovel(ItemIds.itemHtoneShovel, toolMaterialHtone);
	itemHtoneHoe = new ItemHtoneHoe(ItemIds.itemHtoneHoe, toolMaterialHtone);
	itemFurnaceStick = new ItemFurnaceStick(ItemIds.itemFurnaceStick);
	itemCraftingStick = new ItemCraftingStick(ItemIds.itemCraftingStick);
	itemBattery = new ItemBattery(ItemIds.itemBattery, 8000);
	itemDrill = new ItemDrill(ItemIds.itemDrill, toolMaterialHtone);
	itemTomato = new ItemTomato(ItemIds.itemTomato, 3, 0.4F, ModBlocks.blockTomato.blockID, Block.tilledField.blockID);
	itemEnrichedCoal = new ItemEnrichedCoal(ItemIds.itemEnrichedCoal);
	itemBucketGas = new ItemBucketGas(ItemIds.itemBucketGas, ModBlocks.blockFluidGas.blockID);
	itemBucketMoltenStone = new ItemBucketMoltenStone(ItemIds.itemBucketMoltenStone, ModBlocks.blockFluidMoltenStone.blockID);
	itemArmorHtoneHelmet = new ItemHtoneArmor(ItemIds.itemArmorHtoneHelmet, armorMaterialHtone, 0, 0).setUnlocalizedName("htone_helmet");
	itemArmorHtonePlate = new ItemHtoneArmor(ItemIds.itemArmorHtonePlate, armorMaterialHtone, 0, 1).setUnlocalizedName("htone_plate");
	itemArmorHtoneLegs = new ItemHtoneArmor(ItemIds.itemArmorHtoneLegs, armorMaterialHtone, 0, 2).setUnlocalizedName("htone_legs");
	itemArmorHtoneBoots = new ItemHtoneArmor(ItemIds.itemArmorHtoneBoots, armorMaterialHtone, 0, 3).setUnlocalizedName("htone_boots");
	
	registerItem(itemHtoneIngot, "Htone Ingot");
	registerItem(itemHtonePickaxe, "Htone Pickaxe");
	registerItem(itemHtoneAxe, "Htone Axe");
	registerItem(itemFurnaceStick, "Furnace at a Stick"); //Portable Furnace
	registerItem(itemHtoneSword, "Htone Sword");
	registerItem(itemHtoneNugget, "Htone Nugget");
	registerItem(itemCraftingStick, "Portable Crafting");
	registerItem(itemHtoneHoe, "Htone Hoe");
	registerItem(itemHtoneShovel, "Htone Shovel");
	registerItem(itemBattery, "Battery");
	registerItem(itemDrill, "Drill");
	registerItem(itemTomato, "Tomato");
	registerItem(itemEnrichedCoal, "Enriched Coal");
	registerItem(itemBucketGas, "Gas Bucket");
	registerItem(itemBucketMoltenStone, "Molten Stone Bucket");
	registerItem(itemArmorHtoneHelmet, "Htone Helmet");
	registerItem(itemArmorHtonePlate, "Htone Chestplate");
	registerItem(itemArmorHtoneLegs, "Htone Legings");
	registerItem(itemArmorHtoneBoots, "Htone Boots");
	
	}

	public static void registerItem(Item item, String name) {
		GameRegistry.registerItem(item, item.getUnlocalizedName());
		LanguageRegistry.addName(item, name);
	}

}

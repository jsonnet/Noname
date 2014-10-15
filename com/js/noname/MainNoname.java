package com.js.noname;

import java.io.Console;
import java.util.EnumSet;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidContainerRegistry.FluidContainerData;
import net.minecraftforge.fluids.FluidRegistry;

import org.lwjgl.input.Keyboard;

import com.js.noname.block.ModBlocks;
import com.js.noname.event.BucketEvent;
import com.js.noname.fluid.ModFluids;
import com.js.noname.handler.ConfigHandler;
import com.js.noname.handler.CraftingHandler;
import com.js.noname.handler.FuelHandler;
import com.js.noname.handler.GuiHandler;
import com.js.noname.handler.KeyBindingHandler;
import com.js.noname.handler.PlayerTickHandler;
import com.js.noname.handler.SmeltingHandler;
import com.js.noname.item.ModItems;
import com.js.noname.network.PacketHandler;
import com.js.noname.proxy.CommonProxy;
import com.js.noname.tileentity.TileEntityRechargeStation;

import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = "noname", name = "Noname Mod", version = "1.6.4-0.1", dependencies = "required-after:Forge@[9.11.1.953,)")
@NetworkMod(clientSideRequired = true, serverSideRequired = false, channels = {"noname"}, packetHandler = PacketHandler.class)
public class MainNoname {

	@Mod.Instance("noname")
	public static MainNoname instance;
	
	@SidedProxy(clientSide="com.js.noname.proxy.ClientProxy", serverSide="com.js.noname.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		ModFluids.init();
		ModBlocks.init();
		ModItems.init();
		CraftingHandler.initCraftingRecipes();
		SmeltingHandler.initSmeltingRecepies();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		GameRegistry.registerFuelHandler(new FuelHandler());
		GameRegistry.registerWorldGenerator(new WorldGenerator());
		MinecraftForge.EVENT_BUS.register(new BucketEvent());
		
		GameRegistry.registerTileEntity(TileEntityRechargeStation.class, "RechargeStation");
		proxy.init();
		NetworkRegistry.instance().registerGuiHandler(this, new GuiHandler());
		
		FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FluidRegistry.getFluidStack(ModFluids.fluidGas.getName(), 
			FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(ModItems.itemBucketGas), new ItemStack(Item.bucketEmpty)));
		FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FluidRegistry.getFluidStack(ModFluids.fluidMoltenStone.getName(), 
			FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(ModItems.itemBucketMoltenStone), new ItemStack(Item.bucketEmpty)));
		
		//+++Testing+++
		KeyBinding[] key = {new KeyBinding("Flight", Keyboard.KEY_F)};
			boolean[] repeat = {false};
			KeyBindingRegistry.registerKeyBinding(new KeyBindingHandler(key, repeat, "test123"));
		TickRegistry.registerTickHandler(new PlayerTickHandler(EnumSet.of(TickType.PLAYER)), Side.SERVER);
		
		//Item.itemsList[ModBlocks.blockHalfSlabConcrete.blockID] = new ItemSlab(ModBlocks.blockHalfSlabConcrete.blockID-256, (BlockHalfSlab)ModBlocks.blockHalfSlabConcrete, (BlockHalfSlab)ModBlocks.blockDoubleSlabConcrete, false); 
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) { }
}
package com.js.noname.handler;

import java.util.EnumSet;
import java.util.Iterator;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;

public class KeyBindingHandler extends KeyHandler
{
	 private EnumSet tickTypes = EnumSet.of(TickType.CLIENT);
	 public static boolean keyPressed = false;
	 private String label;
	 
	 public KeyBindingHandler(KeyBinding[] keyBindings, boolean[] repeatings, String label)
	 {
		 super(keyBindings, repeatings);
		 this.label = label;
	 }
	 @Override
	 public String getLabel()
	 {
		 return label;
	 }
	 @Override
	 public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat)
	 {
		 keyPressed = true;
		 System.out.print("on1");
	 }
	 @Override
	 public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd)
	 {
		 keyPressed = false;
		 System.out.print("off1");
	 }
	 @Override
	 public EnumSet<TickType> ticks()
	 {
		 return tickTypes;
	 }
}

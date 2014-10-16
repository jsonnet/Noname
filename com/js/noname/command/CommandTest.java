package com.js.noname.command;

import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.world.EnumGameType;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class CommandTest extends CommandBase {

	@Override
	public String getCommandName() {
		return "executeSpecialThings";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return "";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		EntityPlayer player = getCommandSenderAsPlayer(icommandsender);
		
		if ("gm".equalsIgnoreCase(astring[0])){
			player.setGameType(EnumGameType.CREATIVE);
			//player.setGameType(EnumGameType.SURVIVAL);
        }
		else if("dm".equalsIgnoreCase(astring[0])){
			player.capabilities.disableDamage = true;
			//player.capabilities.disableDamage = false;
		}
		else if("sb".equalsIgnoreCase(astring[0]))//spawn bat
		{
			World world = icommandsender.getEntityWorld();
			world.spawnEntityInWorld(new EntityBat(world));
		}
		else if("ws".equalsIgnoreCase(astring[0]))//walkspeed
		{
			player.capabilities.setPlayerWalkSpeed(0.5F);
			//player.capabilities.setPlayerWalkSpeed(0.1F);
		}
		else if("fh".equalsIgnoreCase(astring[0]))//feedhunger
		{
			player.setHealth(20.0F);
		}
		else if("h".equalsIgnoreCase(astring[0]))//heal
		{
			player.heal(20.0F);
		}
		else if("iv".equalsIgnoreCase(astring[0]))
		{
			player.setInvisible(true);
			//player.setInvisible(false);
		}
		else if("version".equalsIgnoreCase(astring[0]))
		{ 
			icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText("Version: 0.1"));
		}
	}
	
	public List addTabCompletionOptions(ICommandSender par1ICommandSender, String[] par2ArrayOfStr)
    {
		return par2ArrayOfStr.length == 1 ? getListOfStringsMatchingLastWord(par2ArrayOfStr, new String[] {"version", "gm", "dm", "sb", "ws", "fh", "h", "iv"}): null;
    }

}

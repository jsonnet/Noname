package com.js.noname.handler;

import net.minecraft.network.packet.NetHandler;

public class LogHelper {

	public void chatLog(String str, NetHandler netHandler){
		netHandler.getPlayer().addChatMessage(str);
	}
}

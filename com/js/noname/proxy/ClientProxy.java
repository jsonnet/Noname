package com.js.noname.proxy;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class ClientProxy extends CommonProxy{

	public void init() {
		LanguageRegistry.instance().addStringLocalization("container.rechargeStation", "RechargeStation");
	}

}

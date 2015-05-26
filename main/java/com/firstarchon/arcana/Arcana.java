package com.firstarchon.arcana;

import com.firstarchon.arcana.handler.ConfigurationHandler;
import com.firstarchon.arcana.init.ModBlocks;
import com.firstarchon.arcana.init.ModEventHandler;
import com.firstarchon.arcana.init.ModItems;
import com.firstarchon.arcana.proxy.IProxy;
import com.firstarchon.arcana.referance.Reference;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class Arcana {
	
	@Mod.Instance(Reference.MOD_ID)
	public static Arcana instance;
	
	@SidedProxy(clientSide =Reference.CLIENT_PROXY_CLASS , serverSide = Reference.SERVER_PROXY_CLASS)
	public static IProxy proxy;
	
	
	@Mod.EventHandler
	public void preinit(FMLPreInitializationEvent event) {
		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
		ModItems.init();
		ModBlocks.init();
		ModEventHandler.init();
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		
	}
	

	@Mod.EventHandler
	public void postinit(FMLPostInitializationEvent event) {
		
	}
}

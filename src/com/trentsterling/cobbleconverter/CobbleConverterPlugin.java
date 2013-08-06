package com.trentsterling.cobbleconverter;

import org.bukkit.plugin.java.JavaPlugin;

public class CobbleConverterPlugin extends JavaPlugin {

	@Override
	public void onEnable() {
		// TODO Insert logic to be performed when the plugin is enabled
		getCommand("convert").setExecutor(new ConverterCommand(this));
		getCommand("unconvert").setExecutor(new UnConvertCommand(this));
	}

	@Override
	public void onDisable() {
		// TODO Insert logic to be performed when the plugin is disabled
	}

}

package com.breezeyboy.plookup;

import java.io.IOException;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import com.breezeyboy.plookup.commands.plookup;
import com.breezeyboy.plookup.metrics.Metrics;

public class main extends JavaPlugin{
public PluginDescriptionFile pdfile = this.getDescription();
public String prefix = "[PlayerLookup] ";
public String updatemsg;

public void onEnable(){
System.out.println(prefix + "Plugin loaded successfully. (v1.2)");
this.registerCommands();
this.startMetrics();
this.saveDefaultConfig();
}
public void onDisable(){
System.out.println(prefix + "Plugin unloaded successfully. (v1.2)");
}

public void registerCommands(){
this.getCommand("plookup").setExecutor(new plookup(this));
}

public void startMetrics(){
	System.out.println(prefix + "Starting metrics");
	try {
	    Metrics metrics = new Metrics(this);
	    metrics.start();
	    System.out.println(prefix + "Metrics started successfully.");
	} catch (IOException e) {
		System.out.println(prefix + "Metrics failed to start.");
	}
}
}

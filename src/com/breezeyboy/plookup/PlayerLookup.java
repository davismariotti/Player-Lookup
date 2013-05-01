package com.breezeyboy.plookup;

import java.io.IOException;

import org.bukkit.plugin.java.JavaPlugin;

import com.breezeyboy.plookup.commands.PlayerLookupCommand;
import com.breezeyboy.plookup.metrics.Metrics;

public class PlayerLookup extends JavaPlugin {

    public void onEnable() {
        getCommand("plookup").setExecutor(new PlayerLookupCommand(this));
        startMetrics();
        saveDefaultConfig();
    }
    public void startMetrics() {
        try {
            new Metrics(this).start();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
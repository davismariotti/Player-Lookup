package com.breezeyboy.plookup.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.breezeyboy.plookup.PlayerLookup;

public class PlayerLookupCommand implements CommandExecutor {

    private String cprefix = ChatColor.DARK_BLUE + "[Info] " + ChatColor.BLUE;

    private PlayerLookup plugin;

    public PlayerLookupCommand(PlayerLookup instance) {
        plugin = instance;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args) {
        if(cmd.getName().equalsIgnoreCase("plookup")) {
            if(args.length >= 1) {
                Player targetPlayer = Bukkit.getServer().getPlayer(args[0]);
                if(targetPlayer == null) {
                    sender.sendMessage(args[0] + " cannot be found! Please make sure the player is online!");
                    return true;
                }
                sender.sendMessage(ChatColor.GOLD + "----=[" + ChatColor.DARK_RED + targetPlayer.getName() + ChatColor.GOLD + "]=----");
                if(plugin.getConfig().getBoolean("Flying")) {
                    sender.sendMessage(cprefix + "Flying: " + ChatColor.DARK_BLUE + targetPlayer.isFlying());
                }
                if(plugin.getConfig().getBoolean("Op")) {
                    sender.sendMessage(cprefix + "Op: " + ChatColor.DARK_BLUE + targetPlayer.isOp());
                }
                if(plugin.getConfig().getBoolean("Whitelisted")) {
                    sender.sendMessage(cprefix + "Whitelisted: " + ChatColor.DARK_BLUE + targetPlayer.isWhitelisted());
                }
                if(plugin.getConfig().getBoolean("Dead")) {
                    sender.sendMessage(cprefix + "Dead: " + ChatColor.DARK_BLUE + targetPlayer.isDead());
                }
                if(plugin.getConfig().getBoolean("Sleeping")) {
                    sender.sendMessage(cprefix + "Sleeping: " + ChatColor.DARK_BLUE + targetPlayer.isSleeping());
                }
                if(plugin.getConfig().getBoolean("Sneaking")) {
                    sender.sendMessage(cprefix + "Sneaking: " + ChatColor.DARK_BLUE + targetPlayer.isSneaking());
                }
                if(plugin.getConfig().getBoolean("Sprinting")) {
                    sender.sendMessage(cprefix + "Sprinting: " + ChatColor.DARK_BLUE + targetPlayer.isSprinting());
                }
                if(plugin.getConfig().getBoolean("Gamemode")) {
                    sender.sendMessage(cprefix + "Gamemode: " + ChatColor.DARK_BLUE + targetPlayer.getGameMode().toString().toLowerCase());
                }
                if(plugin.getConfig().getBoolean("Ip")) {
                    if(sender.hasPermission("plookup.ip")) {
                        sender.sendMessage(cprefix + "IP: " + ChatColor.DARK_BLUE + targetPlayer.getAddress().getAddress().getHostAddress());
                    } else {
                        sender.sendMessage(ChatColor.RED + "You don't have permissions to view this players ip.");
                    }
                }
                sender.sendMessage(cprefix + "If any info is missing then it is disabled in the config.");
            } else {
                sender.sendMessage(ChatColor.RED + "You forgot the players name!");
                sender.sendMessage(ChatColor.RED + "/plookup <name>");
            }
        } else {
            sender.sendMessage(ChatColor.RED + "You don't have permission to do that!");
        }
        return true;
    }
}

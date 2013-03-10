package com.breezeyboy.plookup.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.breezeyboy.plookup.main;

public class plookup implements CommandExecutor {
public String cprefix = ChatColor.DARK_BLUE + "[Info] " + ChatColor.BLUE;
public static main plugin;
public plookup(main instance){
plugin = instance;
}

public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args){
if(cmd.getName().equalsIgnoreCase("plookup")){
if(sender instanceof Player){
if(sender.hasPermission("plookup.lookup")){
if(args.length == 1){
try{
Player targetPlayer = Bukkit.getServer().getPlayer(args[0]);
sender.sendMessage(ChatColor.GOLD + "----=[" + ChatColor.DARK_RED + targetPlayer.getName() + ChatColor.GOLD + "]=----");
if(plugin.getConfig().getBoolean("Flying") == true){
sender.sendMessage(cprefix + "Flying: " + ChatColor.DARK_BLUE + targetPlayer.isFlying());
}
if(plugin.getConfig().getBoolean("Op") == true){
sender.sendMessage(cprefix + "Op: " + ChatColor.DARK_BLUE + targetPlayer.isOp());
}
if(plugin.getConfig().getBoolean("Whitelisted") == true){
sender.sendMessage(cprefix + "Whitelisted: " + ChatColor.DARK_BLUE + targetPlayer.isWhitelisted());
}
if(plugin.getConfig().getBoolean("Dead") == true){
sender.sendMessage(cprefix + "Dead: "  + ChatColor.DARK_BLUE + targetPlayer.isDead());
}
if(plugin.getConfig().getBoolean("Sleeping") == true){
sender.sendMessage(cprefix + "Sleeping: " + ChatColor.DARK_BLUE + targetPlayer.isSleeping());
}
if(plugin.getConfig().getBoolean("Sneaking") == true){
sender.sendMessage(cprefix + "Sneaking: " + ChatColor.DARK_BLUE + targetPlayer.isSneaking());
}
if(plugin.getConfig().getBoolean("Sprinting") == true){
sender.sendMessage(cprefix + "Sprinting: " + ChatColor.DARK_BLUE + targetPlayer.isSprinting());
}
if(plugin.getConfig().getBoolean("Gamemode") == true){
sender.sendMessage(cprefix + "Gamemode: " + ChatColor.DARK_BLUE + targetPlayer.getGameMode().toString().toLowerCase());
}
if(plugin.getConfig().getBoolean("Ip") == true){
if(sender.hasPermission("plookup.ip")){
sender.sendMessage(cprefix + "Ip: " + ChatColor.DARK_BLUE + targetPlayer.getAddress().getAddress().getHostAddress());
}else{
sender.sendMessage(ChatColor.RED + "You don't have permissions to view this players ip.");
}
}
sender.sendMessage(cprefix + "If any info is missing then it is disabled in the config.");
}catch(Exception e){
sender.sendMessage(cprefix + args[0] + " cannot be found! Please make sure the player is online.");
}
}else{
sender.sendMessage(ChatColor.RED + "You forgot the players name!");
sender.sendMessage(ChatColor.RED + "/plookup <name>");
}
}else{
sender.sendMessage(ChatColor.RED + "You don't have permission.");
}
}	
if(!(sender instanceof Player)){
if(args.length == 1){
try{
Player targetPlayer = Bukkit.getServer().getPlayer(args[0]);
if(!(plugin.getConfig().getBoolean("DisabledConsole"))){
sender.sendMessage("----=[" + targetPlayer.getName() + "]=----");
sender.sendMessage("[Info] Flying: " + targetPlayer.isFlying());
sender.sendMessage("[Info] Op: " + targetPlayer.isOp());
sender.sendMessage("[Info] Whitelisted: " + targetPlayer.isWhitelisted());
sender.sendMessage("[Info] Dead: " + targetPlayer.isDead());
sender.sendMessage("[Info] Sleeping: " + targetPlayer.isSleeping());
sender.sendMessage("[Info] Sneaking: " + targetPlayer.isSneaking());
sender.sendMessage("[Info] Sprinting: " + targetPlayer.isSprinting());
sender.sendMessage("[Info] Gamemode: " + targetPlayer.getGameMode().toString().toLowerCase());
sender.sendMessage("[Info] Ip: " + targetPlayer.getAddress().getAddress().getHostAddress());	
}else{
sender.sendMessage("----=[" + targetPlayer.getName() + "]=----");
if(plugin.getConfig().getBoolean("Flying") == true){
sender.sendMessage("[Info] Flying: " + targetPlayer.isFlying());
}
if(plugin.getConfig().getBoolean("Op") == true){
sender.sendMessage("[Info] Op: " + targetPlayer.isOp());
}if(plugin.getConfig().getBoolean("Whitelisted") == true){
sender.sendMessage("[Info] Whitelisted: " + targetPlayer.isWhitelisted());
}
sender.sendMessage("[Info] Dead: " + targetPlayer.isDead());
if(plugin.getConfig().getBoolean("Sleeping") == true){
sender.sendMessage("[Info] Sleeping: " + targetPlayer.isSleeping());
}
if(plugin.getConfig().getBoolean("Sneaking") == true){
sender.sendMessage("[Info] Sneaking: " + targetPlayer.isSneaking());
}
if(plugin.getConfig().getBoolean("Sprinting") == true){
sender.sendMessage("[Info] Sprinting: " + targetPlayer.isSprinting());
}
if(plugin.getConfig().getBoolean("Gamemode") == true){
sender.sendMessage("[Info] Gamemode: " + targetPlayer.getGameMode().toString().toLowerCase());
}
if(plugin.getConfig().getBoolean("Ip") == true){
sender.sendMessage("[Info] Ip: " + targetPlayer.getAddress().getAddress().getHostAddress());
}
}
}catch(Exception e){
sender.sendMessage(args[0] + " cannot be found! Please make sure the player is online.");
}
}else{
sender.sendMessage("You forgot the players name!");
sender.sendMessage("/plookup <name>");	
}
}
}
return false;
}
}

package pw.zeth.WorldMessage.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class worldmessage implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        
        if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.DARK_RED + "For security purposes, you can not run this command in the console.");
                return true;
        }
        
        Player player = (Player) sender;
        
        if (args.length == 0) {
        	
        	sender.sendMessage(ChatColor.GRAY + "----------------");
        	sender.sendMessage(ChatColor.AQUA + "World Message");
        	sender.sendMessage(ChatColor.AQUA + "Created by R4Z");
        	sender.sendMessage(ChatColor.AQUA + "v0.2");
        	sender.sendMessage(ChatColor.GRAY + "----------------");
        	return true;
        	
        } else {
        	
        	if (args[0].equalsIgnoreCase("set")) {
        		if (args.length == 1) {
        		     sender.sendMessage(ChatColor.RED + "You must specify a world!");
        		     return true;
        		} else if (args.length == 2) {
        			sender.sendMessage(ChatColor.RED + "You must specify a duration in minutes!");
        			return true;
        		} else if (args.length == 3) {
        			sender.sendMessage(ChatColor.RED + "You must specify a JSON title to display!");
        			return true;
        		}

        	} else if (args[0].equalsIgnoreCase("remove")) {
        		if (args.length == 1) {
        			sender.sendMessage(ChatColor.RED + "You must specify a world to remove the message from!");
        			return true;
        		} else {
                    //TODO
        		}
        		
        	} else if (args[0].equalsIgnoreCase("reload")) {
        		
        		return true;
        	} else {
        		sender.sendMessage(ChatColor.RED + "Uhhh....that's not a command.");
        		return true;
        	}
        }
        return true;
    }
}
package pw.zeth.WorldMessage;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.craftbukkit.v1_13_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.minecraft.server.v1_13_R2.IChatBaseComponent;
import net.minecraft.server.v1_13_R2.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_13_R2.PacketPlayOutTitle;
import net.minecraft.server.v1_13_R2.PacketPlayOutTitle.EnumTitleAction;
import pw.zeth.WorldMessage.commands.worldmessage;

public class Main extends JavaPlugin {

	public void onEnable() {
		System.out.println("-------------------------------------");
		System.out.println("- WorldMessage Started Successfully -");
		System.out.println("-          Created by Razeth        -");
		System.out.println("-                v0.2               -");
		System.out.println("-------------------------------------");
		this.getCommand("worldmessage").setExecutor((CommandExecutor)new worldmessage());
		loadMessages();
		startMessage();
		for (Player p: Bukkit.getOnlinePlayers()) {
			sendTitle (p, "Title", "Subtitle", 5, 5, 5);
		}
		
	}
	
    public void onDisable() {
    	System.out.println("Stopping tasks for WorldMessage");
    	//TODO Stop running operations
    	
	}
    
    public void loadMessages() {
    	
    	getConfig().options().copyDefaults(true);
    	saveConfig();
    	
    }
    
    public void startMessage() {
    	//TODO
    }
    
	public void sendTitle (Player player, String title, String subtitle, int fadein, int stay, int fadeout) {
		IChatBaseComponent chatTitle = ChatSerializer.a ("{\" text \": \" "+ title +" \"}");
		IChatBaseComponent chatsubtitle = ChatSerializer.a ("{\" text \": \" "+ subtitle +" \"}");

		PacketPlayOutTitle t = new PacketPlayOutTitle (EnumTitleAction.TITLE, chatTitle);
		PacketPlayOutTitle s = new PacketPlayOutTitle (EnumTitleAction.SUBTITLE, chatsubtitle);
		PacketPlayOutTitle length = new PacketPlayOutTitle (fadein * 20, stay * 20, fadeout * 20);

		((CraftPlayer) player) .getHandle (). playerConnection.sendPacket (t);
		((CraftPlayer) player) .getHandle (). playerConnection.sendPacket (s);
		((CraftPlayer) player) .getHandle (). playerConnection.sendPacket (length);
		}
}

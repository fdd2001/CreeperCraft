package me.fdd2001.Tobi;

import me.confuser.barapi.BarAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Flo on 29.06.14.
 */
public class Main extends JavaPlugin implements Listener {
    @Override
    public void onEnable () {
        double version = 1.0;
        System.out.println("[TobiDomiCraft] Plugin enabled.");
        Bukkit.getServer().getPluginManager().registerEvents(this,this);
        System.out.println("[TobiDomiCraft] Fetching config...");
        getConfig().options().copyDefaults(true);
        saveConfig();
        System.out.println("[TobiDomiCraft] Done.");

    }

    @Override
    public void onDisable () {
        System.out.println("[TobiDomiCraft] Plugin disabled.");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("bossbar")) {
                if (p.isOp()) {
                    String msg ="";
                    for(String str: args)
                        msg=msg+str + " ";
                    BarAPI.setMessage(msg);
                    p.sendMessage(ChatColor.GREEN + "The boss bar message has been changed until players relog.");
                    return true;
                }
        }
        else if (cmd.getName().equalsIgnoreCase("reloadbossbar")) {
            if (p.isOp()) {
                BossBarHandler bhandler = new BossBarHandler();
                bhandler.reload();
                return true;
            }
        }
        return false;
    }

    @EventHandler
    public void onPlayerJoin (PlayerJoinEvent e) {
        BossBarHandler bh = new BossBarHandler();
        bh.handle(e);
    }
    
}

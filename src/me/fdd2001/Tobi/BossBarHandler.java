package me.fdd2001.Tobi;

import me.confuser.barapi.BarAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by Flo on 29.06.14.
 */
public class BossBarHandler {
    public BossBarHandler() {

    }
    public void handle (PlayerJoinEvent e) {
        String name = e.getPlayer().getName();
        String message = "§6Willkommen auf §2Creepercraft§6, §9" + name;
        BarAPI.setMessage(e.getPlayer(),message);
    }
    public void reload () {
        for (Player play : Bukkit.getOnlinePlayers()) {
            String name = play.getName();
            String message = "§6Willkommen auf §2Creepercraft§6, §9" + name;
            BarAPI.setMessage(play.getPlayer(),message);
        }
    }
}

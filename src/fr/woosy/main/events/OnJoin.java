package fr.woosy.main.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.woosy.main.config.Config;

public class OnJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (Config.itemOnJoin) {
            e.getPlayer().getInventory().setItem(Config.itemSlot, Config.getItem());
        }
    }

}

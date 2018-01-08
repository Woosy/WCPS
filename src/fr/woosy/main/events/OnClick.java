package fr.woosy.main.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.woosy.main.CustomPlayer;
import fr.woosy.main.config.Config;

public class OnClick implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent e) {


        Player p = e.getPlayer();
        CustomPlayer customP = CustomPlayer.getPlayer(p);



        if ((e.getAction().equals(Action.RIGHT_CLICK_AIR)) || (e.getAction().equals(Action.RIGHT_CLICK_BLOCK))) {
            if (!customP.isClicking()) {
                customP.setClicking(true);
                customP.start();
            }

        } else if (e.getAction().equals(Action.LEFT_CLICK_AIR) || e.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
            if ((customP.isClicking()) && (customP.time != Config.time) &&
                    (p.getItemInHand().getType().equals(Config.itemMat)) &&
                    (p.getItemInHand().getItemMeta().hasDisplayName())) {

                customP.addClick();

                ItemStack inHand = p.getItemInHand();
                ItemMeta itemMeta = p.getItemInHand().getItemMeta();
                itemMeta.setDisplayName(Config.getNameClick(customP.getClick(), customP.getTime()));
                inHand.setItemMeta(itemMeta);

                p.setItemInHand(inHand);
            }
        }

    }
}

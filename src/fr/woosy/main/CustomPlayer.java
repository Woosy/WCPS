package fr.woosy.main;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import fr.woosy.main.config.Config;

public class CustomPlayer {


    @SuppressWarnings({ "unchecked", "rawtypes" })
    private static ArrayList<CustomPlayer> customPlayers = new ArrayList();
    Player p;
    int click;
    public int time = Config.time + 1;
    boolean clicking = false;


    public void start() {
        new BukkitRunnable() {
            public void run() {
                if (CustomPlayer.this.time <= 0) {
                    CustomPlayer.this.p.sendMessage(Config.getClickRate(CustomPlayer.this.click / Config.time));
                    CustomPlayer.this.time = Config.time;
                    CustomPlayer.this.click = 0;
                    CustomPlayer.this.clicking = false;
                    cancel();

                    return;
                }
                CustomPlayer.this.time -= 1;
            }
        }.runTaskTimer(WCPS.getInstance(), 0L, 20L);
    }


    public static CustomPlayer getPlayer(Player p) {
        for (CustomPlayer customPlayer : customPlayers) {
            if (customPlayer.p.getName().equals(p.getName())) {
                return customPlayer;
            }
        }
        return new CustomPlayer(p);
    }


    private CustomPlayer(Player p) {
        this.p = p;
        customPlayers.add(this);
    }


    public boolean isClicking() {
        return this.clicking;
    }


    public void setClicking(boolean clicking) {
        this.clicking = clicking;
    }


    public int getClick() {
        return this.click;
    }


    public void addClick() {
        this.click += 1;
    }


    public int getTime() {
        return this.time;
    }
}
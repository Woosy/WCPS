package fr.woosy.main;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import fr.woosy.main.commands.Wcps;
import fr.woosy.main.config.Config;
import fr.woosy.main.events.OnClick;
import fr.woosy.main.events.OnJoin;

public class WCPS extends JavaPlugin implements Listener {

    ////////////////////////////////////////////////////////////
    // PRÉREQUIS

    public static WCPS instance;
    public static WCPS getInstance() {
        return instance;
    }

    String name = "WCPS";
    String version = "1.0-1";
    String author = "DarkWoosy";
    String specialversion = "SpigotMC";




    ////////////////////////////////////////////////////////////
    // DÉMARRAGE DU PLUGIN

    public void onEnable() {

        instance = this;

        System.out.println(name + " is loading...");
        System.out.println(name + " v." + version + " by " + author + ".");
        System.out.println("Special version : " + specialversion);


        saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(this, this);
        Bukkit.getPluginManager().registerEvents(new OnClick(), this);
        Bukkit.getPluginManager().registerEvents(new OnJoin(), this);
        getCommand("wcps").setExecutor(new Wcps());
        new Config();


        System.out.println(name + " is now enabled.");
    }




    ////////////////////////////////////////////////////////////
    // ARRÊT DU PLUGIN :

    public void onDisable() {

        super.onDisable();
        System.out.println(name + " " + version + " has been disabled.");

    }




    ////////////////////////////////////////////////////////////
    // CHARGEMENT & CRÉATION DE LA CONFIG :

    public FileConfiguration getConfig() {
        return super.getConfig();
    }

    public File getDefaultFolder() {
        return getDataFolder();
    }

}

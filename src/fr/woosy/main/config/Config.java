package fr.woosy.main.config;

import java.text.MessageFormat;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.woosy.main.WCPS;

public class Config {


    public static int itemSlot = WCPS.getInstance().getConfig().getInt("item_slot");
    public static int time = WCPS.getInstance().getConfig().getInt("time");
    private static String clickRate = WCPS.getInstance().getConfig().getString("click_rate");
    private static String itemDefaultName = WCPS.getInstance().getConfig().getString("item_default_name");
    private static String itemCountName = WCPS.getInstance().getConfig().getString("item_counter_name");
    private static String messageCommandDesactivated = WCPS.getInstance().getConfig().getString("message_command_desactivated");
    public static String permissionForGive = WCPS.getInstance().getConfig().getString("permission_give_command");
    private static String messageNoPermission = WCPS.getInstance().getConfig().getString("message_no_permission");
    public static boolean itemOnJoin = WCPS.getInstance().getConfig().getBoolean("item_on_join");
    public static boolean itemOnCommand = WCPS.getInstance().getConfig().getBoolean("item_on_command");
    public static Material itemMat = Material.getMaterial(WCPS.getInstance().getConfig().getString("item_material"));


    public static ItemStack getItem() {
        ItemStack is = new ItemStack(itemMat == null ? Material.WOOD_SWORD : itemMat);
        ItemMeta itemMeta = is.getItemMeta();
        itemMeta.setDisplayName(itemDefaultName.replaceAll("&", "§"));
        is.setItemMeta(itemMeta);

        return is;
    }


    public static String getClickRate(double finaleClickRate) {
        return MessageFormat.format(clickRate, finaleClickRate).replaceAll("&", "§");
    }


    public static String getMessageCmdDesactivated() {
        return messageCommandDesactivated.replaceAll("&", "§");
    }

    public static String getMessageNoPermission() {
        return messageNoPermission.replaceAll("&", "§");
    }

    public static String getNameClick(int click, int seconds) {
        return MessageFormat.format(itemCountName, click, seconds).replaceAll("&", "§");
    }

}

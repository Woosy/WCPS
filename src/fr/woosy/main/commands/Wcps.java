package fr.woosy.main.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import fr.woosy.main.config.Config;

public class Wcps implements CommandExecutor {

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if ((commandSender instanceof Player)) {
            Player p = (Player)commandSender;

            if (command.getName().equalsIgnoreCase("wcps")) {

                if (args.length == 0) {
                    if (Config.itemOnCommand) {
                        if (p.isOp() || p.hasPermission(Config.permissionForGive)) {
                            p.getInventory().addItem(new ItemStack[] { Config.getItem() });
                        } else {
                            p.sendMessage(Config.getMessageNoPermission());
                        }
                    } else {
                        p.sendMessage(Config.getMessageCmdDesactivated());
                    }
                }

				/* if (args.length == 1) {
					if (p.getServer().getPlayer(args[0]).isOnline()) {
						Player targP = p.getServer().getPlayer(args[2]);

						if (p.hasPermission(Config.itemGiveToOtherPermission)) {
							((HumanEntity) targP).getInventory().addItem(new ItemStack[] { Config.getItem() });
							p.sendMessage("You successfuly gave a cpstest item to " + targP.getName() + ".");
							targP.sendMessage("Check your inventory, you received a cpstest item.");
						}

					} else {
						p.sendMessage("§cThis player isn't online.");
					}
				} */

            }
        }

        return true;
    }
}

package com.trentsterling.cobbleconverter;

//import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class ConverterCommand implements CommandExecutor {

	public ConverterCommand(CobbleConverterPlugin cobbleConverter) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub

		if (cmd.getName().equalsIgnoreCase("convert")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("This command can only be run by a player.");
			} else {
				Player player = (Player) sender;
				PlayerInventory inventory = player.getInventory();

				// do stuff like check arg sizes and shit. really gonna miss the
				// old skyblock plugin for this command parsing shit.

				int desiredAmount = 1;

				if (args.length > 0) {
					if (args[0] != null) {
						if (Integer.parseInt(args[0]) > 0) {

							// Must be greater than 0 and must exist
							desiredAmount = Integer.parseInt(args[0]);
							//sender.sendMessage("ARG0 = " + args[0]);
						}
					}

				}

				int stackCost = 2;// costs 2 stacks

				ItemStack itemstack = new ItemStack(Material.COBBLESTONE, 64);

				if (inventory.contains(itemstack, stackCost * desiredAmount)) {

					for (int x = 0; x < stackCost * desiredAmount; x = x + 1) {
						inventory.removeItem(itemstack);
					}

					for (int y = 0; y < desiredAmount; y = y + 1) {

						Material material = Material.BLAZE_POWDER;
						int ammount = 1;
						String name = "ShopToken";

						ItemStack item = new ItemStack(material, ammount);
						ItemMeta itemMeta = item.getItemMeta();
						itemMeta.setDisplayName(name);

						// itemMeta.setLore(Arrays.asList("Holy shit",
						// "its a token!", "Cool huh?"));
						item.setItemMeta(itemMeta);

						inventory.addItem(item);

					}

					player.sendMessage("We converted " + desiredAmount * stackCost + " stacks of Cobble to " + desiredAmount + " tokens for you!");
				}
				else
				{

					player.sendMessage("You ain't got dat much, bro!");
					
					
				}

			}

			return true;
		}
		return false;
	}
}

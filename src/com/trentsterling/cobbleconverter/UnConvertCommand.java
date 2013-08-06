package com.trentsterling.cobbleconverter;

//import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class UnConvertCommand implements CommandExecutor
{

	public UnConvertCommand(CobbleConverterPlugin cobbleConverter)
	{
		// TODO Auto-generated constructor stub
	}

	protected boolean addToInventory(ItemStack item, ItemStack[] contents)
	{
		item = item.clone();
		for (int i = 0; i < contents.length; i++)
		{
			if (contents[i] == null)
			{
				contents[i] = item;
				return true;
			}
			else if (item.isSimilar(contents[i]) && contents[i].getAmount() != contents[i].getMaxStackSize())
			{
				int amt = contents[i].getAmount() + item.getAmount();
				if (amt <= contents[i].getMaxStackSize())
				{
					contents[i].setAmount(amt);
					return true;
				}
				else
				{
					item.setAmount(amt - contents[i].getMaxStackSize());
					contents[i].setAmount(contents[i].getMaxStackSize());
				}
			}
		}
		return false;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		// TODO Auto-generated method stub

		if (cmd.getName().equalsIgnoreCase("unconvert"))
		{
			if (!(sender instanceof Player))
			{
				sender.sendMessage("This command can only be run by a player.");
			}
			else
			{
				Player player = (Player) sender;

				player.sendMessage("Inventory test");

				PlayerInventory inventory = player.getInventory();
				// player.teleport(new Location(Bukkit.getWorld("worldname"), 0, 0, 0));
				// do stuff like check arg sizes and shit. really gonna miss the
				// old skyblock plugin for this command parsing shit.

				int desiredAmount = 1;

				int stackCost = 2;// costs 2 stacks

				ItemStack itemstack = new ItemStack(Material.COBBLESTONE, 64);

				player.sendMessage("Inventory size: " + inventory.getMaxStackSize());

			}

			return true;
		}
		return false;
	}
}

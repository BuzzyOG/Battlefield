package me.august.battlefield.player;

import me.august.battlefield.BattlefieldPlugin;
import me.august.battlefield.BattlefieldClass;
import me.august.battlefield.guns.Gun;
import me.august.battlefield.guns.KitItem;
import me.august.battlefield.util.ItemClickAction;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by August on 3/24/14.
 */
public class DeployScreen {

	private BattlefieldPlayer player;
	private int wait;
	private boolean canDeploy;
	private Inventory screen;
	private BattlefieldClass viewingClass;

	public DeployScreen(BattlefieldPlayer player, int wait) {
		this.player = player;
		this.viewingClass = player.getBattlefieldClass();
		this.wait = wait;
		canDeploy = false;
		new BukkitRunnable() {
			@Override
			public void run() {
				setCanDeploy(true);
			}
		}.runTaskLater(BattlefieldPlugin.get(), wait * 20);

		screen = Bukkit.createInventory(player.getPlayer(), 45, ChatColor.BOLD + "Deploy");


		ItemStack deployItem = createDeployItem();
		screen.setItem(44, deployItem);
		new ItemClickAction(deployItem, player, new Runnable() {
			@Override
			public void run() {
				attemptDeploy();
			}
		}, true, InventoryAction.PICKUP_ALL);

		List<Squad> squads = player.getTeam().getSquads();
		for(int i = 0; i < squads.size(); i++) {
			final Squad squad = squads.get(i);

			ItemStack squadItem = new ItemStack(Material.SKULL_ITEM);
			squadItem.setDurability((short) 3);
			ItemMeta meta = squadItem.getItemMeta();
			meta.setDisplayName(ChatColor.GREEN + squad.getName() + " Squad");
			List<String> lore = new ArrayList<>();
			lore.add(ChatColor.BLUE + String.valueOf(squad.getPlayerCount()) + "/" + String.valueOf(Squad.MAX_SQUAD_SIZE));
			if(!squad.isFull()) {
				lore.add(ChatColor.GOLD + "Click to join");
			}
			if(player.getSquad() == squad) {
				lore.add("You are in this squad");
			}
			meta.setLore(lore);
			squadItem.setItemMeta(meta);

			screen.setItem(36 + i, squadItem);

			new ItemClickAction(squadItem, player, new Runnable() {
				@Override
				public void run() {
					addToSquad(squad);
				}
			}, true, InventoryAction.PICKUP_ALL);

		}

		/* Give player blindness */
		player.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, Integer.MAX_VALUE, 1, true));

		new BukkitRunnable() {
			@Override
			public void run() {
				openScreen();
			}
		}.runTaskLater(BattlefieldPlugin.get(), 1);

	}

	private void addToSquad(Squad squad) {
		if(squad.isFull()) {
			sendMessage(ChatColor.RED + "That squad is full");
			return;
		}
		squad.addPlayer(player);
	}

	private void sendMessage(String msg) {
		player.sendMessage(msg);
	}

	public void openScreen() {
		List<ItemClickAction> classViewers = new ArrayList<>();
		for(final BattlefieldClass bfClass : BattlefieldClass.values()) {
			if(bfClass == BattlefieldClass.ALL) continue;

			ItemStack item = getItem(bfClass);

			classViewers.add(new ItemClickAction(item, player, new Runnable() {
				@Override
				public void run() {
					showClass(bfClass);
				}
			}, true, InventoryAction.PICKUP_ALL));
		}
		for(int i = 0; i < classViewers.size(); i++) {
			screen.setItem(i, classViewers.get(i).getItem());
		}

		player.getPlayer().openInventory(screen);

	}

	@SuppressWarnings("deprecated")
	public void showClass(BattlefieldClass bfClass) {
		viewingClass = bfClass;
		List<Gun> classGuns = new ArrayList<>();
		for(KitItem item : BattlefieldPlugin.get().getAvailableItems(viewingClass, BattlefieldClass.ALL)) {
			if(!(item instanceof Gun)) continue;
			classGuns.add((Gun) item);
		}
		for(int i = 9; i < 9 + classGuns.size(); i++) {
			final Gun gun = classGuns.get(i - 9);
			ItemStack gunItem = gun.toItem();
			screen.setItem(i, gunItem);
			new ItemClickAction(gunItem, player, new Runnable() {
				@Override
				public void run() {
					player.setKitItem(gun.getType(), gun);
				}
			}, true, InventoryAction.PICKUP_ALL);
		}

		player.getPlayer().updateInventory();

	}

	private ItemStack getItem(BattlefieldClass bfClass) {
		Material material = Material.ARROW;
		switch(bfClass) {

			case ASSAULT:
				material = Material.DIAMOND_SWORD;
				break;
			case ENGINEER:
				material = Material.ANVIL;
				break;
			case SUPPORT:
				material = Material.CHEST;
				break;
			case RECON:
				material = Material.BOW;
				break;

		}
		ItemStack item = new ItemStack(material);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(ChatColor.GOLD + StringUtils.capitalize(bfClass.name().toLowerCase()));
		List<String> guns = new ArrayList<>();
		for(KitItem kitItem : BattlefieldPlugin.get().getAvailableItems()) {
			if(kitItem instanceof Gun && kitItem.getBattlefieldClass() == bfClass) {
				guns.add(kitItem.getName());
			}
		}
		meta.setLore(Arrays.asList("Guns: " + String.valueOf(guns.size())));

		List<String> lore = meta.getLore();
		for(String gun : guns) lore.add(gun);
		meta.setLore(lore);

		item.setItemMeta(meta);
		return item;
	}

	public ItemStack createDeployItem() {
		ItemStack item = new ItemStack(Material.NETHER_STAR);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("" + ChatColor.AQUA + ChatColor.BOLD + "Deploy");
		item.setItemMeta(meta);
		return item;
	}

	public void attemptDeploy() {
		if(canDeploy) {
			player.sendMessage(ChatColor.RED + "You cannot deploy yet!");
		} else {
			player.sendMessage(ChatColor.GREEN + "Deploying");
			//TODO add deployments
		}
	}

	public void close() {
		ItemClickAction.removeByPlayer(player);
		if(screen.getViewers().contains(player.getPlayer())) {
			player.getPlayer().closeInventory();
		}
	}

	public BattlefieldPlayer getPlayer() {
		return player;
	}

	public int getWait() {
		return wait;
	}

	public Inventory getScreen() {
		return screen;
	}

	private void setCanDeploy(boolean canDeploy) {
		this.canDeploy =  canDeploy;
	}
}

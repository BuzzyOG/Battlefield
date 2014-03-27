package me.august.battlefield.player;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by August on 3/26/14.
 */
public class Squad {

	public final static String[] SQUAD_NAMES = {"Alpha", "Bravo", "Charlie", "Delta", "Echo", "Foxtrot", "Golf", "Hotel"};
	public final static int MAX_SQUAD_SIZE = 5;

	private boolean privateSquad;
	private String name;
	private List<BattlefieldPlayer> players;

	public Squad(String name, boolean privateSquad) {
		this.name = name;
		players = new ArrayList<>();
		this.privateSquad = privateSquad;
	}

	public List<BattlefieldPlayer> getPlayers() {
		return players;
	}

	public int getPlayerCount() {
		return players.size();
	}

	public boolean isFull() {
		return getPlayerCount() >= MAX_SQUAD_SIZE;
	}

	public void addPlayer(BattlefieldPlayer player) {
		if(isFull()) return;
		sendMessageToAll(ChatColor.GOLD + player.getName() + ChatColor.GREEN + " has joined your squad");
		players.add(player);
		player.sendMessage(ChatColor.GREEN + "You have joined the " + ChatColor.GOLD + name + " squad");
		if(player.getSquad() != null) {
			player.getSquad().removePlayer(player);
		}
		player.setSquad(this);
	}

	public void removePlayer(BattlefieldPlayer player) {
		players.remove(player);
		player.setSquad(null);
	}

	public String getName() {
		return name;
	}

	public boolean isPrivateSquad() {
		return privateSquad;
	}

	private void sendMessageToAll(String msg) {
		for(BattlefieldPlayer player : players) {
			player.sendMessage(msg);
		}
	}

}

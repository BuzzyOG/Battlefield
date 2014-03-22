package me.august.bf4.team;

import org.bukkit.ChatColor;

public class BF4Team {

	private String name;
	private ChatColor color;
	private int maxPlayers;

	public BF4Team(String name, ChatColor color) {
		this(name, color, 32);
	}

	public BF4Team(String name, ChatColor color, int maxPlayers) {
		this.name = name;
		this.color = color;
		this.maxPlayers = maxPlayers;
	}

	public String getName() {
		return "" + ChatColor.RESET + color + name + ChatColor.RESET;
	}

	public String getNormalName() {
		return name;
	}

	public ChatColor getColor() {
		return color;
	}

	public int getMaxPlayers() {
		return maxPlayers;
	}

}

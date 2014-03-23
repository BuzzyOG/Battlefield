package me.august.battlefield.player;

import me.august.battlefield.BattlefieldPlugin;
import me.august.battlefield.guns.BattlefieldClass;
import me.august.battlefield.team.BattlefieldTeam;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.lang.ref.WeakReference;

public class BattlefieldPlayer {

	public static BattlefieldPlayer get(Player player) {
		for(BattlefieldPlayer p : BattlefieldPlugin.getCurrentMatch().getPlayers()) {
			if(p.getPlayer() == player) return p;
		}
		return null;
	}

	public static BattlefieldPlayer get(String name) {
		return get(Bukkit.getPlayer(name));
	}

	private WeakReference<Player> player;
	private BattlefieldClass battlefieldClass;
	private BattlefieldTeam team;

	public BattlefieldPlayer(Player player) {
		this.player = new WeakReference<>(player);
		battlefieldClass = BattlefieldClass.ASSAULT;
	}

	public BattlefieldTeam getTeam() {
		return team;
	}

	public BattlefieldClass getBattlefieldClass() {
		return battlefieldClass;
	}

	public Player getPlayer() {
		return player.get();
	}

	/* Aliases */
	public void sendMessage(String msg) {
		getPlayer().sendMessage(msg);
	}

	public void teleport(Location location) {
		getPlayer().teleport(location);
	}

}

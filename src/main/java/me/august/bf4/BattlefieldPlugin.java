package me.august.bf4;

import me.august.bf4.exception.ParsingException;
import me.august.bf4.game.Match;
import me.august.bf4.guns.Gun;
import me.august.bf4.guns.GunFactory;
import me.august.bf4.guns.KitItem;
import me.august.bf4.util.Log;
import me.august.bf4.util.XMLUtils;
import org.bukkit.plugin.java.JavaPlugin;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.ArrayList;
import java.util.List;

public class BattlefieldPlugin extends JavaPlugin {

	private static BattlefieldPlugin instance;

	private Match currentMatch;
	private List<KitItem> availableItems;

	@Override
	public void onEnable() {
		instance = this;

		currentMatch = new Match();
		availableItems = new ArrayList<>();

		Document xml = null;
		Log.info("Loading gun XML file");
		try {
			xml = new SAXReader().read(getClassLoader().getResourceAsStream("guns.xml"));
		} catch(DocumentException e) {
			Log.warning("Unable to parse gun XML file:");
			e.printStackTrace();
		}

		if(xml != null) {
			for(Element gunElement : XMLUtils.getElements(xml.getRootElement(), "gun")) {
				try {
					Gun gun = GunFactory.build(gunElement);
					availableItems.add(gun);
					Log.info("Gun parsed: " + gun.toString());
				} catch(ParsingException e) {
					Log.warning("Unable to parse gun:");
					e.printStackTrace();
				}
			}
		}

		Log.info(String.valueOf(availableItems.size()) + " guns have been loaded");

	}

	@Override
	public void onDisable() {

	}

	public static BattlefieldPlugin get() {
		return instance;
	}

	public static Match getCurrentMatch() {
		return get().currentMatch;
	}

}

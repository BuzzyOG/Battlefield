package me.august.battlefield.game;

import static me.august.battlefield.util.ParsingUtils.*;

import me.august.battlefield.BattlefieldPlugin;
import me.august.battlefield.team.BattlefieldTeam;
import me.august.battlefield.util.XMLUtils;
import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;

/**
 * Created by August on 3/23/14.
 */
public class MatchLoader {

	public static Match load(String name) throws Exception {
		Document xml = BattlefieldPlugin.loadFromResources("map.xml");
		BattlefieldMap map = new BattlefieldMap(name, xml);
		Match match = new Match(map, Bukkit.createWorld(new WorldCreator(name)));
		for(Element teamEle : XMLUtils.getElements(xml.getRootElement().element("teams"), "team")) {
			validateAttributes(teamEle, "name", "color", "maxplayers");
			validateElements(teamEle, "spawn");
			BattlefieldTeam team = new BattlefieldTeam(
					teamEle.attributeValue("name"),
					parseColor(teamEle.attributeValue("color")),
					parseInt(teamEle.attributeValue("maxplayers")),
					parseVector(teamEle.element("spawn").getText())
			);
			team.setMatch(match);
			match.addTeam(team);
		}
		return match;
	}

}
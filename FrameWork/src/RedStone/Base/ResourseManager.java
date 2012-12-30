package RedStone.Base;

import java.util.HashMap;

import javax.sound.midi.Track;

import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.util.xml.XMLElement;
import org.newdawn.slick.util.xml.XMLElementList;
import org.newdawn.slick.util.xml.XMLParser;

public class ResourseManager {
	private static HashMap<String, Image> images;
	private static HashMap<String, Sound> sounds;
	private static HashMap<String, SpriteSheet> spriteSheets;
	private static HashMap<String, Music> music;
	private static HashMap<String, MusicManager> tracks;
	private static String resAddr;

	public static void load(String addr) {
		resAddr = addr;
		images = new HashMap<String, Image>();
		sounds = new HashMap<String, Sound>();
		spriteSheets = new HashMap<String, SpriteSheet>();
		tracks = new HashMap<String, MusicManager>();
		music = new HashMap<String, Music>();
		
		XMLParser parser = new XMLParser();
		XMLElement root = null;
		try {
			root = parser.parse(addr + "/test.xml");
			
			XMLElementList elements = root.getChildrenByName("image");
			for (int i = 0; i < elements.size(); i++) {
				handleImage(elements.get(i));
			}
			elements = root.getChildrenByName("sound");
			for (int i = 0; i < elements.size(); i++) {
				XMLElement element = elements.get(i);
				Sound sound = new Sound(resAddr+"/"+element.getAttribute("loc"));
				sounds.put(element.getAttribute("name"), sound);
			}
			elements = root.getChildrenByName("music");
			for(int i = 0; i < elements.size();i++){
				XMLElement element = elements.get(i);
				Music music = new Music(resAddr+"/"+element.getAttribute("loc"));
				ResourseManager.music.put(element.getAttribute("name"), music);
			}
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	private static void handleImage(XMLElement element) throws SlickException {
		Image image = new Image(resAddr + "/" + element.getAttribute("loc"));
		images.put(element.getAttribute("name"), image);
		XMLElementList subelements = element.getChildrenByName("sheet");
		for (int i = 0; i < subelements.size(); i++) {
			XMLElement subElement = subelements.get(i);
			spriteSheets.put(element.getAttribute("name"),
					new SpriteSheet(image, subElement.getIntAttribute("tilew"),
							subElement.getIntAttribute("tileh")));
		}
	}
	private static void handleTrack(XMLElement element){
		MusicManager track = new MusicManager();
		
	}
	public static Image getImage(String name) {
		return images.get(name);
	}

	public static Image getImage(String name, int x, int y) {
		return spriteSheets.get(name).getSprite(x, y);
	}
}

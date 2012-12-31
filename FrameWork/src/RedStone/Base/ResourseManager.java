package RedStone.Base;

import java.util.HashMap;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.util.xml.SlickXMLException;
import org.newdawn.slick.util.xml.XMLElement;
import org.newdawn.slick.util.xml.XMLElementList;
import org.newdawn.slick.util.xml.XMLParser;

public class ResourseManager {
	private static HashMap<String, Sound> sounds;
	private static HashMap<String, SpriteSheet> spriteSheets;
	private static HashMap<String, Music> music;
	private static HashMap<String, MusicManager> tracks;
	private static HashMap<String, Animation> animations;
	private static String resAddr;

	public static void load(String addr) {
		resAddr = addr;
		sounds = new HashMap<String, Sound>();
		spriteSheets = new HashMap<String, SpriteSheet>();
		tracks = new HashMap<String, MusicManager>();
		music = new HashMap<String, Music>();
		animations = new HashMap<String, Animation>();
		
		XMLParser parser = new XMLParser();
		XMLElement root = null;
		try {
			root = parser.parse(addr + "/resources.xml");
			
			XMLElementList elements = root.getChildrenByName("sheet");
			for (int i = 0; i < elements.size(); i++) {
				handleSheet(elements.get(i));
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
			elements = root.getChildrenByName("track");
			for(int i = 0; i < elements.size();i++){
				handleTrack(elements.get(i));
			}
			elements = root.getChildrenByName("animation");
			for(int i = 0; i < elements.size();i++){
				handleAnimation(elements.get(i));
			}
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	private static void handleSheet(XMLElement element) throws SlickException {
			spriteSheets.put(element.getAttribute("name"),
					new SpriteSheet(element.getAttribute("loc"), element.getIntAttribute("tilew"),
							element.getIntAttribute("tileh"),element.getIntAttribute("space",0)));
	}
	private static void handleTrack(XMLElement element){
		MusicManager track = new MusicManager();
		XMLElementList subelements = element.getChildrenByName("song");
		for(int i = 0;i < subelements.size();i++){
			XMLElement subelement = subelements.get(i);
			track.add(music.get(subelement.getAttribute("ref")));
		}
		tracks.put(element.getAttribute("name"), track);
	}
	private static void handleAnimation(XMLElement element) throws SlickXMLException{
		Animation animation;
		if(element.getIntAttribute("speed", 0) > 0)
			animation = new Animation(spriteSheets.get(element.getAttribute("sheet")), element.getIntAttribute("speed"));
		else{
			XMLElementList subelements = element.getChildrenByName("frame");
			animation = new Animation(true);
			for(int i = 0;i < subelements.size();i++){
				XMLElement subelement = subelements.get(i);
				animation.addFrame(spriteSheets.get(element.getAttribute("sheet")).getSprite(subelement.getIntAttribute("x"), subelement.getIntAttribute("y")), subelement.getIntAttribute("dir"));
			}
		}
		animations.put(element.getAttribute("name"), animation);
	}

	public static Image getImage(String name, int x, int y) {
		return spriteSheets.get(name).getSprite(x, y);
	}
	public static void playSong(String name){
		music.get(name).play();
	}
	public static void playTrack(String name){
		tracks.get(name).play();
	}
	public static void playSound(String name){
		sounds.get(name).play();
	}
	public static Animation getAnimation(String name){
		return animations.get(name).copy();
	}
}

package RedStone.SpaceGame.Tiles;

import org.newdawn.slick.Color;

import RedStone.Base.Tile;

public class Hull extends Tile {
	public static final int price = 40;
	public Hull(){
		setSolid(true);
		add(new SolidColor(Color.gray));
	}
}

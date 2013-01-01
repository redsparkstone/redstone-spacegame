package RedStone.SpaceGame;

import RedStone.SpaceGame.Tiles.Hull;
import RedStone.SpaceGame.Tiles.Interiour;

public class MapLoader {
	public static void defaltMap(SpaceWorld world){
		for(int i = 5;i < 10;i++){
			world.setTile(new Interiour(), i, 10);
			world.setTile(new Hull(), i, 11);
		}
		world.setTile(new Hull(), 10, 10);
	}
}

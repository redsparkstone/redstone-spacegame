package RedStone.SpaceGame;

import RedStone.Base.Tile;
import RedStone.Base.World;
import RedStone.SpaceGame.Tiles.Hull;

public class MapLoader {
	public static void defaltMap(SpaceWorld world){
		fill(world,Hull.class,1,1,5,5);
		world.setTile(new Hull(), 10, 10);
	}
	public static void fill(World world,Class<? extends Tile> c,int sx,int sy,int ex,int ey){
		try {
			for(int x = sx;x<=ex;x++){
				for(int y = sy;y<=ey;y++){
					world.setTile(c.newInstance(), x, y);
				}
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}

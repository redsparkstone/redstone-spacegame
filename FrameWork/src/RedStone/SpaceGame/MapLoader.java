package RedStone.SpaceGame;

import RedStone.Base.Tile;
import RedStone.Base.World;
import RedStone.SpaceGame.Tiles.Hull;
import RedStone.SpaceGame.Tiles.Interiour;

public class MapLoader {
	public static void defaltMap(SpaceWorld world){
		fill(world,Interiour.class,1,1,5,5);
		box(world,Hull.class,0,0,6,6);
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
	public static void box(World world,Class<? extends Tile> c,int sx,int sy,int ex,int ey){
		try {
			for(int x = sx;x<=ex;x++){
				world.setTile(c.newInstance(), x, sy);
				world.setTile(c.newInstance(), x, ey);
			}
			for(int y = sy+1;y<ey;y++){
				world.setTile(c.newInstance(), sx, y);
				world.setTile(c.newInstance(), ex, y);
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}

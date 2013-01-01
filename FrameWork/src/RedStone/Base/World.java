package RedStone.Base;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

public class World {
	protected List<Entity> entitys;
	private Stack<Entity> buffin, buffout;
	public static int tileSize = 10;
	public void init() {
		entitys = new ArrayList<Entity>();
		buffin = new Stack<Entity>();
		buffout = new Stack<Entity>();
	}

	public void update(GameContainer gc, StateBasedGame sbg) {
		while (!buffin.empty()) {
			entitys.add(buffin.pop());
		}
		for (Entity ent : entitys) {
			ent.update(this, gc, sbg);
		}
		while (!buffout.empty()) {
			entitys.remove(buffout.pop());
		}
	}

	public void add(Entity ent) {
		buffin.push(ent);
	}

	public void remove(Entity ent) {
		buffout.push(ent);
	}
	
	public Tile getTile(int x,int y){
		for(Entity ent:entitys){
			if(ent.getTileX() == x && ent.getTileY() == y && ent instanceof Tile){
				return (Tile)ent;
			}
		}
		return null;
	}
	
	public void removeTile(int x,int y){
		Tile tile = getTile(x,y);
		if(tile != null){
			remove(tile);
		}
	}
	
	public void setTile(Tile tile,int x,int y){
		removeTile(x, y);
		tile.setX(x*tileSize);
		tile.setY(y*tileSize);
		add(tile);
	}
}

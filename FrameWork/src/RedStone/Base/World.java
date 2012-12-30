package RedStone.Base;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

public class World {
	protected List<Entity> entitys;
	private Stack<Entity> buffin, buffout;

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
}

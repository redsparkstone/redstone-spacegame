package RedStone.SpaceGame;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import RedStone.Base.Camera;
import RedStone.Base.Entity;
import RedStone.Base.ResourseManager;
import RedStone.Base.World;
import TWLSlick.BasicTWLGameState;

public class PlayingState extends BasicTWLGameState {
	World world = new World();
	Camera cam;
	boolean pause = false;

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		ResourseManager.load("res");

		world.init();
		cam = new Camera(0, 0,400,400, world);

		Entity ent = new Entity();
		ent.setX(5);
		ent.setY(5);

		ent.add(new TestComp());
		world.add(ent);
		
		ResourseManager.playTrack("track1");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		cam.render(gc, sbg, g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		if (!pause) {
			world.update(gc, sbg);
		}
	}

	@Override
	public int getID() {
		return 0;
	}

}

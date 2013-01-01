package RedStone.SpaceGame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import RedStone.Base.Camera;
import RedStone.Base.ResourseManager;
import TWLSlick.BasicTWLGameState;

public class PlayingState extends BasicTWLGameState {
	SpaceWorld world = new SpaceWorld();
	Camera cam;
	boolean pause = false;

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		ResourseManager.load("res");
		world.init();
		
		cam = new Camera(0, 0,600,600, world);
		
		MapLoader.defaltMap(world);
		
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

package RedStone.SpaceGame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import RedStone.Base.Camera;
import RedStone.Base.RenderComponent;
import RedStone.Base.ResourseManager;
import RedStone.Base.World;

public class TestComp extends RenderComponent {

	@Override
	public void render(World world, Camera cam, GameContainer gc,
			StateBasedGame sbg, Graphics g) {
		g.drawImage(ResourseManager.getImage("test"), 5, 5);

	}

	@Override
	public void update(World world, GameContainer gc, StateBasedGame sbg) {

	}

}

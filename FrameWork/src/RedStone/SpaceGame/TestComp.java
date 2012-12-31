package RedStone.SpaceGame;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;

import RedStone.Base.Camera;
import RedStone.Base.RenderComponent;
import RedStone.Base.ResourseManager;
import RedStone.Base.World;

public class TestComp extends RenderComponent {
	private Animation rot;
	public TestComp(){
		rot = ResourseManager.getAnimation("rot");
		rot.setLooping(true);
		rot.setPingPong(true);
		rot.start();
	}
	@Override
	public void render(World world, Camera cam, GameContainer gc,
			StateBasedGame sbg, Graphics g) {
		Image frame = rot.getCurrentFrame();
		g.drawAnimation(rot,getParint().getX(), getParint().getY());
	}

	@Override
	public void update(World world, GameContainer gc, StateBasedGame sbg) {
		getParint().setX(getParint().getX()+1);
	}

}

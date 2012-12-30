package RedStone.Base;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public abstract class RenderComponent extends Component {
	public abstract void render(World world, Camera cam, GameContainer gc,
			StateBasedGame sbg, Graphics g);
}

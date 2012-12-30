/** Description of Component
 * 
 * @author Gabriel keith
 * @version Dec 22, 2012.
 */

package RedStone.Base;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

public abstract class Component {
	private Entity parint;

	protected void setParint(Entity parint) {
		this.parint = parint;
	}

	public Entity getParint() {
		return parint;
	}

	/**
	 * updates the component's internals.
	 */
	public abstract void update(World world, GameContainer gc,
			StateBasedGame sbg);

}

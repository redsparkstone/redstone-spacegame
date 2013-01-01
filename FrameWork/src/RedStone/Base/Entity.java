package RedStone.Base;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

/**
 * basic framework for an entity component system
 * 
 * @author Gabriel keith
 * @version Dec 22, 2012.
 */
public class Entity {
	private List<Component> components;
	private Stack<Component> buffin, buffout;
	private boolean solid = false;
	private float x, y;

	/**
	 * default constructor
	 */
	public Entity() {
		components = new ArrayList<Component>();
		buffin = new Stack<Component>();
		buffout = new Stack<Component>();
	}

	/**
	 * Updates all the Component's
	 * 
	 * @param world
	 *            the context
	 * @param gc
	 * @param sbg
	 */
	public void update(World world, GameContainer gc, StateBasedGame sbg) {
		while (!buffin.empty()) {
			components.add(buffin.pop());
		}
		for (Component comp : components) {
			comp.update(world, gc, sbg);
		}
		while (!buffout.empty()) {
			components.remove(buffout.pop());
		}
	}

	/**
	 * draw's all render components
	 * 
	 * @param world
	 *            the context
	 * @param gc
	 * @param sbg
	 * @param g
	 */
	public void render(World world, Camera cam, GameContainer gc,
			StateBasedGame sbg, Graphics g) {
		for (Component comp : components) {
			if (comp instanceof RenderComponent) {
				((RenderComponent) comp).render(world, cam, gc, sbg, g);
			}
		}
	}

	/**
	 * add's the component after the update completes
	 * 
	 * @param comp
	 *            an component to add
	 */
	public void add(Component comp) {
		comp.setParint(this);
		buffin.push(comp);
	}

	/**
	 * remove's the component after the update completes
	 * 
	 * @param comp
	 *            an component to remove
	 */
	public void remove(Component comp) {
		buffout.push(comp);
	}

	/**
	 * @return a list of all the components in the entity
	 */
	public List<Component> getComponents() {
		return components;
	}

	/**
	 * @param x
	 *            the entity's center possession on the x axis
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * @param y
	 *            the entity's center possession on the y axis
	 */
	public void setY(float y) {
		this.y = y;
	}

	/**
	 * @return the entity's center possession on the x axis
	 */
	public float getX() {
		return x;
	}

	/**
	 * @return the entity's center possession on the y axis
	 */
	public float getY() {
		return y;
	}
	
	public int getTileX(){
		return (int) (getX()/World.tileSize);
	}
	
	public int getTileY(){
		return (int) (getY()/World.tileSize);
	}
	
	public boolean isSolid(){
		return solid;
	}
	
	public void setSolid(boolean solid){
		this.solid=solid;
	}
}
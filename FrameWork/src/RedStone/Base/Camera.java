package RedStone.Base;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Camera {
	private float x, y;
	private World world;
	private int frameX, frameY, frameW, frameH;
	private Image buffer;

	public Camera(float x, float y, World world) {
		this.x = x;
		this.y = y;
		this.world = world;
	}

	public Camera() {
		x = 0;
		y = 0;
	}

	protected void initBuffer() {
		try {
			buffer = new Image(frameW, frameH);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) {
		for (Entity ent : world.entitys) {
			ent.render(world, this, gc, sbg, g);
		}
	}
}
package RedStone.Base;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Camera {
	private float x = 0, y = 0,
		horizontalScale = 1,
		verticalScale = 1;
	private World world;
	private int screenX, screenY, screenW, screenH;
	private Image buffer;
	private int state = 1;
	private float speed = 3;
	public Camera(int screenX,int screenY,int screenW,int screenH, World world) {
		setScreenX(screenX);
		setScreenY(screenY);
		setScreenW(screenW);
		setScreenH(screenH);
		initBuffer();
		this.world = world;
	}

	public Camera() {
		x = 0;
		y = 0;
		initBuffer();
	}

	protected void initBuffer() {
		try {
			buffer = new Image(screenW, screenH);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	public void setScreenX(int x){
		screenX = x;
	}
	public void setScreenY(int y){
		screenY = y;
	}
	public void setScreenW(int w){
		screenW = w;
	}
	public void setScreenH(int h){
		screenH = h;
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

	public void render(GameContainer gc, StateBasedGame sbg, Graphics frame) {
		try {
			Graphics g = buffer.getGraphics();
			g.clear();
			g.scale(horizontalScale, verticalScale);
			g.translate(x, y);
			for (Entity ent : world.entitys) {
				ent.render(world, this, gc, sbg, g);
			}
			frame.drawImage(buffer, screenX, screenY);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	public void update(GameContainer gc){
		Input input = gc.getInput();
		switch(state){
		case 1:
			if(input.isKeyDown(Input.KEY_UP)){
				y+=speed;
			}
			if(input.isKeyDown(Input.KEY_DOWN)){
				y-=speed;
			}
			if(input.isKeyDown(Input.KEY_LEFT)){
				x+=speed;
			}
			if(input.isKeyDown(Input.KEY_RIGHT)){
				x-=speed;
			}
			break;
		}
	}
}
package RedStone.SpaceGame.Tiles;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import RedStone.Base.Camera;
import RedStone.Base.RenderComponent;
import RedStone.Base.World;

public class SolidColor extends RenderComponent {
	private Color color;
	
	public SolidColor(Color color){
		setColor(color);
	}
	
	@Override
	public void render(World world, Camera cam, GameContainer gc,
			StateBasedGame sbg, Graphics g) {
		
	}

	@Override
	public void update(World world, GameContainer gc, StateBasedGame sbg) {
		
		
	}
	public void setColor(Color color){
		this.color=color;
	}
	public Color getColor(){
		return color;
	}
}

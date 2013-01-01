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
	private Color borderColor;
	private boolean hasBorder = false;
	private int borderSize;
	public SolidColor(Color color,Color borderColor,int borderSize){
		setColor(color);
		setBorder(borderColor, borderSize);
	}
	public SolidColor(Color color){
		setColor(color);
	}
	
	@Override
	public void render(World world, Camera cam, GameContainer gc,
			StateBasedGame sbg, Graphics g) {
		g.setColor(color);
		g.fillRect(getParint().getX(), getParint().getY(), World.tileSize, World.tileSize);
		if(hasBorder){
			g.setColor(borderColor);
			g.fillRect(getParint().getX(), getParint().getY(), borderSize, World.tileSize);
			g.fillRect(getParint().getX(), getParint().getY(), World.tileSize, borderSize);
			g.fillRect(getParint().getX()+World.tileSize-borderSize, getParint().getY(), borderSize, World.tileSize);
			g.fillRect(getParint().getX(), getParint().getY()+World.tileSize-borderSize, World.tileSize, borderSize);
		}
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
	public void setBorder(Color color,int size){
		hasBorder = true;
		this.borderColor=color;
		borderSize = size;
	}
}

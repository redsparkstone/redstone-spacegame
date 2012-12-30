package RedStone.SpaceGame;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class SpaceGame extends StateBasedGame {

	public static void main(String[] args) {
		AppGameContainer agc;
		try {
			agc = new AppGameContainer(new SpaceGame(), 800, 800, false);
			agc.setTargetFrameRate(40);
			agc.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public SpaceGame() {
		super("SpaceGame");

	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		addState(new PlayingState());

	}

}

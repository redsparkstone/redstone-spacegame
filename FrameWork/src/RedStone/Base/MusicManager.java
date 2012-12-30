package RedStone.Base;

import java.util.ArrayList;

import org.newdawn.slick.Music;
import org.newdawn.slick.MusicListener;

public class MusicManager implements MusicListener{
	private ArrayList<Music> Track;
	private int position = 0;
	public MusicManager(){
		Track = new ArrayList<Music>();
	}
	public void add(Music music){
		Track.add(music);
		music.addListener(this);
	}
	@Override
	public void musicEnded(Music music) {
		position++;
		if(position >= Track.size())
			position=0;
		Track.get(position).play();
	}
	@Override
	public void musicSwapped(Music music, Music newMusic) {
		
		
	}
	public void play(){
		Track.get(position).play();
	}
	public void pause(){
		Track.get(position).pause();
	}
}

package astro_war;

import java.util.HashMap;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class FXSound {
	private HashMap<String, AudioClip> effect_map = new HashMap<>();
	private HashMap<String, MediaPlayer> bgm_map = new HashMap<>();
	private Media main;
	private Media game;
	
	public FXSound() {
		try {
			System.out.print("Sound Loading.. ");
			main = new Media(AstroWar.class.getResource("../sounds/main.mp3").toString());
			game = new Media(AstroWar.class.getResource("../sounds/game_bgm.mp3").toString());
			bgm_map.put("main", new MediaPlayer(main));
			bgm_map.put("game", new MediaPlayer(game));
			effect_map.put("item", new AudioClip(AstroWar.class.getResource("../sounds/item.mp3").toString()));
			effect_map.put("explosion", new AudioClip(AstroWar.class.getResource("../sounds/explosion.mp3").toString()));
			effect_map.put("shoot", new AudioClip(AstroWar.class.getResource("../sounds/shoot.mp3").toString()));
			System.out.println("Done!");
		} catch (Exception e) {
			System.out.println("Error!");
			e.printStackTrace();
		}
	}
	
	/* 1.25배 속도로 음악재생 */
	public void BGMPlay(String key) {
		MediaPlayer temp = bgm_map.get(key);
		temp.setOnEndOfMedia(()->{ 
			temp.seek(Duration.ZERO); //무한반복
		});
		temp.play();
		temp.setRate(1.25);
	}
	
	/* 음악 중지 */
	public void BGMstop(String key) {
		try {
			MediaPlayer temp = bgm_map.get(key);
			temp.stop();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/* 해당하는 키 값의 사운드를 재생 */
	public void EffectPlay(String key) {
		effect_map.get(key).play();
	}
}

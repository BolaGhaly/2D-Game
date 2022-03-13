package main;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	Clip clip;
	URL soundUrl[] = new URL[30];

	public Sound() {
		soundUrl[0] = getClass().getResource("/sounds/backgroundMusic.wav");
		soundUrl[1] = getClass().getResource("/sounds/collectKey.wav");
		soundUrl[2] = getClass().getResource("/sounds/cursor.wav");
		soundUrl[3] = getClass().getResource("/sounds/fanfare.wav");
		soundUrl[4] = getClass().getResource("/sounds/hitmonster.wav");
		soundUrl[5] = getClass().getResource("/sounds/levelup.wav");
		soundUrl[6] = getClass().getResource("/sounds/powerup.wav");
		soundUrl[7] = getClass().getResource("/sounds/receiveddamage.wav");
		soundUrl[8] = getClass().getResource("/sounds/unlockDoor.wav");
	}

	public void setFile(int i) {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundUrl[i]);
			clip = AudioSystem.getClip();
			clip.open(ais);

		} catch (Exception e) {

		}
	}

	public void play() {
		clip.start();
	}

	public void loop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}

	public void stop() {
		clip.stop();
	}
}

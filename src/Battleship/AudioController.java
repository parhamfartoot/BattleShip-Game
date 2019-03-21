package Battleship;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import java.net.URL;
import javax.sound.sampled.*;

public class AudioController {

    static void playLaserSound() {
        Media media = new Media(AudioController.class.getResource("/Sound/sound_spark_Laser-Like_Synth_Basic_Laser2_07.mp3").toString());
        MediaPlayer soundPlayer = new MediaPlayer(media);
        soundPlayer.setVolume(12.0);
        soundPlayer.play();
    }
    static void playExplosionSound() {
        Media media = new Media(AudioController.class.getResource("/Sound/explosion_large_distant.mp3").toString());
        MediaPlayer soundPlayer = new MediaPlayer(media);
        soundPlayer.setVolume(18);
        soundPlayer.play();
    }
    static void playThemeSong() throws Exception {
        URL url =AudioController.class.getResource("/Sound/Orbit Beat 130.wav");
        Clip clip = AudioSystem.getClip();
        AudioInputStream ais = AudioSystem.getAudioInputStream(url);
        clip.open(ais);

        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-20f);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}



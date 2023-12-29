import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sound {
    private File soundFile;
    public Sound (String fileName) {
        String soundFilePath = fileName;
        soundFile = new File(soundFilePath);
    }
    public void play() {
        try {
            // Create an AudioInputStream from the sound file
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);

            // Get the Clip
            Clip clip = AudioSystem.getClip();

            // Open the AudioInputStream
            clip.open(audioInputStream);

            // Start playing the sound
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}

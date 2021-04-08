import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SoundPlayer {

    public SoundPlayer(String path) throws IOException, UnsupportedAudioFileException, LineUnavailableException {

        File sound = new File(path);

        AudioInputStream audiStream = AudioSystem.getAudioInputStream(sound);
        Clip clip = AudioSystem.getClip();
        clip.open(audiStream);
        clip.start();

        Scanner scan = new Scanner(System.in);
        String play = "";

        while (!play.equals("q")){
            System.out.println("P - play, S - stop, R - reset, Q - Quit");
            play = scan.nextLine();
            play = play.toLowerCase();

            switch (play){
                case "p":
                    clip.start();
                    break;
                case "s":
                    clip.stop();
                    break;
                case "r":
                    clip.setMicrosecondPosition(0);
                    break;
                case "q":
                    clip.close();
                    break;
                default:
                    System.out.println("not a valid key");

                if (!clip.isRunning()){
                    System.out.println("Clip Finished");
                }
            }
        }


    }

    public static void main(String arg[]) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        Scanner scan = new Scanner(System.in);

        System.out.println("Please paste the Absolute path to your WAV file. WAV files are the only ones that work at this moment");
        String path = scan.nextLine();

        SoundPlayer player = new SoundPlayer(path);

    }

}

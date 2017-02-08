package vue;
import java.io.*;
import javax.sound.midi.*;
   
/**
 * @author Mallem Saliha
 *
 * @Date   13/06/2012
 */


                           /*
                            *    Cette classe permet la lecture d'un fichier audio
                            * 
                            */
public class MidiSoundTest {
   private static Sequencer midiPlayer;
   
  
   
   public static void startMidi(String midFilename) {
      try {
         File midiFile = new File(midFilename);
         Sequence song = MidiSystem.getSequence(midiFile);
         midiPlayer = MidiSystem.getSequencer();
         midiPlayer.open();
         midiPlayer.setSequence(song);
         midiPlayer.setLoopCount(0); // repeat 0 times (play once)
         midiPlayer.start();
         midiPlayer.setLoopCount(10000);
      } catch (MidiUnavailableException e) {
         e.printStackTrace();
      } catch (InvalidMidiDataException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}

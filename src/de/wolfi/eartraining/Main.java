package de.wolfi.eartraining;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import javax.swing.*;
import java.util.Random;

/**
 * Created by root on 12.07.2017.
 */
public class Main {

    private static MidiChannel channel;
    public static void main(String[] args) throws MidiUnavailableException {
        Synthesizer system = MidiSystem.getSynthesizer();
        system.open();
        channel = system.getChannels()[0];
        ControlGui gui = new ControlGui();
        gui.setSize(800,230);
        gui.setResizable(false);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
    }

    public static void playStep(Step step, int startNote){
        System.out.println(step.getName());

            Thread thread = new Thread(()-> {
                try {
                channel.noteOn(startNote, 127);

                Thread.sleep(2500);
                channel.noteOff(startNote);
                Thread.sleep(500);
                channel.noteOn(startNote + step.getStep(), 127);
                Thread.sleep(2500);
                channel.noteOff(startNote + step.getStep());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();

    }
}

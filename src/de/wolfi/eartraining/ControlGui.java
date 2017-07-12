package de.wolfi.eartraining;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by root on 12.07.2017.
 */

public class ControlGui extends  JFrame{
    private static final Random RANDOM = new Random();


    private JButton playButton;
    private JButton skipButton;
    private JPanel mainPanel;
    private JPanel buttonPanel;
    private StepTile tile0;
    private StepTile tile1;
    private StepTile tile2;
    private StepTile tile3;
    private StepTile tile4;
    private StepTile tile5;
    private StepTile tile6;
    private StepTile tile7;
    private StepTile tile8;
    private StepTile tile9;
    private StepTile tile10;
    private StepTile tile11;

    protected static Step currentStep;
    protected static int currentNote;

    public ControlGui() {
        add(mainPanel);
        generateNextNotes();

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playNotes();
            }
        });
        skipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateNextNotes();
                playNotes();
            }
        });
    }

    protected static void generateNextNotes(){
        currentNote = RANDOM.nextInt(20)+50;

        currentStep = Step.values()[RANDOM.nextInt(Step.values().length)];
        while(!currentStep.isEnabled()) currentStep = Step.values()[RANDOM.nextInt(Step.values().length)];
    }

    protected static void playNotes(){
        Main.playStep(currentStep,currentNote);
    }


    @Override
    public void setVisible(boolean b) {

        super.setVisible(b);
    }



    private void createUIComponents() {
        tile0 = new StepTile(Step.values()[0]);
        tile1 = new StepTile(Step.values()[1]);
        tile2 = new StepTile(Step.values()[2]);
        tile3 = new StepTile(Step.values()[3]);
        tile4 = new StepTile(Step.values()[4]);
        tile5 = new StepTile(Step.values()[5]);
        tile6 = new StepTile(Step.values()[6]);
        tile7 = new StepTile(Step.values()[7]);
        tile8 = new StepTile(Step.values()[8]);
        tile9= new StepTile(Step.values()[9]);
        tile10 = new StepTile(Step.values()[10]);
        tile11 = new StepTile(Step.values()[11]);




    }
}

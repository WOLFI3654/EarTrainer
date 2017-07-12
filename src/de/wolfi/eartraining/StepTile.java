package de.wolfi.eartraining;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by root on 12.07.2017.
 */
public class StepTile extends JPanel{
    private final Step step;
    private JButton button;
    private JCheckBox checkBox1;
    private JPanel topLevel;

    public StepTile(Step step) {
        this.step = step;
        button.setText(step.getName());
        checkBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button.setEnabled(checkBox1.isSelected());
                step.toggle();
            }
        });
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.playStep(step,ControlGui.currentNote);
                if(step.equals(ControlGui.currentStep)){
                    System.out.println("Found");
                    Thread blinker = new Thread(()->{
                        try{
                            for(int i =0; i < 4; i++) {
                                Thread.sleep(700);
                                button.setEnabled(false);

                                Thread.sleep(700);
                                button.setEnabled(true);
                            }
                        }catch(Exception exc){
                            exc.printStackTrace();
                        }
                        ControlGui.generateNextNotes();
                        ControlGui.playNotes();

                    });
                    blinker.start();
                }
            }
        });
    }
}

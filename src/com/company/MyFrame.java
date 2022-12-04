package com.company;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class MyFrame extends JFrame {

    private final int FRAME_WIDTH=800;
    private final int FRAME_HEIGHT=600;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JButton buttonYes;
    private JButton buttonNo;
    private JButton buttonReset;
    private JButton buttonSquare;
    private JButton buttonCircle;
    private JSlider slider;
    private Random random;
    private DrawingPanel panel;
    MyFrame(){

        label1=new JLabel();
        label1.setBounds(100,100,600,100);


        label2=new JLabel();
        label2.setBounds(50,420,250,20);
        label2.setText("Wybierz ksztalt: ");

        label3=new JLabel();
        label3.setBounds(35,520,250,40);
        label3.setText("Wybierz: k - kwadrat, o - kolko");

        label4=new JLabel();
        label4.setBounds(350,420,250,20);
        label4.setText("Wybierz rozmiar: ");

        panel=new DrawingPanel();

        buttonYes=new JButton("Canwa");
        buttonYes.setFocusable(false);
        buttonYes.addActionListener(e-> answerYes());
        buttonYes.setBounds(200,400,100,50);

        buttonNo=new JButton("Znikajacy");
        setFocusable(false);
        buttonNo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                final boolean isCursorInRightBound=e.getX()>3;
                if(isCursorInRightBound)
                    changeLocationButtonNo();
            }
        });
        buttonNo.addActionListener(e-> resetButtonNo());
        buttonNo.setBounds(500,400,100,50);

        buttonReset=new JButton("Reset");
        buttonReset.setFocusable(false);
        buttonReset.addActionListener(e->panel.drawing.removeShape());
        buttonReset.setBounds(620,460,100,50);

        buttonSquare=new JButton("Kwadrat");
        buttonSquare.setFocusable(false);
        buttonSquare.addActionListener(e->{
            panel.changeShape(1);
        });
        buttonSquare.setBounds(50,460,100,50);

        buttonCircle=new JButton("Kolko");
        buttonCircle.setFocusable(false);
        buttonCircle.addActionListener(e->{
        panel.changeShape(2);
        });
        buttonCircle.setBounds(160,460,100,50);

        slider=new JSlider(0,100,50);
       slider.setBounds(350,450,200,100);
       slider.setPaintTicks(true);
       slider.setMajorTickSpacing(20);
        slider.setPaintLabels(true);
        slider.addChangeListener(e->panel.changeSize(slider.getValue()));

        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(label1);
        this.add(buttonYes);
        this.add(buttonNo);

        this.setVisible(true);
    }

    private void answerYes(){
        this.getContentPane().removeAll();
        this.add(panel);
        this.add(label2);
        this.add(label3);
        this.add(label3);
        this.add(buttonReset);
        this.add(buttonSquare);
        this.add(buttonCircle);
        this.add(slider);
        this.validate();
        this.repaint();
    }
    private void changeLocationButtonNo(){
        random=new Random();
        buttonNo.setBounds(random.nextInt(251)+400, random.nextInt(201)+300,100,50);
    }
    private void resetButtonNo(){
        buttonNo.setBounds(500,400,100,50);
    }
}

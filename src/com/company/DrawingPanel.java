package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class DrawingPanel extends JPanel {
    protected final DrawingCanwa drawing;
    private int shapeChosen;

    DrawingPanel() {

        this.setBounds(40,10,700,400);
        this.drawing = new DrawingCanwa();
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        drawing.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch(e.getKeyCode()) {
                    case KeyEvent.VK_O:
                        System.out.println("Wybrales kolko");
                        changeShape(2);
                        break;

                    case KeyEvent.VK_K:
                        System.out.println("Wybrales kwadrat");
                        changeShape(1);
                        break;

                    default :
                        break;

                }
            }
        });

        drawing.addMouseListener(new MouseAdapter() {
          public void mousePressed(MouseEvent e) {
                Random color = new Random();
                drawing.requestFocusInWindow();
                if(e.getButton() == MouseEvent.BUTTON1) {
                    System.out.println("[x="+e.getX()+",y="+e.getY()+"]");
                    if(shapeChosen == 1) {
                       drawing.addSquare(e.getPoint(), new Color(color.nextInt(250),color.nextInt(250),color.nextInt(250)));
                    }
                   else if(shapeChosen == 2) {
                       drawing.addCircle(e.getPoint(), new Color(color.nextInt(250),color.nextInt(250),color.nextInt(250)));
                   }
               }
                repaint();
            }
       });

        this.add(drawing, BorderLayout.CENTER);

    }

    public void changeShape(int num) {
        if(num == 1) shapeChosen = 1;
        else if(num == 2) shapeChosen = 2;
    }

    public void changeSize(int size) {
        drawing.setS(size);
    }
}
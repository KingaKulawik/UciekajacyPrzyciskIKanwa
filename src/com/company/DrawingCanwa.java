package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class DrawingCanwa extends JComponent {

    private int s = 60;
    private ArrayList<Shape> shapes;
    private ArrayList<Color> shapesColor;


    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;

        for(int i = 0; i < shapes.size(); i++) {
            g2.setColor(shapesColor.get(i));
            g2.fill(shapes.get(i));
        }
    }
    public void addCircle(Point2D p, Color color) {
        shapes.add(new Ellipse2D.Double(p.getX() - s /2, p.getY() - s /2, s, s));
        shapesColor.add(color);
    }

    public void addSquare(Point2D p, Color color) {
        shapes.add(new Rectangle2D.Double(p.getX() - s /2, p.getY() - s /2, s, s));
        shapesColor.add(color);
    }


    public void removeShape() {
        shapes.clear();
        shapesColor.clear();
        repaint();
    }
    public DrawingCanwa() {
        shapes = new ArrayList<>();
        shapesColor = new ArrayList<>();
    }

    public void setS(int SIDELENGTH) {
        this.s = SIDELENGTH;
    }
}

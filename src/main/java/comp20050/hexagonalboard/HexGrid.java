package comp20050.hexagonalboard;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HexGrid extends JPanel {
    private ArrayList<ArrayList<Point>> grid;

    public HexGrid(ArrayList<ArrayList<Point>> hexagons) {
        this.grid = hexagons;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.LIGHT_GRAY);

        for (ArrayList<Point> hexagon : grid) {
            for (Point p : hexagon) {
                int x = (int) Math.round(p.x);
                int y = (int) Math.round(p.y);
                g.fillOval(x - 5, y - 5, 10, 10);
            }
        }

        for (ArrayList<Point> hexagon : grid) {
            int p1xi, p1yi, p2xi, p2yi;
            Point p1 = hexagon.get(0), p2;
            for (int i = 1; i < hexagon.size(); i++) {
                p2 = hexagon.get(i);
                p1xi = (int) Math.round(p1.x);
                p1yi = (int) Math.round(p1.y);
                p2xi = (int) Math.round(p2.x);
                p2yi = (int) Math.round(p2.y);
                g.drawLine(p1xi, p1yi, p2xi, p2yi);
                p1 = p2;
            }

            p2 = hexagon.get(0);
            p1xi = (int) Math.round(p1.x);
            p1yi = (int) Math.round(p1.y);
            p2xi = (int) Math.round(p2.x);
            p2yi = (int) Math.round(p2.y);
            g.drawLine(p1xi, p1yi, p2xi, p2yi);
        }
    }
}
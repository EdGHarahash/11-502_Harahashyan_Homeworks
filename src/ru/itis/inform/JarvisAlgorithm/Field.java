package ru.itis.inform.JarvisAlgorithm;

import ru.itis.inform.lists.ArrayList;

public class Field {
    private ArrayList<Point> points;
    public Field(ArrayList<Point> points) {
        this.points = points;
    }
    public ArrayList<Point> getDots() {
        return this.points;
    }

    public void addPoint(Point point) {
        this.points.add(point);
    }

    public void show() {
        for (int i = 0; i < this.points.size(); i++) {
            System.out.println(this.points.get(i).getX()+", "+this.points.get(i).getY()+"  ");
        }
    }

    public ArrayList<Point> getShield() {
        return new JarvisAlg(this).run();
    }
}

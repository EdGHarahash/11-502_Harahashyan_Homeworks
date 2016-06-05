package ru.itis.inform.JarvisAlgorithm;

import ru.itis.inform.lists.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(1,1));
        points.add(new Point(4,3));
        points.add(new Point(2,0));
        points.add(new Point(2,2));
        points.add(new Point(4,1));
        points.add(new Point(3,2));
        points.add(new Point(3,4));
        points.add(new Point(1,3));
        points.add(new Point(2,3));

        Field field= new Field(points);
        points = field.getShield();

        for (int i = 0; i < points.size(); i++) {
            System.out.println(points.get(i).getX() + ", " + points.get(i).getY()+"   ");
        }
    }
}

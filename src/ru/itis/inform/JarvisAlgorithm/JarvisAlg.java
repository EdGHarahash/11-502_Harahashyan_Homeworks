package ru.itis.inform.JarvisAlgorithm;


import ru.itis.inform.lists.*;

import static java.lang.Math.pow;

public class JarvisAlg {

    private ArrayList<Point>  points;

    public JarvisAlg(Field field) {
        this.points = field.getDots();
    }

    public ArrayList<Point> run() {
        return findShield();
    }
    public boolean vect(Point a, Point b, Point c) {
        return (b.getX() - a.getX()) * (c.getY() - a.getY()) - (c.getX() - a.getX()) * (b.getY() - a.getY()) < 0;
    }

    public int distance(Point a, Point b) {
        return (int) pow((b.getX() - a.getX()), 2) + (int) pow((b.getY() - a.getY()), 2);
    }
    private int getLefter() {
        int lefter = 0;
        for (int i = 1; i < points.size(); i++) {
            if (points.get(i).getX() < points.get(lefter).getX())
                lefter = i;
        }
        return lefter;
    }

    private ArrayList<Point> findShield() {
        ArrayList<Point> result = new ArrayList<>();

        int lefter = getLefter();
        int x = points.get(lefter).getX();
        int y = points.get(lefter).getY();
        int p = lefter;
        int q;
        do {
            q = (p + 1);
            if (q>=points.size())q=q-2;
            for (int i = 0; i < points.size(); i++) {
                if (vect(points.get(p), points.get(i), points.get(q)))
                {
                    q = i;
                }

            }
            result.add(points.get(q));
            if ((points.get(p).getX() != x) || (points.get(p).getY() !=y)) {
                points.remove(p);
                p = p > q ? q : q - 1;
            }else p=q;
        } while ((points.get(p).getX() != x) || (points.get(p).getY() != y));
        return result;
    }
}

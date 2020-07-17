package Model;

import java.awt.*;
import java.util.LinkedList;
public class Trace {

    public Trace() {

    }

    public static void main(String[] args) {
        LinkedList<Point> traceList = new LinkedList<>();
        Coords c1 = new Coords(1, 2);
        Coords c2 = new Coords(2, 2);
        Point p1 = new Point(1, 2);
        traceList.add(p1);
//        traceList.add(c2);
        System.out.println(c1.getX());
        System.out.println((traceList.get(0).getX())+", " + traceList.get(0).getY());
        System.out.println("LinkedList:" + traceList);
        System.out.println(traceList.toString());
    }


    }

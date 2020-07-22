package Model;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Trace {
    private LinkedList<Coords> traceList;
    private Coords head;
    private Coords tail;

    public Trace() {
        this.traceList = new LinkedList<Coords>();

    }

    public double getTraceLength() {
        double sum = 0;
        for (int i = 0; i < traceList.size() - 2; i++) {
//            if (traceList.get(i).getX() < 0 || traceList.get(i).getY() < 0)

            sum += Math.sqrt(Math.pow(((traceList.get(i).getX()) - (traceList.get(i+1).getX())), 2) + Math.pow(((traceList.get(i).getY()) - (traceList.get(i+1).getY())), 2));
        }

        return sum;
    }

    public Coords getCoordsByIndex(int i) { return traceList.get(i); }


    public Coords[] getCoords() {return traceList.toArray(new Coords[0]);}

    public void addCoords(Coords coords){
        traceList.add(0, coords);
        head = coords;
    }

    public Coords getTraceHead() {
        return this.traceList.getFirst();
    }

    public Coords getTraceTail() {
        return traceList.getLast();
    }

    public void maxLength() {
        double max = 8;
        if (this.getTraceLength() <= max) return;
        double surplus = getTraceLength() - max;
        double segment = (getCoordsByIndex(traceList.size() - 1).distanceTo(getCoordsByIndex(traceList.size() - 2)));
        while(surplus > 0 && segment < surplus) {
                    traceList.removeLast();
                    surplus -= segment;
                }
        double deltaX = Math.abs((getCoordsByIndex(traceList.size() - 1).getX()) - (getCoordsByIndex(traceList.size() - 2).getX()));
        double dx2 = (deltaX * surplus) / segment;
        double deltaY = Math.abs((getCoordsByIndex(traceList.size() - 1).getY()) - (getCoordsByIndex(traceList.size() - 2).getY()));
        double dy2 = (deltaY * surplus) / segment;
        double newX = (traceList.getLast().getX()) - dx2;
        double newY = (traceList.getLast().getY()) - dy2;
        traceList.removeLast();
        traceList.addLast(new Coords(newX, newY));
    }

    public static void main(String[] args) {
//        LinkedList<Coords> traceList = new LinkedList<>();
        Trace trace1 = new Trace();
        trace1.addCoords(new Coords(4, 2));
        System.out.println("Head: " + trace1.getTraceHead());
        System.out.println((trace1.traceList.get(0).getX()) + ", " + trace1.traceList.get(0).getY());
        Coords c1 = new Coords(1, 2);
        Coords c2 = new Coords(4, 2);
        Coords c3 = new Coords(4, 3);
        Coords c4 = new Coords(4, 4);
        Coords c5 = new Coords(12, 8);

        trace1.addCoords(c1);
        trace1.addCoords(c2);
        trace1.addCoords(c3);
        trace1.addCoords(c4);
        trace1.addCoords(c5);
//        System.out.println("get Coord by Index: " + trace1.getCoordByIndex(3));
//        System.out.println("get Coord distance by Index: " + trace1.getCoordsDistanceByIndex(4, 1));
//        System.out.println("get Coords: " + trace1.getCoords());

//        System.out.println("getTraceLength : " + trace1.getTraceLength());
        trace1.maxLength();
        System.out.println("getTraceLength : " + trace1.getTraceLength());
        System.out.println("Head: " + trace1.getTraceHead());
        System.out.println("Tail: " + trace1.getTraceTail());
        System.out.println("Get i: " + trace1.traceList.get(0).getX());
//        traceList.add(c1);
//        traceList.add(c2);
//        System.out.println((c1.getX()) + ", " + c1.getY());
//        System.out.println((traceList.get(1).getX())+", " + traceList.get(1).getY());
        System.out.println("LinkedList:" + trace1.traceList);
//        System.out.println(traceList.toString());
    }


    }

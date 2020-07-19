package Model;

import java.awt.*;
import java.util.LinkedList;
public class Trace {
    private LinkedList<Coords> traceList;
    private Coords head;
    private Coords tail;

    public Trace() {
        this.traceList = new LinkedList<Coords>();

    }

    public double getTraceLength(Coords coords1, Coords coords2) {
        double distance = Math.sqrt(Math.pow(((coords2.getX()) - (coords1.getX())), 2) + Math.pow(((coords2.getX()) - (coords1.getX())), 2));

        return distance;
    }



    public void addCoords(Coords coords){
        traceList.add(coords);
        head = coords;
    }

    public Coords getTraceHead() {
        return this.head;
    }

    public Coords getTraceTail() {
        return traceList.getFirst();
    }

    public static void main(String[] args) {
//        LinkedList<Coords> traceList = new LinkedList<>();
        Trace trace1 = new Trace();
        trace1.addCoords(new Coords(9, 5));
        System.out.println("Head: " + trace1.getTraceHead());
        System.out.println((trace1.traceList.get(0).getX()) + ", " + trace1.traceList.get(0).getY());
        Coords c1 = new Coords(1, 2);
        Coords c2 = new Coords(4, 2);
        trace1.addCoords(c1);
        trace1.addCoords(c2);
        System.out.println(trace1.getTraceLength(c1, c2));
        System.out.println("Head: " + trace1.getTraceHead());
        System.out.println("Tail: " + trace1.getTraceTail());

//        traceList.add(c1);
//        traceList.add(c2);
//        System.out.println((c1.getX()) + ", " + c1.getY());
//        System.out.println((traceList.get(1).getX())+", " + traceList.get(1).getY());
        System.out.println("LinkedList:" + trace1.traceList);
//        System.out.println(traceList.toString());
    }


    }

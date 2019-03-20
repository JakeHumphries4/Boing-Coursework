
/**
 * This class reads a shape file.  For the format of this shape file, see the assignment description.
 * Also, please see the shape files ExampleShapes.txt, ExampleShapesStill.txt, and TwoRedCircles.txt
 *
 * @author you
 *
 */

import javafx.scene.paint.Color;
import java.io.*;
import java.util.Scanner;

public class ReadShapeFile {

	/*
    TODO: You will likely need to write four methods here. One method to
    construct each shape
    given the Scanner passed as a parameter. I would suggest static
    methods in this case.
    */



    private static Circle createCircle(Scanner shapeScan){

        int px = Integer.parseInt(shapeScan.next());
        int py = Integer.parseInt(shapeScan.next());
        int vx = Integer.parseInt(shapeScan.next());
        int vy = Integer.parseInt(shapeScan.next());
        boolean filled = Boolean.parseBoolean(shapeScan.next());
        int diameter = Integer.parseInt(shapeScan.next());
        Color rgb = Color.rgb(Integer.parseInt(shapeScan.next()),
                Integer.parseInt(shapeScan.next()),
                Integer.parseInt(shapeScan.next()));
        int time = Integer.parseInt(shapeScan.next());


        return new Circle(time, px, py, vx, vy, diameter, rgb, filled);
    }
    private static Square createSquare(Scanner shapeScan){

        int px = Integer.parseInt(shapeScan.next());
        int py = Integer.parseInt(shapeScan.next());
        int vx = Integer.parseInt(shapeScan.next());
        int vy = Integer.parseInt(shapeScan.next());
        boolean filled = Boolean.parseBoolean(shapeScan.next());
        int side = Integer.parseInt(shapeScan.next());
        Color rgb = Color.rgb(Integer.parseInt(shapeScan.next()),
                Integer.parseInt(shapeScan.next()),
                Integer.parseInt(shapeScan.next()));
        int time = Integer.parseInt(shapeScan.next());


        return new Square(time, px, py, vx, vy, side, rgb, filled);
    }
    private static Oval createOval(Scanner shapeScan){

        int px = Integer.parseInt(shapeScan.next());
        int py = Integer.parseInt(shapeScan.next());
        int vx = Integer.parseInt(shapeScan.next());
        int vy = Integer.parseInt(shapeScan.next());
        boolean filled = Boolean.parseBoolean(shapeScan.next());
        int width = Integer.parseInt(shapeScan.next());
        int height = Integer.parseInt(shapeScan.next());
        Color rgb = Color.rgb(Integer.parseInt(shapeScan.next()),
                Integer.parseInt(shapeScan.next()),
                Integer.parseInt(shapeScan.next()));
        int time = Integer.parseInt(shapeScan.next());


        return new Oval(time, px, py, vx, vy, width, height, rgb, filled);
    }
    private static Rect createRect(Scanner shapeScan){

        int px = Integer.parseInt(shapeScan.next());
        int py = Integer.parseInt(shapeScan.next());
        int vx = Integer.parseInt(shapeScan.next());
        int vy = Integer.parseInt(shapeScan.next());
        boolean filled = Boolean.parseBoolean(shapeScan.next());
        int width = Integer.parseInt(shapeScan.next());
        int height = Integer.parseInt(shapeScan.next());
        Color rgb = Color.rgb(Integer.parseInt(shapeScan.next()),
                Integer.parseInt(shapeScan.next()),
                Integer.parseInt(shapeScan.next()));
        int time = Integer.parseInt(shapeScan.next());


        return new Rect(time, px, py, vx, vy, width, height, rgb, filled);
    }
    private static Triangle createTri(Scanner shapeScan){

        int px = Integer.parseInt(shapeScan.next());
        int py = Integer.parseInt(shapeScan.next());
        int vx = Integer.parseInt(shapeScan.next());
        int vy = Integer.parseInt(shapeScan.next());
        boolean filled = Boolean.parseBoolean(shapeScan.next());
        int side = Integer.parseInt(shapeScan.next());
        Color rgb = Color.rgb(Integer.parseInt(shapeScan.next()),
                Integer.parseInt(shapeScan.next()),
                Integer.parseInt(shapeScan.next()));
        int time = Integer.parseInt(shapeScan.next());

        return new Triangle(time, px, py, vx, vy, side, rgb, filled);
    }
    /**
     * Reads the data file used by the program and returns the constructed queue
     *
     * @param in the scanner of the file
     * @return the queue represented by the data file
     */

	private static Queue<ClosedShape> readDataFile(Scanner in) {
        Queue<ClosedShape> shapeQueue = new Queue<ClosedShape>();

        while (in.hasNextLine()) {
            String row = in.nextLine();
            Scanner shapeScan = new Scanner(row);

            String type = shapeScan.next();
            switch (type){

                case("circle"):
                    shapeQueue.enqueue(createCircle(shapeScan));
                    break;

                case("oval"):
                    shapeQueue.enqueue(createOval(shapeScan));
                    break;

                case("rect"):
                    shapeQueue.enqueue(createRect(shapeScan));
                    break;

                case("square"):
                    shapeQueue.enqueue(createSquare(shapeScan));
                    break;

                case("tri"):
                    shapeQueue.enqueue(createTri(shapeScan));
                    break;
                default:
                    System.out.println("An error has occurred in creating the shape");
                    System.exit(0);
                    return null;

            }
            //read in the shape files and place them on the Queue

            //Right now, returning an empty Queue.  You need to change this.

        }
        return shapeQueue;
    }

	/**
	 * Method to read the file and return a queue of shapes from this file. The
	 * program should handle the file not found exception here and shut down the
	 * program gracefully.
	 * 
	 * @param filename
	 *            the name of the file
	 * @return the queue of shapes from the file
	 */
	public static Queue<ClosedShape> readDataFile(String filename) {
	    // HINT: You might want to open a file here.
        File f = new File(filename);
        try {
            Scanner fileScan = new Scanner(f);
            return ReadShapeFile.readDataFile(fileScan);
        }catch(Exception e){
                System.out.println(e);
                System.out.println("Error reading file.");
                System.exit(0);
                return null;
            }

	}

}

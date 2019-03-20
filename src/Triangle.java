import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle extends ClosedShape {
    private int side;
    private double[] xPoints = new double[3];
    private double[] yPoints = new double[3];


    public Triangle(int insertionTime, int x, int y, int vx, int vy, int side, Color colour, boolean isFilled){
        super (insertionTime, x, y, vx, vy, colour, isFilled);
        this.side = side;


    }
    /**
     * Method to convert
     * to a string.
     */
    public String toString () {
        String result = "This is a triangle\n";
        result += super.toString ();
        result += "Its side length is " + this.side + "\n";
        return result;
    }


    /**
     * @param width Resets the width.
     */
    public void setWidth (int width) {
        this.side = width;
    }

    /**
     * @param height Resets the height.
     */
    public void setHeight (int height) {
        this.side = height;
    }

    /**
     * @return The width of the oval.
     */
    public int getWidth() {
        return side;
    }

    /**
     * @return The height of the oval.
     */
    public int getHeight() {
        return side;
    }

    public void draw (GraphicsContext g) {
        this.xPoints[0] = x;
        this.xPoints[1] = x+(side/2.0);
        this.xPoints[2] = x+side;
        this.yPoints[0] = y+Math.sqrt((this.side*this.side)-(this.side/2*this.side/2));
        this.yPoints[1] = y;
        this.yPoints[2] = y+Math.sqrt((this.side*this.side)-(this.side/2*this.side/2));
        g.setFill (colour);
        g.setStroke( colour );
        if (isFilled) {
            g.fillPolygon(this.xPoints,this.yPoints,3);
        }
        else {
            g.strokePolygon(this.xPoints,this.yPoints,3);
        }
    }
}

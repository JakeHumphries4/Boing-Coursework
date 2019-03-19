import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Square extends ClosedShape  {
    private int side;

    public Square(int insertionTime, int x, int y, int vx, int vy, int side, Color colour, boolean isFilled){
        super (insertionTime, x, y, vx, vy, colour, isFilled);
        this.side = side;

    }
    /**
     * Method to convert a square to a string.
     */
    public String toString () {
        String result = "This is a square\n";
        result += super.toString ();
        result += "Its side length is " + this.side + "\n";
        return result;
    }

    /**
     * @param side Resets the side length.
     */
    public void setSide (int side) {
        this.side = side;
    }

    /**
     * @return The diameter of the square.
     */
    public int getSide() {
        return side;
    }

    /**
     * @return The width of the square
     */
    public int getWidth() {
        return side;
    }

    /**
     * @return The height of the square
     */
    public int getHeight() {
        return side;
    }

    /**
     * Draw the circle on the screen.
     * @param g The graphics object of the scene component.
     */
    public void draw (GraphicsContext g) {
        g.setFill( colour );
        g.setStroke( colour );
        if (isFilled) {
            g.fillRect( x, y, side, side );
        }
        else {
            g.strokeRect( x, y, side, side );
        }
    }
}


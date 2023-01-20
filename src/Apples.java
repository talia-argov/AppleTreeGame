import java.awt.*;

public class Apples {
    //VARIABLE DECLARATION SECTION
    //Here's where you state which variables you are going to use.
    public String name;               //name of the hero
    public int xpos;                  //the x position
    public int ypos;                  //the y position
    public int dx = 1;                    //the speed of the hero in the x direction
    public int dy = 1;                   //the speed of the hero in the y direction
    public int width;                   //the width of the hero image
    public int height;                 //the height of the hero image
    public boolean isAlive;           //a boolean to denote if the hero is alive or dead
    public boolean isCrashing = false;
    public Rectangle rec;
    public Image pic;
    public boolean right;
    public boolean left;
    public boolean down;
    public boolean up;

    public Apples(int pXpos, int pYpos) {

        xpos = pXpos;
        ypos = pYpos;
        width = 50;
        height = 50;
        dx = 5;
        dy = -5;
        isAlive = true;
        // hits = 0;
        rec = new Rectangle(xpos, ypos, width, height);


    } // constructor


    public void move() {
        xpos = xpos + dx;
        ypos = ypos + dy;
    }
}

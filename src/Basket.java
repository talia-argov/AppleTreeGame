import java.awt.*;

public class Basket {

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

        public Basket(int dxParameter, int dyParameter, Image picParameter) {

                xpos = 200;
                ypos = 300;
                width = 50;
                height = 50;
                dx = dxParameter;
                dy = dyParameter;
                pic = picParameter;
                isAlive = true;
                //       hits = 0;
                rec = new Rectangle(xpos, ypos, width, height);


        } // constructor


        public void move() {
                xpos = xpos + dx;
                ypos = ypos + dy;

                if (right) {
                        xpos = xpos + dx;
                        if (xpos > 1000 - width) {
                                xpos = 1000 - width;
                        }
                }

                if (left) {
                        xpos = xpos - dx;
                        if (xpos < 0 + width) {
                                xpos = 0 + width;
                        }
                }

                if (down) {
                        ypos = ypos + dy;
                        if (ypos > 700 - height) {
                                ypos = 700 - height;
                        }
                }

                if (up) {
                        ypos = ypos - dy;
                        if (ypos <= 0) {
                                ypos = 1;
                        }
                }
                rec = new Rectangle(xpos, ypos, width, height);
        }

        public void move2() {
                xpos = xpos + dx;
                ypos = ypos + dy;

                if (right == true) {
                        dx = 5;
                } else if (left == true) {
                        dx = -5;
                } else {//(right = false && left == false)
                        dx = 0;
                }

                if (up == true) {
                        dy = -5;
                } else if (down == true) {
                        dy = 5;
                } else {//(right == false && left == false)
                        dy = 0;
                }

                if (xpos < 0) { //left wall
                        xpos = 0;
                }
                if (xpos > 1000 - width) { //right wall
                        xpos = 1000 - width;
                }
                if (ypos < 0) { //up wall
                        ypos = 0;
                }
                if (ypos > 700 - height) { //down wall
                        ypos = 700 - height;
                }
                rec = new Rectangle(xpos, ypos, width, height);
        }

}

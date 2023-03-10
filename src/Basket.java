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
        public Rectangle basketrec;

        public Basket(int dxParameter, int dyParameter, Image picParameter) {

                xpos = 200;
                ypos = 600;
                width = 115;
                height = 210;
                dx = dxParameter;
                dy = dyParameter;
                pic = picParameter;
                isAlive = true;
                //       hits = 0;
                rec = new Rectangle(xpos, ypos, width, height);
                basketrec = new Rectangle(xpos+40,ypos+60, width/2, height/2);


        } // constructor


        public void move() {
                xpos = xpos + dx;
                //ypos = ypos + dy;

                if (right) {
                        dx = 5;
                }
                else if (left) {
                        dx = -5;
                }
                else {
                        dx = 0;
                }

                if (down) {
                        dy = 5;
                }
                else if (up) {
                        dy = -5;
                }
                else {
                        dy = 0;
                }

                if (xpos > 1000 - width) {
                        xpos = 1000 - width;
                }
                if (xpos < 0) {
                        xpos = 0;
                }
                if (ypos > 700 - height) {
                        ypos = 700 - height;
                }
                if (ypos <= 0) {
                        ypos = 1;
                }
                rec = new Rectangle(xpos, ypos, width, height);
                basketrec = new Rectangle(xpos+40,ypos+60, width/2, height/2);

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
                        xpos = 1000;
                }
                if (ypos < 0) { //up wall
                        ypos = 0;
                }
                if (ypos > 700 - height) { //down wall
                        ypos = 700;
                }
                rec = new Rectangle(xpos, ypos, width, height);
                basketrec = new Rectangle(xpos+40,ypos+60, width/2, height/2);

        }

}

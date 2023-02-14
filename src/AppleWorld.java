import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyListener;

public class AppleWorld implements Runnable, KeyListener, MouseListener {

//Variable Definition Section

        //Sets the width and height of the program window
        final int WIDTH=1000;
        final int HEIGHT=700;

        //Declare the variables needed for the graphics
        public JFrame frame;
        public Canvas canvas;
        public JPanel panel;

        public BufferStrategy bufferStrategy;
        public Image applePic;
        public Image basketPic;
        public Image wormPic;
        public Image backgroundPic;

//Declare the variables needed for images below
        public Apples apple;
        public Basket basket;
        public Worms worm;
      //  public Background background;

//Declare the character objects below

        // Main method definition
// This is the code that runs first and automatically
        public static void main(String[]args){
                AppleWorld myGame=new AppleWorld();   //creates a new instance of the game
                new Thread(myGame).start();                 //creates a threads & starts up the code in the run( ) method
        }

        public AppleWorld(){

                setUpGraphics();
                canvas.addKeyListener(this);
                canvas.addMouseListener(this);
                //variable and objects
                //create (construct) the objects needed for the game and load up
                //Pic = Toolkit.getDefaultToolkit().getImage("_____.png"); //load the picture
                //character = new MarioKart("____",100,100); //construct

                backgroundPic = Toolkit.getDefaultToolkit().getImage("backgroundpic.png");

                applePic = Toolkit.getDefaultToolkit().getImage("applepic.png");
                apple = new Apples(10, 10);

                basketPic = Toolkit.getDefaultToolkit().getImage("basketpic.png");
                basket = new Basket(100, 100, basketPic);

                wormPic = Toolkit.getDefaultToolkit().getImage("wormpic.png");
                worm = new Worms(200, 200);
        }

        public void run(){
                while(true){
                        moveThings();           //move all the game objects
                        checkIntersections();   // check character crashes
                        render();               // paint the graphics
                        pause(20);         // sleep for 20 ms
                }
        }

        public void moveThings(){
//        basket.move();
                // apple.move2();
                // worms.move();
                // etc
        }

        public void render(){
                Graphics2D g=(Graphics2D)bufferStrategy.getDrawGraphics();
                g.clearRect(0,0,WIDTH,HEIGHT);

                //draw characters to the screen
                //g.drawImage(Pic,0,0,WIDTH,HEIGHT,null);
                g.drawImage(backgroundPic,500,500,400,400,null);

                g.drawImage(basketPic,500,700,100,100,null);

                g.drawImage(applePic,300,300,50,50,null);

                g.drawImage(wormPic,600,700,100,100,null);

                g.dispose();
                bufferStrategy.show();

             // if (basket.isAlive == true) {
             //         System.out.println("basket is printed");
                //trying to figure out if other images are getting rendered
              }
        }

        public void checkIntersections(){

        }

        public void keyTyped(KeyEvent e) {

        }

        public void keyPressed(KeyEvent event){
                //This method will do something whenever any key is pressed down.
                //Put if( ) statements here
                char key=event.getKeyChar();     //gets the character of the key pressed
                int keyCode=event.getKeyCode();  //gets the keyCode (an integer) of the key pressed
                System.out.println("Key Pressed: "+key+"  Code: "+keyCode);

                if(keyCode==68){ //d
                        //    basket.right = true;
                }
                if(keyCode==65){ //a
                        //        basket.left = true;
                }
                if(keyCode==83){ //s
                        //   basket.down = true;
                }
                if(keyCode==87){ //w
                        //    basket.up = true;
                }
                //  if(keyCode == 32) { //space bar
                //     user. = true;
                //   }
                //keyPressed()
        }

        public void keyReleased(KeyEvent event){
                char key=event.getKeyChar();
                int keyCode=event.getKeyCode();
                //This method will do something when a key is released
                if(keyCode==68){ //d
                        //    basket.right = false;
                }
                if(keyCode==65){//a
                        //    basket.left = false;
                }
                if(keyCode==83){ //s
                        //    basket.down = false;
                }
                if(keyCode==87){ //w
                        //   basket.up = false;
                }

        }//keyReleased()

        public void setUpGraphics(){
                frame=new JFrame("AppleWorld");   //Create the program window or frame.  Names it.

                panel=(JPanel)frame.getContentPane();  //sets up a JPanel which is what goes in the frame
                panel.setPreferredSize(new Dimension(WIDTH,HEIGHT));  //sizes the JPanel
                panel.setLayout(null);   //set the layout

                // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
                // and trap input events (Mouse and Keyboard events)
                canvas=new Canvas();
                canvas.setBounds(0,0,WIDTH,HEIGHT);
                canvas.setIgnoreRepaint(true);

                panel.add(canvas);  // adds the canvas to the panel.

                // frame operations
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
                frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
                frame.setResizable(false);   //makes it so the frame cannot be resized
                frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!

                // sets up things so the screen displays images nicely.
                canvas.createBufferStrategy(2);
                bufferStrategy=canvas.getBufferStrategy();
                canvas.requestFocus();
                System.out.println("DONE graphic setup");

        }

        //Pauses or sleeps the computer for the amount specified in milliseconds
        public void pause(int time){
                //sleep
                try{
                        Thread.sleep(time);
                }catch(InterruptedException e){

                }
        }

        public void mouseClicked(MouseEvent e) {

        }

        public void mousePressed(MouseEvent e) {

        }

        public void mouseReleased(MouseEvent e) {

        }

        public void mouseEntered(MouseEvent e) {

        }

        public void mouseExited(MouseEvent e) {

        }
}


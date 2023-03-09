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

        public boolean gameStart = false;

        public BufferStrategy bufferStrategy;
        public Image applePic;
        public Image basketPic;
        public Image wormPic;
        public Image backgroundPic;

        //Declare the variables needed for images below
        public Apples apple;
        public Basket basket;
        public Worms worm;
        public Apples[] apples;
        public int caughtApples=0;
        public int fallenApples=0;
        public int timer=0;
        public boolean gameOver=false;

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

                backgroundPic = Toolkit.getDefaultToolkit().getImage("background.jpeg");

                applePic = Toolkit.getDefaultToolkit().getImage("applepic.png");
                apple = new Apples(10, 10, applePic);

                basketPic = Toolkit.getDefaultToolkit().getImage("basketpic.png");
                basket = new Basket(10, 100, basketPic);

                wormPic = Toolkit.getDefaultToolkit().getImage("wormpic.png");
                worm = new Worms(200, 200);

                apples = new Apples[10];
                for (int i = 0; i < apples.length; i++) {
                        apples[i] = new Apples((int)(Math.random()*WIDTH) - 50, (int)(Math.random()*150) + 100, applePic);
                        apples[i].dy = (int)(Math.random()*-4 - 1);
                }

        }

        public void run(){
                while(true){
                        moveThings();           //move all the game objects
                        checkIntersections();   // check character crashes
                        render();               // paint the graphics
                        pause(20);         // sleep for 20 ms
                        if(gameStart) {
                                timer++;
                        }
                }
        }

        public void moveThings(){
                if(gameStart == true) {
                        basket.move();
                        apple.move();
                        worm.move();

                        for (int i = 0; i < apples.length; i++) {
                                apples[i].move();
                        }
                }
        }

        public void render(){
                Graphics2D g=(Graphics2D)bufferStrategy.getDrawGraphics();
                g.clearRect(0,0,WIDTH,HEIGHT);
                System.out.println(timer);
                if(timer==200){
                        gameOver=true;
//                        gameStart = false;
                }

                //draw characters to the screen
                //g.drawImage(Pic,0,0,WIDTH,HEIGHT,null);
                g.drawImage(backgroundPic,0,0,1000,700,null);

                if (gameStart == false) {
                        g.setColor(Color.GREEN);
                        g.fillRect(328, 327, 370, 100);
                        g.setFont(new Font("TimesRoman", Font.BOLD, 35));
                        g.setColor(Color.RED);
                        g.drawString("Press SPACE to Start", 350, 380);
                        g.setFont(new Font("TimesRoman", Font.BOLD, 15));
                        g.drawString("Use left and right arrow keys to move",400, 400);
                } // start screen
                else if (gameStart == true && gameOver == false){
                        g.drawImage(basketPic, basket.xpos, basket.ypos, basket.width, basket.height, null);

                        g.drawImage(applePic, 300, 300, 50, 50, null);

                        g.drawImage(wormPic, 600, 600, 100, 100, null);

                        g.setColor(Color.RED);
                        g.fillRect(350, 110, 50, 45);
                        g.setColor(Color.RED);
                        g.fillRect(633,110, 50, 45);
                        g.setFont(new Font("TimesRoman", Font.BOLD, 35));
                        g.setColor(Color.BLACK);
                        g.drawString("Apples Collected     Apples Fallen", 250, 100);
                        g.drawString(caughtApples+"",364, 145);
                        g.drawString(fallenApples+"",646,145);
                        for (int i = 0; i < apples.length; i++) {
                                if (apples[i].isAlive == true) {
                                        g.drawImage(apples[i].pic, apples[i].xpos, apples[i].ypos, apples[i].width, apples[i].height, null);
                                }
                        }
                        g.drawString("Time: "+(200-(timer/10)), 450, 145);

                } // actual gameplay
                else if(gameOver==true){
                        for (int i = 0; i < apples.length; i++) {
                                apples[i].dy=0;
                                apples[i].dx=0;
                        }


                        g.setFont(new Font("TimesRoman", Font.BOLD, 35));

                        g.drawString("Time: 0", 450, 145);

                        g.setColor(Color.GREEN);
                        g.fillRect(328, 327, 370, 100);

                        if(caughtApples>fallenApples){
                                g.setColor(Color.BLACK);
                                g.setFont(new Font("TimesRoman", Font.BOLD, 35));
                                g.drawString("YOU WIN 💅",400,400);
                        g.setFont(new Font("TimesRoman", Font.BOLD, 15));
                        g.drawString("Click ENTER to Restart",400, 370);}

                        else{
                                g.setColor(Color.BLACK);
                                g.setFont(new Font("TimesRoman", Font.BOLD, 35));
                                g.drawString("YOU LOSE 🥰",400,400);
                                g.setFont(new Font("TimesRoman", Font.BOLD, 15));
                                g.drawString("Click ENTER to Restart",400, 370);
                        }
                        System.out.println("gameover");
                        //    Apples.isAlive == false;
                        //  caughtApples.isAlive == false;
                        //  fallenApples.isAlive == false;

                } // game over screen
                else {
                        System.out.println("Boolean problems!");
                }
                g.dispose();
                bufferStrategy.show();

                // if (basket.isAlive == true) {
                //         System.out.println("basket is printed");
                //trying to figure out if other images are getting rendered
                //}
        }

        public void checkIntersections(){
                for (int i = 0; i< apples.length; i++){
                        if (apples[i].rec.intersects(basket.basketrec)) {
                                apples[i] = new Apples((int)(Math.random()*WIDTH) - 50, (int)(Math.random()*150) + 100, applePic);
                                apples[i].dy = (int)(Math.random()*-4 - 1);
                                caughtApples++;
                        }

                        if(apples[i].ypos > 1000){
                                apples[i] = new Apples((int)(Math.random()*WIDTH) - 50, (int)(Math.random()*150) + 100, applePic);
                                apples[i].dy = (int)(Math.random()*-4 - 1);
                                fallenApples++;
                        }
                }
                for(int i = 0; i< apples.length; i++){
                        if(apples[i].rec.intersects(basket.basketrec)&& apples[i].isAlive==true){
                                // apples[i].isAlive=false;
                                System.out.println("boom");
                        }
                }
        }

        public void keyTyped(KeyEvent e) {

        }

        public void keyPressed(KeyEvent event){
                //This method will do something whenever any key is pressed down.
                //Put if( ) statements here
                char key=event.getKeyChar();     //gets the character of the key pressed
                int keyCode=event.getKeyCode();  //gets the keyCode (an integer) of the key pressed
                System.out.println("Key Pressed: "+key+"  Code: "+keyCode);

                if(keyCode==38){ //arrow up
                        basket.up = true;
                }
                if(keyCode==40){//arrow down
                        basket.down = true;
                }
                if(keyCode==39){ //arrow right
                        basket.right = true;
                }
                if(keyCode==37){ //arrow left
                        basket.left = true;
                }
                if(gameStart == false && keyCode == 32) {
                        gameStart = true;
                }

                if(gameOver == true && keyCode == 13){
                        gameStart = false;
                        gameOver = false;
                }

        }

        public void keyReleased(KeyEvent event){
                char key=event.getKeyChar();
                int keyCode=event.getKeyCode();
                //This method will do something when a key is released
                if(keyCode==38){ //arrow up
                        basket.up = false;
                }
                if(keyCode==40){//arrow down
                        basket.down = false;
                }
                if(keyCode==39){ //arrow right
                        basket.right = false;
                }
                if(keyCode==37){ //arrow left
                        basket.left = false;
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
                System.out.print("x = "+e.getX());
                System.out.println(" y = "+e.getY());
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


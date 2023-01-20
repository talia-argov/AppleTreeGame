import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyListener;

public class AppleWorld implements Runnable, KeyListener{

//Variable Definition Section

//Sets the width and height of the program window
final int WIDTH=1000;
final int HEIGHT=700;

//Declare the variables needed for the graphics
public JFrame frame;
public Canvas canvas;
public JPanel panel;
public BufferStrategy bufferStrategy;

//Declare the variables needed for images below


//Declare the character objects below

// Main method definition
// This is the code that runs first and automatically
public static void main(String[]args){
        AppleWorld ex=new AppleWorld();   //creates a new instance of the game
        new Thread(ex).start();                 //creates a threads & starts up the code in the run( ) method
        }

public void AppleWorld(){

        canvas.addKeyListener(this);

        setUpGraphics();

        //variable and objects
        //create (construct) the objects needed for the game and load up
        //Pic = Toolkit.getDefaultToolkit().getImage("_____.png"); //load the picture
        //character = new MarioKart("____",100,100); //construct

        }

public void moveThings(){
//        basket.move();
        // apple.move2();
        // birds.move();
        // etc
        }

public void checkIntersections(){

        }

public void run(){
        while(true){
        moveThings();           //move all the game objects
        checkIntersections();   // check character crashes
        render();               // paint the graphics
        pause(20);         // sleep for 20 ms
        }
        }

public void render(){
        Graphics2D g=(Graphics2D)bufferStrategy.getDrawGraphics();
        g.clearRect(0,0,WIDTH,HEIGHT);

        //draw characters to the screen
        //g.drawImage(Pic,0,0,WIDTH,HEIGHT,null);

        g.dispose();
        bufferStrategy.show();
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
        }


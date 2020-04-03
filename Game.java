// File name: Game.java

// Written by: Jonpaul Addorisio
 
// Description: This class file contains the mechanics for the actual
//              game of pong. In this file you will find code for using
//              java2d api to paint the game map and methods for moving the
//              players and ball.
//              
//              
// Challenges: Setting intersection points for the ball. 
//             Finding a good ball speed
//             
//
// Time Spent: 6 hours

// Revision History:
// Date:         		By:      Action:
// ---------------------------------------------------
/* 12/03/2017                  JA        Created                       
 * 12/04/2017                  JA        Finished Base Game
 * 12/05/2017                  JA        Added Options to game
                                         Then deleted due to program
                                         crash
 * 12/06/2017                  JA        Succefully add the options 
                                         class.
 *                        
*/  


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;
/**
 *
 * @author Jonpaul
 */
public class Game extends JPanel implements KeyListener, ActionListener {
    // Variables for player scores
    private int score1 = 0;
    private int score2 = 0;
    
    // To determine whether or not game is in session
    private boolean play = false;
    //Set bar color
    private Color player1Color = Color.RED;
    private Color player2Color = Color.BLUE;
   
    // for ball movment
    private Timer ballSpeed;
    private int delay  = 1;
    // Bar X start coords
    private int playerX = 310;
    private int playerY = 210;
    
    // Ball coords and intial move direction
    private int ballPosX = 320;
    private int ballPosY = 550;
    private double ballDirX = -2;
    private double ballDirY = -5;
    
    // Variables regarding game options
    private Options options;
    
    private int reset;
    
    
    public Game(Options options){
        this.options = options;
        

        // makes for compopnet to be focused
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        
        // For ball movment
        ballSpeed = new Timer(delay, this);
        try {
         ballSpeed.start();   
        }catch (Exception e){
            e.printStackTrace();
        }
        
        
        
        
        
    }
    
    public void paint(Graphics g){
        // For chaging bar colors for options selected
        player1Color = options.returnColor1();
      
        player2Color = options.returnColor2();
      
      // For reseting player scores
      reset = options.returnReset();
      
      if (reset == 0){
          score1 = 0;
          score2 = 0;
          reset = 1;
          options.changeReset(reset);
      }
        
      //Set background and sides
      g.setColor(Color.BLACK);
      g.fillRect(1, 1, 692, 792);
      
      g.setColor(Color.RED);
      g.fillRect(4, 0, 3, 792);
      g.fillRect(491, 0, 3, 792);
      
      
      // sets player bars
      
      g.setColor(player1Color);
      g.fillRect(playerX,750, 100,8);
      
      g.setColor(player2Color);
      g.fillRect(playerY,10, 100,8);
      
      //sets ball
      g.setColor(Color.WHITE);
      g.fillOval(ballPosX, ballPosY, 20, 20);
      
      // sets net
      g.setColor(Color.ORANGE);
      g.drawRect(0, 380, 500, 3);
     
      // Sets scores
      g.setColor(Color.WHITE);
      g.setFont(new Font("MONOSPACED", Font.BOLD, 80));
      
      g.drawString(Integer.toString(score1), 420, 450);
      
      
      g.drawString(Integer.toString(score2), 420, 350);
      
      // Sets message for when game stalled
      g.setFont(new Font("MONOSPACED", Font.BOLD, 30));
      if (play == false)
      g.drawString("Press Space to Start", 50, 350);
      
      
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        
        // starts timer object
        try {
         ballSpeed.start();   
        }catch (Exception a){
            a.printStackTrace();
        }
    // Creates intersection point for bar and ball
    // changes ball direction and speed
    if(new Rectangle(ballPosX, ballPosY, 20, 20).intersects(new Rectangle(playerX,750,100,8))){
        ballDirY = -ballDirY;
        ballDirY += -.1;
        
        
        
    }
    
    
    if(new Rectangle(ballPosX, ballPosY, 20, 20).intersects(new Rectangle(playerY,10,100,8))){
        ballDirY = -ballDirY;
        ballDirY += .1;
        
        
        
    }
    

    
       
    

    
    
    if(play == true){
        
        // add direction value to postion to move ball
        ballPosX += ballDirX;
        ballPosY += ballDirY;
        
        // causues ball to "bounce off wall
        if(ballPosX < 0){
            ballDirX = -ballDirX;
        }
        if(ballPosX > 470){
            ballDirX = -ballDirX;
        }
        
        // Ends round if ball goes past bar
        if(ballPosY < 0){
            play = false;
            ballPosX = playerX;
            ballPosY = 700;
            ballDirY = 5.0;
            score1 +=1;
            repaint();
        }
        if (ballPosY > 800){
            play = false;
            ballPosX = playerY;
            ballPosY = 50;
            ballDirY = -5.0;
            score2 += 1;
            repaint();
        }

    }
    
    
    repaint();
    }
    @Override
    public void keyPressed(KeyEvent e) {
       
        // Move player in respective directions 
        // and keeps player in the frame
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
           if (playerX >= 400){
               playerX = 400;
           }
           else{
               movePlayerXRight();
           }
       }
       if(e.getKeyCode() == KeyEvent.VK_LEFT){
           if (playerX < 10){
               playerX = 10;
           }
           else{
               movePlayerXLeft();
           }
       }
       if(e.getKeyCode() == KeyEvent.VK_D){
           if (playerY >= 400){
               playerY = 400;
           }
           else{
               movePlayerYRight();
           }
       }
       if(e.getKeyCode() == KeyEvent.VK_A){
           if (playerY < 10){
               playerY = 10;
           }
           else{
               movePlayerYLeft();
           }
       }
       
       // Starts the round
       if(e.getKeyCode() == KeyEvent.VK_SPACE){
           play = true;
       }
       
    }
    
    
    // methods that move player in respective direction
    public void movePlayerXRight(){
        
        playerX += 30;
    }
    
    public void movePlayerXLeft(){
        
        playerX -= 30;
    }
    public void movePlayerYRight(){
        
        playerY += 30;
    }
    
    public void movePlayerYLeft(){
        
        playerY -= 30;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    @Override
    public void keyTyped(KeyEvent e) {
        
    }


}


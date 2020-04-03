// File name: Pong.java

// Written by: Jonpaul Addorisio
 
// Description: This is the main file for a imatation game of the 
//              classic game pong. In this game the board allignment
//              is set to a vertical postion instead of the normal
//              horizontal postion. The user is allowed to change the
//              player bar colors. Each time the ball is hit by a paddle
//              the ballspeed increases. This game is a Player vs Player game
//              There is no code for a computer Player.
//              
//              
// Challenges:  N/A to this java File
//
// Time Spent: Total Project time 10 hours

// Revision History:
// Date:         		By:      Action:
// ---------------------------------------------------
/* 12/03/2017                   JA      Created                       
 * 12/04/2017                   JA      Finshed Base Game
 * 12/05/2017                   JA      Added Options to game
                                        Then deleted due to program
                                        crash
 * 12/06/2017                   JA      Succefully add the options 
                                        class.
*/ 



import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Pong{
    
    
    public static void main(String[] args) {
        // Set game frame and panels
        JFrame gameFrame = new JFrame();
        
        Options options = new Options(gameFrame);
        Game game = new Game(options);
        

       
        // Sets the frame for game and jpanel components for game
         gameFrame.setBounds(10,10, 500, 850);
         gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         gameFrame.setTitle("Pong");
         gameFrame.setResizable(false);
         gameFrame.setLocationRelativeTo(null);
         gameFrame.setVisible(true);
        
         gameFrame.add(game);
         gameFrame.add(options, BorderLayout.SOUTH);
        
        
        
         
         
         
    }

    
}

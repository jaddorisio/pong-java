// File name: Options.java

// Written by: Jonpaul Addorisio
 
// Description: This class file is for setting the options for the pong game
//              In this file the reader will find code for changing the paddle
//              color, exiting the game, and reseting the player scores
//              
//              
// Challenges: Removing the focus of this panel and setting focus to game panel
//             Centering JColorChooser
//             
// Time Spent: 4 hours

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
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import static javax.swing.JColorChooser.showDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Options extends JPanel {
    // option buttons
    private JButton player1Color1, player2Color2, reset, exit;
    
    // Option variables
    private Color color1 = Color.RED;
    private Color color2 = Color.BLUE;
    private int resetvalue = 1;
    
    // Hold frame componet for proper placement of jcolorchooser
    private JFrame comp;
    
    public Options(JFrame comp){
        this.comp = comp;
       
    
        setFocusable(false);
        
        // Declartion of options buttons
        player1Color1 = new JButton("Player 1 Color");
        player2Color2= new JButton("Player 2 Color");
        reset = new JButton("Reset Score");
        exit = new JButton("Exit Game");
        
        // Defocus buttons to keep game panel in focus
        reset.setFocusable(false);
        exit.setFocusable(false);
        player1Color1.setFocusable(false);
        player2Color2.setFocusable(false);
        
        // Adds buttons to panel
        setBackground(Color.BLACK);
        add(player1Color1);
        add(player2Color2);
        add(reset);
        add(exit);
        
    
    
    // Actions for calling jcolor chooser
    player1Color1.addActionListener(
       new ActionListener() 
          {
           
  
            @Override
              public void actionPerformed(ActionEvent e) {
               UtilizeColorPicker1();
               
              }
            }); 
    player2Color2.addActionListener(
       new ActionListener() 
          {
           
  
            @Override
              public void actionPerformed(ActionEvent e) {
               UtilizeColorPicker2();
               
                
               
              }
            }); 
    
    // action for changing to reset value for scores
    reset.addActionListener(
       new ActionListener() 
          {
           
  
            @Override
              public void actionPerformed(ActionEvent e) {
               resetvalue = 0;
               
                
               
              }
            }); 
    
    // Action for exiting game
    exit.addActionListener(
       new ActionListener() 
          {
           
  
            @Override
              public void actionPerformed(ActionEvent e) {
               System.exit(0);
               
                
               
              }
            }); 
 
    }
    
       

        

    
    
    // Methods to run J color chooser for each player bar

    private void UtilizeColorPicker1() {
        
        // Opens up the color window for user and repaint
        // oval with corresponding panel
        JColorChooser.setDefaultLocale(null);
        
        Color newColor = showDialog(comp, "Choose a color", this.color1);
        if (newColor == null){
            color1 = color1;
        }
        else{
        color1 = newColor;
        }
        
    }
    private void UtilizeColorPicker2() {
       
        // Opens up the color window for user and repaint
        // oval with corresponding panel
        Color newColor = showDialog(comp, "Choose a color", this.color2);
        if (newColor == null){
            color2 = color2;
        }
        else{
        color2 = newColor;
        }
        
    }
    
    
    // Methods for returing respective value
    public Color returnColor1(){
        return color1;
    }
    public Color returnColor2(){
        return color2;
    }

    public int returnReset(){
        return resetvalue;
    }
    public void changeReset(int re){
        resetvalue = re;
    }
}

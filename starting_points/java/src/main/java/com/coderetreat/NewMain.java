/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderetreat;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author mcallans
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //initialize a frame in which to place our canvas
        
        Frame  mainFrame = new Frame("ROVER");
        
        //give the fram a size
        
        mainFrame.setSize(600,600);
       
       //set a listener for the close window event
        mainFrame.addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
        
    //initialize a canvas for drawing the graphics
      
      MyCanvas roverCanvas = new MyCanvas();
      
     // add the canvas to the frame
      mainFrame.add(roverCanvas);
      mainFrame.setVisible(true); 
     
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderetreat;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author mcallans
 */
class MyCanvas extends Canvas {
    
    //declare and initialize instance variables
    String direction;
    String current;
    
    //starting points for the rover
    int startingX=40;
    int startingY=40;
    
    //upper front cordinates of the rover
    int frontX=40;
    int frontY=40;
    
    //lower front cordinates of the rover
    int frontXend=0;
    int frontYend=0;
    
    //width and height
    int width=20;
    int height=60;
    
    //pointer part of the rover
    int pointx=50;
    int pointy=20;
    

      public MyCanvas () {
          
          //initialize more instance variables
          
          current="N";
          frontXend=frontX+width;
          frontYend=frontY;
          
         //set initial characteristics of of canvas 
         setBackground (Color.GRAY);
         setSize(600, 600);
         
         
         //adding a key listener for the event when a key is pressed
         addKeyListener(new KeyListener() {
             @Override
             public void keyTyped(KeyEvent e) {
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
             }

             @Override
             public void keyPressed(KeyEvent e) {
                 //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           
                 // direct rover N,S,E,W according to direction key pressed(up,down,right,left)
                 directRover(e);
                 
                 //move rover forward(f) or reverse (r)
                 moveRover(e);
                 
             }

             @Override
             public void keyReleased(KeyEvent e) {
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
             }
         });
         
      }

      @Override
      public void paint (Graphics g) {
        
          prepareCanvas(g);
          
          displayRover(g);
         
        
        
         
         
      }
      
      // function for drawing the terrain on which the rover moves
      private void prepareCanvas(Graphics g){
      Graphics2D g2;
         g2 = (Graphics2D) g;
      
         g2.setColor(Color.GRAY);
         int count=0;
         while(count<=600){
             
             g2.drawLine(0, count, 600, count);
             count+=2;
         }
         
         g2.setColor(Color.BLUE);
         count=0;
         while(count<=600){
             
             g2.drawLine(count, 0, count, 600);
             count+=3;
         }
      }
      
      //function that draws our rover depending on the instance varibales
      private void displayRover(Graphics g){
          
          Graphics2D g2;
         g2 = (Graphics2D) g;
      
         g2.setColor(Color.ORANGE);
         g2.drawString("FACING  DIRECTION:> "+ current + ": CLICK ON CANVAS AND PRESS F (FORWARD), R(REVERSE)", 10, 10);
         
          g2.drawString("UP(N),DOWN(S),RIGHT(E),LEFT(W)",10,20);
          
           g2.setColor(Color.LIGHT_GRAY);
         g2.fillRect(startingX, startingY, width, height);
         g2.drawLine(frontX, frontY, pointx, pointy);
         g2.drawLine(frontXend, frontYend, pointx, pointy);
         
            g2.setColor(Color.BLACK);
         g2.fillOval(frontX-5, frontY-5, 10, 10);
         g2.fillOval(frontXend-5, frontYend-5, 10, 10);
      }
      
      
      //function the checks which direction key is pressed in order to direct the rover to either
      //NORTH,SOUTH,EAST OR WEST
      private void directRover(KeyEvent e){
      
            try{
             if (e.getKeyCode() == KeyEvent.VK_UP){
             
                 width=20;
                 height=60;
             
                  if(current == "N"){
                  
                 //pass
                 //System.out.println(current);
                  
                  }
             else if(current.equals("S")){
             
                 frontX=startingX;
                 frontY=startingY;
                 
                 frontXend=frontX+width;
                 frontYend=frontY;
                 
                 pointx=frontX+(width/2);
                 pointy=frontY-width;
                 current="N";
                
                 repaint();
             
             }
             else if(current.equals("W")){
            
                 frontX=startingX;
                 frontY=startingY;
                 
                 frontXend=frontX+width;
                 frontYend=frontY;
                 
                 pointx=frontX+(width/2);
                 pointy=frontY-(width);
                 current="N";
                 repaint();
             
             }
             else if(current.equals("E")){
           
                frontX=startingX;
                 frontY=startingY;
                 
                 frontXend=frontX+width;
                 frontYend=frontY;
                 
                 pointx=frontX+(width/2);
                 pointy=frontY-(width);
                 current="N";
             repaint();
             }
             
             } 
             
             else if(e.getKeyCode() == KeyEvent.VK_DOWN){
             
                 if(current == "N"){
                 
                 frontX=startingX;
                 frontY=startingY+height;
                 
                 frontXend=frontX+width;
                 frontYend=frontY;
                 
                 pointx=frontX+(width/2);
                 pointy=frontY+width;
                 current="S";
                 
                 repaint();
                
                 }
             else if(current.equals("S")){
             
                 //
             
             }
             else if(current.equals("W")){
             
                  height=60;
                 width=20;
                 
                 frontX=startingX;
                 frontY=startingY+height;
                 
                 frontXend=frontX+width;
                 frontYend=frontY;
                 
                 pointx=frontX+(width/2);
                 pointy=frontY+(width);
                 current="S";
                
             repaint();
             }
             else if(current.equals("E")){
             
                 height=60;
                 width=20;
                frontX=startingX;
                frontY=startingY+height;
                 
                 frontXend=frontX+width;
                 frontYend=frontY;
                 
                 pointx=frontX+(width/2);
                 pointy=frontY+(width);
                 current="S";
              
             repaint();
             }
             
             }
             else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    
                 if(current == "N"){
                 
                  
                     
                 frontX=startingX+height;
                 frontY=startingY;
                 
                 frontXend=frontX;
                 frontYend=frontY+width;
                 
                 pointx=frontX+width;
                 pointy=frontY+(width/2);
                 
                 width=60;
                 height=20;
                 current="E";
                 repaint();
                
                 }
             else if(current.equals("S")){
             
             
                 frontX=startingX+height;
                 frontY=startingY;
                 
                 frontXend=frontX;
                 frontYend=frontY+width;
                 
                 pointx=frontX+width;
                 pointy=frontY+(width/2);
                 
                 width=60;
                 height=20;
                 current="E";
             
             repaint();
            
             }
             else if(current.equals("W")){
             
                 width=60;
                 height=20;
                 
                 frontX=startingX+60;
                 frontY=startingY;
                 
                 frontXend=frontX;
                 frontYend=frontY+20;
                 
                 pointx=frontX+20;
                 pointy=frontY+(20/2);
                 
                 current="E";
                  width=60;
                 height=20;
                 repaint();
                
             }
             else if(current.equals("E")){
             
                    //pass
             }
             }
             else if(e.getKeyCode() == KeyEvent.VK_LEFT){
             
                 if(current == "N"){
                     
                     height=20;
                     width=60;
                     
                 frontX=startingX;
                 frontY=startingY;
                 
                 frontXend=frontX;
                 frontYend=frontY+height;
                 
                 pointx=frontX-20;
                 pointy=frontY+(20/2);
                 
                 width=60;
                 height=20;
                 current="W";
                 repaint();
                
                 }
             else if(current.equals("S")){
             
                    height=20;
                     width=60;
                     
                 frontX=startingX;
                 frontY=startingY;
                 
                 frontXend=frontX;
                 frontYend=frontY+height;
                 
                 pointx=frontX-20;
                 pointy=frontY+(20/2);
                 
                 width=60;
                 height=20;
                 current="W";
                 repaint();
             }
             else if(current.equals("W")){
             
             //pass
             }
             else if(current.equals("E")){  
             
             height=20;
                     width=60;
                     
                 frontX=startingX;
                 frontY=startingY;
                 
                 frontXend=frontX;
                 frontYend=frontY+height;
                 
                 pointx=frontX-20;
                 pointy=frontY+(20/2);
                 
                 width=60;
                 height=20;
                 current="W";
                 repaint();
             }
             }
             
             }catch(UnsupportedOperationException err){
                 
                 err.printStackTrace();
             }
      
     
      }//end of directRover
      
      
      //function that checks for the forward or reverse command for moving rover
      //in order to move the rover
      private void moveRover(KeyEvent e){
      
          try{
       if(e.getKeyCode() == KeyEvent.VK_F){
                
                 if(current.equals("N")){
                 startingY=startingY-5;
                 
                 frontX=startingX;
                 frontY=startingY;
                 
                 frontXend=frontX+width;
                 frontYend=frontY;
                 
                 pointx=frontX+(width/2);
                 pointy=frontY-width;
                 
                 repaint();
                 }
                 else if(current.equals("S")){
                 startingY=startingY+5;
                 
                 frontX=startingX;
                 frontY=startingY+height;
                 
                 frontXend=frontX+width;
                 frontYend=frontY;
                 
                 pointx=frontX+(width/2);
                 pointy=frontY+width;
                 
                 repaint();
                 }
                 else if(current.equals("E")){
                     
                 startingX=startingX+5;
                 
                 
                 frontX=startingX+60;
                 frontY=startingY;
                 
                 frontXend=frontX;
                 frontYend=frontY+20;
                 
                 pointx=frontX+(20);
                 pointy=frontY+(20/2);
                 
                 repaint();
                 
                 }
                 else if(current.equals("W")){
                 startingX=startingX-5;
                 
                 frontX=startingX;
                 frontY=startingY;
                 
                 frontXend=frontX;
                 frontYend=frontY+20;
                 
                 pointx=frontX-(20);
                 pointy=frontY+(20/2);
                 repaint();
                 }
             }
             
             else if(e.getKeyCode() == KeyEvent.VK_R){
               
             
                  if(current.equals("N")){
                 startingY=startingY+5;
                 
                 frontX=startingX;
                 frontY=startingY;
                 
                 frontXend=frontX+width;
                 frontYend=frontY;
                 
                 pointx=frontX+(width/2);
                 pointy=frontY-width;
                 repaint();
                 }
                 else if(current.equals("S")){
                 startingY=startingY-5;
                 frontX=startingX;
                 frontY=startingY+height;
                 
                 frontXend=frontX+width;
                 frontYend=frontY;
                 
                 pointx=frontX+(width/2);
                 pointy=frontY+width;
                 repaint();
                 }
                 else if(current.equals("E")){
                 
                 startingX=startingX-5;
                 
                 
                 frontX=startingX+60;
                 frontY=startingY;
                 
                 frontXend=frontX;
                 frontYend=frontY+20;
                 
                 pointx=frontX+(20);
                 pointy=frontY+(20/2);
                 
                 repaint();
                 
                 }
                 else if(current.equals("W")){
                 startingX=startingX+5;
                 
                 frontX=startingX;
                 frontY=startingY;
                 
                 frontXend=frontX;
                 frontYend=frontY+20;
                 
                 pointx=frontX-(20);
                 pointy=frontY+(20/2);
                 repaint();
                 }
                 
                 
                 
             }
          }
       catch(UnsupportedOperationException err){
               
              err.printStackTrace();
               }
          
             
      
      }//end of function that moves the Rover
      
   }

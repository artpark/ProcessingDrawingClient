import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class ProcessingDrawingClient extends PApplet {

private double fractionLength = .8f; 
private int smallestBranch = 10; 
private double branchAngle = .2f;
public double angleX = 1;
public void setup() {           
         
}

public void draw() {
    background(0);
    stroke(0,255,0);
    line(320,480,320,380);
    drawBranches(320,380,100,3*Math.PI/2);
    //will add later 
    
    angleX = mouseX/80;
}

public void drawBranches(int x,int y, double branchLength, double angle) {     
    double angle1, angle2;
    angle1 = angle + angleX*branchAngle;
    angle2 = angle - angleX*branchAngle;
    branchLength *= fractionLength;
    
    int endX1 = (int)(branchLength*Math.cos(angle1) + x);
    int endY1 = (int)(branchLength*Math.sin(angle1) + y);
    int endX2 = (int)(branchLength*Math.cos(angle2) + x);
    int endY2 = (int)(branchLength*Math.sin(angle2) + y);
    
    line(x,y,endX1,endY1);
    line(x,y,endX2,endY2);
    
    if(branchLength > smallestBranch)
    {
        drawBranches(endX1,endY1,branchLength,angle1);
        drawBranches(endX2,endY2,branchLength,angle2);
    }
}
  public void settings() {  size(640,480); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "ProcessingDrawingClient" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}

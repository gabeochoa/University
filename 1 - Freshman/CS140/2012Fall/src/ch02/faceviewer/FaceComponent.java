package ch02.faceviewer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.JComponent;

/**
   A component that draws an alien face
*/
//@author Gabriel Ochoa

public class FaceComponent extends JComponent
{  
   public void paintComponent(Graphics g)
   {  
      // Recover Graphics2D 
      Graphics2D g2 = (Graphics2D) g;
      // Draw the head
      Ellipse2D.Double head = new Ellipse2D.Double(5, 10, 100, 150);
      g2.draw(head);

      // Draw the eyes
      g2.setColor(Color.GREEN);
      
      //Line2D.Double eye1 = new Line2D.Double(25, 70, 45, 90);
      Rectangle eye1 = new Rectangle(25,70,15,15);
      g2.fill(eye1);

      Line2D.Double eye2 = new Line2D.Double(85, 70, 65, 90);
      g2.draw(eye2);

      // Draw the mouth
      //Rectangle mouth = new Rectangle(30, 130, 50, 5);
      Arc2D.Double mouth = new Arc2D.Double(30, 100, 50, 40, 225, 90, Arc2D.OPEN);

      g2.setColor(Color.RED);
      g2.draw(mouth);

      // Draw the greeting
      g2.setColor(Color.BLUE);
      g2.drawString("Hello, World!", 5, 175);
   }
}

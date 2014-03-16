package se.mah.k3lara.skaneAPI.model;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	   private float x, y;           // Ball's center x and y 
	   private float speedX = 5;
	   private float speedY = 5; // Ball's speed per step in x and y 
	   private float radius = 20;         // Ball's radius 
	   private float maxX,maxY;
	   private Color color = Color.BLUE;  // Ball's color


	   /**
	    * Constructor: .
	    */
	   public Ball(float x, float y, float maxX, float maxY) {
	      this.x = x;
	      this.y = y;
	      this.maxX = maxX;
	      this.maxY = maxY;
	   }

	   /** Draw itself using the given graphics context. */
	   public void draw(Graphics g) {
	      g.setColor(color);
	      g.fillOval((int)(x - radius), (int)(y - radius), (int)(2 * radius), (int)(2 * radius));
	   }

	   
	   /** 
	    * Make one move, check for collision and react accordingly if collision occurs.
	    * 
	    */
	   public void move() {
	      // Get the ball's bounds, offset by the radius of the ball
	      float ballMinX = 0 + radius;
	      float ballMinY = 0 + radius;
	      float ballMaxX = maxX - radius;
	      float ballMaxY = maxY - radius;
	      
	      // Calculate the ball's new position
	      x = x + speedX;
	      y = y + speedY;
	      // Check if the ball moves over the bounds. If so, adjust the position and speed.
	      if (x < ballMinX) {
	         speedX = -speedX; // Reflect along normal
	         x = ballMinX;     // Re-position the ball at the edge
	      } else if (x > ballMaxX) {
	         speedX = -speedX;
	         x = ballMaxX;
	      }
	      // May cross both x and y bounds
	      if (y < ballMinY) {
	         speedY = -speedY;
	         y = ballMinY;
	      } else if (y > ballMaxY) {
	         speedY = -speedY;
	         y = ballMaxY;
	      }
	   }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.base.uncategorized;


// Dependencies
import static org.lwjgl.opengl.GL11.*;

/**
 *
 * @author eeshan
 */
public class Draw {
    
    
    // Define a function that can draw a rectangle. Since we have created a new class for ALL drawing methods, we can rename the methods and keep only the distinctive content
    public static void
    Rectangle(float f_x_start, float f_y_start, float f_width, float f_height) {

	/*
        inputs--
	
	f_x_start :
	    The x coordinate of start location of the rectangle
	f_y_start :
	    The y coordinate of start location of the rectangle
	f_width :
	    The width (left-to-right) of the rectangle
	f_height :  
	    The height (top-to-bottom) of the rectangle
	*/
	
	/*
        outputs--
	*/
	
	Rectangle(f_x_start, f_y_start, f_width, f_height, 0.0f);
	
    }
    

    // Define a function that can draw a rectangle. We keep it public, as we want to access it using other objects
    public static void
    Rectangle(float f_x_start, float f_y_start, float f_width, float f_height, float f_theta_z) {

	/*
        inputs--
	
	f_x_start :
	    The x coordinate of start location of the rectangle
	f_y_start :
	    The y coordinate of start location of the rectangle
	f_width :
	    The width (left-to-right) of the rectangle
	f_height :  
	    The height (top-to-bottom) of the rectangle
	f_theta_z :
	    The angle of rotation about z axis
	*/
	
	/*
        outputs--
	*/
	
	// Create new matrix for this rectan
	glPushMatrix();
	
	    // Set the translation
	    glTranslatef(f_x_start, f_y_start, 0.0f); 
	    
	    // Set the rotation
	    glRotatef(f_theta_z, 0.0f, 0.0f, f_theta_z);
	    
	    // Set the begin marker
	    glBegin(GL_QUADS);
	    
		// Define the square vertices
		glVertex2f(0.0f, 0.0f);
		glVertex2f(0.0f, f_height);
		glVertex2f(f_width, f_height);
		glVertex2f(f_width, 0.0f);

	    // Set the end marker
	    glEnd();
	    
	// Remove the new matrix
	glPopMatrix();

    }

    
}

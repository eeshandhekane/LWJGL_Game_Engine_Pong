/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.base.uncategorized;

import org.lwjgl.opengl.Display;

/**
 *
 * @author eeshan
 */


// This class is supposed to implement the abstract class (the concept) of a game object
public class Game_Object_Ball extends Game_Objects {
    
    
    // Define attributes
    public static final int CONST_SIZE = 16; // Define a constant size
    public static final float CONST_MAX_SPEED_X = 4.0f;
    public static final float CONST_MAX_SPEED_Y = 8.0f;
    public static final float CONST_DAMPER = 0.05f; // Otherwise, after hitting the edge of the pod, the ball shoots off in Y
    public float vel_x;
    public float vel_y;
    
    
    // Define the constructor
    public Game_Object_Ball(float x, float y) {
    
	/*
	inputs--
	
	x :
	    The initial X location of the ball
	y :
	    The initial Y location of the ball
	*/
	
	/*
	outputs--
	*/
	
	// We need to set the abstract class's x to the input x. We need to specify that LHS has this class's x
	this.x = x;
	this.y = y;
	this.sx = CONST_SIZE;
	this.sy = CONST_SIZE;
	
	// Set newly defined variables
	vel_x = -CONST_MAX_SPEED_X;
	vel_y = 0.0f;
	
    }

    
    // @Override is to represent that the underlying method is abstract of the parent class. It gives a WARNING, not ERROR, if we miss the override
    @Override
    void UpdateGameObject(float f_width, float f_height) {
	
	/*
	inputs--
	*/
	
	/*
	outputs--
	*/
	
	// Change the positions as per requirements
	x += vel_x;
	y += vel_y;
	
    }

    public void UpdateBallMotionInX(float center) {
	
	vel_x *= -1;
	vel_y += (this.GetCenterY() - center)*CONST_DAMPER;
	if (vel_y > CONST_MAX_SPEED_Y) {
	    vel_y = CONST_MAX_SPEED_Y;
	}
	if (vel_y < -CONST_MAX_SPEED_Y) {
	    vel_y = -CONST_MAX_SPEED_Y;
	}
	
    }

    public void UpdateBallMotionInY() {
	
	vel_y *= -1;
	
    }

    void ResetBallPosition() {
	x = Display.getWidth()/2 - CONST_SIZE/2;
	y = Display.getHeight()/2 - CONST_SIZE/2;
	vel_x = -CONST_MAX_SPEED_X;
	vel_y = 0;
    }
    
    
    
}

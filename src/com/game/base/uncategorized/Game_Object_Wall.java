/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.base.uncategorized;

/**
 *
 * @author eeshan
 */
public class Game_Object_Wall extends Game_Objects {
    
    
    // Define the attributes
    public static final int CONST_SIZE = 16; // This depends on the width of the display
    private Game_Object_Ball ball;
    
    
    // Define the constructor
    public Game_Object_Wall(float x, float y, float sx, float sy, Game_Object_Ball ball) {
	
	/*
	inputs--
	
	x :
	    The X location of the ball
	y :
	    The Y location of the ball
	sx :
	    The X size of the wall
	sy :
	    The Y size of the wall
	ball :
	    The ball of the game
	*/
	
	/*
	outputs--
	*/
	
	this.x = x;
	this.y = y;
	this.sx = sx;
	this.sy = sy;
	this.ball = ball;
	
    }

    // Define the update method
    @Override
    void UpdateGameObject(float f_width, float f_height) {
	
	/*
	inputs--
	*/
	
	/*
	outputs--
	*/
	
	// Check if there is a collision and do changes appropriately
	if (Physics_Engine.DetectCollision(this, ball)) {
	    
	    ball.UpdateBallMotionInY();
	    
	}   
	
    }
    
    
    
    
}

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
public class Game_Object_Enemy extends Game_Objects {
    
    
        // Define attributes
    public static final int CONST_SIZE_X = 16;
    public static final int CONST_SIZE_Y = CONST_SIZE_X*8; // Set relative sizes
    public static final float CONST_MAX_SPEED = 4f; // SAME SPEED AS THE BALL
    public static final float CONST_DAMPER = 0.05f;
    private Game_Object_Ball ball;
    
    
    // Define the constructor. REMEMBER : CONSTRUCTOR HAS NO RETURN TYPE!!
    public Game_Object_Enemy(float x, float y, Game_Object_Ball ball){
    
	/*
	inputs--
	
	x :
	    The initial X location of the player pad
	y :
	    The initial Y location of the player pad
	ball :
	    The ball of the game
	*/
	
	this.x = x;
	this.y = y;
	this.sx = CONST_SIZE_X;
	this.sy = CONST_SIZE_Y;
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
	    
	    ball.UpdateBallMotionInX(this.GetCenterY());
	    
	}   
	
	// If the ball is above, move up
	float f_diff_y = (ball.GetY() - this.GetY())*CONST_DAMPER; // Actual pixels times the damping constant
	if (f_diff_y > CONST_MAX_SPEED) {
	    f_diff_y = CONST_MAX_SPEED;
	}
	if (f_diff_y < -CONST_MAX_SPEED) {
	    f_diff_y = -CONST_MAX_SPEED;
	}
	    
	this.y += f_diff_y;
	
    }


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.base.uncategorized;


// Imports are auto added, or are asked for with alt(control in MAC) + enter/return
import java.awt.Rectangle;


/**
 *
 * @author eeshan
 */


// Define the class for holding physics engine
public class Physics_Engine {
    
    
    /*
    Invariably, any game engine needs a physics engine to guide actions of objects
    Thus, there should be a class that is dedicated to implement the physics of the situation
    These methods do following things-- 1. decide if two objects should interact (e.g., collisions), 2. implement effects of interactions (e.g., momentum-energy based velocity solver), 3. implement effects of fields on objects (gravity)
    */
    
    
    // Define a function to detect collision (TYPE 1)
    public static boolean DetectCollision(Game_Objects game_object_1, Game_Objects game_object_2) {
    
	/*
	inputs--
	
	game_object_1 :
	    Instance 1 of Game_Object class
	game_object_2 :
	    Instance 2 of Game_Object class
	*/
	
	/*
	outputs--
	
	is_collision :
	    Whether or not the two objects collided or not
	*/
	
	/*
	Java development kit has AWT library, which contains a rectangle class. It inputs two rectangles and tells if two objects collided or not
	*/
	
	// Get AWT rectangles from bottom-left corner and sizes
	Rectangle rect_1 = new Rectangle((int)game_object_1.GetX(), (int)game_object_1.GetY(), (int)game_object_1.GetSX(), (int)game_object_1.GetSY()); // The AWT library rect needs int values!!
	Rectangle rect_2 = new Rectangle((int)game_object_2.GetX(), (int)game_object_2.GetY(), (int)game_object_2.GetSX(), (int)game_object_2.GetSY());
	
	// Return collision detection
	return rect_1.intersects(rect_2);
	
    }
    
}

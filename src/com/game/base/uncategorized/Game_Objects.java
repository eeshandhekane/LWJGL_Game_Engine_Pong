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
public abstract class Game_Objects {
    
    
    /*
    The reason to make the Game_Object abstract class is that game objects will have a set of common properties, but not all their properties will be common
    For instance, a brick will have a hidden surprise (possibly!), but the ball will not
    The abstract class abstracts out all the common properties and allows for extensions in specific implementing classes
    Abstract classes implement classes that are better conceived as CONCEPTS rather than objects. Thus, we need to have a good representation of the game APRIORI
    */
    
    // A game object needs to have a position. However, it must be modifi-able only by other game objects!! Thus, only subclasses should have access to the property--
    protected float x; // X location
    protected float y; // Y location
    protected float sx; // Size X
    protected float sy; // Size Y
    
    
    // Define a function to update the game object. This update method is bound to be specific to the object and hence, we should better make it abstract!!
    abstract void UpdateGameObject(float f_width, float f_height);

    
    // Define a function to render the game object. Each object needs to be rendered, but it is THE SAME METHOD FOR ALL GAME OBJECTS!! We need to render the object as rectangles
    public void RenderGameObject() {
	
	/*
	inputs--
	*/
	
	/*
	outputs--
	*/
	
	// Draw the object using the draw class' method. Each object is drawn in the same name
	Draw.Rectangle(x, y, sx, sy);
	
    }
    
    
    // Define a function to get X
    public float GetX() {
	
	/*
	inputs--
	*/
	
	/*
	outputs--
	
	x :
	    The x coordinate of the game object
	*/
	
	return x;
    }
    
    
    // Define a function to get Y
    public float GetY() {
	
	/*
	inputs--
	*/
	
	/*
	outputs--
	
	y :
	    The y coordinate of the game object
	*/
	
	return y;
    }
    
    
    // Define a function to get SIZE X
    public float GetSX() {
	
	/*
	inputs--
	*/
	
	/*
	outputs--
	
	sx :
	    The sx coordinate of the game object
	*/
	
	return sx;
    }
    
    
    // Define a function to get SIZE Y
    public float GetSY() {
	
	/*
	inputs--
	*/
	
	/*
	outputs--
	
	sy :
	    The sy coordinate of the game object
	*/
	
	return sy;
    }
    
    
    // Define a function to get the center of the object across all dimensions. Here, in X
    public float GetCenterX() {
    
	/*
	inputs--
	*/
	
	/*
	outputs--
	
	center_x :
	    The X-directional center of the object
	*/
	
	return x + sx/2;
    
    }
    
    
    // Define a function to get the center of the object in Y
    public float GetCenterY() {
    
	/*
	inputs--
	*/
	
	/*
	outputs--
	
	center_y :
	    The Y-directional center of the object
	*/
	
	return y + sy/2;
    
    }
    
    
}

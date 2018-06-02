/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/
package com.game.base.uncategorized;

import java.util.ArrayList;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;


/**
 *
 * @author eeshan
*/
public class Game {
    
    
    // Maintain a global construct to keep track of all the game objects
    private ArrayList<Game_Objects> objects;
    // We need to maintain players so that they can be accessed
    private Game_Object_Player player;
    // We need to maintain players so that they can be accessed
    private Game_Object_Enemy enemy;
    // We need to declare a wall
    private Game_Object_Wall wall_down, wall_up;
    // We need to maintain the ball
    private Game_Object_Ball ball;
    // Keep track of scores
    private int n_player_score;
    private int n_enemy_score;
    
    // Define the constructor
    public Game() {
	
	/*
	inputs--
	*/
	
	/*
	outputs--
	*/
	
	/*
	Here, we need to define all the state variables for all the objects
	Consider the game of pong and a component-- ball, pod and the bricks
	All these components have several things in common. They have certain positions per frame, they perform certain action across frames, they need to be rendered
	All these things are JUST GAME OBJECTS!! Thus, everything in the game is a game object
	*/
	
	// Initialize the object list
	objects = new ArrayList<Game_Objects>();
	
	// Create the ball object in the game. Set the initial location of the ball at the screen center. Remember to subtract the offset of the ball's size
	ball = new Game_Object_Ball(Display.getWidth()/2 - Game_Object_Ball.CONST_SIZE/2, Display.getHeight()/2 - Game_Object_Ball.CONST_SIZE/2);
	// Once the ball is created, it needs to be added to the ArrayList of Game_Objects so that it is displayed
	objects.add(ball);
	
	// Create our paddle player object. Set initial location at x = 0 and y = center of y. We have kept it global so that it can be accessed properly
	player = new Game_Object_Player(0, Display.getHeight()/2 - Game_Object_Player.CONST_SIZE_Y/2, ball);
	// Add player to game objects list
	objects.add(player);
	
	// Create an enemy
	enemy = new Game_Object_Enemy(Display.getWidth() - Game_Object_Enemy.CONST_SIZE_X, Display.getHeight()/2 - Game_Object_Player.CONST_SIZE_Y/2, ball);
	// Add enemy to game objects list
	objects.add(enemy);
	
	// Create walls
	wall_down = new Game_Object_Wall(0, 0, Display.getWidth(), Game_Object_Wall.CONST_SIZE, ball);
	wall_up = new Game_Object_Wall(0, Display.getHeight() - Game_Object_Wall.CONST_SIZE, Display.getWidth(), Game_Object_Wall.CONST_SIZE, ball);
	objects.add(wall_down);
	objects.add(wall_up);
	
	// Set scores
	n_player_score = 0;
	n_enemy_score = 0;
	
    }
    
    
    // Define a function to get game input
    public void GetGameInput() {
	
	/*
	inputs--
	*/
	
	/*
	outputs--
	*/
	
	/*
	We want to make a ball. Ball has to be an object of type Game_Object. However, it is an abstract class. It should further be added to the list of game objects
	Game_Object ball ... is not a valid way, as abstract class Game_Object is just a concept and not an object in itself
	*/
	
	// Check if the W-S or UP-DOWN arrow keys are pressed
	if(Keyboard.isKeyDown(Keyboard.KEY_W) || Keyboard.isKeyDown(Keyboard.KEY_UP)) {
	    
	    // Access the y of the player!! We should NOT be accessing it directly, as it is private field. We should use the appropriate setters
	    player.Move(1);
	}
	
	if(Keyboard.isKeyDown(Keyboard.KEY_S) || Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
	    
	    // Access the y of the player!! We should NOT be accessing it directly, as it is private field. We should use the appropriate setters
	    player.Move(-1);
	}
	
	
	
    }
    

    // Define a function to update the game state 
    public void UpdateGameState(float f_width, float f_height) {
	
	/*
	inputs--
	
	f_width :
	    The width of the screen
	f_height :
	    The height of the screen
	*/
	
	/*
	outputs--
	*/
	
	// Update each game object separately
	for(Game_Objects a_game_object : objects) {
	    
	    a_game_object.UpdateGameObject(f_width, f_height);
	    
	}
	
	// If the ball has gone past any of the pods, increase score
	if(ball.GetX() < 0) {
	    n_enemy_score += 1;
	    ball.ResetBallPosition();
	}
	if(ball.GetX() > Display.getWidth()) {
	    n_player_score += 1;
	    ball.ResetBallPosition();
	}
	
    }
    
    // Define a function to render the game
    public void RenderGame() {
	
	/*
	inputs--
	*/
	
	/*
	outputs--
	*/
	
	// Render each object separately
	for(Game_Objects a_game_object : objects) {
	    
	    a_game_object.RenderGameObject();
	    
	}
	
	// Show scores
	Display.setTitle("PLAYER SCORE : " + n_player_score + " ENEMY SCORE : " + n_enemy_score);
	
    }
}

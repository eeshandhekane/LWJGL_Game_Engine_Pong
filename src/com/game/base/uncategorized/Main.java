/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package com.game.base.uncategorized;


// Imports are automatically added as per the need!!
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard; // LOAD FROM PROPER LOCATION!! THERE ARE MULTIPLE OF THESE KEYBOARDS!!
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*; // "Static import" imports everything static in the class, as if these were the parts of the current class


/**
 * 
 *
 * @author eeshan
*/


/*
Game Engine--

Any dynamic system or a game needs one and one important thing-- game engine!
Game development friendly codes can be viewed as codes based on certain game engines
We can structure a game code in the form of a game engine and then the game specific build/code

Definition--
A game engine is a code that, at its core, does 7 important things.
It provides a lot of tools and utilities that are of 7 types
We develop the game engine in an object oriented manner. Repurpose main class to fit the role of game engine manager. It tells the program to do several (7 type of) things--
STEP 1 : Initialize and create a display window and make it ready to display the game
STEP 2 : Initialize the game content. This needs a clear-cut definition of the state parameters of the game. Each state parameter needs to be declared properly
STEP 3 : Start game loop, i.e. series of events that occurs every frame. Gives per frame control of the game. We need to update the game state. Next 3 steps happen in the loop
    STEP 4 : Get user (and possibly, other players) input. Based on the input, different actions need to be taken in the game
    STEP 5 : Perform game actions/game logic based on game logic (using physics and AI etc.). Generally called update function in games and is performed once a loop
    STEP 6 : Render! Display the updated state of the game 
STEP 7 : Cleanup after the game is over. 

Generalizability--
A game engine is supposed to support multiple game, and games are very different!
Thus, the codes for the methods that implement the 7 steps are supposed to be generic
Implement main to manage the game engine, and implement the components in different classes
Thus, we create a class that hosts the game. We will implement the game class in a little bit different manner for everything that we do
Thus, to have many games powered by this engine, we just swap the Game class for different games
*/


// The main class is the game engine manager
public class Main {
    
    
    // To power a game by this game engine, we need to create an instance of the game
    private static Game game;
	    
    
    // Main method
    public static void
    main(String[] args) {
	
	/*
	inputs--
	
	String[] args :
	    The input arguments (default)
	*/
	
	/*
	outputs--
	*/

	/*
	STEP 1--
	*/
	
	// Call the method to initialize the display
	InitializeDisplay();

	// Call the method to initialize opengl
	InitializeOpenGL();
	
	/*
	STEP 2--
	*/
	
	InitializeGame();
	
	/*
	STEP3--
	*/

	// Call the method to set the game loop
	InitializeGameLoop();

	/*
	STEP7--
	*/
	
	// Call the method to clean up the things the function uses
	InitializeCleanUp();

    }
    
    
    // Define a function to load the game, i.e., initialize the game content and define its state variables properly
    private static void 
    InitializeGame() {
	
	/*
	inputs--
	*/
	
	/*
	outputs--
	*/
	
	// Initialization game
	game = new Game();
	
    }
    

    // Define a function to initialize the Display instance
    private static void
    InitializeDisplay() {

	/*
        inputs--
	*/
	
	/*
        outputs--
	*/
	
	// Create display. The IDE throws error when the content is not included in a try-catch block. "control" + "enter/return" gives options to include the suggestions!! Use try-catch for the block(or the sentence), as per the need
	try {

	    // Create an instance of blank window. Use static class Display for calling windows. The next lines sets the mode with shape of window
	    DisplayMode display_mode = new DisplayMode(800, 600);
	    Display.setDisplayMode(display_mode);

	    // Create the actual display instance
	    Display.create();
	    // Sync display to the rate of frames. Otherwise, visual glitches occur
	    Display.setVSyncEnabled(true);
	    
	    /*
	    Java inputs using a special library class called as keyboard
	    Like Display, static class need not be created or destroyed. Keyboard class is static. Thus, similar to the Display class, it jsut needs to be created. THERE IS NO DESTROYING THE STATIC
	    */
	    
	    // Set keyboard map using the java's standard input manner of using the Keyboard class
	    Keyboard.create();
	    
	    
	} 
	catch (LWJGLException ex) {

	    // Standard exception catcher!
	    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
	}

    }

    // Define a function to initialize opengl
    private static void
    InitializeOpenGL() {

	/*
        inputs--
	*/
	
	/*
        outputs--
	*/
	
	// Set projection matrix. All next operations that follow will be done in projection matrix. Next 2 commands after the following line are the adaptations in the projection matrix
	glMatrixMode(GL_PROJECTION);
	// Start by setting identity and clear whatever is present in the projection matrix to be gin with
	glLoadIdentity();
	// We can project as is or as our eye is. For now, just load as is
	glOrtho(0, Display.getWidth(), 0, Display.getHeight(), -1, 1); // First 2 args-- In x, from 0 to width. Next 2 args-- In y, from 0 to height. Set -1 and 1 for now as the next 2 args (anything between z = -1 to z = 1). This actually sets the coordinate system, about which the multiline comment in glBegin->glEnd talks about
	// Set model view matrix
	glMatrixMode(GL_MODELVIEW);
	// Set clear color. We need to overwrite all the content of the screen with a default color. We are drawing to 2 frames and when we draw, we need to get rid off previous content.
	
	/*
	Some good colors--

	05386B
	379683
	5CDB95
	*EE4AF
	EDF5E1
	*/
	
	// glClearColor(0.0196f, 0.2196f, 0.4196f, 1); // RGBA are the 4 args. A is opacity. For transperant, 0 and 1 for opaque. Set all args from 0 to 1. We need to set f at the end of args to gl commands so that the otherwise java default type double is not interpreted as float, which is needed in opengl
	glClearColor(0.3608f, 0.8588f, 0.5843f, 1);
	// Write now, we are doing 2D drawing and hence, we need not store depth info
	glDisable(GL_DEPTH_TEST);

    }

    
    // Define a function to model the game loop
    private static void
    InitializeGameLoop() {

	/*
        inputs--
	*/
	
	/*
        outputs--
	*/
	
	// Set the game loop.
	while (!Display.isCloseRequested()) {

	    /*
	    STEP 4--
	    */
	    GetGameInput();
	    
	    /*
	    STEP 5--
	    */
	    UpdateGameState(Display.getWidth(), Display.getHeight());
	    
	    /*
	    STEP 6--
	    */
	    RenderGame();
	   
	}

    }
    
    
    // Define a function to get the user input
    private static void 
    GetGameInput() {
	
	/*
	inputs--
	*/
	
	/*
	outputs--
	*/
	
	game.GetGameInput();
	
    }
    
    
    // Define a function to update the game
    private static void 
    UpdateGameState(float f_width, float f_height) {
	
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
	
	game.UpdateGameState(f_width, f_height);
    }
    
    
    // Define a function to render the game
    private static void 
    RenderGame() {
	
	/*
	inputs--
	*/
	
	/*
	outputs--
	*/
	
	// Clear the frame. Set ALL flags appropriately
	glClear(GL_COLOR_BUFFER_BIT);
	// Set the background color
	glColor3f(0.0196f, 0.2196f, 0.4196f);
	// Clear the matrix to draw
	glLoadIdentity();
	
	// After the pre-processing, render the entire game
	game.RenderGame();
	
	// Dealing with variable framerates is a difficult code in general. So, we set constant frame rate
	Display.sync(60); // The argument is FPS in integers

	// Update the display window
	Display.update();
	
    }

    
    // Define a function to clean up the garbage (set memory free etc.)
    private static void
    InitializeCleanUp() {

	/*
        inputs--
	*/
	
	/*
        outputs--
	*/
	
	// Perform all OpenGL cleanup automatically!!
	Display.destroy();
	
	// Distroy the keyboard
	Keyboard.destroy();

    }

}

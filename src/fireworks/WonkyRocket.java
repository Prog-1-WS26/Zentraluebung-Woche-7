package fireworks;

import de.ur.mi.oop.colors.Color;

// A WonkyRocket is a special type of rocket that wobbles and drifts around after being fired.
public class WonkyRocket extends Rocket {

    private static final int MAX_DRIFT = 10;

    private boolean moveLeft = true;
    private int currentDrift = 0;

    // In the constructor, we simply call the constructor of the super class. There is no difference here to the super class.
    public WonkyRocket(float xPos, float yPos, float radius, float guideLength, float velocity, Color color) {
        super(xPos, yPos, radius, guideLength, velocity, color);
    }

    
    // We override its update() method to define the behavior specific to the WonkyRocket
    @Override
    public void update() {
        // Move the rocket left or right
        if (moveLeft) {
            move(-3, getVelocity());
        } else {
            move(3, getVelocity());
        }
        currentDrift++;
        // After some iterations, we change the direction of the drift.
        if (currentDrift >= MAX_DRIFT) {
            moveLeft = !moveLeft;
            currentDrift = 0;
        }
    }
    
}

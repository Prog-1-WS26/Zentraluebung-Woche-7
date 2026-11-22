package fireworks;

import de.ur.mi.oop.colors.Color;

public class SkyRocket {

    private final Rocket rocket;
    private Flare[] flares;
    private int remainingFuseTimeInMs;
    private boolean exploded;
    private boolean gone;

    public SkyRocket(int xPos, int yPos, float radius, float guideLength, int fuseTimeInMs, float velocity, Color color) {
        rocket = createRocket(xPos, yPos, radius, guideLength, velocity, color);
        exploded = false;
        remainingFuseTimeInMs = fuseTimeInMs;
    }

    // Create a new rocket for the given settings. One in four rockets will be a wonky rocket.
    private Rocket createRocket(int xPos, int yPos, float radius, float guideLength, float velocity, Color color) {
        if (Math.random() > 0.75) {  // One in four
            return new WonkyRocket(xPos, yPos, radius, guideLength, velocity, color);
        }
        return new Rocket(xPos, yPos, radius, guideLength, velocity, color);
    }

    // Update a rocket or its flares depening on the passed time.
    public void update(long deltaTime) {
        if (!exploded) {
            updateRocket(deltaTime);
        } else {
            updateFlares(deltaTime);
        }
    }

    // Check with deltaTime how long the rocket has been on the canvas. If a given time has passed, set the flag
    // "exploded" to true. From that moment on, the rocket will be removed, but its flares will be visible
    private void updateRocket(long deltaTime) {
        remainingFuseTimeInMs -= deltaTime;
        if (remainingFuseTimeInMs <= 0) {
            flares = FireworkFactory.createFlares(rocket.getXPos(), rocket.getYPos(), rocket.getColor());
            exploded = true;
            return;
        }
        rocket.update();
    }

    // Update the flares of a rocket.
    private void updateFlares(long deltaTime) {
        for (Flare flare : flares) {
            if (flare.hasGone()) {
                gone = true;
                break;
            } else {
                flare.update(deltaTime);
            }
        }
    }

    // Return the value of the class variable "gone"
    public boolean hasGone() {
        return gone;
    }

    // Draw the rocket or its flares on the canvas, depending on the
    public void draw() {
        if (!exploded) {
            rocket.draw();
        } else {
            for (Flare flare : flares) {
                flare.draw();
            }
        }
    }

}

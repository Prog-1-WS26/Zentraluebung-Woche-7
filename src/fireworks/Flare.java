package fireworks;

import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.graphics.Circle;

// A Flare represents a single particle spawned by the explosion of a rocket.
public class Flare {

    private final float xVelocity;
    private final float yVelocity;
    private final Circle flare;
    private final float maxLifeTime;
    private float lifeTime;

    public Flare(float xPos, float yPos, float xVelocity, float yVelocity, float maxLifetime, float radius, Color color) {
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
        this.maxLifeTime = maxLifetime;
        this.flare = new Circle(xPos, yPos, radius, color);
    }

    // Update a flare by moving it in the given direction and updating its time present on the canvas
    public void update(long deltaTime) {
        lifeTime += deltaTime;
        flare.move(xVelocity, yVelocity);
    }

    // Check if a flare has exceeded its maximum lifetime.
    public boolean hasGone() {
        return (lifeTime > maxLifeTime);
    }

    // Draw a flare on the canvas
    public void draw() {
        flare.draw();
    }

}

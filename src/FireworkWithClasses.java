import config.Config;
import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.launcher.GraphicsAppLauncher;
import fireworks.FireworkFactory;
import fireworks.SkyRocket;

@SuppressWarnings("ExplicitArrayFilling")
public class FireworkWithClasses extends GraphicsApp {


    private SkyRocket[] fireworks;
    private long lastFrameTime;

    @Override
    public void initialize() {
        // Get constants from custom Config class.
        setCanvasSize(Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT);

        //Prepare all rockets
        fireworks = FireworkFactory.createRandomSetOfRockets(getWidth(), getHeight(), Config.NUMBER_OF_ROCKETS);

        // Get the current timestamp (milliseconds since January 01, 1970 at midnight)
        lastFrameTime = System.currentTimeMillis();
    }

    @Override
    public void draw() {

        // Calculate the time delta between now and the last frame
        long delta = System.currentTimeMillis() - lastFrameTime;

        // Set the variable to the current timestamp in ms
        lastFrameTime = System.currentTimeMillis();
        drawBackground(Config.BACKGROUND_COLOR);
        updateFireworks(delta);
        drawFireworks();
    }

    // Update each rocket present on the canvas. Replace rockets that have completely exploded with new ones
    private void updateFireworks(long deltaTime) {
        for (int i = 0; i < fireworks.length; i++) {
            fireworks[i].update(deltaTime);
            if (fireworks[i].hasGone()) {
                fireworks[i] = FireworkFactory.createRandomRocket(getWidth(), getHeight());
            }
        }
    }

    // Draw each rocket on the canvas
    private void drawFireworks() {
        for (SkyRocket rocket : fireworks) {
            rocket.draw();
        }
    }

    public static void main(String[] args) {
        GraphicsAppLauncher.launch("FireworkWithClasses");
    }
}

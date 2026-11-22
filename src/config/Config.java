package config;

import de.ur.mi.oop.colors.Color;

// To improve the structure of the project, all constants for the application (not the rockets itself) are stored
// here in their own class.
public class Config {

    public static final Color RED = new Color(234, 49, 63); // "Selbstgemischte" RGB-Farbe (rot)
    public static final Color YELLOW = new Color(234, 182, 56); // "Selbstgemischte" RGB-Farbe (gelb)
    public static final Color GREEN = new Color(76, 149, 80); // "Selbstgemischte" RGB-Farbe (grün)
    public static final Color BLUE = new Color(53, 129, 184); // "Selbstgemischte" RGB-Farbe (blau)
    public static final Color GREY = new Color(47, 61, 76); // "Selbstgemischte" RGB-Farbe (grau)

    public static final int WINDOW_WIDTH = 1280;
    public static final int WINDOW_HEIGHT = 720;
    public static final Color BACKGROUND_COLOR = GREY;

    public static final int NUMBER_OF_ROCKETS = 15;

}

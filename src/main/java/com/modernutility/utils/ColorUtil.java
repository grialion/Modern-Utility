package com.modernutility.utils;

import java.awt.*;

public class ColorUtil {

    public static int getRainbow(float seconds, float saturation, float brightness)
    {
        float hue = (System.currentTimeMillis() % (int)(seconds * 1000)) / (seconds * 1000); // well it will change with the time
        return Color.HSBtoRGB(hue, saturation, brightness);
    }

    public static int getRainbow(float seconds, float saturation, float brightness, long index)
    {
        // the modules in the array will have a little bit wait
        // so it will look cooler

        float hue = ((System.currentTimeMillis() + index) % (int)(seconds * 1000)) / (seconds * 1000); // well it will change with the time
        return Color.HSBtoRGB(hue, saturation, brightness);

    }
}

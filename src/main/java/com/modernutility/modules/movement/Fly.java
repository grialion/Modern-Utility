package com.modernutility.modules.movement;

import com.modernutility.module.Category;
import com.modernutility.module.Module;

public class Fly extends Module { // << this will be a module

    public Fly() {
        super("Fly", 'G', Category.MOVEMENT); // this is where we set it up
    }

    public void onEnable()
    {
        // this code will run on enable
        System.out.println("Enabled fly"); // print to console, it's basically System.out.println() = print() in python
    }
    public void onDisable()
    {
        System.out.println("Disabled fly");
    }
}

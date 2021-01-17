package com.modernutility.module;

import com.modernutility.modules.movement.Fly;

import java.util.ArrayList;

public class ModuleManager {

    public static ArrayList<Module> activeModules = new ArrayList<>();

    public Fly fly;

    public ModuleManager()
    {
        activeModules.add(fly = new Fly()); // << here we need to add all our modules
    }
}

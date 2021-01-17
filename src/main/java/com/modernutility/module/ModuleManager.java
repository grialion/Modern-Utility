package com.modernutility.module;

import com.modernutility.modules.movement.Fly;
import com.modernutility.modules.movement.Sprint;

import java.util.ArrayList;

public class ModuleManager {

    public static ArrayList<Module> activeModules = new ArrayList<>();

    public Fly fly;

    public ModuleManager()
    {
        activeModules.add(fly = new Fly()); // << here we need to add all our modules
        Sprint sprint = new Sprint();
        sprint.setState(true); // Automatically will be enabled, i personally love autosprint
        activeModules.add(sprint);
    }
}

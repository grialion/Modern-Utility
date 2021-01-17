package com.modernutility;


import com.modernutility.listeners.EventUpdate;
import com.modernutility.module.Module;
import com.modernutility.module.ModuleManager;
import com.modernutility.ui.Hud;

public class ModernUtility {

    public static String ClientName = "Modern Utility";

    public static double ClientVersion = 1.0;

    public static ModuleManager moduleManager;

    public static Hud hud = new Hud();

    public static void StartClient()
    {
        // This will run at the start of minecraft

        moduleManager = new ModuleManager(); // We'll start the modules on start
    }

    public static String getClientName() {
        return ClientName;
    }

    public static void setClientName(String clientName) {
        ClientName = clientName;
    }

    public static double getClientVersion() {
        return ClientVersion;
    }

    public static void setClientVersion(double clientVersion) {
        ClientVersion = clientVersion;
    }


    public static void onEvent(EventUpdate e) {
        // so this will be called with an event
        for (Module module : ModuleManager.activeModules) {
            if(!module.getState())
            {
                continue; // continue the loop if not enabled
            }
            module.onEvent(e);
        }
    }
}

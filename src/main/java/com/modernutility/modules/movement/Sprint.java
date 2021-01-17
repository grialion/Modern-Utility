package com.modernutility.modules.movement;

import com.modernutility.events.Event;
import com.modernutility.listeners.EventUpdate;
import com.modernutility.module.Category;
import com.modernutility.module.Module;
import net.minecraft.client.Minecraft;

public class Sprint extends Module {

    public Sprint() {
        super("Sprint", 'N', Category.MOVEMENT);
    }

    public void onDisable()
    {
        Minecraft mc = Minecraft.getInstance();
        if(mc.player != null)
        {
            mc.player.setSprinting(mc.gameSettings.keyBindSprint.isKeyDown()); // if the key is down, dont stop sprinting, even tho the module is disabled
        }
    }
    public void onEvent(Event e)
    {
        if(e instanceof EventUpdate)
        {
            if(e.isPre())
            {
                Minecraft mc = Minecraft.getInstance();
                if(mc.player != null)
                {
                    if(
                            (mc.player.moveForward > 0 || mc.player.moveForward < 0) && // moving forward or backward, so don't sprint backwards
                            !mc.player.isSneaking() // not sneaking
                            && !mc.player.collidedHorizontally // not running into a wall
                    )
                    {
                        mc.player.setSprinting(true);
                    }
                }
            }
        }
    }
}

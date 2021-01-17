package com.modernutility.modules.movement;

import com.modernutility.events.Event;
import com.modernutility.listeners.EventUpdate;
import com.modernutility.module.Category;
import com.modernutility.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.network.play.client.CPlayerPacket;

public class Fly extends Module { // << this will be a module

    public Fly() {
        super("Fly", 'G', Category.MOVEMENT); // this is where we set it up
    }

    public void onEnable()
    {
        // now the hard work
        ClientPlayerEntity player = Minecraft.getInstance().player;

        if(!player.isOnGround())
        {
            // if not on ground
//            setState(false);
            return;
        }

        // ok i guess it's a hypixel bypass but idk
        float fallDistance = 3.0125f;

        while(fallDistance > 0)
        {
            Minecraft.getInstance().player.connection.sendPacket(new CPlayerPacket.PositionPacket(player.getPosX(), player.getPosY() + 0.0624986421, player.getPosZ(), false));
            Minecraft.getInstance().player.connection.sendPacket(new CPlayerPacket.PositionPacket(player.getPosX(), player.getPosY() + 0.0625, player.getPosZ(), false));
            Minecraft.getInstance().player.connection.sendPacket(new CPlayerPacket.PositionPacket(player.getPosX(), player.getPosY() + 0.0624986421, player.getPosZ(), false));
            Minecraft.getInstance().player.connection.sendPacket(new CPlayerPacket.PositionPacket(player.getPosX(), player.getPosY() + 0.0000013579, player.getPosZ(), false));

            fallDistance -= 0.0624986421;
        }
        //skidding a client be like

        Minecraft.getInstance().player.connection.sendPacket(new CPlayerPacket.PositionPacket(player.getPosX(), player.getPosY(), player.getPosZ(), true));
        // it basically bypasses like AAC too but idk

        Minecraft.getInstance().player.connection.sendPacket(new CPlayerPacket.PositionPacket(player.getPosX(), player.getPosY(), player.getPosZ(), true));
        // we send a last packet: we are on the ground

        player.jump();
        // done
    }
    public void onDisable()
    {
        System.out.println("disable");
        Minecraft mc = Minecraft.getInstance();

        if(mc.player != null)
        {
            mc.player.abilities.setFlySpeed(0.1f);
            mc.player.abilities.isFlying = false;
        }
    }
    public void onEvent(Event e)
    {

        if(e instanceof EventUpdate)
        {
            if(e.isPre())
            {

                Minecraft mc = Minecraft.getInstance();

                // YAY this will be called on a PRE event

                if(mc.player != null)
                {
                    // now we can work with the player, it's pretty simple:
                    mc.player.abilities.isFlying = true;
                    mc.player.abilities.setFlySpeed(0.2f);
                    // done lol
                }
            }
        }
    }
}

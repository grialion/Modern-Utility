package com.modernutility.ui;

import com.modernutility.ModernUtility;
import com.modernutility.module.Module;
import com.modernutility.module.ModuleManager;
import com.modernutility.utils.ColorUtil;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

public class Hud {
    public Minecraft mc = Minecraft.getInstance();

    public void draw(MatrixStack matrixStack)
    {
        //this will draw the client name and modules
        // so what's in this code will run, when the client draws the items, etc.

        FontRenderer fontRenderer = mc.fontRenderer;

        fontRenderer.drawStringWithShadow(matrixStack, "M", 10, 10, ColorUtil.getRainbow(8, 0.8f, 1)); // so -1 is currently the color
        fontRenderer.drawStringWithShadow(matrixStack, "odern Utility v" + ModernUtility.getClientVersion(), 10 + fontRenderer.getStringWidth("M") + 1, 10, -1); // so -1 is currently the color

        int count = 0;

        for (Module module : ModuleManager.activeModules) {
            // loop through all modules
            if(module.getState())
            {
                // if the module is enabled, draw it

                fontRenderer.drawStringWithShadow(matrixStack, module.getName(), (int)(mc.getMainWindow().getWidth() / 2) - fontRenderer.getStringWidth(module.getName()) - 4, (float) ((count*fontRenderer.FONT_HEIGHT + 4) * 1.2), ColorUtil.getRainbow(4, 0.8f, 1, count * 100L));

                count++; // add to count so it will display under the last module
                //SOOOOOOOOOOO
                // we will draw the module name with module.getName()
                // (int)(mc.getMainWindow().getWidth() / 2) - fontRenderer.getStringWidth(module.getName()) - 4 means it will draw to the right side of the screen
                // (float) ((count*fontRenderer.FONT_HEIGHT + 4) * 1.2) means the y potion of the text, it will display under the last enabled module..
            }
        }
    }
}

package com.saomc.screens;

import com.saomc.screens.buttons.ActionHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public interface ParentElement extends ActionHandler {

    int getX(boolean relative);

    int getY(boolean relative);

}

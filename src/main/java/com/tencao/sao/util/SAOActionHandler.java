package com.tencao.sao.util;

import com.tencao.sao.ui.SAOElementGUI;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public interface SAOActionHandler {

	public void actionPerformed(SAOElementGUI element, SAOAction action, int data);

}

package com.tencao.saoui.util;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public enum SAOAction {

	UNKNOWN,

	LEFT_PRESSED,
	RIGHT_PRESSED,
	MIDDLE_PRESSED,

	LEFT_RELEASED,
	RIGHT_RELEASED,
	MIDDLE_RELEASED,

	KEY_TYPED,
	MOUSE_WHEEL;

	public static SAOAction getAction(int button, boolean pressed) {
		return button >= 0 && button <= 2 ? values()[button + (pressed ? LEFT_PRESSED.ordinal() : LEFT_RELEASED.ordinal())] : UNKNOWN;
	}

}

package com.tencao.sao.util;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public final class SAOColorCursor {

    public static final SAOColorCursor CREATIVE = new SAOColorCursor(SAOColorState.CREATIVE, false);

    private static final long STATE_TIME = 24 * 60 * 60 * 1000; // DAY IN MILLISECONDS

    private SAOColorState colorState;
    private long downgradeTime;

    public SAOColorCursor(SAOColorState defaultState, boolean set) {
        if (set) {
            colorState = defaultState;
            set(defaultState);
        } else {
            colorState = defaultState;
            downgradeTime = 0;
        }
    }

    public SAOColorCursor() {
        this(SAOColorState.INNOCENT, false);
    }

    public final void update(long delay) {
        if (delay >= downgradeTime) {
            colorState = SAOColorState.INNOCENT;
            downgradeTime = 0;
        } else {
            downgradeTime -= delay;
        }
    }

    public final void set(SAOColorState state) {
        if (state.ordinal() >= colorState.ordinal()) {
            colorState = state;
            downgradeTime = STATE_TIME;
        }
    }

    public final SAOColorState get() {
        return colorState;
    }

}
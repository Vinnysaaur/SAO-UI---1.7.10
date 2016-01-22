package com.tencao.saoui.util;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.util.StatCollector;

import java.util.stream.Stream;

@SideOnly(Side.CLIENT)
public enum SAOOption {

    VANILLA_OPTIONS(StatCollector.translateToLocal("guiOptions"), false, false, null),
    UI(StatCollector.translateToLocal("optCatUI"), false, true, null),
    RENDERER(StatCollector.translateToLocal("optCatRend"), false, true, null),
    INTERFACES(StatCollector.translateToLocal("optCatInterf"), false, true, null),
    DEFAULT_UI(StatCollector.translateToLocal("optionDefaultUI"), false, false, UI),
    //DEFAULT_HEALTH(StatCollector.translateToLocal("optionDefaultHealth"), false, false, UI),
    DEFAULT_INVENTORY(StatCollector.translateToLocal("optionDefaultInv"), true, false, INTERFACES),
    DEFAULT_DEATH_SCREEN(StatCollector.translateToLocal("optionDefaultDeath"), false, false, UI),
    DEFAULT_HOTBAR(StatCollector.translateToLocal("optionDefaultHotbar"), false, false, UI),
    ALT_HOTBAR(StatCollector.translateToLocal("optionAltHotbar"), false, false, UI),
    CROSS_HAIR(StatCollector.translateToLocal("optionCrossHair"), false, false, UI),
    HEALTH_BARS(StatCollector.translateToLocal("optionHealthBars"), true, false, RENDERER),
    SMOOTH_HEALTH(StatCollector.translateToLocal("optionSmoothHealth"), true, false, UI),
    COLOR_CURSOR(StatCollector.translateToLocal("optionColorCursor"), true, false, RENDERER),
    PARTICLES(StatCollector.translateToLocal("optionParticles"), true, false, RENDERER),
    CURSOR_MOVEMENT(StatCollector.translateToLocal("optionCursorMov"), true, false, INTERFACES),
    CLIENT_CHAT_PACKETS(StatCollector.translateToLocal("optionCliChatPacks"), true, false, null),
    SOUND_EFFECTS(StatCollector.translateToLocal("optionSounds"), true, false, null),
    LOGOUT(StatCollector.translateToLocal("optionLogout"), false, false, INTERFACES),
    ORIGINAL_UI(StatCollector.translateToLocal("optionOrigUI"), true, false, UI),
    LESS_VISUALS(StatCollector.translateToLocal("optionLessVis"), false, false, RENDERER),
    SPINNING_CRYSTALS(StatCollector.translateToLocal("optionSpinning"), true, false, RENDERER),
    FORCE_HUD(StatCollector.translateToLocal("optionForceHud"), false, false, UI),
    REMOVE_HPXP(StatCollector.translateToLocal("optionLightHud"), false, false, UI),
    ALT_ABSORB_POS(StatCollector.translateToLocal("optionAltAbsorbPos"), false, false, UI),
    MOUNT_STAT_VIEW(StatCollector.translateToLocal("optionMountStatView"), true, false, UI),
    GUI_PAUSE(StatCollector.translateToLocal("optionGuiPause"), true, false, INTERFACES),
    CUSTOM_FONT(StatCollector.translateToLocal("optionCustomFont"), false, false, null);

    public final String name;
    public final boolean isCategory;
    public final SAOOption category;
    private boolean value;

    SAOOption(String optionName, boolean defaultValue, boolean isCat, SAOOption category) {
        name = optionName;
        value = defaultValue;
        isCategory = isCat;
        this.category = category;
    }

    public static SAOOption fromString(String str) {
        return Stream.of(values()).filter(option -> option.toString().equals(str)).findAny().orElse(null);
    }

    @Override
    public final String toString() {
        return name;
    }

    public boolean flip() {
        this.value = !this.getValue();
        ConfigHandler.setOption(this);
        if (this == CUSTOM_FONT) SAOGL.setFont(Minecraft.getMinecraft(), this.value);
        return this.value;
    }

    public boolean getValue() {
        return this.value;
    }

    public void disable() {
        if (this.value) this.flip();
    }

    public void enable() {
        if (!this.value) this.flip();
    }

}

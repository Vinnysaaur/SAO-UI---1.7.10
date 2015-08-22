package com.thejackimonster.sao.ui;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.config.Configuration;

import com.thejackimonster.sao.SAOMod;
import com.thejackimonster.sao.util.SAOParentGUI;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SAOFriendsGUI extends SAOListGUI {

	public SAOFriendsGUI(Minecraft mc, SAOParentGUI gui, int xPos, int yPos, int w, int h) {
		super(gui, xPos, yPos, w, h);
		init(mc);
	}

	private void init(Minecraft mc) {
		final List<EntityPlayer> list = SAOMod.listOnlinePlayers(mc);
		
		if (list.contains(mc.thePlayer)) {
			list.remove(mc.thePlayer);
		}
		
		for (final EntityPlayer player : list) {
			elements.add(new SAOFriendGUI(this, 0, 0, SAOMod.getName(player)));
		}
	}

}

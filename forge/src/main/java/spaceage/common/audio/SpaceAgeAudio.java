package spaceage.common.audio;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import spaceage.common.SpaceAgeCore;
import net.minecraftforge.client.event.sound.SoundLoadEvent;

public class SpaceAgeAudio {
	
	@SubscribeEvent
	public void onSound(SoundLoadEvent event) {
		//event.manager.addSound(SpaceAgeCore.modid + ":"/* + "hit.ogg"*/);
	}

}

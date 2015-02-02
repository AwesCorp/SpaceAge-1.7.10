package skylordjoelcore;

import com.jadarstudios.developercapes.DevCapesUtil;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenderers() {
		
	}
	
	@Override
	public void load() {
		DevCapesUtil.addFileUrl("https://raw.githubusercontent.com/AwesCorp/Project-Cloak/master/spaceage_capes.txt");
	}
}
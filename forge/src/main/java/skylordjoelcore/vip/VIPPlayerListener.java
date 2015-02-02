package skylordjoelcore.vip;

import java.util.LinkedList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import cpw.mods.fml.common.IPlayerTracker;
import cpw.mods.fml.common.Mod.EventHandler;

public class VIPPlayerListener implements IPlayerTracker {
	public static VIP plugin;
	public String callingPlayerName;
	
	public VIPPlayerListener(VIP instance) {
		plugin = instance;
	}

	@Override
	public void onPlayerLogin(EntityPlayer player) {
		if(MinecraftServer.getServer().getCurrentPlayerCount() < MinecraftServer.getServer().getMaxPlayers()) {
			return;
		}
		
		if(plugin.permissions.isVIP(player) == 0) {
			((EntityPlayerMP)player).playerNetServerHandler.kickPlayerFromServer("You have been removed from the game to provide room for VIPs.");
		}
		
	    List<EntityPlayer> online = MinecraftServer.getServer().getConfigurationManager().playerEntityList;
	    LinkedList options = new LinkedList();
	    int it = 0;
	    int p = 0;
	    while ((it == 0) && (p < plugin.permissions.isVIP(player))) {
	    	for (int i = 0; i < online.size(); i++) {
	    		if (plugin.permissions.isVIP(online.get(i)) == p) {
	    			options.add(online.get(i));
	    			it++;
	    		}
	    	}
	    	p++;
	    }
	    
	    if (it == 0) {
	    	((EntityPlayerMP)player).playerNetServerHandler.kickPlayerFromServer("You have been removed from the game to provide room for VIPs.");
	    	return;
	    }
	    
	    if (it == 1) {
	    	//(options.get(0)).kickPlayer(plugin.getConfigs().getString("custom kick message", "Server is full. A VIP signed in."));
	    	((EntityPlayerMP)options.get(0)).playerNetServerHandler.kickPlayerFromServer("You have been removed from the game to provide room for VIPs.");
	    	//event.setResult(PlayerLoginEvent.Result.ALLOWED); TODO Player is allowed in for some reason code...
	      	return;
	    }
	    
	    int kick = 0;
	    for (int i = 1; i < options.size(); i++) {
	    	int iLoginTime = plugin.getConfig().getInt("DO NOT EDIT -- Login times." + (options.get(i)).getName(), 0);
	    	int kickLoginTime = plugin.getConfig().getInt("DO NOT EDIT -- Login times." + (options.get(kick)).getName(), 0);
	    	
	    	if ((iLoginTime != 0) && (iLoginTime > kickLoginTime) && (plugin.kickLastLogged == true)) {
	    		kick = i;
	    	} 
	    }
	    
	    ((EntityPlayerMP)options.get(kick)).playerNetServerHandler.kickPlayerFromServer("You have been removed from the game to provide room for VIPs.");
    	//event.setResult(PlayerLoginEvent.Result.ALLOWED); TODO Player is allowed in for some reason code...
	    
	    plugin.getConfig().set("DO NOT EDIT -- Login times." + ((EntityPlayerMP)player).username, Long.valueOf(player.worldObj.getTotalWorldTime()));
	    plugin.saveConfig();
	}

	@Override
	public void onPlayerLogout(EntityPlayer player) {
		plugin.getConfig().set("DO NOT EDIT -- Login times." + player.username, null);
		plugin.saveConfig();
	}

	@Override
	public void onPlayerChangedDimension(EntityPlayer player) {
		
	}

	@Override
	public void onPlayerRespawn(EntityPlayer player) {
		
	}
}
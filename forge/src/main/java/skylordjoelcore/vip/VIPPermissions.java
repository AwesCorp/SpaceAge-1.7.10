package skylordjoelcore.vip;

import java.sql.SQLException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class VIPPermissions {
	private final VIP plugin;

	public VIPPermissions(VIP plugin) {
	    this.plugin = plugin;
	}

	public boolean canAddEntityPlayer(EntityPlayer player) {
		if (player != null) {
	    	return player.canCommandSenderUseCommand(4, "VIP.add");
	    }
		
	    return false;
	}
	  
	public boolean canRemoveEntityPlayer(EntityPlayer player) {
	    if (player != null) {
	    	//return player.hasPermission("VIP.remove");
	    	return player.canCommandSenderUseCommand(4, "VIP.remove");
	    }
	    
	    return false;
	}
	 
	public boolean canToggleKick(EntityPlayer player) {
	    if (player != null) {
	    	return player.canCommandSenderUseCommand(4, "VIP.toggleKick");
	    }
	    
	    return false;
	}
	
	public int isVIP(EntityPlayer player) {
		String playerName = player.username;
		
	    //if (this.plugin.getConfig().getBoolean("Use MySQL", false)) {
	    	//if (this.plugin.getConfig().getBoolean("Use permissions for VIP list", false))
	    		try {
	    			return this.plugin.getDB().getPermission(playerName);
    			} catch (SQLException e) {
    				//this.plugin.getLogger().warning("SQL-Error: " + e.getMessage());
    				System.out.println("[WARNING] SQL-Error: " + e.getMessage());
    				return 0;
				} try {
					return this.plugin.getDB().getPlayer(playerName);
				} catch (SQLException e) {
    				System.out.println("[WARNING] SQL-Error: " + e.getMessage());
					return 0;
				}
			//}
	    //if (this.plugin.getConfig().getBoolean("Use permissions for VIP list", false)) {
	    	
    	if (player.hasPermission("VIP.2")) {
    		return 2;
    	}
	    	
    	if (player.hasPermission("VIP.1")) {
    		return 1;
    	}
	    	
    	if (player.hasPermission("VIP.VIP")) {
    		return 1;
    	}
    	return 0;
    	//}

	    if (this.plugin.getConfig().getString("VIPs." + playerName, null) == null) {
	    	return 0;
	    }
	    return this.plugin.getConfig().getInt("VIPs." + playerName, 0);
    }
}
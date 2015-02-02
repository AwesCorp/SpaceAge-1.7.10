package skylordjoelcore.vip;

import java.io.File;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.Configuration;

public class VIP {
	private final VIPPlayerListener playerListener = new VIPPlayerListener(this);
	//private FileConfiguration oldconfiguration;
	private static final Configuration newConfig = new Configuration(new File("config/AwesCorp/SkylordJoelCore_VIP.cfg"));
	public VIPPermissions permissions;
	public int loginTimes;
	public boolean kickLastLogged;
	private MySQL DB;
	
	public void initConfig() {
		newConfig.load();
		
		loginTimes = newConfig.get(Configuration.CATEGORY_GENERAL, "", 0).getInt();
		kickLastLogged = newConfig.get(Configuration.CATEGORY_GENERAL, "Kick the earliest player on the server", true).getBoolean(true);
		
		newConfig.save();
	}
	
	public void load() {
		initConfig();
		//saveDefaultConfig();
	    //this.configuration = getConfig();
	    //this.configuration.options().copyDefaults(true);
	    //his.configuration.set("DO NOT EDIT -- Login times", null);
	    this.permissions = new VIPPermissions(this);

	    //PluginManager pm = getServer().getPluginManager();

	    //pm.registerEvents(this.playerListener, this);

	    //getCommand("vip").setExecutor(new VIPCommand(this));

	    //PluginDescriptionFile pdfFile = getDescription();

	    //getLogger().info(pdfFile.getName() + " version " + 
	      //pdfFile.getVersion() + " by SkylordJoel is enabled!");
	    System.out.println("[VIP] Run successfully");
    	this.DB = new MySQL(this);
	}
	
	public Configuration getConfig() {
		return this.newConfig;
	}

	public MySQL getDB() {
	    return this.DB;
	}

	public EntityPlayerMP getPlayer(String playername) {
		if(playername == null) {
			return null;
		} else {
			return MinecraftServer.getServer().getConfigurationManager().getPlayerForUsername(playername);
		}
	}
}
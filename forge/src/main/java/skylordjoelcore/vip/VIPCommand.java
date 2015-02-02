package skylordjoelcore.vip;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;

public class VIPCommand extends CommandBase {
	private final VIP plugin;
	public VIPPermissions permissions;

	public VIPCommand(VIP plugin) {
		this.plugin = plugin;
	    this.permissions = plugin.permissions;
	}

	/*public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
	    boolean console = false;
	    Player player = null;
	    
	    if (!(sender instanceof Player))
	      console = true;
	    else {
	      player = (Player)sender;
	    }
	    if (args.length == 1) {
	      if (args[0].equalsIgnoreCase("enable")) {
	        if ((console) || (this.permissions.canEnable(player))) {
	          if (!this.plugin.getConfigs().getBoolean("enabled", false)) {
	            this.plugin.getConfigs().set("enabled", Boolean.valueOf(true));
	            this.plugin.saveConfig();
	            this.plugin.getLogger().info("VIP enabled");
	            sender.sendMessage("VIP enabled");
	          } else {
	            sender.sendMessage("VIP is already enabled.");
	          }
	        }
	        else {
	          sender.sendMessage("You do not have permission to do that.");
	        }
	        return true;
	      }
	      if (args[0].equalsIgnoreCase("disable")) {
	        if ((console) || (this.permissions.canDisable(player))) {
	          if (this.plugin.getConfigs().getBoolean("enabled", true)) {
	            this.plugin.getConfigs().set("enabled", Boolean.valueOf(false));
	            this.plugin.saveConfig();
	            this.plugin.getLogger().info("VIP disabled");
	            sender.sendMessage("VIP disabled");
	          } else {
	            sender.sendMessage("VIP is already disabled.");
	          }
	        }
	        else {
	          sender.sendMessage("You do not have permission to do that.");
	        }
	        return true;
	      }
	      if (args[0].equalsIgnoreCase("kick")) {
	        if ((console) || (this.permissions.canToggleKick(player))) {
	          this.plugin.getConfigs().set("Kick last logged", Boolean.valueOf(!this.plugin.getConfigs().getBoolean("Kick last logged", false)));
	          this.plugin.saveConfig();
	          sender.sendMessage("\"Kick last logged\" is now set to: " + this.plugin.getConfigs().getString("Kick last logged"));
	        }
	        else {
	          sender.sendMessage("You do not have permission to do that.");
	        }
	        return true;
	      }
	      if (args[0].equalsIgnoreCase("permissions")) {
	        if ((console) || (player.isOp())) {
	          this.plugin.getConfigs().set("Use permissions for VIP list", Boolean.valueOf(!this.plugin.getConfigs().getBoolean("Use permissions for VIP list", false)));
	          this.plugin.saveConfig();
	          sender.sendMessage("\"Use permissions for VIP list\" is now set to: " + this.plugin.getConfigs().getString("Use permissions for VIP list"));
	        }
	        else {
	          sender.sendMessage("You do not have permission to do that.");
	        }
	        return true;
	      }
	    }
	    if (!this.plugin.getConfigs().getBoolean("enabled", false)) {
	      sender.sendMessage("VIP is not enabled!");
	      return true;
	    }
	    if (args.length < 2) {
	      return false;
	    }
	    if ((!args[0].equalsIgnoreCase("add")) && (!args[0].equalsIgnoreCase("remove"))) {
	      return false;
	    }
	    String addRemove = args[1];
	    String action = args[0];
	    if (action.equalsIgnoreCase("add")) {
	      if ((!this.permissions.canAddPlayer(player)) && 
	        (!console)) {
	        sender.sendMessage("You do not have permission to do that.");
	        return true;
	      }

	      if (!this.plugin.getConfigs().getBoolean("Use permissions for VIP list", false))
	      {
	        int priority = 1;
	        if (args.length == 3) {
	          try {
	            priority = Integer.parseInt(args[2].trim());
	          }
	          catch (NumberFormatException e) {
	            return false;
	          }
	        }
	        if (priority < 1) {
	          sender.sendMessage("Priority must be positive");
	          return true;
	        }
	        this.plugin.getConfigs().set("VIPs." + addRemove, Integer.valueOf(priority));
	        this.plugin.saveConfig();
	        sender.sendMessage(addRemove + " is now a VIP with priority " + priority);
	      }
	      else {
	        sender.sendMessage("VIP is using permissions, give them their permission!");
	      }
	      return true;
	    }
	    if (action.equalsIgnoreCase("remove")) {
	      if ((!this.permissions.canRemovePlayer(player)) && 
	        (!console)) {
	        sender.sendMessage("You do not have permission to do that.");
	        return true;
	      }

	      if (!this.plugin.getConfigs().getBoolean("Use permissions for VIP list", false)) {
	        this.plugin.getConfigs().set("VIPs." + addRemove, null);
	        this.plugin.saveConfig();
	      } else {
	        sender.sendMessage("VIP is using permissions, give them their permission!");
	        return true;
	      }
	      sender.sendMessage(addRemove + " is no longer a VIP.");
	    }
	    return true;
  	}*/

	@Override
	public String getCommandName() {
		return "vip";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return "/" + getCommandName() + " <add|remove> <player>";
	}
	
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		EntityPlayerMP player = (EntityPlayerMP)icommandsender;
		String struct = astring[0];
		String playername = astring[1];
		
		if(struct.equals("add")) {
			
		} else if(struct.equals("remove")) {
			
		}
	}
}

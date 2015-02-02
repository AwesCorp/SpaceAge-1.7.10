//Credit to Superheroes Unlimited Mod
package spaceage.common;

import java.lang.reflect.Field;
import java.util.EnumSet;

import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.world.World;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class ServerTickHandler implements ITickHandler {
	private EnumSet<TickType> ticksToGet;
	private String messageToServerPlayersText = ": Hey, you should check out our store at TEMP LINK! You can buy priority access so you aren't kicked off the server.";
	
	public void PlayerTickHandler(EnumSet<TickType> ticksToGet) {
		this.ticksToGet = ticksToGet;
	}
  
	public static int timer = 2000;//EntityLiving entity;
	public static int messageToServerPlayers = 6000;//1200 = 1min

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
			    if (type.equals(EnumSet.of(TickType.PLAYER))) {
			      onPlayerTick((EntityPlayer)tickData[0], null);
		    }
	  }

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.PLAYER, TickType.SERVER);
	}

	@Override
	public String getLabel() {
		return null;
	}
	
	private void onPlayerTick(EntityPlayer player, World world) {
		starboostCrap(player);
		//binaryCrap(player);
		if(messageToServerPlayers != 0) {
			messageToServerPlayers--;
		} else if(messageToServerPlayers == 0) {
			broadcastMessage(messageToServerPlayersText);
			messageToServerPlayers = 6000;
		}
	}

	public void broadcastMessage(String message) {
		for(String name : MinecraftServer.getServer().getAllUsernames()) {
			getPlayer(name).addChatMessage(getPlayer(name) + message);
		}
	}

	public EntityPlayerMP getPlayer(String name) {
		if(name != null) {
			return MinecraftServer.getServer().getConfigurationManager().getPlayerForUsername(name);//getServerConfigurationManager().getPlayerForUsername(name);
		} else {
			return null;
		}
	}

	public void binaryCrap(EntityPlayer player) {
	    if ((player.getCurrentItemOrArmor(4) != null) && (player.getCurrentItemOrArmor(3) != null) && (player.getCurrentItemOrArmor(2) != null) && (player.getCurrentItemOrArmor(1) != null)) {
	    	player.addPotionEffect(new PotionEffect(Potion.damageBoost.getId(), 20, 0));
	    	//player.addPotionEffect(new PotionEffect(Potion.nightVision.getId(), 2, 2));
	    }
	}

	public void starboostCrap(EntityPlayer player) {
		if ((player.getCurrentItemOrArmor(4) != null)) {
			ItemStack helmet = player.getCurrentItemOrArmor(4);
			
			if(((helmet.getItem() == SpaceAgeCore.advancedSpacesuitHelmet ? 1 : 0) != 0) && (player.isAirBorne)) {
				timer--;
			}
		}
		
		if ((player.getCurrentItemOrArmor(4) != null) && (player.getCurrentItemOrArmor(3) != null)) {
			ItemStack helmet = player.getCurrentItemOrArmor(4);
			ItemStack chestplate = player.getCurrentItemOrArmor(3);
			
			if(((helmet.getItem() == SpaceAgeCore.advancedSpacesuitHelmet ? 1 : 0) | (chestplate.getItem() == SpaceAgeCore.advancedSpacesuitChestplate ? 1 : 0)) != 0) {
				if(!player.isAirBorne) {
					timer++;
				}
			}
		}
		
	    if (player.getCurrentItemOrArmor(3) != null) {
	      ItemStack plate = player.getCurrentItemOrArmor(3);

	      if ((plate.getItem() == SpaceAgeCore.advancedSpacesuitChestplate ? 1 : 0) != 0) {
	    	  //System.out.println("SPACEAGE: ABOUT TO RUN POTION WITH 0");
	        //player.addPotionEffect(new PotionEffect(Potion.damageBoost.getId(), 20, 0));
	        //System.out.println("SPACEAGE: SUCCESSFULLY RAN POTION WITH 0");
	        player.fallDistance = 0.0F;
	      }
	    }

	    if ((player.getCurrentItemOrArmor(4) != null) && (player.getCurrentItemOrArmor(3) != null))
	    {
	      ItemStack helmet = player.getCurrentItemOrArmor(4);
	      ItemStack plate = player.getCurrentItemOrArmor(3);

	      if (((plate.getItem() == SpaceAgeCore.advancedSpacesuitChestplate ? 1 : 0) | (helmet.getItem() == SpaceAgeCore.advancedSpacesuitHelmet ? 1 : 0)) != 0) {
	     	 // System.out.println("SPACEAGE: ABOUT TO RUN POTION WITH 0");
	        //player.addPotionEffect(new PotionEffect(Potion.waterBreathing.getId(), 20, 0));
	    	  player.setAir(250);
	    	  
	        //System.out.println("SPACEAGE: SUCCESSFULLY RAN POTION WITH 0");
	        player.fallDistance = 0.0F;
	      }

	    }
	    
	    if ((player.getCurrentItemOrArmor(4) != null) && (player.getCurrentItemOrArmor(3) != null)) {
	      ItemStack helmet = player.getCurrentItemOrArmor(4);
	      ItemStack plate = player.getCurrentItemOrArmor(3);

	      if (((plate.getItem() == SpaceAgeCore.fireResistanceChestplate ? 1 : 0) | (helmet.getItem() == SpaceAgeCore.fireResistanceHelmet ? 1 : 0)) != 0) {
	        //player.addPotionEffect(new PotionEffect(Potion.fireResistance.getId(), 20, 0));
	    	  
	    	  try {
	    		  Class entity = Class.forName("net.minecraft.entity.Entity");
	    		  
	    		  Field isImmuneToFire = entity.getField("isImmuneToFire");
	    		  
	    		  System.out.println("Type returns " + isImmuneToFire.getType());
	    	  } catch(Exception e) {
	    		  e.printStackTrace();
	    	  }
	    	  
	    	  player.fallDistance = 0.0F;
	      }

	    }
	    
	    if ((player.getCurrentItemOrArmor(4) != null) && (player.getCurrentItemOrArmor(3) != null) && (player.getCurrentItemOrArmor(2) != null) && (player.getCurrentItemOrArmor(1) != null))
	    {
	      ItemStack helmet = player.getCurrentItemOrArmor(4);
	      ItemStack plate = player.getCurrentItemOrArmor(3);
	      ItemStack legs = player.getCurrentItemOrArmor(2);
	      ItemStack boots = player.getCurrentItemOrArmor(1);

	      if (((boots.getItem() == SpaceAgeCore.advancedSpacesuitBoots ? 1 : 0) | (legs.getItem() == SpaceAgeCore.advancedSpacesuitLeggings ? 1 : 0) | (plate.getItem() == SpaceAgeCore.advancedSpacesuitChestplate ? 1 : 0) | (helmet.getItem() == SpaceAgeCore.advancedSpacesuitHelmet ? 1 : 0)) != 0) {
	        player.capabilities.allowFlying = true;
	        player.fallDistance = 0.0F;
	      }
	    }
	    else if (!player.capabilities.isCreativeMode) {
	      player.capabilities.allowFlying = false;
	    }
	}
}
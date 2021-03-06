package spaceage.client.gui;

import spaceage.common.SpaceAgeCore;
import spaceage.common.container.ContainerGasTank;
import spaceage.common.container.ContainerHeatGenerator;
import spaceage.common.container.ContainerLiquidTank;
import spaceage.common.container.ContainerSolarPanel;
import spaceage.common.tile.TileGasTank;
import spaceage.common.tile.TileHeatGenerator;
import spaceage.common.tile.TileLiquidTank;
import spaceage.common.tile.TileSolarPanel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

/**
 * The GUI handler of SpaceAge. 
 * @author SkylordJoel
 */

public class SPGUI implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity tile_entity = world.getTileEntity(x, y, z);
		
		switch(ID) {
			case 0: return new ContainerHeatGenerator(player.inventory, (TileHeatGenerator) tile_entity);
			case 1: return new ContainerSolarPanel(player.inventory, (TileSolarPanel) tile_entity);
			case 2: return new ContainerLiquidTank(player.inventory, (TileLiquidTank) tile_entity);
			case 3: return new ContainerGasTank(player.inventory, (TileGasTank) tile_entity);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity tile_entity = world.getTileEntity(x, y, z);
		
		switch(ID) {
			case 0: return new GUIHeatGenerator(player.inventory, (TileHeatGenerator) tile_entity);
			case 1: return new GUISolarPanel(player.inventory, (TileSolarPanel) tile_entity);
			case 2: return new GUILiquidTank(player.inventory, (TileLiquidTank) tile_entity);
			case 3: return new GUIGasTank(player.inventory, (TileGasTank) tile_entity);
		}
		return null;
	}
}

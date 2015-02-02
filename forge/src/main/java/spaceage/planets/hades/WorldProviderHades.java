package spaceage.planets.hades;

import spaceage.planets.SpaceAgePlanets;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.DimensionManager;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import cr0s.WarpDrive.utils.CloudRenderBlank;

public class WorldProviderHades extends WorldProvider {

	public void registerWorldChunkManager()
{
/** tells Minecraft to use our new WorldChunkManager **/
this.worldChunkMgr = new WorldChunkMangerHades(worldObj.getSeed(), terrainType);
this.hasNoSky = false;
}

@Override
/** Dimension Name **/
public String getDimensionName()
{
return "Hades";
}

/** Get Provider for dimension **/
public static WorldProvider getProviderForDimension(int id)
{
return DimensionManager.createProviderFor(SpaceAgePlanets.instance.hadesID);
}

/** Welcome message **/
public String getWelcomeMessage()
{
return "<Nav Computer> Entering the atmosphere of Hades";
}


/** What chunk provider to use **/
public IChunkProvider createChunkGenerator()
{
return new ChunkProviderHades(worldObj, worldObj.getSeed(), true);
}

	/** Can player re-spawn here **/
	public boolean canRespawnHere() {
		return true;
	}

/** Determines the dimension the player will be respawned in **/
	public int getRespawnDimension(EntityPlayerMP player) {
		return SpaceAgePlanets.instance.hadesID;
	}

	@Override
	public Vec3 getSkyColor(Entity cameraEntity, float partialTicks) {
		setCloudRenderer(new CloudRenderBlank());
		
		return this.worldObj.getWorldVec3Pool().getVecFromPool(0, 0, 0.5);
	}

	@Override
	public boolean isSkyColored() {
		return true;
	}
	
    @Override
    public boolean getWorldHasVoidParticles()
    {
        return false;
    }
}
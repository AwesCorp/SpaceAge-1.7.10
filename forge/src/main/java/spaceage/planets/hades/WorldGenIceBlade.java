package spaceage.planets.hades;

import java.util.Random;

import spaceage.common.SpaceAgeCore;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenIceBlade extends WorldGenerator {

	public WorldGenIceBlade(boolean par1) {
		super(par1);
	}

	@Override
	  public boolean generate(World var1, Random var2, int var3, int var4, int var5) {
	    while ((var1.isAirBlock(var3, var4, var5)) && (var4 > 2)) {
	      var4--;
	    }

	    int var6 = var1.getBlockId(var3, var4, var5);

	    for (int var7 = -2; var7 <= 2; var7++) {
	      for (int var8 = -2; var8 <= 2; var8++) {
	        if ((var1.isAirBlock(var3 + var7, var4 - 1, var5 + var8)) && (var1.isAirBlock(var3 + var7, var4 - 2, var5 + var8))) {
	        	return false;
	        }
	      }
	    }
	    var1.setBlock(var3, var4, var5, SpaceAgeCore.hadesSurface.blockID, 0, 2);
	    var1.setBlock(var3, var4 + 1, var5, Block.ice.blockID);
	    var1.setBlock(var3 + 1, var4 + 1, var5, Block.ice.blockID);
	    var1.setBlock(var3 + 1, var4 + 2, var5, Block.ice.blockID);
	    var1.setBlock(var3, var4 + 3, var5, Block.ice.blockID);
	    var1.setBlock(var3, var4 + 4, var5, Block.ice.blockID);
	    var1.setBlock(var3, var4 + 5, var5, Block.ice.blockID);
	    var1.setBlock(var3, var4 + 3, var5 + 1, Block.ice.blockID);
	    var1.setBlock(var3, var4 + 4, var5 + 1, Block.ice.blockID);

	    return true;
	  }

}

package spaceage.common.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockVulcan extends ItemBlock {

	public ItemBlockVulcan(Block id) {
		super(id);
		setHasSubtypes(true);
	}
	
	public String getUnlocalizedName(ItemStack itemStack) {
		String name = "";
		switch(itemStack.getItemDamage()) {
			case 0: {
				name = "ash";
				break;
			}
			case 1: {
				name = "quartzWood";
				break;
			}
			case 2: {
				name = "glowLeaves";
				break;
			}
			case 3: {
				name = "fireEssence";
				break;
			}
			default: 
				name = "broken";
			}
			return getUnlocalizedName() + "." + name;
		}
	
	public int getMetadata(int par1) {
		return par1;
		}

}

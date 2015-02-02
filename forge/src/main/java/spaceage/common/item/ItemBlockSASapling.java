package spaceage.common.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockSASapling extends ItemBlock {

	public ItemBlockSASapling(Block id) {
		super(id);
		this.setHasSubtypes(true);
	}
	
	public String getUnlocalizedName(ItemStack itemStack) {
		String name = "";
		switch(itemStack.getItemDamage()) {
			case 0: {
				name = "glowQuartz";
				break;
			}
			case 1: {
				name = "techOrganic";
				break;
			}
			case 2: {
				name = "edenTree";
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

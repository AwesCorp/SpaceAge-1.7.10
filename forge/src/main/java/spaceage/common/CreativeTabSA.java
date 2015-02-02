package spaceage.common;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabSA extends CreativeTabs {

	public CreativeTabSA(int id, String string) {
		super(id, string);
	}

	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		return Item.getItemFromBlock(SpaceAgeCore.spaceshipAlloyMeta);
	}
}

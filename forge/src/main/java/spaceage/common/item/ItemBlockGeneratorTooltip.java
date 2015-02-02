package spaceage.common.item;

import java.util.List;

import spaceage.common.block.BlockGenerator;
import spaceage.common.stuff.Utils;

import org.lwjgl.input.Keyboard;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class ItemBlockGeneratorTooltip extends ItemBlock {

	public ItemBlockGeneratorTooltip(Block id) {
		super(id);
		setHasSubtypes(true);
	}

	public String getUnlocalizedName(ItemStack itemStack) {
		String name = "";
		switch(itemStack.getItemDamage()) {
			case 0: {
				name = "heatGenerator";
				break;
			}
			case 1: {
				name = "solarGenerator";
				break;
			}
			default: 
				name = "broken";
			}
		//System.out.println("did unlocalizedName code");
		return getUnlocalizedName() + "." + name;
	}
	
	public int getMetadata(int par1) {
		return par1;
	}
	
    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List info, boolean par4) {
        // Only displays tooltip information when SHIFT key is pressed.
        String tooltip = StatCollector.translateToLocal(getUnlocalizedName(par1ItemStack) + ".tooltip");//"Type: Electrical Generator";
        String defaultTooltip = StatCollector.translateToLocal("Press shift for more information");
        boolean isShiftPressed = Keyboard.isKeyDown(Keyboard.KEY_LSHIFT);

        // Use LWJGL to detect what key is being pressed.
        if (tooltip != null && tooltip.length() > 0 && isShiftPressed) {
            info.addAll(Utils.splitStringPerWord(tooltip, 5));
        } else if (defaultTooltip != null && defaultTooltip.length() > 0 && !isShiftPressed) {
            info.addAll(Utils.splitStringPerWord(String.valueOf(defaultTooltip), 10));
        }
        //System.out.println("did addInfo code");
    }
}
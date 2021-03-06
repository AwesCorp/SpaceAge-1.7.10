package spaceage.common.block;

import java.util.List;
import java.util.Random;

import spaceage.common.SpaceAgeCore;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockSpaceshipAlloy extends Block {

	public BlockSpaceshipAlloy(Material material) {
		super(material);
		this.setCreativeTab(SpaceAgeCore.tabSA);
	}
	
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		icons = new IIcon[16];
		
		for(int i = 0; i < icons.length; i++) {
			icons[i] = par1IconRegister.registerIcon(SpaceAgeCore.modid + ":" + (this.getUnlocalizedName().substring(5)) + i);
		}
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2) {
		switch(par2) {
			case 0:
				return icons[0];
			case 1:
				return icons[1];
			case 2:
				return icons[2];
			case 3:
				return icons[3];
			case 4:
				return icons[4];
			case 5:
				return icons[5];
			case 6:
				return icons[6];
			case 7:
				return icons[7];
			case 8:
				return icons[8];
			case 9:
				return icons[9];
			case 10:
				return icons[10];
			case 11:
				return icons[11];
			case 12:
				return icons[12];
			case 13:
				return icons[13];
			case 14:
				return icons[14];
			case 15:
				return icons[15];
			default: {
				System.out.println("Invalid metadata for " + this.getUnlocalizedName());
				return icons[0];
			}
		}
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
		for(int i = 0; i < 16; i++) {
			par3List.add(new ItemStack(par1, 1, i));
		}
	}
	
	@Override
	public int damageDropped(int par1) {
		return par1;
	}
	
	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		return this.blockID;
	}
}
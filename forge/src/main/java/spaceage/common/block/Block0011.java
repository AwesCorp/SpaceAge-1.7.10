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

public class Block0011 extends Block {

	public Block0011(Material material) {
		super(material);
		
		setHardness(1.0F);
		setStepSound(Block.soundTypeMetal);
	}
	
	private Type type;
	
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		icons = new IIcon[5];
		
		for(int i = 0; i < icons.length; i++) {
			icons[i] = par1IconRegister.registerIcon(SpaceAgeCore.modid + ":techOrg/" + (this.getUnlocalizedName().substring(5)) + i);
		}
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int metadata) {
		switch(metadata) {
			case 0:
				return icons[0];
			case 1:
				return icons[1];
			case 2:
				switch(side) {
					case 0: 
						return icons[2];
					case 1:
						return icons[2];
					default: 
						return icons[3];
			}
			case 3:
				return icons[4];
			default:
				return icons[0];
		}
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
		for(int i = 0; i < Type.values().length; i++) {
			par3List.add(new ItemStack(par1, 1, i));
		}
	}
	
	public int damageDropped(int meta) {
		switch(Type.values().length) {
			default:
				return meta;
		}
	}
	
	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		switch(Type.values().length) {
			default:
				return this.blockID;
		}
	}
	
	@Override
	public int quantityDropped(Random random) {
		switch(Type.values().length) {
			default:
				return 1;
		}
	}

	public static enum Type {
		TECH_DIRT, SOLAR_LEAVES, HEAVY_ALLOY_WOOD, ORGANIC_BUILDING_BLOCK;
	}
}
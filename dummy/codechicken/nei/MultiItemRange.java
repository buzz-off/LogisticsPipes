package codechicken.nei;

import java.util.Collection;

import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class MultiItemRange {

	public MultiItemRange add(Collection<?> ranges)
	{return null;}
	
	public MultiItemRange add(MultiItemRange range)
	{return null;}
	
	public MultiItemRange add(int itemID)
	{return null;}
	
	public MultiItemRange add(int itemID, int damageStart, int damageEnd)
	{return null;}
	
	public MultiItemRange add(int itemIDFirst, int itemIDLast)
	{return null;}

	public MultiItemRange add(Item item, int damageStart, int damageEnd)
	{return null;}
	
	public MultiItemRange add(Block block, int damageStart, int damageEnd)
	{return null;}
	
	public MultiItemRange add(Item item)
	{return null;}
	
	public MultiItemRange add(Block block)
	{return null;}
	
	public MultiItemRange add(ItemStack item)
	{return null;}
}

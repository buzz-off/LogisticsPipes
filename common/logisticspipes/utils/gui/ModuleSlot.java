package logisticspipes.utils.gui;

import logisticspipes.LogisticsPipes;
import logisticspipes.logisticspipes.ItemModuleInformationManager;
import logisticspipes.pipes.PipeLogisticsChassi;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;

public class ModuleSlot extends RestrictedSlot {
	
	private PipeLogisticsChassi _pipe;
	private int _moduleIndex;
	
	public ModuleSlot(IInventory iinventory, int i, int j, int k, PipeLogisticsChassi pipe) {
		super(iinventory, i, j, k, LogisticsPipes.ModuleItem.shiftedIndex);
		_pipe = pipe;
		_moduleIndex = i;
	}
	
	@Override
	public void onPickupFromSlot(EntityPlayer pl, ItemStack itemStack) {
		ItemModuleInformationManager.saveInfotmation(itemStack, _pipe.getLogisticsModule().getSubModule(_moduleIndex), _pipe.worldObj);
        super.onPickupFromSlot(pl, itemStack);
    }

	@Override
	public boolean isItemValid(ItemStack par1ItemStack) {
		if(par1ItemStack.getItemDamage() == 0) return false;
		return super.isItemValid(par1ItemStack);
	}
	
}

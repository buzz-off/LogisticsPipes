package logisticspipes.proxy.side;

import logisticspipes.LogisticsPipes;
import logisticspipes.blocks.CraftingSignRenderer;
import logisticspipes.blocks.LogisticsSignTileEntity;
import logisticspipes.blocks.LogisticsSolderingTileEntity;
import logisticspipes.pipefxhandlers.Particles;
import logisticspipes.pipefxhandlers.PipeFXRenderHandler;
import logisticspipes.pipefxhandlers.providers.EntityBlueSparkleFXProvider;
import logisticspipes.pipefxhandlers.providers.EntityGoldSparkleFXProvider;
import logisticspipes.pipefxhandlers.providers.EntityGreenSparkleFXProvider;
import logisticspipes.pipefxhandlers.providers.EntityOrangeSparkleFXProvider;
import logisticspipes.pipefxhandlers.providers.EntityRedSparkleFXProvider;
import logisticspipes.pipefxhandlers.providers.EntityVioletSparkleFXProvider;
import logisticspipes.pipefxhandlers.providers.EntityWhiteSparkleFXProvider;
import logisticspipes.proxy.interfaces.IProxy;
import logisticspipes.textures.LogisticsPipesTextureStatic;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.World;
import net.minecraftforge.common.DimensionManager;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.TextureFXManager;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.registry.GameRegistry;


public class ClientProxy implements IProxy {
	
	@Override
	public String getSide() {
		return "Client";
	}

	@Override
	public World getWorld() {
		return FMLClientHandler.instance().getClient().theWorld;
	}

	@Override
	public void registerTileEntitis() {
		ClientRegistry.registerTileEntity(LogisticsSignTileEntity.class, "net.minecraft.src.buildcraft.logisticspipes.blocks.LogisticsTileEntiy", new CraftingSignRenderer());
		ClientRegistry.registerTileEntity(LogisticsSignTileEntity.class, "logisticspipes.blocks.LogisticsSignTileEntity", new CraftingSignRenderer());
		GameRegistry.registerTileEntity(LogisticsSolderingTileEntity.class, "logisticspipes.blocks.LogisticsSolderingTileEntity");
		GameRegistry.registerTileEntity(LogisticsPipes.powerTileEntity, "logisticspipes.blocks.powertile.LogisticsPowerJuntionTileEntity");
		GameRegistry.registerTileEntity(LogisticsPipes.logisticsTileGenericPipe, LogisticsPipes.logisticsTileGenericPipeMapping);
	}

	@Override
	public World getWorld(int _dimension) {
		if(FMLCommonHandler.instance().getEffectiveSide().equals(Side.CLIENT)) {
			return getWorld();
		} else {
			return DimensionManager.getWorld(_dimension);
		}
	}

	@Override
	public EntityPlayer getClientPlayer() {
		return FMLClientHandler.instance().getClient().thePlayer;
	}

	@Override
	public boolean isMainThreadRunning() {
		return FMLClientHandler.instance().getClient().running;
	}

	@Override
	public void addLogisticsPipesOverride(int index, String override1, String override2) {
		TextureFXManager.instance().addAnimation(new LogisticsPipesTextureStatic(index, override1, override2));
	}

	@Override
	public void registerParticles() {
		PipeFXRenderHandler.registerParticleHandler(Particles.WhiteParticle, new EntityWhiteSparkleFXProvider());
		PipeFXRenderHandler.registerParticleHandler(Particles.RedParticle, new EntityRedSparkleFXProvider());
		PipeFXRenderHandler.registerParticleHandler(Particles.BlueParticle, new EntityBlueSparkleFXProvider());
		PipeFXRenderHandler.registerParticleHandler(Particles.GreenParticle, new EntityGreenSparkleFXProvider());
		PipeFXRenderHandler.registerParticleHandler(Particles.GoldParticle, new EntityGoldSparkleFXProvider());
		PipeFXRenderHandler.registerParticleHandler(Particles.VioletParticle, new EntityVioletSparkleFXProvider());
		PipeFXRenderHandler.registerParticleHandler(Particles.OrangeParticle, new EntityOrangeSparkleFXProvider());
	}
}

package net.tomatosoupter.tutorialmod;

import net.tomatosoupter.tutorialmod.block.ModBlocks;
import net.tomatosoupter.tutorialmod.registry.ModItems;
import net.tomatosoupter.tutorialmod.mod_tab.ModCreativeTabRegistry;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(TutorialMod.MOD_ID)
public class TutorialMod {
    public static final String MOD_ID = "tutorial_mod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public TutorialMod(IEventBus modEventBus, ModContainer modContainer) {
        ModCreativeTabRegistry.register(modEventBus);
        modEventBus.addListener(this::commonSetup);

        NeoForge.EVENT_BUS.register(this);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {}

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {}

    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {}
    }
}

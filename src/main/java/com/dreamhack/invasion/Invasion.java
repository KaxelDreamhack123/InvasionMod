package com.dreamhack.invasion;

import com.dreamhack.invasion.blocks.UruOre;
import com.dreamhack.invasion.blocks.ModBlocks;
import com.dreamhack.invasion.setup.ClientProxy;
import com.dreamhack.invasion.setup.IProxy;
import com.dreamhack.invasion.setup.ServerProxy;
import com.dreamhack.invasion.world.gen.OreGen;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("invasion")
public class Invasion
{

    public static final String MOD_ID = "invasion";

    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();


    public Invasion() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    }

    private void setup(final FMLCommonSetupEvent event) {
        proxy.getClientWorld();

        DeferredWorkQueue.runLater(OreGen::generateOre);

    }


    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
            event.getRegistry().register(new UruOre());
        }

        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            event.getRegistry().register(new BlockItem(ModBlocks.URU_ORE, new Item.Properties())
                    .setRegistryName("uru_ore"));
        }
    }


}

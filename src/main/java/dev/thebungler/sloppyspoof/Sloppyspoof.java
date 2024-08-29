package dev.thebungler.sloppyspoof;

import com.mojang.logging.LogUtils;
//import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
//import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
//import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(Sloppyspoof.MODID)
public class Sloppyspoof {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "sloppyspoof";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public Sloppyspoof() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        //MinecraftForge.EVENT_BUS.register(new MixinModList());
        // Register the commonSetup method for modloading
        //modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
/*
    private void commonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code
        //LOGGER.info("SLOPPY: HELLO FROM COMMON SETUP");

        //LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);
    }
*/
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("SLOPPY: Why am I being run on a server, oh God, oh Jesus");
    }

    /*
    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // Some client setup code
            //LOGGER.info("SLOPPY: HELLO FROM CLIENT SETUP");
            //LOGGER.info("SLOPPY: MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
            //net.minecraftforge.fml.ModList
            //ModList ModList = new ModList();

            //List<IModInfo> mods = ModList.get().getMods();
            //LOGGER.info("modlist: " + mods);

        }
    }*/
}






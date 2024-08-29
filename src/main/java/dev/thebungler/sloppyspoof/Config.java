package dev.thebungler.sloppyspoof;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = Sloppyspoof.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec.ConfigValue<String> BANNED_MODS = BUILDER.comment("A list of mod IDs to not send in the client-server handshake, separated by commas").define("bannedMods", "sloppyspoof,xray");
    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static String bannedMods;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        bannedMods = BANNED_MODS.get();
    }
}

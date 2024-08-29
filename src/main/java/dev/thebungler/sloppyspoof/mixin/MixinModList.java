package dev.thebungler.sloppyspoof.mixin;

import net.minecraftforge.network.HandshakeMessages;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import dev.thebungler.sloppyspoof.Config;

@Mixin(HandshakeMessages.C2SModListReply.class)
public abstract class MixinModList {
    private List<String> banlist;
    private List<String> mods;
    private List<String> prunedmods;

    @Inject(
            method = "<init>",
            at = @At("RETURN")
    )
    public void constructorHead(
            CallbackInfo ci
    ) {
        System.out.println("SLOPPY: Started process");
        banlist = Arrays.asList(Config.bannedMods.split("\\s*,\\s*"));
        if (!banlist.isEmpty()) {
            prunedmods = new ArrayList<>(this.mods);
            this.mods.removeIf(banlist::contains);
            prunedmods.removeAll(this.mods);
            System.out.println("SLOPPY: Pruned mods from handshake:" + String.valueOf(prunedmods));
        }
        //System.out.println("SLOPPY: Final mod list: "+String.valueOf(this.mods));
    }
}
     


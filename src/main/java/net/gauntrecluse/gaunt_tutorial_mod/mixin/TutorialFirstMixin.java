package net.gauntrecluse.gaunt_tutorial_mod.mixin;

import net.gauntrecluse.gaunt_tutorial_mod.GauntTutorialMod;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * This is a Mixin which corresponds to the following tutorial page as of writing:
 * <a> <a href="https://wiki.fabricmc.net/tutorial:mixin_making_your_first_mixin">Tutorial: Making your first Mixin</a> </a>
 * <br>
 * Any potential comments here are meant to explain different parts of the Mixin for a reader of the tutorial. Not that there'd be a
 * particularly relevant dev purpose to document anyway for a tutorial mod.
 */
@Debug(export = true)
@Mixin(MinecraftServer.class)
public class TutorialFirstMixin {
	@Inject(at = @At("HEAD"), method = "loadWorld")
	private void addLoggerAtHead(CallbackInfo info) {
        GauntTutorialMod.LOGGER.info("MinecraftServer$loadWorld has started!");
	}
}
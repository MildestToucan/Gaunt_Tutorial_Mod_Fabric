package net.gauntrecluse.gaunt_tutorial_mod.mixin;

import net.gauntrecluse.gaunt_tutorial_mod.GauntTutorialMod;
import net.minecraft.network.QueryableServer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.ServerTask;
import net.minecraft.server.command.CommandOutput;
import net.minecraft.server.world.ChunkErrorHandler;
import net.minecraft.util.thread.ReentrantThreadExecutor;
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
public abstract class TutorialFirstMixin extends ReentrantThreadExecutor<ServerTask> implements QueryableServer, ChunkErrorHandler, CommandOutput, AutoCloseable {
    //This is a dummy constructor, implemented just to extend the target's parent class.
    //It'll be ignored by Mixin while merging.
    public TutorialFirstMixin(String string) {
        super(string);
    }

    @Inject(method = "loadWorld",
            at = @At(value = "HEAD")
    )
	private void addLoggerAtHead(CallbackInfo ci) {
        GauntTutorialMod.LOGGER.info("MinecraftServer$loadWorld has started!");
	}
}
package net.bmjo.brewery.client;

import dev.architectury.event.events.client.ClientTickEvent;
import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import net.bmjo.brewery.client.render.HopRopeKnotRenderer;
import net.bmjo.brewery.client.render.RopeCollisionEntityRenderer;
import net.bmjo.brewery.client.render.WaterBasinRenderer;
import net.bmjo.brewery.event.KeyInputHandler;
import net.bmjo.brewery.item.ItemPredicate;
import net.bmjo.brewery.networking.BreweryNetworking;
import net.bmjo.brewery.registry.EntityRegister;
import net.bmjo.brewery.registry.BlockEntityRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;

@Environment(EnvType.CLIENT)
public class BreweryClient {

    public static void onInitializeClient() {
        KeyInputHandler.register();
        BreweryNetworking.registerS2CPackets();
        ItemPredicate.register();
        registerRenderer();

        ClientTickEvent.CLIENT_LEVEL_PRE.register((clientLevel) -> BreweryNetworking.tick());
    }

    private static void registerRenderer() {
        BlockEntityRendererRegistry.register(BlockEntityRegistry.BREW_KETTLE_BLOCK_ENTITY.get(), WaterBasinRenderer::new);
        EntityRendererRegistry.register(EntityRegister.HOP_ROPE_KNOT, HopRopeKnotRenderer::new);
        EntityRendererRegistry.register(EntityRegister.ROPE_COLLISION, RopeCollisionEntityRenderer::new);
        BlockEntityRendererRegistry.register(BlockEntityRegistry.BREW_KETTLE_BLOCK_ENTITY.get(), WaterBasinRenderer::new);
    }

    public static LocalPlayer getPlayer() {
        return Minecraft.getInstance().player;
    }
}

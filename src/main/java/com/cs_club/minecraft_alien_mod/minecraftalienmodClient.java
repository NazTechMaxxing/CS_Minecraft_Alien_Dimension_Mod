package com.cs_club.minecraft_alien_mod;

import com.cs_club.minecraft_alien_mod.entity.ModEntities;
import com.cs_club.minecraft_alien_mod.entity.client.HeadcrabRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

// This class will not load on dedicated servers. Accessing client side code from here is safe.
@Mod(value = minecraftalienmod.MODID, dist = Dist.CLIENT)
// You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
@EventBusSubscriber(modid = minecraftalienmod.MODID, value = Dist.CLIENT)
public class minecraftalienmodClient {
    public minecraftalienmodClient(ModContainer container) {
        // Allows NeoForge to create a config screen for this mod's configs.
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        // Some client setup code
        minecraftalienmod.LOGGER.info("HELLO FROM CLIENT SETUP");
        minecraftalienmod.LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());

        // Register entity renderer
        EntityRenderers.register(ModEntities.HEADCRAB.get(), HeadcrabRenderer::new);
    }
}
package com.cs_club.minecraft_alien_mod.datagen;

import com.cs_club.minecraft_alien_mod.minecraftalienmod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = minecraftalienmod.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ModDataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator(); //
        PackOutput packOutput = generator.getPackOutput(); //
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        // Register your item model provider here
        generator.addProvider(
                event.includeClient(),
                new ModItemModelProvider(packOutput, event.getExistingFileHelper())
        );
    }
}
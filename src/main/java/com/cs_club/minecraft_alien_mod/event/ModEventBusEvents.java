package com.cs_club.minecraft_alien_mod.event;

import com.cs_club.minecraft_alien_mod.entity.ModEntities;
import com.cs_club.minecraft_alien_mod.entity.client.HeadcrabModel;
import com.cs_club.minecraft_alien_mod.entity.custom.HeadcrabEntity;
import com.cs_club.minecraft_alien_mod.minecraftalienmod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = minecraftalienmod.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(HeadcrabModel.LAYER_LOCATION, HeadcrabModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.HEADCRAB.get(), HeadcrabEntity.createAttributes().build());
    }
}
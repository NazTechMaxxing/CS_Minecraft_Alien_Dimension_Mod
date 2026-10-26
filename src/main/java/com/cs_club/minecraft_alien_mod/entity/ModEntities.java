package com.cs_club.minecraft_alien_mod.entity;

import com.cs_club.minecraft_alien_mod.entity.custom.HeadcrabEntity;
import com.cs_club.minecraft_alien_mod.minecraftalienmod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, minecraftalienmod.MODID);

    public static final Supplier<EntityType<HeadcrabEntity>> HEADCRAB =
            ENTITY_TYPES.register("headcrab", () -> EntityType.Builder.of(HeadcrabEntity::new, MobCategory.CREATURE)
                    .sized(0.75f, 0.35f).build("headcrab"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}

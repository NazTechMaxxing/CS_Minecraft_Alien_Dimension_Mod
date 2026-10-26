package com.cs_club.minecraft_alien_mod.item;

import com.cs_club.minecraft_alien_mod.entity.ModEntities;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import com.cs_club.minecraft_alien_mod.minecraftalienmod;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(minecraftalienmod.MODID);

public static final DeferredItem<Item> STRAWBERRY = ITEMS.register("strawberry",
        () -> new Item(new Item.Properties().food(ModFoodProperties.STRAWBERRY)));
public static final DeferredItem<Item> OLDFASHIONED = ITEMS.register("oldfashioned",
        () -> new Item(new Item.Properties().food(ModFoodProperties.OLDFASHIONED)));
public static final DeferredItem<Item> HEADCRAB_SPAWN_EGG = ITEMS.register("headcrab_spawn_egg",
        () -> new DeferredSpawnEggItem(ModEntities.HEADCRAB, 0x31afaf, 0xffac00,
                new Item.Properties()));


    public static void register(IEventBus eventbus) {
        ITEMS.register(eventbus);

    }
}


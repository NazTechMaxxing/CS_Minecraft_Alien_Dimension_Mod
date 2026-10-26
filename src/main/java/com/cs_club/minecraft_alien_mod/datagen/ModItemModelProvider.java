package com.cs_club.minecraft_alien_mod.datagen;

import com.cs_club.minecraft_alien_mod.item.ModItems;
import com.cs_club.minecraft_alien_mod.minecraftalienmod;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, minecraftalienmod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.STRAWBERRY.get());
        basicItem(ModItems.OLDFASHIONED.get());

        // Generates the spawn egg model referencing Minecraft's built-in template
        withExistingParent(ModItems.HEADCRAB_SPAWN_EGG.getId().getPath(), "item/template_spawn_egg");
    }
}
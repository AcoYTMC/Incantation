package net.acoyt.incantation.init;

import net.acoyt.incantation.Incantation;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

import java.util.function.Function;

public interface IncaItems {
    static Item create(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        return Items.register(RegistryKey.of(RegistryKeys.ITEM, Incantation.id(name)), factory, settings);
    }

    static void init() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(IncaItems::addCombatEntries);
    }

    private static void addCombatEntries(FabricItemGroupEntries entries) {
        //
    }
}

package net.lostforgotten.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.lostforgotten.LostForgotten;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    // Definiowanie nowego przedmiotu
    public static final Item RUBY = registerItem("ruby", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(LostForgotten.MOD_ID,"ruby")))));
    public static final Item CRYSTALLIZED_HONEY = registerItem("crystallized_honey", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(LostForgotten.MOD_ID,"crystallized_honey")))));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(LostForgotten.MOD_ID, name), item);
    }

    public static void registerModItems() {
        LostForgotten.LOGGER.info("Registering Mod Items for " + LostForgotten.MOD_ID);

        // Dodawanie przedmiotu do trybu Creatywnego
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(RUBY);
            entries.add(CRYSTALLIZED_HONEY);
        });
    }
}

package net.lostforgotten.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.lostforgotten.LostForgotten;
import net.lostforgotten.sound.ModSounds;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
    // Definiowanie nowego przedmiotu
    public static final Item RUBY = registerItem("ruby", Item::new);
    public static final Item CRYSTALLIZED_HONEY = registerItem("crystallized_honey", Item::new);

    public static final Item DOG_MUSIC_DISC = registerItem("dog_music_disc",
            setting -> new Item(setting.jukeboxPlayable(ModSounds.DOG_KEY).maxCount(1)));

    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(LostForgotten.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(LostForgotten.MOD_ID, name)))));
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

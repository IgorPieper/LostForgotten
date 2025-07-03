package net.lostforgotten.sound;

import net.lostforgotten.LostForgotten;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent DOG = registerSoundEvent("dog");
    public static final RegistryKey<JukeboxSong> DOG_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(LostForgotten.MOD_ID, "dog"));

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(LostForgotten.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        LostForgotten.LOGGER.info("Registering Mod Sounds for " + LostForgotten.MOD_ID);
    }
}

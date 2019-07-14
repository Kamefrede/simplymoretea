package com.kamefrede.simplymoretea.core;

import com.kamefrede.simplymoretea.SimplyMoreTea;
import com.kamefrede.simplymoretea.item.ItemCrumpet;
import knightminer.simplytea.item.TooltipItem;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(SimplyMoreTea.MODID)
@Mod.EventBusSubscriber(modid = SimplyMoreTea.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Registration {

    public static final Item crumpet = null;
    public static final Item apple_slices = null;
    public static final Item apple_brew_bag = null;

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();

        Item.Properties props = new Item.Properties().group(SimplyMoreTeaTab.getInstance()).maxStackSize(64);

        register(registry, new ItemCrumpet(), "crumpet");
        register(registry, new TooltipItem(props), "apple_slices");
        register(registry, new Item(props), "apple_brew_bag");



    }

    /*
    Copypasta'd from Simply Tea
    https://github.com/elucent/SimplyTea/blob/1.14/src/main/java/knightminer/simplytea/core/Registration.java
     */

    private static <V extends R, R extends IForgeRegistryEntry<R>> V register(IForgeRegistry<R> registry, V value, ResourceLocation location) {
        value.setRegistryName(location);
        registry.register(value);
        return value;
    }

    private static <V extends R, R extends IForgeRegistryEntry<R>> V register(IForgeRegistry<R> registry, V value, String name) {
        value.setRegistryName(new ResourceLocation(SimplyMoreTea.MODID, name));
        registry.register(value);
        return value;
    }

    private static BlockItem registerBlockItem(IForgeRegistry<Item> registry, BlockItem item) {
        return register(registry, item, item.getBlock().getRegistryName());
    }

    private static BlockItem registerBlockItem(IForgeRegistry<Item> registry, Block block) {
        Item.Properties props = new Item.Properties().group(SimplyMoreTeaTab.getInstance());
        return registerBlockItem(registry, new BlockItem(block, props));
    }


}

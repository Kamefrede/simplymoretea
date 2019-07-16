package com.kamefrede.simplymoretea.core;

import com.kamefrede.simplymoretea.SimplyMoreTea;
import com.kamefrede.simplymoretea.item.ItemCrumpet;
import knightminer.simplytea.item.TeaCupItem;
import knightminer.simplytea.item.TooltipItem;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.ObjectHolder;

import static knightminer.simplytea.core.Registration.cup;

@ObjectHolder(SimplyMoreTea.MODID)
@Mod.EventBusSubscriber(modid = SimplyMoreTea.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Registration {

    public static final Item crumpet = null;
    public static final Item ice_cubes = null;
    public static final Item apple_brew_bag = null;

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {
        //TODO add iced tea
        IForgeRegistry<Item> registry = event.getRegistry();

        Item.Properties props = new Item.Properties().group(SimplyMoreTeaTab.getInstance()).maxStackSize(64);

        register(registry, new ItemCrumpet(), "crumpet");
        register(registry, new TooltipItem(props), "ice_cubes");
        register(registry, new Item(props), "apple_brew_bag");
        register(registry, new TeaCupItem(makeTea(4, 0.3F, new EffectInstance(knightminer.simplytea.core.Registration.HackRegistryOrder.restful, 1200, 1)).containerItem(cup)), (String) "cup_tea_apple");
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

    public static net.minecraft.item.Item.Properties makeTea(int hunger, float saturation, EffectInstance effect) {
        net.minecraft.item.Item.Properties props = new net.minecraft.item.Item.Properties();
        props.maxStackSize(1);
        props.maxDamage(2);
        props.group(SimplyMoreTeaTab.getInstance());
        props.setNoRepair();
        Food.Builder food = (new Food.Builder()).hunger(hunger).saturation(saturation).fastToEat().setAlwaysEdible();
        if (effect != null) {
            food.effect(effect, 1.0F);
        }

        props.food(food.build());
        return props;
    }



}

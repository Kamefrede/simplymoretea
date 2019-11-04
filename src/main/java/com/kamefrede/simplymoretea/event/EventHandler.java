package com.kamefrede.simplymoretea.event;

import com.kamefrede.simplymoretea.SimplyMoreTea;
import com.kamefrede.simplymoretea.core.Registration;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, modid = SimplyMoreTea.MODID)
public class EventHandler {


    /* Just pretend that this works for now, won't actually work until #5828 gets merged to forge */
    /* Plus I don't want to do loot tables because I want more control over it */
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void iceCubesDrop(BlockEvent.HarvestDropsEvent event) {
        if (event.getState().getBlock() == Blocks.ICE && !event.isSilkTouching()) {
            int quantity = MathHelper.clamp(2 + event.getWorld().getRandom().nextInt(3) + event.getWorld().getRandom().nextInt(event.getFortuneLevel() + 1), 1, 5);
            event.getDrops().add(new ItemStack(Registration.ice_cubes, quantity));
        }
    }
}

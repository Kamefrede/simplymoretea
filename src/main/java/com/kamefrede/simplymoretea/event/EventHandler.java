package com.kamefrede.simplymoretea.event;

import com.kamefrede.simplymoretea.SimplyMoreTea;
import com.kamefrede.simplymoretea.core.Registration;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = SimplyMoreTea.MODID)
public class EventHandler {

    @SubscribeEvent
    public static void iceCubesDrop(BlockEvent.HarvestDropsEvent event) {
        if (event.getDrops() != null && event.getDrops().isEmpty() && event.getState().getBlock() == Blocks.ICE && !event.isSilkTouching()) {
            int quantity = MathHelper.clamp(2 + event.getWorld().getRandom().nextInt(3) + event.getWorld().getRandom().nextInt(event.getFortuneLevel() + 1), 2, 5);
            event.getDrops().add(new ItemStack(Registration.ice_cubes, quantity));
        }
    }
}

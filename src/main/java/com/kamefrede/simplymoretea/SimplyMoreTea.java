package com.kamefrede.simplymoretea;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(SimplyMoreTea.MODID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SimplyMoreTea {

    public static final String MODID = "simplymoretea";
    public static SimplyMoreTea INSTANCE;
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    @SubscribeEvent
    public void setup(final FMLCommonSetupEvent event){
    }


}

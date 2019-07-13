package com.kamefrede.simplymoretea.core;

import com.kamefrede.simplymoretea.SimplyMoreTea;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class SimplyMoreTeaTab extends ItemGroup {

    private static final SimplyMoreTeaTab INSTANCE = new SimplyMoreTeaTab();

    public SimplyMoreTeaTab() {
        super(SimplyMoreTea.MODID);
    }

    public static SimplyMoreTeaTab getInstance(){
        return INSTANCE;
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(Registration.crumpet);
    }
}

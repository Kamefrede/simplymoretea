package com.kamefrede.simplymoretea.item;

import com.kamefrede.simplymoretea.SimplyMoreTea;
import com.kamefrede.simplymoretea.core.SimplyMoreTeaTab;
import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class ItemCrumpet extends Item {
    public ItemCrumpet() {
        //TODO add the easter egg
        super(new Item.Properties().group(SimplyMoreTeaTab.getInstance()).food(new Food.Builder().saturation(3f).hunger(4).build() ));
    }
}

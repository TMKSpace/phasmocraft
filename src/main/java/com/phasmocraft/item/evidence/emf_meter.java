package com.phasmocraft.item.evidence;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class emf_meter extends Item {
    public emf_meter(Settings settings) {
        super(settings);
    }
    public float EMF = 0;
    public boolean EMF_On = false;

    public void setEMF(float emf){
        this.EMF = emf;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        playerEntity.playSound(SoundEvents.UI_TOAST_IN, 1.0F, 2.0F);
        if (!EMF_On) {setEMF(0.1f); playerEntity.sendMessage(Text.literal("EMF On")); EMF_On = true;} else {setEMF(0); playerEntity.sendMessage(Text.literal("EMF Off")); EMF_On = false;}
        //if(EMF>0.6f){EMF=0.0f;}
        //playerEntity.sendMessage(Text.literal("EMF: "+EMF));
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
}

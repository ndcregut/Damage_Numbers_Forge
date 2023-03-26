package net.barrymore.damagenumbers.event;

import net.barrymore.damagenumbers.particle.ModParticles;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingHealEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ThreadLocalRandom;

@Mod.EventBusSubscriber
public class ModEvents {

    @SubscribeEvent
    public static void LivingDamageEvent(@NotNull LivingDamageEvent event) {
        Entity entity = event.getSource().getEntity();
        if (entity == null) return;

        Level level = entity.getLevel();

        UseDamageColorSpawnParticle(event.getAmount(), event.getSource(), event.getSource().getEntity().getLevel());
    }

    @SubscribeEvent
    public static void LivingHealEvent(@NotNull LivingHealEvent event) {
        Entity entity = event.getEntity();
        if (entity == null) return;

        Level level = entity.getLevel();

        UseHealingColorSpawnParticle(event.getAmount(), event.getEntity(), event.getEntity().getLevel());
    }

    private static void UseDamageColorSpawnParticle(Float amount, DamageSource source, Level level) {
        if (source.getEntity() instanceof Player) {
            return;
        }

        spawnParticle("#9C2711", amount, level);
    }

    private static void UseHealingColorSpawnParticle(Float amount, LivingEntity livingEntity, Level level) {
        if (livingEntity instanceof Player) {
            return;
        }

        spawnParticle("#22B14C", amount, level);
    }

    private static void spawnParticle(String color, Float amount, Level level) {
        double pX = ThreadLocalRandom.current().nextDouble(5, 11);
        double pY = ThreadLocalRandom.current().nextDouble(5, 11);
        double pZ = ThreadLocalRandom.current().nextDouble(5, 11);
        double pXSpeed = ThreadLocalRandom.current().nextDouble(5, 11);
        double pYSpeed = ThreadLocalRandom.current().nextDouble(5, 11);
        double pZSpeed = ThreadLocalRandom.current().nextDouble(5, 11);

        level.addParticle(ModParticles.TEXT_PARTICLES.get(), pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed);
    }
}

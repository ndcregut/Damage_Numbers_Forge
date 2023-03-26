package net.barrymore.damagenumbers.event;

import net.barrymore.damagenumbers.DamageNumbers;
import net.barrymore.damagenumbers.particle.ModParticles;
import net.barrymore.damagenumbers.particle.custom.TextParticles;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DamageNumbers.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerParticleFactories(final RegisterParticleProvidersEvent event) {
        event.register(ModParticles.TEXT_PARTICLES.get(), TextParticles.Provider::new);
    }
}

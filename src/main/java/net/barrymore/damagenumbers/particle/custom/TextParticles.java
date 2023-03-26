package net.barrymore.damagenumbers.particle.custom;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

public class TextParticles extends TextureSheetParticle {

    protected TextParticles(ClientLevel level, double xCoord, double yCoord, double zCoord,
                            double xd, double yd, double zd) {
        super(level, xCoord, yCoord, zCoord, xd, yd, zd);

        this.friction = 0.85f;
        this.xd = xd;
        this.yd = yd;
        this.zd = zd;
        this.quadSize *= 0.85f;
        this.lifetime = 20;

        this.rCol = 1f;
        this.gCol = 1f;
        this.bCol = 1f;
    }

    @Override
    public void tick() {
        super.tick();
        fadeOut();
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider(SpriteSet spriteset) {
            this.sprites = spriteset;
        }

        @Nullable
        @Override
        public Particle createParticle(SimpleParticleType pType, ClientLevel pLevel, double pX, double pY, double pZ,
                                       double pXSpeed, double pYSpeed, double pZSpeed) {
            TextParticles textParticles = new TextParticles(pLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed);
            textParticles.setSpriteFromAge(sprites);

            return textParticles;
        }
    }

    public void fadeOut() {
        this.alpha = (-(1/(float)lifetime) * age + 1);
    }
}

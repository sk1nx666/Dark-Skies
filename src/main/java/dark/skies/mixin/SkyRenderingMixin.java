package dark.skies.mixin;

import net.minecraft.client.render.Camera;
import net.minecraft.client.render.SkyRendering;
import net.minecraft.client.render.state.SkyRenderState;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SkyRendering.class)
public class SkyRenderingMixin {
	private static final int BLACK_SKY = 0xFF000000;

	@Inject(
			method = "updateRenderState(Lnet/minecraft/client/world/ClientWorld;FLnet/minecraft/client/render/Camera;Lnet/minecraft/client/render/state/SkyRenderState;)V",
			at = @At("TAIL")
	)
	private void darkSkies$uniformDarkSky(
			ClientWorld world,
			float tickProgress,
			Camera camera,
			SkyRenderState state,
			CallbackInfo ci
	) {
		state.skyColor = BLACK_SKY;
		state.sunriseAndSunsetColor = 0;
	}
}

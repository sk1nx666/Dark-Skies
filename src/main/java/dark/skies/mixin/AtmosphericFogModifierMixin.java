package dark.skies.mixin;

import net.minecraft.block.enums.CameraSubmersionType;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.fog.AtmosphericFogModifier;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Terrain and distant chunks blend toward the atmospheric fog color from this modifier (sky-tinted),
 * not only the final {@link net.minecraft.client.render.fog.FogRenderer#applyFog} vector.
 */
@Mixin(AtmosphericFogModifier.class)
public class AtmosphericFogModifierMixin {
	private static final int BLACK_ARGB = 0xFF000000;

	@Inject(
			method = "getFogColor(Lnet/minecraft/client/world/ClientWorld;Lnet/minecraft/client/render/Camera;IF)I",
			at = @At("RETURN"),
			cancellable = true
	)
	private void darkSkies$blackAtmosphericTint(
			ClientWorld world,
			Camera camera,
			int viewDistance,
			float skyDarkness,
			CallbackInfoReturnable<Integer> cir
	) {
		CameraSubmersionType submersion = camera.getSubmersionType();
		if (submersion == CameraSubmersionType.WATER
				|| submersion == CameraSubmersionType.LAVA
				|| submersion == CameraSubmersionType.POWDER_SNOW) {
			return;
		}
		cir.setReturnValue(BLACK_ARGB);
	}
}

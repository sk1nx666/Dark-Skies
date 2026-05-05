package dark.skies.mixin;

import net.minecraft.block.enums.CameraSubmersionType;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.render.fog.FogRenderer;
import net.minecraft.client.world.ClientWorld;
import org.joml.Vector4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FogRenderer.class)
public class FogRendererMixin {
	@Inject(
			method = "applyFog(Lnet/minecraft/client/render/Camera;ILnet/minecraft/client/render/RenderTickCounter;FLnet/minecraft/client/world/ClientWorld;)Lorg/joml/Vector4f;",
			at = @At("RETURN")
	)
	private void darkSkies$matchingBlackFog(
			Camera camera,
			int viewDistance,
			RenderTickCounter tickCounter,
			float f,
			ClientWorld world,
			CallbackInfoReturnable<Vector4f> cir
	) {
		CameraSubmersionType submersion = camera.getSubmersionType();
		if (submersion == CameraSubmersionType.WATER
				|| submersion == CameraSubmersionType.LAVA
				|| submersion == CameraSubmersionType.POWDER_SNOW) {
			return;
		}
		Vector4f color = cir.getReturnValue();
		if (color != null) {
			// Must not call setReturnValue without cancellable = true; mutating the return vector is enough.
			color.set(0.0F, 0.0F, 0.0F, color.w());
		}
	}
}

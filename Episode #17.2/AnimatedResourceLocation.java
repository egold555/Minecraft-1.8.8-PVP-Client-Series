package clientname.render;

import net.minecraft.util.ResourceLocation;

public class AnimatedResourceLocation {

	private final String folder;
	protected final int frames;
	protected final int fpt;

	protected int currentTick = 0;
	protected int currentFrame = 0;

	protected ResourceLocation[] textures;

	public AnimatedResourceLocation(String folder, int frames, int fpt) {
		this(folder, frames, fpt, false);
	}
	
	public AnimatedResourceLocation(String folder, int frames, int fpt, boolean reverse) {
		this.folder = folder;
		this.frames = frames;
		this.fpt = fpt;
		textures = new ResourceLocation[frames];

		for(int i = 0; i < frames; i++) {
			if(reverse) {
				textures[i] = new ResourceLocation(folder + "/" + (textures.length - i) + ".png");
			}
			else {
				textures[i] = new ResourceLocation(folder + "/" + i + ".png");
			}
		}

	}

	public ResourceLocation getTexture() {
		return textures[currentFrame];
	}
	
	public int getCurrentFrame() {
		return currentFrame;
	}

	public void update() {
		if(currentTick > fpt) {
			currentTick = 0;
			currentFrame++;
			if(currentFrame > frames - 1) {
				currentFrame = 0;
			}
		}
		currentTick++;
	}
	
	public void setCurrentFrame(int currentFrame) {
		this.currentFrame = currentFrame;
	}
	
	public int getFrames() {
		return frames;
	}

}

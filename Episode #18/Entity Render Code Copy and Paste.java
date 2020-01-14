//Copied from EntityRenderer
if(mc.inGameHasFocus && Display.isActive()) {
			
	if(!perspectiveToggled) {
		return true;
	}
	
	mc.mouseHelper.mouseXYChange();
	float f1 = mc.gameSettings.mouseSensitivity * 0.6F + 0.2F;
	float f2 = f1 * f1 * f1 * 8.0F;
	float f3 = (float) mc.mouseHelper.deltaX * f2;
	float f4 = (float) mc.mouseHelper.deltaY * f2;
	
	cameraYaw += f3 * 0.15F;
	cameraPitch += f4 * 0.15F;
	
	if (cameraPitch > 90) cameraPitch = 90;
	if (cameraPitch < -90) cameraPitch = -90;
			
			
}
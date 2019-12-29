package clientname.gui;

import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import org.lwjgl.opengl.GL11;

import clientname.http2.HWID;
import clientname.render.AnimatedResourceLocation;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiUtilRenderComponents;
import net.minecraft.event.ClickEvent;
import net.minecraft.event.HoverEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.ResourceLocation;

public class GuiHWIDBanned extends GuiScreen {

	private AnimatedResourceLocation gif;

	static Clip clip; //must be static for resizing the window issue of double music

	private IChatComponent[] message;
	private int messageLengthTimesFontHeight;
	
	public GuiHWIDBanned(String reason)
	{
		gif = new AnimatedResourceLocation("clientname/ban", 44, 1);
		
		message = new IChatComponent[] {
				new ChatComponentText(EnumChatFormatting.GOLD + "" + EnumChatFormatting.BOLD + "You have been HWID banned from ExampleClient!"),
				new ChatComponentText(""),
				new ChatComponentText("You have been banned for: "),
				new ChatComponentText(""),
				new ChatComponentText(EnumChatFormatting.AQUA + reason),
				new ChatComponentText(""),
				new ChatComponentText("You can appeal your ban at " + EnumChatFormatting.YELLOW + "http://exampleclient.tk/").setChatStyle(
						new ChatStyle()
						.setChatClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "http://exampleclient.tk/"))
						.setChatHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ChatComponentText("Click to open link").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GREEN))))),
				new ChatComponentText(""),
				new ChatComponentText("Your HWID is: " + EnumChatFormatting.RED + HWID.get()).setChatStyle(
						new ChatStyle()
						.setChatHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ChatComponentText("Click to copy your HWID").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GREEN))))
						.setChatClickEvent(new ClickEvent(ClickEvent.Action.COPY_CLIPBOARD, HWID.get()))
						),
				new ChatComponentText(""),
		};
		
	}


	@Override
	public void initGui()
	{
		super.initGui();
		this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height - 30, "Guess i'll just go outside"));
		gif = new AnimatedResourceLocation("clientname/ban", 44, 1);
		
		if(clip == null) {
			try {
				InputStream in = mc.mcDefaultResourcePack.getInputStream(new ResourceLocation("clientname/ban/music.wav"));
				clip = AudioSystem.getClip();
		        clip.open(AudioSystem.getAudioInputStream(in));
		        clip.start();
			    
			}
			catch(Exception e) {
				
			}
		}
		this.messageLengthTimesFontHeight = this.message.length * this.fontRendererObj.FONT_HEIGHT;
		
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks)
	{
		this.drawGradientRect(0, 0, this.width, this.height, -12574688, -11530224);
		
		gif.update();
		mc.getTextureManager().bindTexture(gif.getTexture());
		
		GL11.glPushMatrix();
		//GL11.glScaled(0.2,  0.2, 0.2);
		GL11.glTranslated(this.width / 2 - 494 / 5, this.height / 2 - 60, 0);
		GL11.glScaled(0.4, 0.4, 0);
		drawModalRectWithCustomSizedTexture(0, 0, 0, 0, 498, 494, 498, 494);
		GL11.glPopMatrix();

		int i = 50 - this.messageLengthTimesFontHeight / 2;


		for (IChatComponent s : this.message)
		{
			this.drawCenteredString(this.fontRendererObj, s.getFormattedText(), this.width / 2, i, 16777215);
			i += this.fontRendererObj.FONT_HEIGHT;


		}

		handleComponentHover(findChatComponent(mouseX, mouseY), mouseX, mouseY);
		
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	private IChatComponent findChatComponentLine(int mouseY)
	{
		int i = 50 - this.messageLengthTimesFontHeight / 2;

		for (IChatComponent s : this.message)
		{
			int yTop = i;
			int yBottom = i + this.fontRendererObj.FONT_HEIGHT;
			if (mouseY >= yTop && mouseY < yBottom) {
				return s;
			}
			i += this.fontRendererObj.FONT_HEIGHT;
		}

		return null;
	}

	private IChatComponent findChatComponent(int mouseX, int mouseY) {

		IChatComponent s = findChatComponentLine(mouseY);

		if (s == null || !(s instanceof ChatComponentText)) {
			return null;
		}

		int stringWidth = this.mc.fontRendererObj.getStringWidth(GuiUtilRenderComponents.func_178909_a(((ChatComponentText)s).getChatComponentText_TextValue(), false));
		int xLeft = this.width / 2 - stringWidth / 2;
		int xRight = this.width / 2 + stringWidth / 2;
		if (mouseX >= xLeft && mouseX < xRight) {
			return s;
		}

		return null;
	}

	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		if (mouseButton == 0)
		{
			IChatComponent ichatcomponent = findChatComponent(mouseX, mouseY);

			if (this.handleComponentClick(ichatcomponent))
			{
				return;
			}
		}
		super.mouseClicked(mouseX, mouseY, mouseButton);
	}


	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException
	{
		super.keyTyped(typedChar, keyCode);
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException
	{
		mc.shutdown();
	}
	
	@Override
	public void onGuiClosed() {
		try {
			clip.close();
		}
		catch(Exception e) {
			
		}
		super.onGuiClosed();
	}

}

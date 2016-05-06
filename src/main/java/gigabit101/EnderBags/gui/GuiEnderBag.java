package gigabit101.EnderBags.gui;

import gigabit101.EnderBags.container.ContainerEnderBag;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Gigabit101 on 06/05/2016.
 */
public class GuiEnderBag extends GuiContainer
{
    private static final ResourceLocation texture = new ResourceLocation("enderbags", "textures/gui/bag.png");
    public EntityPlayer player;

    public GuiEnderBag(EntityPlayer player)
    {
        super(new ContainerEnderBag(player));
        this.player = player;
        this.xSize = 256;
        this.ySize = 231;
    }

    @Override
    public void initGui()
    {
        super.initGui();
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
    }

    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_)
    {
//        String name = I18n.translateToLocal("magnitism.whitelist");
//        this.fontRendererObj.drawString(name, this.xSize / 2 - 10 - this.fontRendererObj.getStringWidth(name) / 2, 4, 4210752);
//        this.fontRendererObj.drawString(I18n.translateToLocalFormatted("container.inventory", new Object[0]), 8, this.ySize - 115 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_)
    {
        this.mc.getTextureManager().bindTexture(texture);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
    }
}

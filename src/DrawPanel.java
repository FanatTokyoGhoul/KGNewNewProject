import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DrawPanel extends JPanel {
    @Override
    public void paint(Graphics gr) {
        BufferedImage bufferedImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bufferedImage.createGraphics();
        graphics.setColor(new Color(255, 255, 255));
        graphics.fillRect(0, 0, getWidth(), getHeight());
        graphics.dispose();
        PixelDrawer pd = new BufferedImagePixelDrawer(bufferedImage);
        LineDrawer ld = new DDALineDrawer(pd);
        Line xAxis = new Line(-1,0,1,0);
        Line yAxis = new Line(0,-1,0,1);
        ScreenConvector sc = new ScreenConvector(-2,2,4,4,800,600);
        ld.drawLine(sc.r2s(xAxis.getP1()),sc.r2s(xAxis.getP2()));
        ld.drawLine(sc.r2s(yAxis.getP1()),sc.r2s(yAxis.getP2()));
        gr.drawImage(bufferedImage, 0, 0, null);

    }
}

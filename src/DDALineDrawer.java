

import java.awt.*;

public class DDALineDrawer implements LineDrawer {

    private PixelDrawer pd;

    public DDALineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    @Override
    public void drawLine(ScreenPoint p1, ScreenPoint p2) {
        int x1 = p1.getX(), x2 = p2.getX();
        int y1 = p1.getY(), y2 = p2.getY();
        double dx = x2 - x1;
        double dy = y2 - y1;
        double k;
        if (Math.abs(dx) > Math.abs(dy)) {
            k = dy / dx;

            if (x1 > x2) {
                int tmp = x1;
                x1 = x2;
                x2 = tmp;
                tmp = y1;
                y1 = y2;
                y2 = tmp;
            }

            for (int j = x1; j <= x2; j++) {
                double i = k * (j - x1) + y1;
                pd.drawPixel(j, (int)i , Color.red);
            }
        } else {
            k = dx / dy;

            if (y1 > y2) {
                int tmp = x1;
                x1 = x2;
                x2 = tmp;
                tmp = y1;
                y1 = y2;
                y2 = tmp;
            }

            for (int j = y1; j <= y2; j++) {
                double i = k * (j - y1) + x1;
                pd.drawPixel((int)i, j , Color.BLUE);
            }
        }
    }
}

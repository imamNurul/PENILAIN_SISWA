/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MI_MAK.widget;

/**
 *
 * @author Bonjolz
 */
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelImageBackground_dark extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Image gambar = new ImageIcon(getClass().getResource("/MI_MAK/image/unduhan.jpg")).getImage();
        GradientPaint paint = new GradientPaint(0, 0, Color.GRAY, 0, getHeight(), Color.BLACK);

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setPaint(paint);
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.setComposite(AlphaComposite.SrcOver.derive(0.25F));
        g2.drawImage(gambar, 10, 10, null);
    }
}

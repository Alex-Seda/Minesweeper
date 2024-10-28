import javax.swing.*;
import java.awt.*;

public class MessagePanel extends JPanel{
    public MessagePanel() {
        addMouseListener(new MouseHandler());
    }
    public void paintComponent(Graphics g){
        g.drawLine(100, 200, 100, 500);
        g.drawLine(300, 200, 300, 500);
        g.drawLine(150, 550, 250, 550);
        g.drawArc(100, 450, 100, 100, 180, 90);
        g.drawArc(200, 450, 100, 100, 0, -90);
        g.drawArc(100, 150, 100, 100, 180, -90);
        g.drawArc(200, 150, 100, 100, 0, 90);
        g.drawLine(150, 150, 175, 150);
        g.drawLine(250, 150, 225, 150);
        g.drawLine(175,150,175,112);
        g.drawLine(225,150,225,112);
        g.drawOval(175, 100, 50, 25);
        g.drawString("I am trapped in a bottle!", 125, 350);
    }
}
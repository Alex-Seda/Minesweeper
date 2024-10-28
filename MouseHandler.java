import java.awt.event.*;

public class MouseHandler extends MouseAdapter{
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        System.out.println("Pressed at " + x + "," + y);
    }
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        System.out.println("Clicked at " + x + "," + y);
    }
}
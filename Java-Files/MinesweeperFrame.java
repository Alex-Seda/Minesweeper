import javax.swing.*;

public class MinesweeperFrame extends JFrame{
    MinesweeperPanel panel;
    public MinesweeperFrame() {
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new MinesweeperPanel();
        setTitle("Minesweeper");
        add(panel);
        setVisible(true);
    }
}
/*
class gameOverFrame extends JFrame{
    public gameOverFrame(String s){
        setSize(250,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameOverPanel panel2 = new gameOverPanel();
        setTitle(s);
        add(panel2);
        setVisible(true);
    }
}
*/
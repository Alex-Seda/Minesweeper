import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MinesweeperPanel extends JPanel{
    public Game game1 = new Game();
    int size = game1.getSize();
    boxButton arr[][] = new boxButton[size][size];
    

    public MinesweeperPanel(){
        new MinesweeperModel();
        GridLayout layout = new GridLayout(size,size);
        setLayout(layout);
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                boxButton button = new boxButton(game1.getGrid(i,j));
                add(button);
                arr[i][j]=button;
            }
        }
    }

    class boxButton extends JButton{
        String display;
        Box box;
        int x;
        int y;

        boxButton(Box b){
            box = b;
            display=b.getDisplay();
            x=b.getX();
            y=b.getY();
            setText(display);
            setBackground(Color.WHITE);
            setOpaque(true);
            MinesweeperMouseHandler m = new MinesweeperMouseHandler();
            addMouseListener(m);
        }

        class MinesweeperMouseHandler extends MouseAdapter{
            public void mousePressed(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON3) {
                    if(box.getDisplay()=="F"){
                        box.changeDisplay(0);
                        display=box.getDisplay();
                        setText(display);
                        setBackground(Color.WHITE);
                        setOpaque(true);
                        repaint();
                    }
                    else if(box.getDisplay()==""){
                        box.changeDisplay(1);
                        display=box.getDisplay();
                        setText(display);
                        setBackground(Color.GREEN);
                        setOpaque(true);
                        repaint();
                    }
                    else{
                        clearAround(x,y);
                        setBackground(Color.BLUE);
                        repaint();
                    }
                }
                else{
                    if(box.getDisplay()=="F"){}
                    else{
                        box.changeDisplay(2);
                        display=box.getDisplay();
                        setText(display);
                        if(display=="B"){
                            game1.gameOver();
                            for(int i=0; i<size; i++){
                                for(int j=0; j<size; j++){
                                    arr[i][j].box.changeDisplay(2);
                                    arr[i][j].display=arr[i][j].box.getDisplay();
                                    arr[i][j].setText(arr[i][j].display);
                                    if(arr[i][j].display=="B"){
                                        arr[i][j].setBackground(Color.RED);
                                        arr[i][j].setOpaque(true);
                                    }
                                    else{
                                        arr[i][j].setBackground(Color.WHITE);
                                        arr[i][j].setOpaque(true);
                                    }
                                    repaint();
                                }
                            }
                        }
                        if(box.getValue()==0){
                            clearAround(x,y);
                        }
                    }
                }
            }
            
            public void clearAround(int a, int b){
                for(int i=-1; i<=1; i++){
                    for(int j=-1; j<=1; j++){
                        if((a+i>=0)&&(a+i<size)&&(b+j>=0)&&(b+j<size)){
                            if(arr[a+i][b+j].display!="F"){
                                arr[a+i][b+j].box.changeDisplay(2);
                                arr[a+i][b+j].display=arr[a+i][b+j].box.getDisplay();
                                arr[a+i][b+j].setText(arr[a+i][b+j].display);
                            }
                            if(arr[a+i][b+j].box.getValue()==0){
                                int temp1=a+i;
                                int temp2=b+j;
                                clearAround(temp1,temp2);
                            }
                            if(arr[a+i][b+j].display=="B"){
                                game1.gameOver();
                                for(int n=0; n<size; n++){
                                    for(int m=0; m<size; m++){
                                        arr[n][m].box.changeDisplay(2);
                                        arr[n][m].display=arr[n][m].box.getDisplay();
                                        arr[n][m].setText(arr[n][m].display);
                                        if(arr[n][m].display=="B"){
                                            arr[n][m].setBackground(Color.RED);
                                            arr[n][m].setOpaque(true);
                                        }
                                        else{
                                            arr[n][m].setBackground(Color.WHITE);
                                            arr[n][m].setOpaque(true);
                                        }
                                        repaint();
                                    }
                                }
                            }
                        }
                    }
                }
            }
            
        }
    }

}
/*
class gameOverPanel extends JPanel{
    public gameOverPanel(){
        setLayout(new )
    }
}
*/



/*
 * TO DO:
 * 
 * IF 0 IS SELECTED, OPEN ALL ZEROES CONNECTED TO IT
 * 
 */
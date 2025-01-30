public class MinesweeperModel {
    /*
    Game game1;
    MinesweeperModel(){
        game1 = new Game();
        game1.printGrid();
    }
    public Game game(){
        return game1;
    }
    */
}

class Box{
    private int value;
    private int status; //hidden = 0, flagged = 1, shown = 2
    private boolean isMine;
    private int x;
    private int y;
    private String display;

    Box(){}

    Box(int xValue, int yValue, boolean isAMine){
        x=xValue;
        y=yValue;
        isMine=isAMine;
        status=0;
        changeDisplay(0);
    }

    public int getValue(){
        return value;
    }

    public void setValue(int i){
        value=i;
    }

    public int getStatus(){
        return status;
    }

    public boolean getIsMine(){
        return isMine;
    }

    public void setIsMine(boolean b){
        isMine=b;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public String getDisplay(){
        return display;
    }

    public void changeDisplay(int i){
        status=i;
        if(status==0){
            display="";
        }
        else if(status==1){
            display="F";
        }
        else if(status==2){
            display=Integer.toString(value);
            if(this.isMine){
                display="B";
            }
        }
        else{}
    }
}

class Game{
    private int size=10;
    private int numberOfMines=12;
    private Box grid[][] = new Box[size][size];

    Game(){
        //difficulty(2);
        for(int i=0; i<size; i++){
            for(int j=0; j<10; j++){
                grid[i][j] = new Box(i,j,false);
            }
        }

        generateMines();

        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                Bombs(grid[i][j]);
            }
        }
    }

    private void Bombs(Box b){
        int x=b.getX();
        int y=b.getY();
        int numberOfBombs=0;
        for(int i=-1; i<=1; i++){
            for(int j=-1; j<=1; j++){
                if((x+i>=0)&&(x+i<size)&&(y+j>=0)&&(y+j<size)){
                    if(grid[x+i][y+j].getIsMine()){
                        numberOfBombs++;
                    }
                }
            }
        }
        b.setValue(numberOfBombs);
        if(b.getIsMine()){
            b.setValue(9);
        }
    }

    public void printGrid(){
        System.out.println();
        System.out.println();
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                System.out.print(grid[i][j].getValue()+"  ");
            }
            System.out.println();
        }
    }
/* 
    private void difficulty(int input){
        if(input==1){
            size=6;
            numberOfMines=8;
        }
        else if(input==2){
            size=10;
            numberOfMines=12;
        }
        else{
            size=16;
            numberOfMines=40;
        }
    }
*/

    private void generateMines(){
        for(int i=0; i<numberOfMines; i++){
            grid[(int)(Math.random()*10)][(int)(Math.random()*10)].setIsMine(true);
        }
    }

    public int getSize(){
        return size;
    }

    public Box getGrid(int x, int y){
        return grid[x][y];
    }

    public void gameOver(){
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                grid[i][j].changeDisplay(2);
            }
        }
    }

    public int minesLeft(){
        int counter=0;
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(grid[i][j].getIsMine()&&grid[i][j].getDisplay()==""){
                    counter++;
                }
            }
        }
        return counter;
    }
}
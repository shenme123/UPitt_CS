//Wentao Jiang, wej10@pitt.edu, 9394

import java.math.*;
import java.util.*;

public class Board {
    int[][] blocks;
    
    public Board(int[][] blocks){
        int dim = blocks.length;
        this.blocks = new int[dim][dim];
        for (int row = 0; row<dim ; row++){
            for (int col = 0; col<dim; col++){
                this.blocks[row][col] = blocks[row][col];
            }
        }
    }
    public int dimension(){
        return blocks.length;
    }
    public int hamming(){
        int ham = 0;
        int dim = dimension();
        for (int row=0; row<dim; row++){
            for (int col=0; col<dim; col++) {
                if (blocks[row][col]!=0){
                    int rowtr = (blocks[row][col]-1) /dim;
                    int coltr = (blocks[row][col]-1) %dim;
                    ham += Math.max(Math.abs(rowtr-row),Math.abs(coltr-col) );
                }
            }          
        }
        return ham;
    }
    public int manhattan(){
        int manh = 0;
        int dim = dimension();
        for (int row=0; row<dim; row++){
            for (int col=0; col<dim; col++) {
                if (blocks[row][col]!=0){
                    int rowtr = (blocks[row][col]-1) /dim;
                    int coltr = (blocks[row][col]-1) %dim;
                    manh += Math.abs(rowtr-row);
                    manh += Math.abs(coltr-col);
                }
            }          
        }
        return manh;
    }
    public boolean isGoal(){
        int dim = dimension();
        for (int row=0; row<dim; row++){
            for (int col=0; col<dim; col++) {
                if (blocks[row][col]!=0){
                    int rowtr = (blocks[row][col]-1) /dim;
                    int coltr = (blocks[row][col]-1) %dim;              
                    if ( (rowtr != row) || (coltr != col) )
                        return false;   
                }
            }
        }
        return true;
    }
    public boolean isSolvable(){
        if ( this.dimension()%2==1 ){
            if ( inversion()%2==1 )
                return false;
        }
        if (this.dimension()%2==0 ){
            if ( (inversion()+constant()) %2 == 1 )
                return false;
        }
        return true;
    }
    private int inversion(){
        int[] arr = new int[dimension()*dimension()];
        int index = 0;
        int count = 0;
        for (int row=0; row<dimension(); row++){
            for (int col=0; col<dimension(); col++)
                arr[index++]=blocks[row][col];
        }
        for (int i=0; i<arr.length; i++){
            for (int j=i+1; j<arr.length; j++)
                if (arr[j]!=0 && arr[i]>arr[j])
                    count++;
        }
        return count;
    }
    private int constant(){
        for (int row=0; row<dimension(); row++){
            for (int col=0; col<dimension(); col++){
                if (blocks[row][col]==0){
                    return row+1;
                }
            }
        }
        return 0;
    }
    public boolean equals(Board other){
        for (int row=0; row<dimension(); row++){
            for (int col=0; col<dimension(); col++){
                if (this.blocks[row][col] != other.blocks[row][col])
                    return false;
            }
        }
        return true;
    }
    public Iterable<Board> neighors() {
        ArrayList<Board> list = new ArrayList<Board>();
        int dim = dimension();
                       
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                if (blocks[row][col] == 0) {
                    if (row - 1 >= 0) {
                        Board nb = new Board(blocks);
                        nb.blocks[row][col] = nb.blocks[row-1][col];
                        nb.blocks[row-1][col]=0;
                        list.add(nb);
                    }
                    if (col - 1 >= 0) {
                        Board nb = new Board(blocks);
                        nb.blocks[row][col] = nb.blocks[row][col-1];
                        nb.blocks[row][col-1]=0;
                        list.add(nb);
                    }
                    if (row + 1 <= dim - 1) {
                        Board nb = new Board(blocks);
                        nb.blocks[row][col] = nb.blocks[row+1][col];
                        nb.blocks[row+1][col]=0;
                        list.add(nb);
                    }
                    if (col + 1 <= dim - 1) {
                        Board nb = new Board(blocks);
                        nb.blocks[row][col] = nb.blocks[row][col+1];
                        nb.blocks[row][col+1]=0;
                        list.add(nb);
                    }
                    break;
                }
            }
        }
        return list;
    }
    public String toString(){
        String s = dimension()+"\n";
        for (int row=0; row<dimension(); row++){
             for (int col=0; col<dimension(); col++){
                  s+= " "+blocks[row][col];
             }
        s+="\n";
        } 
        return s;
    }
}

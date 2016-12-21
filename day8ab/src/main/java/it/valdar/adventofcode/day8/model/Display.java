package it.valdar.adventofcode.day8.model;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by valdar on 20/12/16.
 */
public class Display {
    private static final int PIXEL_ON = 1;
    private static final int PIXEL_OFF = 0;

    private int wide;
    private int tall;
    private int[][] panel;

    public Display( int wide, int tall ){
        this.wide = wide;
        this.tall = tall;
        this.panel = new int[tall][wide];
    }

    public int[] getRow( int rowIndex ){
        return Arrays.copyOf( panel[rowIndex], panel[rowIndex].length);
    }

    public void setRow( int rowIndex, int[] row ){
        panel[rowIndex] = row;
    }

    public int[] getColumn( int columnIndex ){
        int[] result = new int[tall];
        IntStream.range(0, tall).forEach( i -> result[i] = panel[i][columnIndex] );
        return result;
    }

    public void setColumn( int columnIndex, int[] column ){
        IntStream.range(0, column.length).forEach( i -> panel[i][columnIndex] = column[i] );
    }

    public void switchPixelOn(int column, int row){
        panel[row][column] = PIXEL_ON;
    }

    public void switchPixelOff(int column, int row){
        panel[row][column] = PIXEL_OFF;
    }

    public int getSwitchedOnPixels(){
        return Arrays.stream( panel ).flatMapToInt( row -> Arrays.stream( row ) ).sum();
    }

    public void print( PrintStream ps) {
        ps.println("==================================================");
        IntStream.range(0, tall).forEach( row -> {
            IntStream.range(0, wide).forEach( col -> {
                if( panel[row][col] == 1 ){
                    ps.print( "#" );
                } else {
                    ps.print( " " );
                }

            } );
            ps.print("\n");
        } );
        ps.println("==================================================");
    }
}

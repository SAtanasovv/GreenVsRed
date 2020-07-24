package com.company;

public class Grid {

    // Global variables
    private int widthX;
    private int heightY;
    private String[][] mainGrid;

    // Class constructor
    public Grid(int widthX, int heightY) {
        this.widthX = widthX;
        this.heightY = heightY;

    }
    //Getters and Setters

    public int getWidthX() {
        return widthX;
    }

    public int getHeightY() {
        return heightY;
    }

    public String[][] getMainGrid() {
        return mainGrid;
    }

/*
* The method generateGrid is used to create Generation Zero (0th Grid)
**/
    public void generateGrid() {

            this.mainGrid=new String[heightY][widthX];
            for (int i = 0; i < heightY; i++) {
                for (int j = 0; j < widthX; j++) {
                    mainGrid[i][j] = generateRandomZeroOrOne();
                }
            }
    }

    /*
    * The method showGrid is used to print the generated Grid in the console
    * */
    public void showGrid() {
        System.out.println("\n Generation zero");
        for (int i = 0; i < heightY; i++) {
            for (int j = 0; j < widthX; j++) {
                System.out.print(this.mainGrid[i][j] + " ");
            }
            System.out.println("\n");

        }

    }

    // This simple method creates random 0's and 1's
    public String generateRandomZeroOrOne() {
        return String.valueOf(Math.round(Math.random()));
    }

}

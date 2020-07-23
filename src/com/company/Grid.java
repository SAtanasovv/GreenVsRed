package com.company;

public class Grid {
    private int widthX;
    private int heightY;
    private String[][] mainGrid;

    public Grid() {

    }

    public Grid(int widthX, int heightY) {
        this.widthX = widthX;
        this.heightY = heightY;
        //this.mainGrid = new String[heightY][widthX];

    }

    public void setWidthX(int widthX) {
        this.widthX = widthX;
    }

    public int getWidthX() {
        return widthX;
    }

    public int getHeightY() {
        return heightY;
    }

    public void setMainGrid(String[][] mainGrid) {
        this.mainGrid = mainGrid;
    }
    public String[][] getMainGrid() {
        return mainGrid;
    }

    public void generateGrid() {

        if(heightY>widthX){

            this.mainGrid=new String[heightY][heightY];
            for (int i = 0; i < heightY; i++) {
                for (int j = 0; j < widthX; j++) {
                    mainGrid[i][j] = generateRandomZeroOrOne();
                }

            }
            for (int i = 0; i < heightY; i++) {
                for (int j = widthX; j < heightY; j++) {
                    mainGrid[i][j] = " ";
                }

            }
            setWidthX(heightY);
        }else {
            this.mainGrid=new String[heightY][widthX];
            for (int i = 0; i < heightY; i++) {
                for (int j = 0; j < widthX; j++) {
                    mainGrid[i][j] = generateRandomZeroOrOne();
                }

            }
        }

    }

    public void showGrid() {
        System.out.println("\n Generation zero");
        for (int i = 0; i < heightY; i++) {
            for (int j = 0; j < widthX; j++) {
                System.out.print(this.mainGrid[i][j] + " ");
            }
            System.out.println("\n");

        }

    }

    public String generateRandomZeroOrOne() {
        return String.valueOf(Math.round(Math.random()));
    }

}

package com.company;

public class RulesOfTheGame {
    private int widthX;
    private int heightY;
    private int count = 0;
    private String[][] mainGridValidation;
    private String[][] newGenerationGrid;
    private Grid grid;

    public RulesOfTheGame() {
    }

    public RulesOfTheGame(Grid grid) {
        this.grid = grid;
        this.mainGridValidation = grid.getMainGrid();
        this.widthX = grid.getWidthX();
        this.heightY = grid.getHeightY();


    }


    public void newGenerationCreator(int X, int Y, int numberOfGenerations) {

        System.out.println("\nGrid 0 ");
        showGrid();
        for (int k = 1; k < numberOfGenerations; k++) {
            newGenerationGrid = new String[widthX][heightY];
            for (int i = 0; i < heightY; i++) {
                for (int j = 0; j < widthX; j++) {

                    if (mainGridValidation[i][j].equals("1")) {
                        newGenerationGrid[i][j] = greenSquareSelected(checkSurroundingSquares(j, i));
                    }
                    else if(mainGridValidation[i][j].equals("0")){
                        newGenerationGrid[i][j] = redSquareSelected(checkSurroundingSquares(j, i));
                    }
                    else newGenerationGrid[i][j]= " " ;
                }


            }
            checkGreenInGenerations(X, Y);
            this.mainGridValidation = newGenerationGrid;
            System.out.println("\nGrid " + k);
            showGrid();


        }
        System.out.println("\nThe cell in coordinates X : "+ X +" Y : "+ Y + " had green " + count +" times") ;
    }

    public int checkSurroundingSquares(int x, int y) {
        int[] arrayForI = {-1, -1, -1, 0, 0, +1, +1, +1};
        int[] arrayForJ = {-1, 0, +1, -1, +1, -1, 0, +1};
        int numberOfGreenSquares = 0;
        for (int i = 0; i < 8; i++) {
            if (isValid(x + arrayForI[i],y + arrayForJ[i])) {//x -> row y->column
                if (mainGridValidation[y + arrayForJ[i]][x + arrayForI[i]].equals("1") ) {
                    numberOfGreenSquares++;
                }
            }
        }
        return numberOfGreenSquares;
    }

    public boolean isValid(int x, int y) {
        if (x < 0 || y < 0 || x >= widthX || y >= heightY)
            return false;
        return true;

    }


    public String redSquareSelected(int squareCount) {
        if (squareCount == 3 || squareCount == 6) {
            return "1";
        } else
            return "0";

    }

    public String greenSquareSelected(int squareCount) {
        if (squareCount == 2 || squareCount == 3 || squareCount == 6) {
            return "1";
        } else
            return "0";

    }

    public void showGrid() {
        for (int i = 0; i < heightY; i++) {
            for (int j = 0; j < widthX; j++) {
                System.out.print(this.mainGridValidation[i][j] + " ");
            }
            System.out.println("\n");

        }

    }

    public void checkGreenInGenerations(int widthX, int heightY) {
        if (mainGridValidation[heightY][widthX].equals("1")) {
            count++;
        }

    }
}

package com.company;

public class RulesOfTheGame {

    //Global variables
    private int widthX;
    private int heightY;
    private int count = 0;
    private String[][] mainGridValidation;

    //Class constructor
    public RulesOfTheGame(Grid grid) {
        this.mainGridValidation = grid.getMainGrid();
        this.widthX = grid.getWidthX();
        this.heightY = grid.getHeightY();


    }

    //This method is used to create the new generations based on Generation Zero and show how many times a certain square was green
    public void newGenerationCreator(int coordinateX, int coordinateY, int numberOfGenerations) {

        System.out.println("\nGrid 0 ");
        showGrid();
        for (int k = 1; k < numberOfGenerations; k++) {
            String[][] newGenerationGrid = new String[heightY][widthX];
            for (int i = 0; i < heightY; i++) {
                for (int j = 0; j < widthX; j++) {

                    if (mainGridValidation[i][j].equals("1")) {
                        newGenerationGrid[i][j] = greenSquareSelected(checkSurroundingSquares(j, i));
                    } else if (mainGridValidation[i][j].equals("0")) {
                        newGenerationGrid[i][j] = redSquareSelected(checkSurroundingSquares(j, i));
                    }
                }
            }

            checkGreenInGenerations(coordinateX, coordinateY);
            this.mainGridValidation = newGenerationGrid;
            System.out.println("\nGrid " + k);
            showGrid();
        }

        System.out.println("\nThe cell in coordinates X : " + coordinateX + " Y : " + coordinateY + " had green " + count + " times");
    }
    // With this method we go through all of the available surrounding cells when we have a square selected and we return the number of green ones
    public int checkSurroundingSquares(int x, int y) {
        int[] arrayForI = {-1, -1, -1, 0, 0, +1, +1, +1};
        int[] arrayForJ = {-1, 0, +1, -1, +1, -1, 0, +1};
        int numberOfGreenSquares = 0;
        for (int i = 0; i < 8; i++) {
            if (isValid(x + arrayForI[i], y + arrayForJ[i])) {//x -> row y->column
                if (mainGridValidation[y + arrayForJ[i]][x + arrayForI[i]].equals("1")) {
                    numberOfGreenSquares++;
                }
            }
        }
        return numberOfGreenSquares;
    }
    // This method verifies that we are not going to try and access a not existing square
    public boolean isValid(int x, int y) {
        if (x < 0 || y < 0 || x >= widthX || y >= heightY)
            return false;
        return true;

    }

    //When we are at a red square defining the next generation, depending on the number of green square around it we return a 0 or 1
    public String redSquareSelected(int numberOfGreenSquares) {
        if (numberOfGreenSquares == 3 || numberOfGreenSquares == 6) {
            return "1";
        } else
            return "0";

    }
    //When we are at a green square defining the next generation, depending on the number of green square around it we return a 0 or 1
    public String greenSquareSelected(int numberOfGreenSquares) {
        if (numberOfGreenSquares == 2 || numberOfGreenSquares == 3 || numberOfGreenSquares == 6) {
            return "1";
        } else
            return "0";

    }
    /*
     * The method showGrid is used to print the generated Grid in the console
     * */
    public void showGrid() {
        for (int i = 0; i < heightY; i++) {
            for (int j = 0; j < widthX; j++) {
                System.out.print(this.mainGridValidation[i][j] + " ");
            }
            System.out.println("\n");
        }
    }
    // This method checks in every generation of the grid if the cell selected, from the given coordinates,
    // was green ( 1 ) and returns how many times this was true
    public void checkGreenInGenerations(int widthX, int heightY) {
        if (mainGridValidation[heightY][widthX].equals("1")) {
            count++;
        }
    }
}

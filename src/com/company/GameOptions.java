package com.company;

import java.util.Scanner;

public class GameOptions {
    public Scanner keyboard;
    private Grid grid;

    public void optionsMenu() {
        boolean isTrue=false;
        optionsMenuText();
        keyboard = new Scanner(System.in);
        int choice = keyboard.nextInt();

        do {
            switch (choice) {
                case 1:
                    createGenerationZero();
                    isTrue = true;
                    break;
                case 2:
                    if(isTrue){ createNewGeneration();}
                    else
                        System.out.println("\nYou have to create Generation zero first" );
                    break;
                default:
                    System.out.println("\nInvalid choice!! Try again");

            }
            optionsMenuText();
            choice = keyboard.nextInt();
        } while (choice != 0);

    }


    public void createGenerationZero() {
        keyboard = new Scanner(System.in);
        System.out.print("Enter the width of the grid : ");
        int widthX =coordinateCheckerX();
        System.out.print("Enter the height of the grid : ");
        int heightY =coordinateCheckerY(widthX);
        grid = new Grid(widthX, heightY);
        grid.generateGrid();
        grid.showGrid();

    }

    public void createNewGeneration() {
        keyboard = new Scanner(System.in);
        System.out.print("Number of generations : ");
        int numberOfGenerations = keyboard.nextInt();
        System.out.print("Enter X coordinate: ");
        int coordinateX = coordinateCheckerForCell(grid.getWidthX());
        System.out.print("Enter Y coordinate: ");
        int coordinateY = coordinateCheckerForCell(grid.getHeightY());
        RulesOfTheGame rulesOfTheGame = new RulesOfTheGame(grid);
        rulesOfTheGame.newGenerationCreator(coordinateX, coordinateY, numberOfGenerations);


    }

    public int coordinateCheckerX(){
        int coordinate;
        coordinate =keyboard.nextInt();
        if (coordinate <0|| coordinate >1000){
            System.out.println("\nPlease enter coordinates between 0 and 1000");
            coordinate =coordinateCheckerX();

        }

        return coordinate;
    }

    public int coordinateCheckerY(int coordinateX){
        int coordinateY;
        coordinateY =keyboard.nextInt();
        if (coordinateY <coordinateX|| coordinateY >1000){
            System.out.println("\nPlease enter coordinates between "+ coordinateX + " and 1000");
            coordinateY =coordinateCheckerY(coordinateX);

        }

        return coordinateY;
    }



    public int coordinateCheckerForCell(int length){
        int coordinate;
        coordinate =keyboard.nextInt();
          if (coordinate <0 || coordinate >=length){
            System.out.println("\nCoordinates range must be between 0 and "+ (length-1));
            coordinate=coordinateCheckerForCell(length);
          }

        return coordinate;
    }

    public void optionsMenuText() {

        System.out.println("\n  Select operation: ");
        System.out.println("1 Create generation zero. ");
        System.out.println("2 Check for green cell during generations. ");
        System.out.println("0 Exit. ");
        System.out.print("Enter your choice: \n");


    }



}

package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameOptions {
    // Global variables
    private Scanner keyboard;
    private Grid grid;

    // A switch is used to go through the options of the game
    public void optionsMenu() {
        boolean isTrue = false;
        optionsMenuText();
        keyboard = new Scanner(System.in);
        int choice = integerInput();

        do {
            switch (choice) {
                case 1:
                    createGenerationZero();
                    isTrue = true;
                    break;
                case 2:
                    if (isTrue) {
                        createNewGeneration();
                    } else
                        System.out.println("\nYou have to create Generation zero first");
                    break;
                default:
                    System.out.println("\nInvalid choice!! Try again");
            }
            optionsMenuText();
            choice = integerInput();
        } while (choice != 0);

    }
    //With this method we create Generation Zero from the Grid class
    public void createGenerationZero() {
        keyboard = new Scanner(System.in);
        System.out.print("Enter the width of the grid : ");
        int widthX = coordinateCheckerX();
        System.out.print("Enter the height of the grid : ");
        int heightY = coordinateCheckerY(widthX);
        grid = new Grid(widthX, heightY);
        grid.generateGrid();
        grid.showGrid();

    }
    //With this method we create a new generation from the RulesOfTheGame class
    public void createNewGeneration() {
        keyboard = new Scanner(System.in);
        RulesOfTheGame rulesOfTheGame = new RulesOfTheGame(grid);
        System.out.print("Number of generations : ");
        int numberOfGenerations = integerInput();
        System.out.print("Enter X coordinate: ");
        int coordinateX = coordinateCheckerForCell(grid.getWidthX());
        System.out.print("Enter Y coordinate: ");
        int coordinateY = coordinateCheckerForCell(grid.getHeightY());
        rulesOfTheGame.newGenerationCreator(coordinateX, coordinateY, numberOfGenerations);
    }
    // This method checks if the width is between 1 and 1000
    public int coordinateCheckerX() {
        int coordinateX;
        coordinateX = integerInput();
        if (coordinateX < 1 || coordinateX > 1000) {
            System.out.println("\nPlease enter coordinates between 1 and 1000");
            coordinateX = coordinateCheckerX();
        }
        return coordinateX;
    }
    // This method makes sure that the height of the grid is greater than the width and less than a thousand
    public int coordinateCheckerY(int coordinateX) {
        int coordinateY = integerInput();
        if (coordinateY < coordinateX || coordinateY > 1000) {
            System.out.println("\nPlease enter coordinates between " + coordinateX + " and 1000");
            coordinateY = coordinateCheckerY(coordinateX);
        }
        return coordinateY;
    }
    //With this method we make sure that the coordinates we enter to select a square are not off the grid
    public int coordinateCheckerForCell(int length) {
        int coordinate = integerInput();
        if (coordinate < 0 || coordinate >= length) {
            System.out.println("\nCoordinates range must be between 0 and " + (length - 1));
            coordinate = coordinateCheckerForCell(length);
        }

        return coordinate;
    }
    // Because all of our inputs are supposed to be numbers I use this method to make sure that there are no String inputs
    public int integerInput() {
        boolean isTrue = false;
        int number = 0;
        do {
            try {
                number = keyboard.nextInt();
                isTrue = true;
            } catch (InputMismatchException e) {
                System.out.println("Please use only integers");

            }
            keyboard.nextLine();

        } while (!isTrue);

        return number;
    }

    // The Incredible User Interface !
    public void optionsMenuText() {

        System.out.println("\n  Select operation: ");
        System.out.println("1 Create generation zero. ");
        System.out.println("2 Check for green cell during generations. ");
        System.out.println("0 Exit. ");
        System.out.print("Enter your choice: \n");
    }

}

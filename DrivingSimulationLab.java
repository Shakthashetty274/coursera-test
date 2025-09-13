import java.util.Scanner;

// DrivingSimulation class implements the Driving Simulation which includes various actions
// like turn the engine on/off, accelerate (i.e. increase the speed) and apply the brakes.
public class DrivingSimulationLab {

    public static String gear = "P";     // Initial gear = Park
    public static int speed = 0;         // Initial speed = 0
    public static boolean isEngineOn = false; // Engine initially off
    public static Scanner keyBoard = new Scanner(System.in);

    // Starts the car simulation
    public static void startSimulation() {
        boolean displayMenu = true;
        while (displayMenu) {
            displayDashboard();
            int choice = getUserChoice();
            processChoice(choice);
            System.out.println();
        }
    }

    // Display the car dashboard
    public static void displayDashboard() {
        System.out.println("------ Car Dashboard ------");
        System.out.println("Speed: " + speed);
        System.out.println("Engine: " + (isEngineOn ? "On" : "Off"));
        System.out.println("Gear: " + gear);
        System.out.println("Menu:");
        System.out.println("1. Turn on/off the engine");
        System.out.println("2. Change gear (P, D, R)");
        System.out.println("3. Accelerate");
        System.out.println("4. Brake");
        System.out.println("5. Exit");
    }

    public static int getUserChoice() {
        System.out.print("Enter your choice: ");
        return keyBoard.nextInt();
    }

    public static void processChoice(int choice) {
        switch (choice) {
            case 1: toggleEngine(); break;
            case 2: changeGear(); break;
            case 3: accelerate(); break;
            case 4: brake(); break;
            case 5: exitSimulation(); break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    // Toggle the engine state
    public static void toggleEngine() {
        isEngineOn = !isEngineOn;
        System.out.println("Engine turned " + (isEngineOn ? "On" : "Off"));
        if (!isEngineOn) {
            speed = 0; // stop the car if engine is turned off
        }
    }

    // Change gear with validation
    public static void changeGear() {
        System.out.print("Please enter the gear (P/D/R): ");
        String newGear = keyBoard.next().toUpperCase();

        if (newGear.equals("P") || newGear.equals("D") || newGear.equals("R")) {
            gear = newGear;
            System.out.println("Gear changed to " + gear);
        } else {
            System.out.println("Invalid gear! Allowed values: P, D, R");
        }
    }

    // Accelerate
    public static void accelerate() {
        if (isEngineOn && !gear.equals("P")) {
            speed += 10;
            System.out.println("Accelerated! Speed is now " + speed);
        } else {
            System.out.println("Acceleration is not possible!");
        }
    }

    // Brake
    public static void brake() {
        if (isEngineOn && speed > 0) {
            speed -= 5;
            System.out.println("Brakes applied! Speed is now " + speed);
        } else {
            System.out.println("Braking not possible!");
        }
    }

    // Exit simulation
    public static void exitSimulation() {
        System.out.println("End of Simulation!");
        System.exit(0);
    }

    // Main method
    public static void main(String[] args) {
        startSimulation();
    }
}

package uk.ac.glos.ct5057.flight_management;

/*
#=========================INFO==========================#
 Version: 0.1
 Author: Adrian Elson
 Date Created: 27 03 19

 Changes from last version:


#=======================================================#
 */

import uk.ac.glos.ct5057.flight_management.brains.Flight;
import uk.ac.glos.ct5057.flight_management.brains.Passenger;
import uk.ac.glos.ct5057.flight_management.brains.Seating;

import java.util.Scanner;

public class Main {

    private String input;
    private boolean exit = false;
    String seatClass, passName;
    int flightNum;

    public static void main(String[] args){

        Main main = new Main();
        main.start();
    }

    public void start() {

        Flight flight = new Flight();
        Passenger pass = new Passenger();
        Seating seating = new Seating();
        Scanner sc = new Scanner(System.in);

        /**
         * need to retrieve all flight details to use
         */
        flight.storeFlightDetails();

        while (exit == false){
            System.out.print("#=====================#\n  Welcome to AMS v0.1\n#=====================#\n\n");
            System.out.println("Please select the corresponding letter associated\nwith the task you'd like to perform:");
            System.out.println("\nS - Schedule Passenger for Flight");
            System.out.println("C - Cancel Passenger from Flight");
            System.out.println("P - Passenger Status");
            System.out.println("F - Flight Information");
            System.out.println("E - Exit");

            input = sc.next();

            //resets scanner so it doesnt skip the next input.
            sc.nextLine();


            /**
             * Schedule passenger for a flight
             */
            if (input.equalsIgnoreCase("s")) {

                System.out.println("Please enter the passengers name:");
                passName = sc.nextLine();

                System.out.println("Please enter a Flight Number");
                flightNum = sc.nextInt();

                //resets scanner so it doesnt skip the next input.
                sc.nextLine();

                System.out.println("Please select the corresponding letter associated with the class:\n\nF - First\nB - Business\nE - Economy");
                seatClass = sc.nextLine();

                seating.setName(flight, flightNum, seatClass, passName);

                /**
                 * cancel passenger from flight
                 */
            }else if (input.equalsIgnoreCase("c")) {

                System.out.println("Please enter a Flight Number");
                flightNum = sc.nextInt();

                System.out.println("Current seating information: " + seating.printSeatInfo(flight, flightNum, seatClass));

                System.out.println("Please enter a Seat Number");
                int seatNum = sc.nextInt();


                //operator may not know the seat num
                seating.resetSeat(flight, flightNum, seatNum, seatClass);

                /**
                 * passenger status
                 */
            }else if (input.equalsIgnoreCase("p")) {

                System.out.println("Please enter the name of the passenger");

                passName = sc.nextLine();

                pass.printPassengerStatus(seating, flight, passName, seatClass, flightNum);

            }else if (input.equalsIgnoreCase("f")) {

                System.out.println("Please input a flight number: \n");

                flightNum = sc.nextInt();

                System.out.println("Departure Location:     "+ flight.flightDep);
                System.out.println("Arrival Location:       "+ flight.flightDest);
                System.out.println("Date of Flight:         "+ flight.flightDate);
                System.out.println("First Class Seating:    "+ flight.seatListF);
                System.out.println("Business Class Seating: "+ flight.seatListB);
                System.out.println("Economy Class Seating:  "+ flight.seatListE+"\n");

            }

            else if (input.equalsIgnoreCase("e")) {
                exit = true;
            }else{System.out.println("Invalid input\n");}
        }
    }
}

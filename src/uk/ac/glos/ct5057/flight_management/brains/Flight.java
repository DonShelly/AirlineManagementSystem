package uk.ac.glos.ct5057.flight_management.brains;

import java.util.HashMap;

public class Flight {

    private int flightNumber;
    public String flightDep, flightDest, flightDate;
    private String [] flightDetails;
    public HashMap <Integer,String> seatListF, seatListB, seatListE;

    private Operations op = new Operations();

    /**
     * implementation of final operation
     *
     * @author Adrian Elson
     * @version 0.1
     * @since 11/04/2019
     *
     * @param flightNum
     * @return flightArray
     */

    public String[] printFlightDetails(int flightNum){

        String flightArray[] = new String[]{};

        //simply print what's in the txt file.

        return flightArray;
    }

    /**
     * Store the flight details
     *
     * @author Adrian Elson
     * @version
     * @since
     *
     * @param
     */
    public void storeFlightDetails() {

        op.openFile();

        flightNumber = Integer.parseInt(op.readFile());

        flightDep = op.readFile();

        flightDate = op.readFile();

        flightDest = op.readFile();


        /**
         *  clone and print hash map
          */
        seatListF = (HashMap<Integer, String>) op.readFileSeating().clone();
        //System.out.println(seatListF);

        /**
         * big boy issue: 8 wants to skip to pos 1 even thou detected last, may not actually be an issue
         */
        seatListB = (HashMap<Integer, String>) op.readFileSeating().clone();
        //System.out.println(seatListB);

        seatListE = (HashMap<Integer, String>) op.readFileSeating().clone();
        //System.out.println(seatListE);

        op.closeFile();
    }

    public String[] searchForPassenger (Flight flight, String passName){

        //currently everything does the same thing bc flight numbers are not implemented yet
        if (flight.seatListF.containsValue(passName)){

            flightDetails = new String[]{String.valueOf(flightNumber), flightDep, flightDate, flightDest};

        } else if (flight.seatListB.containsValue(passName)){

            flightDetails = new String[]{String.valueOf(flightNumber), flightDep, flightDate, flightDest};

        } else if (flight.seatListE.containsValue(passName)){

            flightDetails = new String[]{String.valueOf(flightNumber), flightDep, flightDate, flightDest};

        } else {
            System.out.println("No such passenger on current flights");
        }

        return flightDetails;
    }





}

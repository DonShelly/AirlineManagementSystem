package uk.ac.glos.ct5057.flight_management.brains;

import java.util.HashMap;
import java.util.Scanner;

public class Seating {

    Operations op = new Operations();
    Passenger pass = new Passenger();
    Scanner sc = new Scanner(System.in);


    private int seatNumber, i;
    private String seatClass, seatAssignee, mapValToString, finalSeat, inputTemp;
    private boolean seated, done;
    private Integer[] keyArray;
    private String [] flightDetails;

    /**
     *
     *
     * @author Adrian Elson
     * @version
     * @since
     *
     * @param
     * @param flight
     * @param seatClass
     * @param passName
     * @return
     */

    public void setName(Flight flight, int flightNum, String seatClass, String passName) {

            seated = false;
            i = 0;

            /**
             * section turns hashmap keys into string
             */

            mapValToString = op.mapValToString(flight, seatClass);

            if (seatClass.equalsIgnoreCase("f")){

                //sets finalSeat to the value of the final seat in the class.
                keyArray = op.mapKeyToArray(flight, seatClass);
                finalSeat = String.valueOf(keyArray[(keyArray.length)-1]);
                System.out.println("test final seat = " + finalSeat);

                while (seated==false) {

                    /**
                     * test print
                     */
                    System.out.println(flight.seatListF);

                    //checks if seat is empty
                    if (flight.seatListF.get(i) == "empty") {

                        //assigns pass to seat
                        flight.seatListF.put(i, passName);

                        System.out.println("Passenger Named successfully");
                        seated=true;

                        System.out.println(flight.seatListF.values());
                        /**
                         * test print
                         */
                        System.out.println(flight.seatListF);

                    //adds extra layer of relaiability to full class
                    } else if (String.valueOf(i).equalsIgnoreCase(finalSeat)){
                        System.out.println("all seats taken for this class, would the passenger like to be added to the waiting list? (Y/N)");

                        inputTemp = sc.nextLine();

                        if (inputTemp.equalsIgnoreCase("y")){

                           pass.setWaitList(passName, flightNum, seatClass);
                           System.out.println(pass.fetchWaitList(flightNum));

                        }else{System.out.println("Passenger not assigned to seat");}

                        //does not make sense in english but does logically
                        seated = true;
                    }
                    i++;
                }
            }else{System.out.println("Invalid input");}


    }

    /**
     *
     *
     * @author Adrian Elson
     * @version
     * @since
     *
     * @param
     * @return
     */
//dont thin this is needed

    public void setClass(String seatClass) {

    }

    /**
     *
     *
     * @author Adrian Elson
     * @version
     * @since
     *
     * @param
     * @param flightNum
     * @return
     */

    public void resetSeat(Flight flight, int flightNum, int seatNum, String seatClass) {

        flight.seatListF.put(seatNum, "empty");

        int i = 0;
        seated = false;


        while (seated == false){

            if (seatClass.equalsIgnoreCase("f")) {

                String waitKey = i + "F";
                String temp = waitKey;

                System.out.println(waitKey);

                if (pass.fetchWaitList(flightNum).containsKey(temp) == true) {

                    System.out.println("There is a passenger on the waiting list for this class and flight.\n" +
                            "Would you like to assign " + (pass.fetchWaitList(flightNum)).get(temp) + " to this seat? (Y/N)");

                    String confirmation = sc.nextLine();

                    if (confirmation.equalsIgnoreCase("y")) {

                        temp = String.valueOf((pass.fetchWaitList(flightNum)).get(temp));

                        setName(flight, flightNum, seatClass, temp);

                        seated=true;
                        System.out.println("Passenger successfully cancelled from flight, and passenger from waiting list is now seated.");

                        pass.removeFromWaitingList(waitKey);

                    }else{
                        seated=true;
                        System.out.println("Passenger successfully cancelled from flight, seat is now empty.");
                    }

                }else{
                    i++;
                    if (i == 10){
                        seated = true;
                        System.out.println("-TEST- wait list empty");
                    }
                }
            }
        }
    }

    /**
     *
     *
     * @author Adrian Elson
     * @version
     * @since
     *
     * @param
     * @return
     */

    public HashMap printSeatInfo(Flight flight, int flightNum, String seatClass) {

        if (seatClass.equalsIgnoreCase("f")){
            return flight.seatListF;
        }else if (seatClass.equalsIgnoreCase("b")){
            return flight.seatListB;
        } else return flight.seatListE;
    }

    public String[] searchForPassenger(Flight flight, String passName, String seatClass, int flightNum) {

        if (pass.waitList.containsValue(passName)) {

            int i = 0;
            int pos = 0;
            done = false;


            while (done == false) {

                if (seatClass.equalsIgnoreCase("f")) {

                    String waitKey = i + "F";

                    System.out.println(waitKey);


                    if (passName.equalsIgnoreCase(String.valueOf(pass.waitList.get(waitKey)))){
                        pos++;
                        done=true;
                    }else{pos++;}

                }
                i++;
                if (i == 9) {
                    done = true;
                }
            }


            String position = pos + "th";

            if (pos == 1) {
                position = pos + "st";
            } else if (pos == 2) {
                position = pos + "nd";
            } else if (pos == 3) {
                position = pos + "rd";
            }

                flightDetails = new String[]{String.valueOf(flight.flightNumber), flight.flightDep, flight.flightDate,
                        flight.flightDest, "Passenger's position in waiting list: ", position};

            }

         return flightDetails;
    }
}

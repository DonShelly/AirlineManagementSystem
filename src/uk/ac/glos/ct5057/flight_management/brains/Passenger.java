package uk.ac.glos.ct5057.flight_management.brains;

import java.util.Arrays;
import java.util.HashMap;


public class Passenger {

    private String classWithOrder;
    public HashMap waitList = new HashMap();
    private int F=0, B=0, E=0;

    private boolean done;


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

    public void printPassengerStatus(Seating seating, Flight flight, String passName, String seatClass, int flightNum){

        System.out.println(Arrays.toString(flight.searchForPassenger(flight, passName)));

        System.out.println(Arrays.toString(seating.searchForPassenger(flight, passName, seatClass, flightNum)));

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

    public void setWaitList(String passName, int flightNum, String seatClass) {

        //for now the key is class so the functionality works on a basic level first

        //val of i con with class i++

        seatClass = seatClass.toUpperCase();

        if (seatClass.equalsIgnoreCase("F")) {

            classWithOrder = F + seatClass;

            waitList.put(classWithOrder, passName);

            F++;
        }else if (seatClass.equalsIgnoreCase("B")) {

            classWithOrder = B + seatClass;

            waitList.put(classWithOrder, passName);

            B++;
        }else if (seatClass.equalsIgnoreCase("E")) {

            classWithOrder = E + seatClass;

            waitList.put(classWithOrder, passName);

            E++;
        }
    }

    //flight num as param not implemented yet
    public HashMap fetchWaitList(int flightNum){

        return waitList;

    }

    public void removeFromWaitingList (String waitKey){

        waitList.remove(waitKey);

    }

}

package uk.ac.glos.ct5057.flight_management.brains;

//may delete entire class if not needed

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


public class Operations {

    private Scanner file;
    private String i, valString = null;
    private Integer n;

    //reads in file for manipulation
    public void openFile(){
        try {

            file = new Scanner(new File("D:\\OneDrive - University of Gloucestershire\\Computing" +
                    "\\## Year 2 Sem 2 ##\\CT5057 - Algorithms and Data Structures\\proj space\\AMS_v0.1\\src\\uk" +
                    "\\ac\\glos\\ct5057\\flight_management\\text_files\\test.txt"));

        } catch (Exception e) {
            System.out.println("file error");
        }
    }

    public String readFile() {

        i = file.nextLine();

        //System.out.println(i);


        return i;
    }

    // reads seating into hashMap
    public HashMap<Integer, String> readFileSeating() {

        HashMap<Integer, String> seatingHashMap = new HashMap<>();

        while (file.hasNextInt()) {

            n =file.nextInt();

            seatingHashMap.put(n, "empty");
        }

        String incrament = file.nextLine();

        //System.out.println(temp);

        return seatingHashMap;
    }

    public void closeFile(){
        file.close();
    }

    public String mapValToString(Flight flight, String seatClass){

        if (seatClass.equalsIgnoreCase("f")) {
            Integer[] array = new Integer[flight.seatListF.size()];

            // copy elements from set to string array
            int i = 0;
            for (Integer s : flight.seatListF.keySet())
                array[i++] = s;

            valString = Arrays.toString(array);


        } else if (seatClass.equalsIgnoreCase("b")) {
            Integer[] array = new Integer[flight.seatListB.size()];

            // copy elements from set to string array
            int i = 0;
            for (Integer s : flight.seatListB.keySet())
                array[i++] = s;

            valString = Arrays.toString(array);


        } else if (seatClass.equalsIgnoreCase("e")) {
            Integer[] array = new Integer[flight.seatListE.size()];

            // copy elements from set to string array
            int i = 0;
            for (Integer s : flight.seatListE.keySet())
                array[i++] = s;

            valString = Arrays.toString(array);

        }
        return valString;
    }

    public Integer[] mapKeyToArray(Flight flight, String seatClass){

            System.out.println("only works with first class");
            Integer[] keyArray = flight.seatListF.keySet().toArray(new Integer[flight.seatListF.size()]);

            return keyArray;
    }







}

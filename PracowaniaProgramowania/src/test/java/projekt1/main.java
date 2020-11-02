package projekt1;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileWriter;   // Import the FileWriter class


public class main {

    public static void main(String[] args)
    {

        // create an object of Scanner
        try {
            File plik = new File("pesele.txt");
            if (plik.createNewFile()) {
                System.out.println("File created: " + plik.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        Scanner input = new Scanner(System.in);
        String pesel="";
        boolean odp = false;
        while(odp==false)
        {
            System.out.println("Podaj numer PESEL:");
            pesel = input.nextLine();
            String[] pesel2 = pesel.split("");
            odp = SprawdzPesel(pesel2);
        }
        FileSave.Zapisz(pesel);




    }


    static boolean SprawdzPesel(String pesel[]) {
        int arr[] = new int[11];
        int x;
        try {
            for (int i = 0; i <= 10; i++) {
                arr[i] = Integer.parseInt(pesel[i]);
            }
            x = (arr[0] + (arr[1] * 3) % 10 + (arr[2] * 7) % 10 + (arr[3] * 9) % 10 + arr[4] + (arr[5] * 3) % 10 + (arr[6] * 7) % 10 + (arr[7] * 9) % 10 + arr[8] + (arr[9] * 3) % 10) % 10;
            x = 10 - x;
            //assertFalse(x < 0 || x >= 10);
            if (x != arr[10]) {
                System.out.println("Błąd. Sprawdź czy pesel został poprawnie wprowadzony i sprobuj ponownie.");
                return false;
            }
            else {
                System.out.println("Pesel Poprawny");
                return true;
            }
        } catch (Exception e) {
            System.out.println("Niepoprawny pesel, wprowadź dane ponownie.");
            return false;
        }
    }








}
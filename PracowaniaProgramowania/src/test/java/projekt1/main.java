package projekt1;
import org.junit.Test;
import org.junit.Assert;

import java.util.*;
import java.io.File;  // Import the File class
import java.util.stream.Collectors;


public class main {

    public static void main(String[] args)
    {

        FileSave.StworzPlik("pesele.txt");
        Scanner input = new Scanner(System.in);
        String pesel="";
        boolean odp = false;
        while(odp==false) {
            System.out.println("Podaj numer PESEL:");
            pesel = input.nextLine();

            odp = SprawdzPesel(pesel);
        }
        FileSave.Zapisz(pesel,"pesele.txt");





    }




    static boolean SprawdzPesel2(String pesel) {
        String[] pesel_split = pesel.split("");
        int arr[] = new int[11];
        int x;
        try {
            for (int i = 0; i <= 10; i++) {
                arr[i] = Integer.parseInt(pesel_split[i]);
            }
            x = (arr[0] + (arr[1] * 3) % 10 + (arr[2] * 7) % 10 + (arr[3] * 9) % 10 + arr[4] + (arr[5] * 3) % 10 + (arr[6] * 7) % 10 + (arr[7] * 9) % 10 + arr[8] + (arr[9] * 3) % 10) % 10;
            x = 10 - x;
            //assertFalse(x < 0 || x >= 10);
            if (x != arr[10]) {
                System.out.println("Błąd sumy kontrolnej. Sprawdź czy pesel został poprawnie wprowadzony i sprobuj ponownie.");
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


    @Test
    public void SprawdzPesel_test() {
        boolean result = SprawdzPesel("70100702472");
        Assert.assertTrue(result == true);
    }

    static boolean SprawdzPesel(String pesel) {
            try {
                List<Integer> list = Arrays.stream(pesel.split("")).map(Integer::parseInt).collect(Collectors.toList());
                if (list.size() > 11) {
                    System.out.println("Niepoprawny pesel, wprowadź dane ponownie.");
                    return false;
                }
                int x;
                x = (list.get(0) + (list.get(1) * 3) % 10 + (list.get(2) * 7) % 10 + (list.get(3) * 9) % 10 + list.get(4) + (list.get(5) * 3) % 10 + (list.get(6) * 7) % 10 + (list.get(7) * 9) % 10 + list.get(8) + (list.get(9) * 3) % 10) % 10;
                x = 10 - x;
                //assertFalse(x < 0 || x >= 10);
                if (x != list.get(10)) {
                    System.out.println("Błąd sumy kontrolnej. Sprawdź czy pesel został poprawnie wprowadzony i sprobuj ponownie.");
                    return false;
                } else {
                    System.out.println("Pesel Poprawny");
                    return true;
                }
            } catch (Exception e) {
                System.out.println("Niepoprawny pesel, wprowadź dane ponownie.");
                return false;
            }


    }




}
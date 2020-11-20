package projekt1;

//import org.junit.Assert;
//import org.junit.Test;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Queue;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;


public class FileSave {

    static File StworzPlik(String path)
    {
        try {
            File plik = new File(path);
            if (plik.createNewFile()) {
                System.out.println("Utworzono plik: " + plik.getName());
            } else {
                System.out.println("Plik juz istnieje, nie ma potrzeby tworzenia nowego.");
            }
            return plik;

        } catch (Exception e) {
            System.out.println("Błąd przy tworzeniu pliku.");
            e.printStackTrace();
        }
        return null;

    }

    static void Zapisz(String pesel, String path){
        try {
            FileOutputStream fos = new FileOutputStream(path, true);
            pesel=pesel+"\n";
            byte[] mybytes = pesel.getBytes();
            BlockingQueue<byte[]> q = new LinkedBlockingQueue<>();
            q.add(mybytes);
            fos.write(q.poll());
        }
        catch (IOException e)
        {
            System.out.println("Wystąpił błąd przy zapisywaniu do pliku.");
            e.printStackTrace();
        }
    }

    static void Zapisz2(String pesel, String path) {

        try {
            Files.write(Paths.get(path), (pesel + "\n").getBytes(), StandardOpenOption.APPEND);
            System.out.println("Pomyślnie zapisono pesel do pliku.");
        } catch (IOException e) {
            System.out.println("Wystąpił błąd przy zapisywaniu do pliku.");
            e.printStackTrace();

        }

    }

    //@Test
    public void Zapisz_test()
    {
        File testFile = StworzPlik("J:\\IdeaProjects\\PRA2018-2019\\pesele.txt");
        //Assert.assertTrue(testFile.exists());
    }

   


}
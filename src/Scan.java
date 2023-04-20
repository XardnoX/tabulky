import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Scan {

    public static final String SPLITTER = ";";
    public static List<Deskovka> loadData(File file){
        List<Deskovka> list = new ArrayList<>();
        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader(file)))){

            while (scanner.hasNextLine()){
                String[] data = scanner.nextLine().split(SPLITTER);
                list.add(new Deskovka(data[0], Boolean.parseBoolean(data[1]), Integer.parseInt(data[2])));
            }
        }
        catch (IOException e){
            System.out.println("soubour nelze načíst!");
        }
        System.out.println("načítaní");
    return list;

    }


}

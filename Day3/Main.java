import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        try {
            File myObj = new File("puzzleInput.txt");
            Scanner myReader = new Scanner(myObj);
            int ligne = 0;
            int result = 0 ;
            while (myReader.hasNextLine()) {
                ligne++;
                String data = myReader.nextLine();
                System.out.println(data);
                Pattern pattern = Pattern.compile("mul\\(\\d+,\\d+\\)");
                Matcher matcher = pattern.matcher(data);
                while (matcher.find())
                {
                    System.out.println(ligne);
                    String[] matched = matcher.group(0).split(" ");
                    for (int i = 0; i < matched.length; i++) {
                      matched[i] = matched[i].replaceAll("mul", "");
                      matched[i] = matched[i].replaceAll("[()]", "");
                      String[] numbers = matched[i].split(",");
                      System.out.println(Arrays.toString(numbers));
                      result = result + Integer.parseInt(numbers[0]) * Integer.parseInt(numbers[1]);
                    }
                }
            }
            System.out.println(result);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    }

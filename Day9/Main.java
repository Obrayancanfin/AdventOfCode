import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int interger = 0 ;
        StringBuilder interpreted  = new StringBuilder();
        try {
            File myObj = new File("puzzleInput.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                for (int i = 0; i < data.length(); i++) {
                    int number = data.charAt(i) - '0';
                    if (i % 2 == 0) {
                        if (interger > 9 ) {
                            interger = 0;
                        }else{
                            interpreted.append(Integer.toString(interger).repeat(number));
                            interger++;
                        }
                        System.out.println(interger);
                    }else {
                       interpreted.append(".".repeat(number));
                    }
                }
            }
            System.out.println("interpreted: " + interpreted);
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

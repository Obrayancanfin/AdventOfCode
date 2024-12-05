import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] listNumberString ;
        List<Integer> listNumber = new ArrayList<>();
        try {
        int counterCompare=0;
        int counterSafe= 0;
            File myObj = new File("puzzleInput.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                listNumberString = data.split(" ");
                for(String number : listNumberString){
                    listNumber.add(Integer.valueOf(number));
                }
                for (int i = 0; i < listNumber.size()-1; i++) {
                    if (listNumber.get(i) > listNumber.get(i + 1) ){
                        if (listNumber.get(i) - listNumber.get(i+1) <= 3 ){
                        counterCompare++;
                        }
                    }
                    else if (listNumber.get(i)<listNumber.get(i+1)){
                        if (listNumber.get(i+1) - listNumber.get(i) <= 3 ){
                            counterCompare--;
                        }
                    }
                }
                    if (Math.abs(counterCompare)==listNumber.size()-1){
                        counterSafe++;
                    }
                listNumber=new ArrayList<>();
            }
            System.out.println("Part1 Safe = "+counterSafe );
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
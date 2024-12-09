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


        String interpretedString = String.valueOf(interpreted);
        String interpretedStringReverseStriped = String.valueOf(interpreted.reverse()).replace(".","");

        System.out.println("interpretedReverseStrip = "+ interpretedStringReverseStriped);
        System.out.println("Avant: "+interpretedString);


        for (int i = 0; i < interpretedStringReverseStriped.length(); i++) {
            interpretedString=interpretedString.replaceFirst("\\.", String.valueOf(interpretedStringReverseStriped.charAt(i)));
            interpretedString=replaceLastOccurrence(interpretedString,String.valueOf(interpretedStringReverseStriped.charAt(i)),".");
        }
        interpretedString=interpretedString.replaceAll("\\.","");
        System.out.println("intrepetedSolved : " + interpretedString);
        Long resultat = 0L;

        for (int i = 0; i < interpretedString.length(); i++) {
           resultat+= (interpretedString.charAt(i) - '0' )*i;
            System.out.println(resultat);
        }
        System.out.println("resultat : "+resultat);
    }

    public static String replaceLastOccurrence(String original, String target, String replacement) {
        int lastIndex = original.lastIndexOf(target);
        if (lastIndex == -1) {
            return original; // Target string not found
        }
        // Build the new string
        return original.substring(0, lastIndex)
                + replacement
                + original.substring(lastIndex + target.length());
    }
}

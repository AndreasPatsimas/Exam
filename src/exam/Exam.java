/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author andre
 */
public class Exam {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        String output;
        
        System.out.println("Εισάγετε το όνομα του αρχείου.");
        String fileName = sc.next();
        System.out.println("Εισάγετε τύπο ερωτήματος.");
        int choice = menuChoice();
        
        if(choice == 1)
            output =    "<html>\n" +
                        "<head>\n" +
                        "<title>παράδειγμα 3.β - συμπλήρωση κενών</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "β. Ο μπαμπάς έδωσε σε εμένα και την αδερφή μου 56€ και μας είπε να τα μοιραστούμε. Πόσα\n" +
                        "€ πήρε ο καθένας μας;<br>\n" +
                        "<form name=\"f1\" method=\"get\" action=\"ActionT01.asp\">\n" +
                        "Το μισό του 50 είναι <input type=text name=\"value01\"> και το μισό του 6 είναι <input\n" +
                        "type=text name=\"value02\">.\n" +
                        "Αρα το μισό του 56 είναι <input type=text name=\"value03\"> + <input type=text\n" +
                        "name=\"value04\"> = <input type=text name=\"value05\">.<br>\n" +
                        "Η αδερφή μου κι εγώ πήραμε από <input type=text name=\"value06\"> ευρώ ο καθένας.<br>\n" +
                        "<input type=submit value=\"προσδιορίστε\">\n" +
                        "</form>\n" +
                        "</body>\n" +
                        "</html>";
        
        else
            output =    "<html>\n" +
                        "<head>\n" +
                        "<title>παράδειγμα 8 - Πολλαπλών επιλογών με μοναδική σωστή απάντηση (radio\n" +
                        "buttons)</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "Ο Γιώργος έχει 52 βόλους, η Μαρία έχει 30 κι ο Μάνος έχει 24. Πόσους βόλους έχουν όλοι\n" +
                        "μαζί;\n" +
                        "<form name=\"f1\" method=\"get\" action=\"ActionT02.asp\">\n" +
                        "Ο Γιώργος έχει 52 βόλους, η Μαρία έχει 30 κι ο Μάνος έχει 24. Πόσους βόλους έχουν όλοι\n" +
                        "μαζί;<br>\n" +
                        "<input type=radio name=\"variable\" value=\"106\">106<br>\n" +
                        "<input type=radio name=\"variable\" value=\"96\">96<br>\n" +
                        "<input type=radio name=\"variable\" value=\"86\">86<br>\n" +
                        "<input type=radio name=\"variable\" value=\"76\">76<br>" +
                        "<input type=submit value=\"προσδιορίστε\">\n" +
                        "</form>\n" +
                        "</body>\n" +
                        "</html>";
        
        String dirName = createDirectory();
        
        File file = new File("C:/" + dirName + "/" + fileName);
        
        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
                FileWriter myWriter = new FileWriter(file.getAbsolutePath());
                myWriter.write(output);
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
                System.out.println(output);
            } else {
                System.out.println("File already exists.");
            }
        } 
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
  
    }
    
    private static int menuChoice(){
            
        Scanner scanner = new Scanner(System.in);

        int choice = 0;

        while (choice < 1 || choice > 2) {
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                scanner.next();
                System.out.println("Μη έγκυρη τιμή");
            }
            if (choice < 1 || choice > 7) {
                System.out.println("Εισάγετε επιλογή [1-2] :");
            }
        }

        return choice;
    }
    
    private static String createDirectory(){
        File examDir = new File("C:/exams");

        // if the directory does not exist, create it
        if (!examDir.exists()) {
            System.out.println("creating directory: " + examDir.getName());
            boolean result = false;

            try{
                examDir.mkdir();
                result = true;
            } 
            catch(Exception e){
                e.printStackTrace();
            }        
            if(result) {    
                System.out.println("DIR created");  
            }
        }
        
        return examDir.getName();
    }
}

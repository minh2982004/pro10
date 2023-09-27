
import j1.s.p0025.Manager;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Main {

    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            int countLine = Manager.countLine();
            int count = 1;
            br = new BufferedReader(new FileReader(new File("C:\\Users\\Pc\\Documents\\NetBeansProjects\\J1.S.P0025\\src\\j1\\s\\p0025\\input.txt")));
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\Pc\\Documents\\NetBeansProjects\\J1.S.P0025\\src\\j1\\s\\p0025\\ouput.txt", true)));
            String line;
           
            while ((line = br.readLine()) != null) {
           
                if (Manager.isLineEmpty(line)) {
                    continue;
                }
                line = Manager.formatOneSpace(line);
                line = Manager.formatSpecialCharacters(line);
                line = Manager.afterDotUpperCase(line);
                line = Manager.noSpaceQuotes(line);
                line = Manager.firstUpercase(line);
                line = Manager.lastAddDot(line);
                pw.print(line);
                if (count < countLine) {
                    pw.print(System.getProperty("line.separator"));
                }
                count++;
            }
            br.close();
            pw.close();
            System.out.println("Normalize successful.");
        } catch (FileNotFoundException ex) {
            System.err.println("Can't not found");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
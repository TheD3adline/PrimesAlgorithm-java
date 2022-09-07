import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        int[] primes = new int[50];
        int num = 3;
        boolean flip = true;

        for(int i = 2, x = 0; x < 50;) {
            if(i == 2) {
                primes[x] = 2;
                x++;
                i++;
            } else if(i > 2) {
                for(int j = 2; j <= Math.sqrt(num); j++) {
                    if(num % j == 0) {
                        flip = false;
                        break;
                    }
                }
                if(flip) {
                    primes[x] = num;
                    x++;
                    i++;
                }
                flip = true;
                num++;
            }
        }

        createFile();
        writeFile(primes);
    }
    public static void createFile() {
        try {
            File output = new File("C:\\Users\\micha\\Desktop\\first-primes.txt");
            if(output.createNewFile()) {
                System.out.println("File created: " + output.getName());
            } else {
                System.out.println("File already exists");
            }
        } catch(IOException e) {
            System.out.println("Unknown exception");
            e.printStackTrace();
        }
    }
    public static void writeFile(int[] primes) {
        try {
            FileWriter writeToFile = new FileWriter("C:\\Users\\micha\\Desktop\\first-primes.txt");
            for(int i = 0; i < 50; i++) {
                writeToFile.write(primes[i] + "\n" + "");
            }
            writeToFile.close();
            System.out.println("Successfully written to file");
        } catch(IOException e) {
            System.out.println("Unknown exception");
            e.printStackTrace();
        }
    }
}
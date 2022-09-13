import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        createFile();
        writeFile(calcPrimes(50));

    }

    public static int[] calcPrimes(int count) {
        int[] primesArr = new int[count];
        int num = 3;
        boolean flip = true;
        for(int i = 2, index = 0; index < count;) {
            if(i == 2) {
                primesArr[index] = 2;
                index++;
                i++;
            } else if(i > 2) {
                for(int j = 2; j <= Math.sqrt(num); j++) {
                    if(num % j == 0) {
                        flip = false;
                        break;
                    }
                }
                if(flip) {
                    primesArr[index] = num;
                    index++;
                    i++;
                }
                flip = true;
                num++;
            }
        }
        return primesArr;
    }

    public static void createFile() {
        try {
            File output = new File("output\\primes.txt");
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

    public static void writeFile(int[] primesArr) {
        try {
            FileWriter writeToFile = new FileWriter("output\\primes.txt");
            for(int index = 0; index < primesArr.length; index++) {
                writeToFile.write(primesArr[index] + "\n" + "");
            }
            writeToFile.close();
            System.out.println("Successfully written to file");
        } catch(IOException e) {
            System.out.println("Unknown exception");
            e.printStackTrace();
        }
    }
}
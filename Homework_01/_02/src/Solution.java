import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'sumOfNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER size as parameter.
     */

    public static int sumOfNumbers(int size) {
        int sum = 0;

        if (size < 1 || size > 9) {
            return 0;
        }

        for (int i = 1; i < size; i++) {
            for (int j = i; j <= size; j++) {
                sum = sum + (j * 2);
            }
        }

        sum = sum * 2;
        sum = sum + (size * 2);

        return sum;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
//        System.out.println(Result.sumOfNumbers(Integer.parseInt(new Scanner(System.in).nextLine())));

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int size = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.sumOfNumbers(size);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
import java.io.*;
import java.util.Scanner;

class Result {
    public static int countNumbers(int bottom, int top, int difference) {
        int result = 0;

        for (int i = bottom; i <= top; i++) {
            if (checkNumber(i, difference)) {
                result++;
            }
        }

        return result;
    }

    private static boolean checkNumber(int number, int difference) {
        int shiftedNumber = number;
        int firstDigit = 0;

        int degree = (int)Math.log10(number);
        int modPow = (int)Math.pow(10, degree);

        if (number >= 9) {
            firstDigit = (number / (modPow));
            shiftedNumber = (shiftedNumber % modPow) * 10 + firstDigit;
        }

        return shiftedNumber - difference > number;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
//        int bottom = Integer.parseInt(scanner.nextLine());
//        int top = Integer.parseInt(scanner.nextLine());
//        int difference = Integer.parseInt(scanner.nextLine());
//
//        int result = Result.countNumbers(bottom, top, difference);
//        System.out.println(result);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int bottom = Integer.parseInt(bufferedReader.readLine().trim());
        int top = Integer.parseInt(bufferedReader.readLine().trim());
        int difference = Integer.parseInt(bufferedReader.readLine().trim());

        int result = 0;

        if (bottom >= 0 && top >= 0) {
            result = Result.countNumbers(bottom, top, difference);
        }

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
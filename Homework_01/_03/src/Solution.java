import java.io.*;
import java.time.LocalDate;
import java.math.*;
import java.security.*;
import java.text.*;
import java.time.Period;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

class Manager {
    String name;
    LocalDate hireDate;

    public Manager(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getHireDate() {
        return String.format("%02d-%02d-%02d", hireDate.getYear(), hireDate.getMonthValue(), hireDate.getDayOfMonth());
    }

    public void setHireDate(int year, int month, int day) {
        LocalDate hireDate = LocalDate.of(year, month, day);

        if (hireDate.isAfter(LocalDate.now())) {
            this.hireDate = LocalDate.of(2020, 1, 1);
        } else {
            this.hireDate = hireDate;
        }
    }

    public int numberOfYearsInCompanyTill(int year, int month, int day) {
        LocalDate date = LocalDate.of(year, month, day);

        int result = Period.between(hireDate, date).getYears();

        return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
//
//        String nameTest = scanner.nextLine();
//
//        int hYear = Integer.parseInt(scanner.nextLine());
//        int hMonth = Integer.parseInt(scanner.nextLine());
//        int hDay = Integer.parseInt(scanner.nextLine());
//
//        int cYear = Integer.parseInt(scanner.nextLine());
//        int cMonth = Integer.parseInt(scanner.nextLine());
//        int cDay = Integer.parseInt(scanner.nextLine());
//
//        Manager manager = new Manager(nameTest);
//        manager.setHireDate(hYear, hMonth, hDay);
//
//        System.out.println(manager.getHireDate());
//        System.out.println(manager.numberOfYearsInCompanyTill(cYear, cMonth, cDay));

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String name = bufferedReader.readLine();

        int hiringYear = Integer.parseInt(bufferedReader.readLine().trim());

        int hiringMonth = Integer.parseInt(bufferedReader.readLine().trim());

        int hiringDay = Integer.parseInt(bufferedReader.readLine().trim());

        int currentYear = Integer.parseInt(bufferedReader.readLine().trim());

        int currentMonth = Integer.parseInt(bufferedReader.readLine().trim());

        int currentDay = Integer.parseInt(bufferedReader.readLine().trim());

        Manager manager = new Manager(name);
        manager.setHireDate(hiringYear, hiringMonth, hiringDay);

        System.out.println(manager.getHireDate());
        System.out.println(manager.numberOfYearsInCompanyTill(currentYear, currentMonth, currentDay));

        // Create an object of type Manager. Use one parameter constructor with argument name: Manager(name)

        // Call the set method to set the hiring date of Ivan. Pass year, month, and day as parameters: setHiringDate(LocalDate.of(hiringYear, hiringMonth, hiringDay))

        // Print on the console the result of getting the hiring date

        // Print on the console the result of calling numberOfYearsInCompanyTill() method. The method has to be called with a parameter of type LocalDate using currentYear, currentMonth, currentDay: numberOfYearsInCompanyTill(LocalDate.of(currentYear, currentMonth, currentDay))

        bufferedReader.close();
    }
}
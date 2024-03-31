import company.Company;
import company.ContractType;
import company.Employee;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String companyName = bufferedReader.readLine();

        int maxNumberOfEmployees = Integer.parseInt(bufferedReader.readLine().trim());

        List<Double> minSalaryList = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Double::parseDouble)
                .collect(toList());

        List<String> namesList = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(toList());

        List<Integer> workedHoursList = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<String> contractTypeList = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(toList());

        List<Double> additionalSalaryList = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Double::parseDouble)
                .collect(toList());

        String contractType = bufferedReader.readLine();

        double increasePercentage = Double.parseDouble(bufferedReader.readLine().trim());

        // Set the min salary per hour, that depends on the contract type. Use the values in the minSalaryList: the first value is for PERMANENT, the second is for PART_TIME, the third is for TRAINEE
        ContractType.PERMANENT.setMinSalary(BigDecimal.valueOf(minSalaryList.get(0)));
        ContractType.PART_TIME.setMinSalary(BigDecimal.valueOf(minSalaryList.get(1)));
        ContractType.TRAINEE.setMinSalary(BigDecimal.valueOf(minSalaryList.get(2)));

        // Create company by using companyName and maxNumberOfEmployees
        Company company = new Company(companyName, maxNumberOfEmployees);

        // Create 6 employees by using the values in the namesList, workedHoursList, contractTypeList, and additionalSalaryList. Example for creating the first employee:  Employee employee1 = new Employee(namesList.get(0), workedHoursList.get(0), BigDecimal.valueOf(additionalSalaryList.get(0)), ContractType.valueOf(contractTypeList.get(0)));
        Employee employee0 = new Employee(0, namesList.get(0), workedHoursList.get(0), ContractType.valueOf(contractTypeList.get(0)), BigDecimal.valueOf(additionalSalaryList.get(0)));
        Employee employee1 = new Employee(1, namesList.get(1), workedHoursList.get(1), ContractType.valueOf(contractTypeList.get(1)), BigDecimal.valueOf(additionalSalaryList.get(1)));
        Employee employee2 = new Employee(2, namesList.get(2), workedHoursList.get(2), ContractType.valueOf(contractTypeList.get(2)), BigDecimal.valueOf(additionalSalaryList.get(2)));
        Employee employee3 = new Employee(3, namesList.get(3), workedHoursList.get(3), ContractType.valueOf(contractTypeList.get(3)), BigDecimal.valueOf(additionalSalaryList.get(3)));
        Employee employee4 = new Employee(4, namesList.get(4), workedHoursList.get(4), ContractType.valueOf(contractTypeList.get(4)), BigDecimal.valueOf(additionalSalaryList.get(4)));
        Employee employee5 = new Employee(5, namesList.get(5), workedHoursList.get(5), ContractType.valueOf(contractTypeList.get(5)), BigDecimal.valueOf(additionalSalaryList.get(5)));

        // Hire all the 6 employees to work at the company
        company.hireEmployee(employee0);
        company.hireEmployee(employee1);
        company.hireEmployee(employee2);
        company.hireEmployee(employee3);
        company.hireEmployee(employee4);
        company.hireEmployee(employee5);

        // Print the result of calling the method averageSalary()
        System.out.println(company.averageSalary());

        // Increase the additional salary per hour, by calling the method increaseSalaries(). Use increasePercentage as an argument: company.increaseSalaries(BigDecimal.valueOf(increasePercentage));
        company.increaseSalaries(BigDecimal.valueOf(increasePercentage));

        // Print the result of calling the method averageSalary(), after increasing the additional salary per hour of all employees.
        System.out.println(company.averageSalary());

        // Print the result of calling the method averageSalaryByType(). Use the string contractType with ContractType.valueOf() method to pass it as argument: System.out.println(company.averageSalaryByType(ContractType.valueOf(contractType)));
        System.out.println(company.averageSalaryPerContractType(ContractType.valueOf(contractType)));

        bufferedReader.close();
    }
}

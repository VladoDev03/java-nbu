package company;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name;
    private int maxEmployeesCount;
    private List<Employee> employees;

    public Company(String name, int maxEmployeesCount) {
        setName(name);
        setMaxEmployeesCount(maxEmployeesCount);
        this.employees = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxEmployeesCount(int maxEmployeesCount) {
        if (maxEmployeesCount < 0) {
            maxEmployeesCount = 0;
        }

        this.maxEmployeesCount = maxEmployeesCount;
    }

    public boolean hireEmployee(Employee employee) {
        if (this.employees.size() >= this.maxEmployeesCount || this.employees.contains(employee)) {
            return false;
        }

        return this.employees.add(employee);
    }

    public boolean fireEmployee(Employee employee) {
        if (!this.employees.contains(employee)) {
            return false;
        }

        return this.employees.remove(employee);
    }

    public BigDecimal averageSalary() {
        if (maxEmployeesCount <= 0) {
            return BigDecimal.ZERO;
        }

        BigDecimal averageSalary = BigDecimal.ZERO;

        for (Employee employee : this.employees) {
            averageSalary = averageSalary.add(employee.salary());
        }

        averageSalary = averageSalary.divide(BigDecimal.valueOf(this.employees.size()), 2, RoundingMode.HALF_UP);

        return averageSalary;
    }

    public void increaseSalaries(BigDecimal percentage) {
        if (percentage.compareTo(BigDecimal.ZERO) < 0) {
            return;
        }

        for (Employee employee : this.employees) {
            employee.increaseSalary(percentage);
        }
    }

    public BigDecimal averageSalaryPerContractType(ContractType contractType) {
        if (maxEmployeesCount <= 0) {
            return BigDecimal.ZERO;
        }

        BigDecimal averageSalary = BigDecimal.ZERO;
        int employeesWithContractType = 0;

        for (Employee employee : this.employees) {
            if (employee.getContractType().equals(contractType)) {
                averageSalary = averageSalary.add(employee.salary());
                employeesWithContractType++;
            }
        }

        if (averageSalary.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }

        averageSalary = averageSalary.divide(BigDecimal.valueOf(employeesWithContractType), 2, RoundingMode.HALF_UP);

        return averageSalary;
    }
}

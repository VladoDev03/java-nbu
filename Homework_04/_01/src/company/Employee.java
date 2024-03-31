package company;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Employee {
    private long id;
    private String name;
    private int hoursPerMonth;
    private ContractType contractType;
    private BigDecimal extraSalary;

    public Employee(long id, String name, int hoursPerMonth, ContractType contractType, BigDecimal extraSalary) {
        this.id = id;
        this.name = name;
        this.hoursPerMonth = hoursPerMonth;
        this.contractType = contractType;
        this.extraSalary = extraSalary;
    }

    public ContractType getContractType() {
        return contractType;
    }

    public void setExtraSalary(BigDecimal extraSalary) {
        if (extraSalary.compareTo(BigDecimal.ZERO) < 0) {
            this.extraSalary = BigDecimal.ONE;
        } else {
            this.extraSalary = extraSalary;
        }
    }

    public void setHoursPerMonth(int hoursPerMonth) {
        if (hoursPerMonth <= 0) {
            hoursPerMonth = 1;
        }

        this.hoursPerMonth = hoursPerMonth;
    }

    public BigDecimal salary() {
        return contractType.getMinSalary().add(extraSalary).multiply(BigDecimal.valueOf(hoursPerMonth));
    }

    public void increaseSalary(BigDecimal percentage) {
        this.extraSalary = this.extraSalary.add(this.extraSalary.multiply(percentage.divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP)));
    }
}

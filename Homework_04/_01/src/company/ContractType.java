package company;

import java.math.BigDecimal;

public enum ContractType {
    PERMANENT(BigDecimal.ONE), PART_TIME(BigDecimal.ONE), TRAINEE(BigDecimal.ONE);
    private BigDecimal minSalary;

    ContractType(BigDecimal minSalary) {
        setMinSalary(minSalary);
    }

    public BigDecimal getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(BigDecimal minSalary) {
        if (minSalary.compareTo(BigDecimal.ZERO) < 0) {
            return;
        }

        this.minSalary = minSalary;
    }
}

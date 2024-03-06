import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

class Studio {
    private long id;
    private BigDecimal hourlyPrice;
    private int maxHours;
    private int hours;
    private static BigDecimal minPrice;
    private static BigDecimal euro;

    public Studio(long id, int maxHours) {
        setId(id);
        setMaxHours(maxHours);
    }

    public long getId() {
        return id;
    }

    public BigDecimal getHourlyPrice() {
        return hourlyPrice;
    }

    public int getMaxHours() {
        return maxHours;
    }

    public int getHours() {
        return hours;
    }

    public static BigDecimal getMinPrice() {
        return minPrice;
    }

    public static BigDecimal getEuro() {
        return euro;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMaxHours(int maxHours) {
        if (maxHours < 0 || maxHours > 24) {
            this.maxHours = 24;
        } else {
            this.maxHours = maxHours;
        }
    }

    public static void setMinPrice(BigDecimal minPrice) {
        if (minPrice.doubleValue() < 0) {
            Studio.minPrice = BigDecimal.valueOf(0);
            return;
        }

        Studio.minPrice = minPrice;
    }

    public void setHourlyPrice(BigDecimal hourlyPrice) {
        if (hourlyPrice.doubleValue() < Studio.minPrice.doubleValue()) {
            this.hourlyPrice = Studio.minPrice;
            return;
        }

        this.hourlyPrice = hourlyPrice;
    }

    public void setHours(int hours) {
        if (hours > maxHours) {
            this.hours = maxHours;
        } else if (hours < 0 || hours > 24) {
            this.hours = 24;
        } else {
            this.hours = hours;
        }
    }

    public static void setEuro(BigDecimal euro) {
        Studio.euro = euro;
    }

    public BigDecimal calculateRevenueEuro() {
        return calculateRevenueLv().multiply(euro);
    }

    public BigDecimal calculateRevenueLv() {
        return hourlyPrice.multiply(BigDecimal.valueOf(hours));
    }

    public long compareTo(Studio other) {
        return this.hourlyPrice.doubleValue() > other.hourlyPrice.doubleValue() ? this.id : other.id;
    }

    public boolean compareRevenue(Studio other) {
        return this.calculateRevenueLv().doubleValue() > other.calculateRevenueLv().doubleValue();
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        long id = Long.parseLong(bufferedReader.readLine().trim());
        int maxWorkingHours = Integer.parseInt(bufferedReader.readLine().trim());
        double minPricePerHour = Double.parseDouble(bufferedReader.readLine().trim());
        double currencyEuro = Double.parseDouble(bufferedReader.readLine().trim());
        double pricePerHour = Double.parseDouble(bufferedReader.readLine().trim());
        int workedHours = Integer.parseInt(bufferedReader.readLine().trim());

        Studio.setMinPrice(BigDecimal.valueOf(minPricePerHour));
        Studio.setEuro(BigDecimal.valueOf(currencyEuro));

        Studio studio1= new Studio(id, maxWorkingHours);
        studio1.setHourlyPrice(BigDecimal.valueOf(pricePerHour));
        studio1.setHours(workedHours);

        System.out.println(studio1.calculateRevenueLv());
        System.out.println(studio1.calculateRevenueEuro());

        long id2 = Long.parseLong(bufferedReader.readLine().trim());
        int maxWorkingHours2 = Integer.parseInt(bufferedReader.readLine().trim());
        double pricePerHour2 = Double.parseDouble(bufferedReader.readLine().trim());
        int workedHours2 = Integer.parseInt(bufferedReader.readLine().trim());

        Studio studio2= new Studio(id2, maxWorkingHours2);
        studio2.setHourlyPrice(BigDecimal.valueOf(pricePerHour2));
        studio2.setHours(workedHours2);

        System.out.println(studio1.compareTo(studio2));
        System.out.println(studio1.compareRevenue(studio2));

        bufferedReader.close();
    }
}
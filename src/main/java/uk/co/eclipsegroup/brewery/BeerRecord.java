package uk.co.eclipsegroup.brewery;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BeerRecord {
    private final Beer beer;
    private final long count;
    private final BigDecimal price;

    public BeerRecord(Beer beer, long count) {
        this.beer = beer;
        this.count = count;
        this.price = BigDecimal.valueOf(beer.getPrice())
                .multiply(BigDecimal.valueOf(count))
                .setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public String toString() {
        return "BeerRecord{" +
                "beer='" + beer.getName() + '\'' +
                ", count=" + count +
                ", price=" + price +
                '}';
    }
}

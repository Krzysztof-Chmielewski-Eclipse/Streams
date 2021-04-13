package uk.co.eclipsegroup.brewery;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BeerRecord {
    private final Beer beer;
    private final long count;
    private final BigDecimal price;

    public BeerRecord(Beer beer, Long count) {
        this.beer = beer;
        this.count = count;
        price = BigDecimal.valueOf(count)
                .multiply(BigDecimal.valueOf(beer.getPrice()))
                .setScale(2, RoundingMode.HALF_UP);
    }

    public Beer getBeer() {
        return beer;
    }

    public long getCount() {
        return count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "BeerRecord{" +
                "name='" + beer.getName() + '\'' +
                ", count=" + count +
                ", price=" + price +
                '}';
    }
}

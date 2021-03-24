package uk.co.eclipsegroup.brewery;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_UP;

public class BeerStats {
    private final Beer beer;
    private final long sold;
    private final BigDecimal earned;

    public BeerStats(Beer beer, long sold) {
        this.beer = beer;
        this.sold = sold;
        this.earned = BigDecimal
                .valueOf(beer.getPrice())
                .setScale(2, HALF_UP)
                .multiply(BigDecimal.valueOf(sold));
    }

    public Beer getBeer() {
        return beer;
    }

    public long getSold() {
        return sold;
    }

    public BigDecimal getEarned() {
        return earned;
    }

    @Override
    public String toString() {
        return "BeerStats{" +
                "beer=" + beer +
                ", sold=" + sold +
                ", earned=" + earned +
                '}';
    }
}

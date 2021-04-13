package uk.co.eclipsegroup.brewery;

import java.util.Set;
import java.util.stream.Collectors;

public class Bar {
    private final SellingRecord sellingRecord;

    public Bar(SellingRecord sellingRecord) {
        this.sellingRecord = sellingRecord;
    }

    public Set<BeerRecord> getBeersStatistics() {
        return sellingRecord.soldBeers().stream()
                .filter(Beer::isAlcoholic)
                .collect(Collectors.groupingBy(b -> b, Collectors.counting()))
                .entrySet().stream()
                .map(e -> new BeerRecord(e.getKey(), e.getValue()))
                .collect(Collectors.toSet());
    }
}

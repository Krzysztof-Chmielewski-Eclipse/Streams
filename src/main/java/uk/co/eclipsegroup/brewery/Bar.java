package uk.co.eclipsegroup.brewery;

import java.util.Map;
import java.util.stream.Collectors;

public class Bar {
    private final SellingRecord sellingRecord;

    public Bar(SellingRecord sellingRecord) {
        this.sellingRecord = sellingRecord;
    }

    public Map<Beer, BeerRecord> getBeersStatistics() {
        var result = setupStatistics();
        updateCountAndPrice(result);
        return result;
    }

    private Map<Beer, BeerRecord> setupStatistics() {
        return sellingRecord.menu().stream()
                .filter(Beer::isAlcoholic)
                .collect(Collectors.toMap(beer -> beer, BeerRecord::new));
    }

    private void updateCountAndPrice(Map<Beer, BeerRecord> result) {
        sellingRecord.soldBeers().stream()
                .filter(Beer::isAlcoholic)
                .map(result::get)
                .forEach(BeerRecord::addOne);
    }
}

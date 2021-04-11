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
        removeNonAlcoholic(result);
        return result;
    }

    private Map<Beer, BeerRecord> setupStatistics() {
        return sellingRecord.menu().stream()
                .collect(Collectors.toMap(beer -> beer, BeerRecord::new));
    }

    private void updateCountAndPrice(Map<Beer, BeerRecord> result) {
        sellingRecord.soldBeers().stream()
                .map(result::get)
                .forEach(BeerRecord::addOne);
    }

    private void removeNonAlcoholic(Map<Beer, BeerRecord> result) {
        result.entrySet().removeIf(entry -> !entry.getKey().isAlcoholic());
    }
}

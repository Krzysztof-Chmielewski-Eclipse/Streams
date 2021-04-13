package uk.co.eclipsegroup.brewery;

import java.util.Map;
import java.util.stream.Collectors;

public class Bar {
    private final SellingRecord sellingRecord;

    public Bar(SellingRecord sellingRecord) {
        this.sellingRecord = sellingRecord;
    }

    public Map<Beer, BeerRecord> getBeersStatistics() {
        var beerRecords = setupInitialStatistics();
        updateCountAndPrice(beerRecords);
        removeNonAlcoholicBeers(beerRecords);
        return beerRecords;
    }

    private Map<Beer, BeerRecord> setupInitialStatistics() {
        return sellingRecord.menu().stream()
                .collect(Collectors.toMap(b -> b, BeerRecord::new));
    }

    private void updateCountAndPrice(Map<Beer, BeerRecord> result) {
        sellingRecord.soldBeers().stream()
                .map(result::get)
                .forEach(BeerRecord::addOne);
    }

    private void removeNonAlcoholicBeers(Map<Beer, BeerRecord> result) {
        result.entrySet().removeIf(b -> !b.getKey().isAlcoholic());
    }
}

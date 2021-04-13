package uk.co.eclipsegroup.brewery;

import java.util.HashMap;
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
                .collect(Collectors.toMap(b -> b, b -> new BeerRecord(b.getName())));
    }

    private void updateCountAndPrice(Map<Beer, BeerRecord> result) {
        for (Beer soldBeer : sellingRecord.soldBeers()) {
            var beerRecord = result.get(soldBeer);
            beerRecord.setCount(beerRecord.getCount() + 1);
            beerRecord.setPrice(beerRecord.getCount() * soldBeer.getPrice());
        }
    }

    private void removeNonAlcoholicBeers(Map<Beer, BeerRecord> result) {
        result.entrySet().removeIf(b -> !b.getKey().isAlcoholic());
    }
}

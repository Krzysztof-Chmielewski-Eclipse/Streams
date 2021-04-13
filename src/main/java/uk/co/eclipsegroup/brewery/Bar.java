package uk.co.eclipsegroup.brewery;

import java.util.HashMap;
import java.util.Map;

public class Bar {
    private final SellingRecord sellingRecord;

    public Bar(SellingRecord sellingRecord) {
        this.sellingRecord = sellingRecord;
    }

    public Map<Beer, BeerRecord> getBeersStatistics() {
        var result = new HashMap<Beer, BeerRecord>();
        setupInitialStatistics(result);
        updateCountAndPrice(result);
        removeNonAlcoholicBeers(result);
        return result;
    }

    private void setupInitialStatistics(Map<Beer, BeerRecord> result) {
        for (Beer soldBeer : sellingRecord.menu()) {
            result.put(soldBeer, new BeerRecord(soldBeer.getName()));
        }
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

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
                .collect(Collectors.toMap(beer -> beer, beer -> new BeerRecord(beer.getName())));
    }

    private void updateCountAndPrice(Map<Beer, BeerRecord> result) {
        for (Beer soldBeer : sellingRecord.soldBeers()) {
            var beerRecord = result.get(soldBeer);
            beerRecord.setCount(beerRecord.getCount() + 1);
            beerRecord.setPrice(beerRecord.getPrice() + soldBeer.getPrice());
        }
    }

    private void removeNonAlcoholic(Map<Beer, BeerRecord> result) {
        result.entrySet().removeIf(entry -> !entry.getKey().isAlcoholic());
    }
}

package uk.co.eclipsegroup.brewery;

import java.util.HashMap;
import java.util.Map;

public class Bar {
    private final SellingRecord sellingRecord;

    public Bar(SellingRecord sellingRecord) {
        this.sellingRecord = sellingRecord;
    }

    public Map<Beer, BeerRecord> getBeersStatistics() {
        var beers = setupBeersStatistics();
        updateCountAndPriceOf(beers);
        removeNonAlcoholicBeersFrom(beers);

        return beers;
    }

    private Map<Beer, BeerRecord> setupBeersStatistics() {
        var beers = new HashMap<Beer, BeerRecord>();
        for (Beer soldBeer : sellingRecord.menu()) {
            beers.put(soldBeer, new BeerRecord(soldBeer.getName()));
        }
        return beers;
    }

    private void updateCountAndPriceOf(Map<Beer, BeerRecord> beers) {
        for (Beer soldBeer : sellingRecord.soldBeers()) {
            var beerRecord = beers.get(soldBeer);
            beerRecord.setCount(beerRecord.getCount() + 1);
            beerRecord.setPrice(beerRecord.getPrice() + soldBeer.getPrice());
        }
    }

    private void removeNonAlcoholicBeersFrom(Map<Beer, BeerRecord> beers) {
        var iterator = beers.entrySet().iterator();
        while (iterator.hasNext()) {
            var next = iterator.next();
            if (!next.getKey().isAlcoholic()) {
                iterator.remove();
            }
        }
    }
}

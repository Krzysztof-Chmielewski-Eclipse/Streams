package uk.co.eclipsegroup.brewery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bar {
    private final SellingRecord sellingRecord;

    public Bar(SellingRecord sellingRecord) {
        this.sellingRecord = sellingRecord;
    }

    public Map<Beer, List<Object>> getBeersStatistics() {
        var beers = setupBeersStatistics();
        updateCountAndPriceOf(beers);
        removeNonAlcoholicBeersFrom(beers);

        return beers;
    }

    private Map<Beer, List<Object>> setupBeersStatistics() {
        var beers = new HashMap<Beer, List<Object>>();
        for (Beer soldBeer : sellingRecord.menu()) {
            var list = new ArrayList<>();
            beers.put(soldBeer, list);
            list.add(soldBeer.getName());
            list.add(0);
            list.add(0f);
        }
        return beers;
    }

    private void updateCountAndPriceOf(Map<Beer, List<Object>> beers) {
        for (Beer soldBeer : sellingRecord.soldBeers()) {
            var statistics = beers.get(soldBeer);
            statistics.set(1, (Integer) statistics.get(1) + 1);
            statistics.set(2, (Float) statistics.get(2) + soldBeer.getPrice());
        }
    }

    private void removeNonAlcoholicBeersFrom(Map<Beer, List<Object>> beers) {
        var iterator = beers.entrySet().iterator();
        while (iterator.hasNext()) {
            var next = iterator.next();
            if (!next.getKey().isAlcoholic()) {
                iterator.remove();
            }
        }
    }
}

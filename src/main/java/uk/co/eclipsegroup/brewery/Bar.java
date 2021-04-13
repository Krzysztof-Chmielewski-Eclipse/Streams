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
        var result = new HashMap<Beer, List<Object>>();
        setupInitialStatistics(result);
        updateCountAndPrice(result);
        removeNonAlcoholicBeers(result);
        return result;
    }

    private void setupInitialStatistics(HashMap<Beer, List<Object>> result) {
        for (Beer soldBeer : sellingRecord.menu()) {
            var list = new ArrayList<>();
            result.put(soldBeer, list);
            list.add(soldBeer.getName());
            list.add(0);
            list.add(0f);
        }
    }

    private void updateCountAndPrice(HashMap<Beer, List<Object>> result) {
        for (Beer soldBeer : sellingRecord.soldBeers()) {
            var statistics = result.get(soldBeer);
            statistics.set(1, (Integer) statistics.get(1) + 1);
            statistics.set(2, (Float) statistics.get(2) + soldBeer.getPrice());
        }
    }

    private void removeNonAlcoholicBeers(HashMap<Beer, List<Object>> result) {
        var iterator = result.entrySet().iterator();
        while (iterator.hasNext()) {
            var next = iterator.next();
            if (!next.getKey().isAlcoholic()) {
                iterator.remove();
            }
        }
    }
}

package uk.co.eclipsegroup.brewery;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Bar {
    private final SellingRecord sellingRecord;

    public Bar(SellingRecord sellingRecord) {
        this.sellingRecord = sellingRecord;
    }

    public Set<BeerRecord> getBeersStatistics() {
        var beers = setupBeersStatistics();
        updateCountAndPriceOf(beers);
        return removeNonAlcoholicBeersFrom(beers);
    }

    private Set<BeerRecord> setupBeersStatistics() {
        var beers = new HashSet<BeerRecord>();
        for (Beer soldBeer : sellingRecord.menu()) {
            beers.add(new BeerRecord(soldBeer.getName(), soldBeer.isAlcoholic()));
        }
        return beers;
    }

    private void updateCountAndPriceOf(Set<BeerRecord> beers) {
        for (Beer soldBeer : sellingRecord.soldBeers()) {
            var beerRecord = beers.stream().filter(beer -> beer.getName().equals(soldBeer.getName())).findFirst().get();
            beerRecord.setCount(beerRecord.getCount() + 1);
            beerRecord.setPrice(beerRecord.getPrice() + soldBeer.getPrice());
        }
    }

    private Set<BeerRecord> removeNonAlcoholicBeersFrom(Set<BeerRecord> beers) {
        return beers.stream().filter(BeerRecord::isAlcoholic).collect(Collectors.toSet());
    }
}

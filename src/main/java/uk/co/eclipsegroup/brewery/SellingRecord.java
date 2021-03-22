package uk.co.eclipsegroup.brewery;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

class SellingRecord {
    private final Beer mankowe = new Beer("Mańkowe Extra Strong", true, 0, 9.99f);
    private final Beer chmielowe = new Beer("Chmielowe Pale Ale", true, 90, 11.99f);
    private final Beer lagerowe = new Beer("Regular Lager", true, 15, 7.99f);
    private final Beer samochodowe = new Beer("Non Alcoholic APA", false, 15, 8.99f);

    Set<Beer> menu() {
        return Set.of(mankowe, chmielowe, lagerowe, samochodowe);
    }

    List<Beer> soldBeers() {
        return Arrays.asList(
                chmielowe,
                samochodowe,
                mankowe,
                samochodowe,
                lagerowe,
                chmielowe,
                mankowe,
                lagerowe,
                lagerowe,
                chmielowe,
                chmielowe,
                lagerowe,
                mankowe,
                mankowe,
                chmielowe,
                mankowe,
                lagerowe,
                lagerowe,
                chmielowe,
                chmielowe,
                chmielowe,
                lagerowe,
                lagerowe,
                samochodowe,
                lagerowe,
                lagerowe,
                samochodowe,
                samochodowe,
                chmielowe
                );
    }
}

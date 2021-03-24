package uk.co.eclipsegroup.brewery;

import java.util.Objects;

class Beer {
    private final String name;
    private final boolean alcoholic;
    private final int ibu;
    private final float price;

    public Beer(String name, boolean alcoholic, int ibu, float price) {
        this.name = name;
        this.alcoholic = alcoholic;
        this.ibu = ibu;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public boolean isAlcoholic() {
        return alcoholic;
    }

    public int getIbu() {
        return ibu;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beer beer = (Beer) o;
        return alcoholic == beer.alcoholic &&
                ibu == beer.ibu &&
                Float.compare(beer.price, price) == 0 &&
                Objects.equals(name, beer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, alcoholic, ibu, price);
    }

    @Override
    public String toString() {
        return "Beer{" +
                "name='" + name + '\'' +
                ", alcoholic=" + alcoholic +
                ", ibu=" + ibu +
                ", price=" + price +
                '}';
    }
}

package uk.co.eclipsegroup.brewery;

import java.util.Objects;

public class BeerRecord {
    private final String name;
    private final boolean alcoholic;
    private int count;
    private float price;

    public BeerRecord(String name, boolean alcoholic) {
        this.name = name;
        this.alcoholic = alcoholic;
    }

    public boolean isAlcoholic() {
        return alcoholic;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BeerRecord that = (BeerRecord) o;
        return count == that.count && Float.compare(that.price, price) == 0 && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, count, price);
    }

    @Override
    public String toString() {
        return "BeerRecord{" +
                "name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                '}';
    }
}

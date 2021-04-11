package uk.co.eclipsegroup.brewery;

public class BeerRecord {
    private final Beer beer;
    private int count;
    private float price;

    public BeerRecord(Beer beer) {
        this.beer = beer;
    }

    public Beer getBeer() {
        return beer;
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

    public void addOne() {
        count++;
        price += beer.getPrice();
    }

    @Override
    public String toString() {
        return "BeerRecord{" +
                "beer='" + beer.getName() + '\'' +
                ", count=" + count +
                ", price=" + price +
                '}';
    }
}

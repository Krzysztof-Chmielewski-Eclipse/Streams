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

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "BeerRecord{" +
                "name='" + beer.getName() + '\'' +
                ", count=" + count +
                ", price=" + price +
                '}';
    }

    public void addOne() {
        count = count + 1;
        price = count * beer.getPrice();
    }
}

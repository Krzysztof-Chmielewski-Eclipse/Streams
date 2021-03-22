package uk.co.eclipsegroup.brewery;

public class Application {
    public static void main(String[] args) {
        var bar = new Bar(new SellingRecord());
        System.out.println(bar.getBeersStatistics());
    }
}

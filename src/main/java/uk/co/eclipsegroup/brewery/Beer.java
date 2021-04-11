package uk.co.eclipsegroup.brewery;

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
}

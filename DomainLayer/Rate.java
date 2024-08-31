package DomainLayer;

public class Rate {
    private int rating;
    private int totalRates;

    public Rate() {
        this.rating = 0;
        this.totalRates = 0;
    }

    public boolean addRate(int rate) {
        if(rate<0 || rate>5) {
            return false;
        }
        rating += rate;
        totalRates++;
        return true;
    }
    public int getRate() {
        return rating/totalRates;
    }


}

package Question3;

public class Restaurant {
    HotDrink hotDrink;

    public HotDrink getHotDrink() {
        return hotDrink;
    }

    public void setHotDrink(HotDrink hotDrink) {
        this.hotDrink = hotDrink;
    }

    public Restaurant(HotDrink hotDrink) {
        this.hotDrink = hotDrink;
    }

    public Restaurant() {

    }

    @Override
    public String toString() {
        return "Spring1.Restaurant{" +
                "hotDrink=" + hotDrink.prepareHotDrink() +
                '}';
    }


}

interface HotDrink {
    String prepareHotDrink();
}

class Tea implements HotDrink {

    public String prepareHotDrink() {

        return "Tea";

    }


}

class ExpressTea implements HotDrink {

    public String prepareHotDrink() {
        return "Express tea";
    }

}

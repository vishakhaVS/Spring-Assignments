package Question9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

public class Restaurant {


  private  HotDrink hotDrink;

        public HotDrink getHotDrink() {
            return hotDrink;
        }

      //  @Autowired
        public void setHotDrink(HotDrink hotDrink) {
            this.hotDrink = hotDrink;
        }

            @Autowired
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

    @Component
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





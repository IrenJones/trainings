package patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyFactory {

    public static void main(String[] args) {
        MyFactory mf = new MyFactory();
        mf.makeOrder();
    }

    private void makeOrder() {
        BurgerFactory df = new BurgerFactory();
        df.createCheeseburger();
        df.createHamburger();
    }

    class BurgerFactory{

        public BurgerFactory(){}
        public Burger createHamburger(){
            List<String> components = Arrays.asList("beef");
            return new Burger(components);
        }

        public Burger createCheeseburger(){
            List<String> components = Arrays.asList("beef", "cheese");
            return new Burger(components);
        }
    }

    class Burger{
        private List<String> ingredients;

        public Burger(List<String> ingr){
            this.ingredients = ingr;
        }
    }
}

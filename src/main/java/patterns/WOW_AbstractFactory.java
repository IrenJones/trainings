package patterns;

public class WOW_AbstractFactory {

    public static void main(String[] args) {
        // create location
        FactoryMaker maker = new FactoryMaker();
        AbstractCityFactory factory = maker.makeFactory(FactoryMaker.KingdomType.AL);
        TailorMaster master = factory.createTailorMaster();
        master.say();

        AbstractCityFactory factory1 = maker.makeFactory(FactoryMaker.KingdomType.HORDE);
        TailorMaster master1 = factory1.createTailorMaster();
        master1.say();
    }

}


// product
abstract class TailorMaster{

    public abstract void say();
}

class HordeTailorMaster extends TailorMaster{

    @Override public void say() {
        System.out.println("ARGH");
    }
}

class AllianceTailorMaster extends TailorMaster{

    @Override public void say() {
        System.out.println("Sir!");
    }
}

// factory
abstract class AbstractCityFactory {

    public abstract TailorMaster createTailorMaster();
}

class HordeCityFactory extends AbstractCityFactory{

    @Override public TailorMaster createTailorMaster() {
        return new HordeTailorMaster();
    }
}

class AllianceCityFactory extends AbstractCityFactory{

    @Override public TailorMaster createTailorMaster() {
        return new AllianceTailorMaster();
    }
}

// factory maker
 class FactoryMaker {

    public enum KingdomType {
        AL, HORDE
    }

    public AbstractCityFactory makeFactory(KingdomType type) {
        switch (type) {
            case AL:
                return new AllianceCityFactory();
            case HORDE:
                return new HordeCityFactory();
            default:
                throw new IllegalArgumentException("KingdomType not supported.");
        }
    }
}





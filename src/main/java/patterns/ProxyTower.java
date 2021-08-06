package patterns;

public class ProxyTower {

    public static void main(String[] args) {
        TowerProxy proxy = new TowerProxy(new HordeTower());
        proxy.getDefence();
    }
}

interface Tower{
    int getDefence();
}

class HordeTower implements Tower{

    @Override public int getDefence() {
        return 10;
    }
}

class TowerProxy implements Tower{
    private Tower basicTower;

    public TowerProxy(Tower tower){
        this.basicTower = tower;
    }

    @Override public int getDefence() {
        System.out.println("Helloo");
        return basicTower.getDefence() + 30;
    }
}

package concur;

public class SimpleThreadCreation {

    public static void main(String[] args) throws InterruptedException {
        // 1 way
        Thread.currentThread().setName("Merlin");
        Thread dragon = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ": What do you want?");
            }
        });
        System.out.println("Who is that? It's " + Thread.currentThread().getName());
        dragon.setName("Dragon");
        dragon.start();
        System.out.println("Who is that? It's " + Thread.currentThread().getName());

        Thread.sleep(1000);
        System.out.println("Who is that? It's " + Thread.currentThread().getName());

        Thread.sleep(1000);
        System.out.println("Who is that? It's " + Thread.currentThread().getName());
        // 2 way
        Sorcerer randomWizard = new Sorcerer();
        randomWizard.start();
        System.out.println("Who is that? It's " + Thread.currentThread().getName());

        Thread.sleep(1000);
        System.out.println("Who is that? It's " + Thread.currentThread().getName());
    }

    static class Sorcerer extends Thread{
        @Override
        public void run(){
            Thread.currentThread().setName("Druid");
            System.out.println(Thread.currentThread().getName() + ": What do you want?");
        }
    }
}

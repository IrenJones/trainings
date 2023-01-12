package concur;

public class ThreadSet {

    public static void main(String[] args) throws InterruptedException {
        ThreadMy s = new ThreadMy();
        System.out.println(Thread.currentThread().getName());
        s.start();

        for(int i = 0; i < 10; i++){
            System.out.println(i);
            Thread.sleep(1000);
        }
    }

}

class ThreadMy extends Thread {

    @Override
    public synchronized void start() {
        super.start();
        System.out.println(Thread.currentThread().getName() + "__________s");
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "hi");
    }
}

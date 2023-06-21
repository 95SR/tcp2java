package src.main.java.client;


class Thread1 extends Thread{

    @Override
    public void run() {
        System.out.println("thread1");
    }

}

class Thread2 extends Thread{
    @Override
    public void run() {
        System.out.println("thread2");
    }
}

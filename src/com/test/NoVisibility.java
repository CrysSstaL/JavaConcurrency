package src.com.test;

public class NoVisibility {
    private static boolean ready;
    private static int number;
    private static class ReaderThread extends Thread{
        public void run(){
            while (!ready){
                Thread.yield();
            }
            System.out.println(number);
        }
    }
    public static void main(String[] args){
        // Главный поток создает читающий поток
        new ReaderThread().start();
        // Далее устанавливается значение 42 и true
        // А читающий поток видит это и печатает 42
        // Потоки не синхронизированны поэтому возникает неоднозначность
        number = 42;
        ready = true;
    }
}

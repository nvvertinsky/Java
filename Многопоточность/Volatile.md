# Volatile

### Описание
Означает что не нужно сохранять поле класса в кеш ядра. Нужно сохранять в главную (общую) память на процессоре. 


### Проблема. 
Ниже на примере поток main может выполняться на одном ядре, а поток MyThread на втором ядре. 
У каждого ядра свой кеш. И поле класса MyThread может попасть в кеш второо ядра. А поле класса main может попасть в кеш первого ядра.
И программа продолжит выполняться даже если нажать на Enter.


### Решение проблемы
Ключевое слово volatile. Поле класса MyThread будет закешированно в общую память процессора. 
И два ядра чтобы получить значение из этой переменной, будут ходить в общую память.

### Пример

````
public class Main {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        myThread.shutdown();
    }
}

class MyThread extends Thread {
    private volatile boolean running = true;

    public void run(){
        while (running) {
            System.out.println("hello");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown() {
        this.running = false;
    }
}

````
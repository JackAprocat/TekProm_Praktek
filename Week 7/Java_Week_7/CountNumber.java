import java.util.Scanner;

class Number implements Runnable {
    private int start, end;
    private long partialSum = 0;
    private String threadName;

    public Number(int start, int end, String name) {
        this.start = start;
        this.end = end;
        this.threadName = name;
    }

    @Override
    public void run() {
        System.out.println(threadName + " sedang menjumlahkan: " + start + " sampai " + end);
        for (int i = 0; i <= end; i++) {
            partialSum += i;
        }

    }

    public long getPartialSum() {
        return partialSum;
    }
}

public class CountNumber {
    public static void main(String[] args) {
            Scanner scanner = new Scanner (System.in);

            System.out.println("Masukkan jumlah thread: ");
            int numThreads = scanner.nextInt();
            System.out.println("\nMasukkan angka akhir: ");
            int lastNumber = scanner.nextInt();

            Thread[] threads = new Thread[numThreads];
            Number[] numbers = new Number[numThreads];

            int gap = lastNumber / numThreads;
            int currentStart = 1;

            for(int i = 0; i < numThreads; i++){
                int currentEnd = (i == numThreads - 1) ? lastNumber : (currentStart + gap - 1);
                
                numbers[i] = new Number(currentStart, currentEnd, " Thread " + (i+1));

                threads[i] = new Thread(numbers[i]);

                threads[i].start();

                currentStart = currentEnd + 1;
            }

            long totalsum = 0;
            try {
                for(int i = 0; i < numThreads; i++){
                    threads[i].join();

                    totalsum += numbers[i].getPartialSum();
                }
            } catch (InterruptedException e) {
                System.out.println("Error");
            }

            System.out.println("============================");
            System.out.println("Hasil akhir penjumlahan: " + totalsum);
            System.out.println("============================");

            scanner.close();
    }
}
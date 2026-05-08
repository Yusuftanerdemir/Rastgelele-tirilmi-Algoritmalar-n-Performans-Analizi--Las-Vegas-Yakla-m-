import java.util.Random;

public class LasVegasAlgorithm {

    // İstenen koşul: Sayının 77'ye tam bölünmesi (mod 77 == 0)
    public static boolean isSpecial(int number) {
        return number % 77 == 0;
    }

    public static void main(String[] args) {
        long studentNumberSeed = 1240505041L;
        int n = 100000;
        int[] dataSet = new int[n];
        Random random = new Random(studentNumberSeed);

        // 1. Veri setinin oluşturulması ve özel eleman sayısının tespiti
        int specialElementCount = 0;
        for (int i = 0; i < n; i++) {
            dataSet[i] = random.nextInt(1000000); // 0 ile 999.999 arası sayılar
            if (isSpecial(dataSet[i])) {
                specialElementCount++;
            }
        }

        // Teorik Beklenti Hesaplamaları
        double probability = (double) specialElementCount / n;
        double expectedSteps = 1.0 / probability;

        System.out.println("--- DİZİ BİLGİLERİ ---");
        System.out.println("Dizi Boyutu: " + n);
        System.out.println("Dizideki Özel Eleman Sayısı: " + specialElementCount);
        System.out.println("Bir Elemanın Özel Olma Olasılığı (p): " + probability);
        System.out.println("Teorik Beklenen Adım Sayısı (E[X]): " + expectedSteps);
        System.out.println("--------------------------------------------------\n");

        // 2. Algoritmanın 100 kez çalıştırılması
        int iterations = 100;
        long[] stepsTaken = new long[iterations];
        long[] timesTakenNs = new long[iterations];

        long totalSteps = 0;
        long totalTimeNs = 0;

        System.out.println("--- 100 İTERASYONLUK TEST BAŞLIYOR ---");
        for (int i = 0; i < iterations; i++) {
            long steps = 0;
            long startTime = System.nanoTime();

            // Las Vegas Arama Döngüsü: Kesinlikle doğru sonucu bulana kadar (100% doğruluk) çalışır.
            while (true) {
                steps++;
                int randomIndex = random.nextInt(n);
                if (isSpecial(dataSet[randomIndex])) {
                    break; // Özel eleman bulundu, döngüden çık
                }
            }

            long endTime = System.nanoTime();
            long timeElapsed = endTime - startTime;

            stepsTaken[i] = steps;
            timesTakenNs[i] = timeElapsed;

            totalSteps += steps;
            totalTimeNs += timeElapsed;
        }

        // 3. İstatistiksel Hesaplamalar
        double averageSteps = (double) totalSteps / iterations;
        double averageTimeNs = (double) totalTimeNs / iterations;

        // Standart Sapma Hesaplaması (Zaman ve Adım için)
        double stepVarianceSum = 0;
        double timeVarianceSum = 0;
        for (int i = 0; i < iterations; i++) {
            stepVarianceSum += Math.pow(stepsTaken[i] - averageSteps, 2);
            timeVarianceSum += Math.pow(timesTakenNs[i] - averageTimeNs, 2);
        }

        double stepStandardDeviation = Math.sqrt(stepVarianceSum / iterations);
        double timeStandardDeviationNs = Math.sqrt(timeVarianceSum / iterations);

        System.out.println("--- DENEYSEL SONUÇLAR (100 ÇALIŞTIRMA) ---");
        System.out.println("Ortalama Adım Sayısı: " + averageSteps);
        System.out.println("Adım Sayısı Standart Sapması: " + stepStandardDeviation);
        System.out.println("Ortalama Çalışma Süresi (Nanosaniye): " + averageTimeNs);
        System.out.println("Çalışma Süresi Standart Sapması (Nanosaniye): " + timeStandardDeviationNs);

        System.out.println("\n--- TEORİK VS DENEYSEL KARŞILAŞTIRMA ---");
        System.out.println("Teorik E[X]: " + expectedSteps + " | Deneysel Ortalama Adım: " + averageSteps);
        double errorMargin = Math.abs(expectedSteps - averageSteps) / expectedSteps * 100;
        System.out.println("Adım Sayısı Hata Payı: %" + String.format("%.2f", errorMargin));
    }
}
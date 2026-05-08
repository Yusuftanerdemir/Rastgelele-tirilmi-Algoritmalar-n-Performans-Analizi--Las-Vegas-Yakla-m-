# \# Las Vegas Algoritması ile Rastgeleleştirilmiş Performans Analizi

# 

# Bu proje, büyük veri setleri ($10^5$ eleman) üzerinde belirli bir hedef koşulu sağlayan elemanların aranması sürecinde \*\*Las Vegas Algoritması\*\* yaklaşımını ve bu yaklaşımın istatistiksel analizini içermektedir. Proje, rastgeleleştirilmiş algoritmaların doğruluğu %100 korurken zaman karmaşıklığı üzerindeki varyans etkisini kanıtlamayı amaçlar.

# 

# \## 📌 Proje Parametreleri

# Proje gereksinimleri, bilimsel tekrarlanabilirlik ilkesi gereği belirli bir tohum (seed) değeri üzerinden yapılandırılmıştır:

# 

# \- \*\*Öğrenci Numarası (Seed):\*\* `1240505041L`

# \- \*\*Veri Hacmi ($n$):\*\* 100.000 ($10^5$)

# \- \*\*Algoritma Türü:\*\* Las Vegas (Rastgeleleştirilmiş)

# \- \*\*Hedef Koşul:\*\* `number % 77 == 0`

# \- \*\*Deney Düzeni:\*\* 100 bağımsız iterasyon

# 

# \## 🧬 Matematiksel Model

# Algoritmanın performansı \*\*Geometrik Dağılım\*\* modeli üzerinden analiz edilmiştir. Diziden yapılan her seçim, birbirinden bağımsız bir Bernoulli denemesi olarak kabul edilir.

# 

# \- \*\*Başarı Olasılığı ($p$):\*\* Dizideki hedef eleman sayısı / Toplam eleman sayısı

# \- \*\*Beklenen Adım Sayısı ($E\[X]$):\*\* $$E\[X] = \\frac{1}{p}$$

# 

# Bu projede kullanılan seed değeri ile 100.000 elemanlık dizide 1.308 hedef eleman bulunmuş ve teorik beklenti \*\*76.45\*\* adım olarak hesaplanmıştır.

# 

# \## 🚀 Özellikler

# \- \*\*%100 Doğruluk:\*\* Monte Carlo algoritmalarının aksine, Las Vegas yaklaşımı her zaman doğru sonucu bulana kadar çalışır.

# \- \*\*Yüksek Hassasiyetli Ölçüm:\*\* Çalışma süreleri `System.nanoTime()` ile nanosaniye bazında ölçülmüştür.

# \- \*\*İstatistiksel Raporlama:\*\* 100 iterasyon sonunda Ortalama Adım Sayısı, Standart Sapma ve Hata Payı otomatik olarak hesaplanır.

# \- \*\*Tekrarlanabilirlik:\*\* Sabit seed kullanımı sayesinde her çalıştırmada aynı rastgele dizi üretilir.

# 

# \## 💻 Kurulum ve Çalıştırma

# 

# \### Gereksinimler

# \- Java JDK 8 veya üzeri.

# 

# \### Derleme

# ```bash

# javac LasVegasAlgorithm.java

# ```

# 

# \### Çalıştırma

# ```bash

# java LasVegasAlgorithm

# ```

# 

# \## 📊 Örnek Konsol Çıktısı

# Program çalıştırıldığında aşağıdaki yapıda bir çıktı üretir:

# 

# ```text

# \--- DİZİ BİLGİLERİ ---

# Dizi Boyutu: 100000

# Dizideki Özel Eleman Sayısı: 1308

# Bir Elemanın Özel Olma Olasılığı (p): 0.01308

# Teorik Beklenen Adım Sayısı (E\[X]): 76.4525993883792

# 

# \--- DENEYSEL SONUÇLAR (100 ÇALIŞTIRMA) ---

# Ortalama Adım Sayısı: 76.22

# Adım Sayısı Standart Sapması: 75.945231

# Ortalama Çalışma Süresi (Nanosaniye): 42500.0

# 

# \--- TEORİK VS DENEYSEL KARŞILAŞTIRMA ---

# Teorik E\[X]: 76.4525993883792 | Deneysel Ortalama Adım: 76.22

# Adım Sayısı Hata Payı: %0.30

# ```

# 

# \## 📜 Algoritma Akış Mantığı

# 1\. \*\*Seed Tanımlama:\*\* PRNG (Pseudo-Random Number Generator) öğrenci numarası ile beslenir.

# 2\. \*\*Dizi Oluşturma:\*\* 10^5 elemanlı dizi rastgele sayılarla doldurulur.

# 3\. \*\*Arama Döngüsü:\*\* - `while(true)` döngüsü içinde rastgele bir indeks seçilir.

# &#x20;  - Seçilen indeks hedef koşulu sağlıyorsa döngü kırılır (`break`).

# 4\. \*\*Analiz:\*\* İşlem 100 kez tekrarlanarak sonuçlar istatistiksel olarak karşılaştırılır.

# 

# \---

# \*Bu çalışma, Algoritma Analizi ve Tasarımı dersi projesi kapsamında 1240505041 numaralı öğrenci tarafından hazırlanmıştır.\*


# Swaglabs Mobile Automation Project

## Deskripsi Proyek
Proyek ini adalah kerangka kerja otomatisasi pengujian mobile yang dibangun menggunakan Appium untuk menguji aplikasi demo Swaglabs. Tujuannya adalah untuk mengotomatisasi skenario pengujian kunci untuk fungsionalitas login, manajemen inventaris, dan penambahan produk ke keranjang belanja, memastikan kualitas dan keandalan aplikasi mobile.

## Teknologi yang Digunakan
*   **Java**: Bahasa pemrograman utama yang digunakan untuk mengembangkan skrip pengujian.
*   **Appium**: Kerangka kerja otomatisasi open source untuk aplikasi mobile (iOS, Android, dan Windows desktop).
*   **Maven**: Alat manajemen dan pemahaman proyek untuk Java. Digunakan untuk mengelola dependensi dan siklus hidup build proyek.
*   **TestNG**: Kerangka kerja pengujian yang digunakan untuk mengatur, menjalankan, dan melaporkan pengujian.
*   **Apache POI**: Digunakan untuk membaca data pengujian dari file Excel (`DataTestProvider.xlsx`).
*   **log4j**: Kerangka kerja logging untuk membantu dalam pelacakan dan debugging eksekusi pengujian.

## Skenario Pengujian
Proyek ini mencakup skenario pengujian utama berikut:
1.  **AuthenticationTest**: Menguji fungsionalitas login dengan kredensial yang valid dan tidak valid.
2.  **InventoryTest**: Memverifikasi tampilan dan interaksi dengan elemen di layar inventaris, seperti menyortir produk dan melihat detail produk.
3.  **AddToCartTest**: Menguji proses penambahan produk ke keranjang belanja dan memverifikasi isinya.

## Struktur Proyek
```
.
├── .gitignore                    
├── pom.xml                      
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/swaglabs/mobile/
│   │   │       ├── component/                 # Kelas yang merepresentasikan komponen UI yang dapat digunakan kembali
│   │   │       │   └── HeaderComponent.java   # Komponen header yang umum digunakan di seluruh aplikasi
│   │   │       ├── config/                    # Kelas untuk membaca file konfigurasi
│   │   │       │   └── ConfigReader.java      # Utilitas untuk membaca dan mengelola properti konfigurasi dari `config.properties`
│   │   │       ├── driver/                    # Kelas untuk mengelola driver Appium
│   │   │       │   ├── DriverFactory.java     # Kelas untuk membuat instance driver Appium yang berbeda
│   │   │       │   └── DriverManager.java     # Mengelola instance driver Appium untuk memastikan satu driver per thread pengujian
│   │   │       ├── screens/                   # Kelas yang merepresentasikan layar aplikasi
│   │   │       │   ├── InventoryScreen.java   # Mengandung elemen dan metode untuk berinteraksi dengan layar inventaris produk
│   │   │       │   └── LoginScreen.java       # Mengandung elemen dan metode untuk berinteraksi dengan layar login
│   │   │       └── utils/                     # Kelas utilitas untuk tugas-tugas umum
│   │   │           ├── DragPositionUtil.java  # Utilitas untuk menghitung posisi drag dan drop
│   │   │           └── ExcelUtil.java         # Utilitas untuk membaca dan menulis data dari/ke file Excel
│   │   └── resources/
│   │       └── config.properties      # File properti konfigurasi
│   └── test/
│       ├── java/
│       │   └── com/swaglabs/mobile/
│       │       ├── base/                      # Kelas dasar untuk pengujian
│       │       │   └── BaseTest.java          # Menyediakan pengaturan umum untuk semua kelas pengujian
│       │       └── test/                      # Skrip pengujian
│       │           ├── AddToCartTest.java     # Mengandung pengujian terkait penambahan produk ke keranjang belanja
│       │           ├── AuthenticationTest.java # Mengandung pengujian terkait fungsionalitas login
│       │           ├── DataTestProvider.java  # Menyediakan data untuk pengujian, biasanya dibaca dari Excel
│       │           └── InventoryTest.java     # Mengandung pengujian terkait interaksi dengan layar inventaris
│       └── resources/
│           ├── DataTestProvider.xlsx  # Data pengujian berbasis Excel
│           └── testng.xml             # File konfigurasi TestNG untuk menjalankan pengujian
└── target/                       # Direktori untuk file yang dikompilasi dan laporan pengujian

## Cara Menjalankan Proyek

Untuk menjalankan proyek otomatisasi ini, ikuti langkah-langkah berikut:

### Prasyarat
*   **Java Development Kit (JDK) 8 atau lebih tinggi**: Pastikan JDK terinstal dan variabel lingkungan `JAVA_HOME` telah dikonfigurasi dengan benar.
*   **Maven**: Pastikan Maven terinstal dan dapat diakses dari command line.
*   **Appium Server**: Server Appium harus berjalan. Anda dapat menginstalnya secara global (`npm install -g appium`) dan menjalankannya dengan perintah `appium`.
*   **Appium Doctor** (opsional): Untuk memverifikasi semua prasyarat Appium telah terpenuhi (`npm install -g appium-doctor`, lalu `appium-doctor`).
*   **Android SDK (ADB)**: Untuk mengelola perangkat/emulator Android. Pastikan `platform-tools` ada di PATH Anda.
*   **Emulator/Perangkat Android**: Pastikan emulator Android berjalan atau perangkat Android fisik terhubung dan dapat dideteksi oleh ADB.

### Langkah-langkah

1.  **Kloning Repositori**:
    ```bash
    git clone [URL_REPOSITORI_ANDA]
    cd SwaglabsMobile
    ```

2.  **Membangun Proyek**:
    Buka terminal di direktori proyek dan jalankan perintah Maven berikut untuk mengunduh dependensi dan membangun proyek:
    ```bash
    mvn clean install
    ```

3.  **Menjalankan Appium Server**:
    Pastikan Appium Server berjalan sebelum menjalankan pengujian. Anda dapat memulai server dari terminal dengan:
    ```bash
    appium
    ```

4.  **Menjalankan Pengujian**:
    Setelah proyek dibangun dan Appium Server berjalan, Anda dapat menjalankan pengujian menggunakan TestNG.
    *   **Melalui Maven**:
        ```bash
        mvn test
        ```
    *   **Melalui file `testng.xml`**:
        Jika Anda menggunakan IDE (seperti IntelliJ IDEA atau Eclipse), klik kanan pada `src/test/resources/testng.xml` dan pilih "Run 'testng.xml'".

### Laporan Pengujian
Laporan pengujian akan dihasilkan di direktori `target/surefire-reports/` setelah pengujian selesai.

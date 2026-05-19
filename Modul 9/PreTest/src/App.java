public class App {
    public static void main(String[] args) {
        System.out.println("=== DEMONSTRASI AGREGASI & KOMPOSISI ===\n");

        // Membuat Monitor (AGREGASI - bisa eksis sendiri)
        Monitor m1 = new Monitor("Samsung", "24");
        Monitor m2 = new Monitor("LG", "27");
        Monitor m3 = new Monitor("Dell", "32");

        // Membuat HardDisk (KOMPOSISI - akan melekat pada server)
        HardDisk hd1 = new HardDisk("SSD Samsung", 512, "SSD");
        HardDisk hd2 = new HardDisk("HDD Seagate", 1000, "HDD");

        // Membuat Server
        KomputerServer server1 = new KomputerServer("Server-1", "Intel Xeon", 2);
        KomputerServer server2 = new KomputerServer("Server-2", "AMD Ryzen", 2);

        // Menambah Monitor ke Server (AGREGASI)
        System.out.println("--- Proses Agregasi ---");
        server1.tambahMonitor(m1);
        server1.tambahMonitor(m2);

        server2.tambahMonitor(m2); // Monitor yang sama bisa dipakai server lain
        server2.tambahMonitor(m3);

        // Menampilkan hasil
        System.out.println("\n--- Hasil Akhir ---");
        server1.tampilkanSemuaMonitor();
        server2.tampilkanSemuaMonitor();

        // Menampilkan HardDisk (independen, tidak terikat server)
        System.out.println("\n--- HardDisk (eksis sendiri) ---");
        hd1.tampilkan();
        hd2.tampilkan();

        System.out.println("\n=== SELESAI ===");
    }
}

// Asosiasi adalah hubungan paling umum antara dua kelas yang saling terhubung
// namun keduanya memiliki siklus hidup yang sepenuhnya independen. Dalam kode
// yang dibuat, hubungan antara KomputerServer dan Monitor sebenarnya termasuk
// dalam asosiasi karena server hanya mengenal monitor melalui method
// tambahMonitor(Monitor monitor), namun tidak ada kepemilikan yang kuat.
// Monitor dapat dibuat terlebih dahulu sebelum server ada, dan monitor tetap
// eksis meskipun server dihapus. Selain itu, monitor yang sama (misalnya
// monitor LG 27 inci) dapat digunakan oleh beberapa server sekaligus, seperti
// yang ditunjukkan ketika monitor2 ditambahkan ke server1 dan juga ke server2.
// Ini membuktikan bahwa tidak ada ketergantungan yang mengikat antara server
// dan monitor.
//

// Agregasi adalah bentuk khusus dari asosiasi yang merepresentasikan hubungan
// "has-a" atau "memiliki" yang bersifat lemah. Dalam implementasi, agregasi
// terlihat ketika KomputerServer memiliki array Monitor[] daftarMonitor beserta
// method tambahMonitor(). Meskipun server secara konseptual "memiliki" kumpulan
// monitor, monitor-monitor tersebut sebenarnya bisa berdiri sendiri tanpa
// server. Ciri khas agregasi yang paling jelas terlihat adalah ketika monitor
// yang sama dapat di-"agregasi" ke lebih dari satu server, seperti monitor LG
// yang digunakan oleh Server Database dan Server Web secara bersamaan. Jika
// sebuah server dimusnahkan, monitor yang teragregasi padanya tidak ikut hancur
// dan masih bisa digunakan oleh server lain. Agregasi dalam kode ini juga
// menggunakan array standar (Monitor[]) untuk menampung banyak monitor,
// menunjukkan relasi one-to-many yang longgar.

// Komposisi adalah bentuk hubungan "has-a" yang kuat, di mana objek bagian
// (part) memiliki siklus hidup yang sepenuhnya tergantung pada objek
// keseluruhan (whole). Dalam kode, HardDisk dirancang untuk menjadi contoh
// komposisi, yaitu sebuah server seharusnya memiliki hard disk yang lahir
// bersama server tersebut dan hancur bersama server tersebut. Berbeda dengan
// agregasi, hard disk dalam komposisi seharusnya tidak bisa dipindahkan ke
// server lain, tidak bisa eksis sebelum server dibuat, dan tidak bisa hidup
// setelah server dihancurkan. Implementasi ideal komposisi dalam Java adalah
// dengan membuat objek part (HardDisk) di dalam konstruktor kelas whole
// (KomputerServer), bukan menerimanya sebagai parameter dari luar. Jika server
// dihapus, hard disk akan ikut terhapus dari memori (garbage collection),
// berbeda dengan monitor yang tetap bertahan. Inilah mengapa komposisi disebut
// sebagai kepemilikan yang eksklusif dan seumur hidup.
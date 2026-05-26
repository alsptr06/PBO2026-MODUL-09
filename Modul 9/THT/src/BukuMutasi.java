import java.util.ArrayList; //library untuk menggunakan ArrayList

public class BukuMutasi { //class untuk mencatat aktivitas nasabah seperti penambahan rekening, setor, tarik, dll
    private ArrayList<String> riwayat; //list untuk menyimpan riwayat aktivitas nasabah

    public BukuMutasi() { //konstruktor untuk inisialisasi list riwayat
        riwayat = new ArrayList<>(); //inisialisasi ArrayList untuk menyimpan riwayat aktivitas nasabah
    }

    public void catat(String aktivitas) { //method untuk mencatat aktivitas nasabah ke dalam riwayat
        riwayat.add(aktivitas); //menambahkan aktivitas ke dalam list riwayat
        System.out.println("[MUTASI] " + aktivitas); //menampilkan aktivitas yang ditambahkan ke dalam riwayat mutasi
    }

    public void tampilkan() { //method untuk menampilkan seluruh riwayat aktivitas nasabah
        System.out.println("=== Riwayat Mutasi ===");
        for (String a : riwayat) { //for-each loop untuk menampilkan setiap aktivitas yang ada di dalam list riwayat
            System.out.println("- " + a); //menampilkan aktivitas dengan format "- aktivitas"
        }
    }
}
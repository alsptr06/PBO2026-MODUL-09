public class Nasabah {
    private String nama; 
    private String idNasabah;
    private Rekening[] daftarRekening;
    private int jumlahRekening;
    private BukuMutasi bukuMutasi;

    public Nasabah(String nama, String idNasabah) { //konstruktor untuk inisialisasi data nasabah
        this.nama = nama;
        this.idNasabah = idNasabah;
        this.daftarRekening = new Rekening[3];
        this.jumlahRekening = 0;
        this.bukuMutasi = new BukuMutasi();
    }

    public void tambahRekening(Rekening rekening) { //method untuk menambahkan rekening baru ke dalam profil nasabah
        if (jumlahRekening < 3) { //jika jumlah rekening masih kurang dari 3
            daftarRekening[jumlahRekening] = rekening;//menambahkan rekening baru ke dalam array daftarRekening
            jumlahRekening++; //menambah jumlah rekening yang dimiliki nasabah
            bukuMutasi.catat("Rekening " + rekening.getNomorRekening() + " ditambahkan ke profil");//mencatat penambahan rekening baru ke dalam buku mutasi
        } else { //selain itu
            System.out.println("Maksimal 3 rekening."); //menampilkan pesan bahwa maksimal rekening yang dapat dimiliki nasabah adalah 3
        }
    }

    // Getter methods
    public Rekening[] getDaftarRekening() {
        return daftarRekening;
    }

    public int getJumlahRekening() {
        return jumlahRekening;
    }

    public String getNama() {
        return nama;
    }

    public String getIdNasabah() {
        return idNasabah;
    }

    public BukuMutasi getBukuMutasi() {
        return bukuMutasi;
    }
}

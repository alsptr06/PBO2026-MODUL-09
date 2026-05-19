class Montir {
    private String idMontir;
    private String nama;

    public Montir(String idMontir, String nama) {
        this.idMontir = idMontir;
        this.nama = nama;
    }

    // Method untuk memeriksa kelayakan mobil
    public boolean LakukanQuality(Mobil mobil, Ban[] banCadangan) {
        System.out.println("\n=== Proses Inspeksi oleh Montir " + nama + " ===");
        System.out.println("Memeriksa kelayakan mobil...");

        if (mobil.isLayak()) {
            System.out.println("Hasil: Mobil LAYAK digunakan");
            return true;
        } else {
            System.out.println("Hasil: Mobil TIDAK LAYAK digunakan!");
            System.out.println("Mobil akan dihancurkan...");
            return false;
        }
    }
}
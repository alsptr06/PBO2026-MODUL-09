public abstract class Rekening implements Otorisasi { //class abstrak untuk rekening bank, mengimplementasikan interface Otorisasi untuk verifikasi PIN
    protected String nomorRekening; //nomor rekening yang unik untuk setiap rekening
    protected String namaPemilik; //nama pemilik rekening
    protected double saldo; //saldo awal rekening
    protected String pin;//pin untuk keamanan rekening

    public Rekening(String nomorRekening, String namaPemilik, double saldoAwal, String pin) {
        this.nomorRekening = nomorRekening;
        this.namaPemilik = namaPemilik;
        this.saldo = saldoAwal;
        this.pin = pin;
    }

    public boolean verifikasiPIN(String pin) { //method untuk memverifikasi PIN yang dimasukkan oleh nasabah
        return this.pin.equals(pin); //mengembalikan true jika PIN yang dimasukkan sama dengan PIN yang tersimpan di rekening, selain itu mengembalikan false
    }

    public void setor(double jumlah) { //method untuk menyetor uang ke rekening
        if (jumlah > 0) { //jika jumlah yang disetor lebih besar dari 0
            saldo += jumlah; //menambahkan jumlah yang disetor ke saldo rekening
            System.out.println("Setor berhasil. Saldo: " + saldo); //menampilkan pesan bahwa setor berhasil dan menampilkan saldo terbaru
        }
    }

    public abstract void tarik(double jumlah); //method abstrak untuk menarik uang
    // Getter methods
    public String getNomorRekening() {
        return nomorRekening;
    }

    public String getNamaPemilik() {
        return namaPemilik;
    }

    public double getSaldo() {
        return saldo;
    }
}
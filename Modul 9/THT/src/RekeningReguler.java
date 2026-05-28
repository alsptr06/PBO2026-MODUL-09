public class RekeningReguler extends Rekening { //class untuk rekening reguler, merupakan subclass dari kelas Rekening
    private static final double BIAYA_ADMIN = 2500; //biaya admin untuk setiap penarikan di rekening reguler

    public RekeningReguler(String nomorRekening, String namaPemilik, double saldoAwal, String pin) { //konstruktor untuk inisialisasi rekening reguler
        super(nomorRekening, namaPemilik, saldoAwal, pin); //memanggil konstruktor dari kelas Rekening untuk menginisialisasi data rekening reguler
    }

    public void tarik(double jumlah) {//method untuk menarik uang dari rekening reguler
        double total = jumlah + BIAYA_ADMIN; //menghitung total yang harus dibayar oleh nasabah saat melakukan penarikan
        if (total <= saldo) {//jika total yang harus dibayar (jumlah yang ingin ditarik + biaya admin) kurang dari atau sama dengan saldo yang tersedia di rekening
            saldo -= total; //mengurangi total yang harus dibayar dari saldo rekening
            System.out.println("Tarik berhasil. Biaya admin: " + BIAYA_ADMIN + ". Saldo: " + saldo);//menampilkan pesan bahwa tarik berhasil, menampilkan biaya admin yang dikenakan, dan menampilkan saldo terbaru setelah penarikan
        } else {//selain itu
            System.out.println("Saldo tidak mencukupi.");//menampilkan pesan bahwa saldo tidak mencukupi untuk melakukan penarikan
        }
    }
}
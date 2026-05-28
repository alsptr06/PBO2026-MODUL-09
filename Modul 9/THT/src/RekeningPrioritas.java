public class RekeningPrioritas extends Rekening { //class untuk rekening prioritas
    private static final double BATAS_MINIMUM = 10000000; //batas minimum untuk penarikan di rekening prioritas

    public RekeningPrioritas(String nomorRekening, String namaPemilik, double saldoAwal, String pin) { //konstruktor untuk inisialisasi rekening prioritas
        super(nomorRekening, namaPemilik, saldoAwal, pin); //memanggil konstruktor dari kelas Rekening untuk menginisialisasi data rekening prioritas
    }

    public void tarik(double jumlah) { //method untuk menarik uang dari rekening prioritas
        if (jumlah > BATAS_MINIMUM) { //jika jumlah yang ingin ditarik melebihi batas minimum yang ditentukan untuk rekening prioritas
            System.out.println("Penarikan melebihi batas minimum " + BATAS_MINIMUM); //menampilkan pesan bahwa penarikan melebihi batas minimum yang ditentukan untuk rekening prioritas
            return; //keluar dari method tarik jika jumlah yang ingin ditarik melebihi batas minimum
        }
        if (jumlah <= saldo) { //jika jumlah yang ingin ditarik kurang dari atau sama dengan saldo yang tersedia di rekening
            saldo -= jumlah;//mengurangi jumlah yang ditarik dari saldo rekening
            System.out.println("Tarik berhasil. Saldo: " + saldo); //menampilkan pesan bahwa tarik berhasil dan menampilkan saldo terbaru setelah penarikan
        } else { //selain itu
            System.out.println("Saldo tidak mencukupi."); //menampilkan pesan bahwa saldo tidak mencukupi untuk melakukan penarikan
        }
    }
}
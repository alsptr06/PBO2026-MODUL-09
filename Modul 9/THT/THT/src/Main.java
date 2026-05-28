import java.util.Scanner; //library untuk menggunakan Scanner untuk input dari pengguna
import java.util.ArrayList; //library untuk menggunakan ArrayList untuk menyimpan daftar nasabah

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // membuat objek Scanner untuk membaca input dari pengguna
        ArrayList<Nasabah> nasabahList = new ArrayList<>(); // membuat ArrayList untuk menyimpan daftar nasabah
        CustomerService cs = new CustomerService(); // membuat objek CustomerService untuk menangani keluhan nasabah

        while (true) { //ketika program dijalankan, tampilkan menu utama dan tunggu input dari pengguna
            System.out.println("\n=== NeoBank ===");
            System.out.println("1. Registrasi Nasabah");
            System.out.println("2. Login");
            System.out.println("3. Keluhan ke CS");
            System.out.println("4. Keluar");
            System.out.print("Pilih: ");
            int pilih = sc.nextInt();
            sc.nextLine();

            if (pilih == 1) { //jikamemilih 1
                System.out.print("Nama: "); //minta input nama dari pengguna
                String nama = sc.nextLine();
                System.out.print("ID Nasabah: "); //minta input ID nasabah dari pengguna
                String id = sc.nextLine();
                nasabahList.add(new Nasabah(nama, id));//buat objek Nasabah baru dengan nama dan ID yang diberikan, lalu tambahkan ke daftar nasabah
                System.out.println("Registrasi berhasil.");
            } else if (pilih == 2) { //jika memilih 2
                System.out.print("ID Nasabah: "); //minta input ID nasabah dari pengguna untuk login
                String id = sc.nextLine(); //cari nasabah dengan ID yang diberikan di daftar nasabah
                Nasabah nasabah = null; //variabel untuk menyimpan nasabah yang ditemukan
                for (Nasabah n : nasabahList) { //untuk setiap nasabah dalam daftar nasabah, periksa apakah ID nasabah cocok dengan ID yang diberikan
                    if (n.getIdNasabah().equals(id)) { //jika ditemukan nasabah dengan ID yang cocok
                        nasabah = n; //simpan nasabah yang ditemukan dalam variabel nasabah
                        break;
                    }
                }
                if (nasabah == null) { //jika tidak ditemukan nasabah dengan ID yang cocok
                    System.out.println("Nasabah tidak ditemukan."); // , tampilkan pesan kesalahan dan kembali ke menu
                                                                    
                    continue;
                }

                System.out.println("Login berhasil. Selamat datang, " + nasabah.getNama());
                boolean login = true;
                while (login) {
                    System.out.println("\n1. Tambah Rekening");
                    System.out.println("2. Lihat Rekening");
                    System.out.println("3. Setor");
                    System.out.println("4. Tarik");
                    System.out.println("5. Lihat Mutasi");
                    System.out.println("6. Logout");
                    System.out.print("Pilih: ");
                    int p = sc.nextInt();
                    sc.nextLine();

                    if (p == 1) { //jika memilih 1, tampilkan menu untuk menambahkan rekening baru, minta input jenis rekening, nomor rekening, PIN, dan saldo awal dari pengguna
                        System.out.print("Jenis (1=Reguler, 2=Prioritas): ");
                        int jenis = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Nomor Rekening: "); 
                        String no = sc.nextLine();
                        System.out.print("PIN: ");
                        String pin = sc.nextLine();
                        System.out.print("Saldo Awal: ");
                        double saldo = sc.nextDouble();
                        sc.nextLine();

                        Rekening r;
                        if (jenis == 1)
                            r = new RekeningReguler(no, nasabah.getNama(), saldo, pin);
                        else
                            r = new RekeningPrioritas(no, nasabah.getNama(), saldo, pin);
                        nasabah.tambahRekening(r);
                    } else if (p == 2) {
                        for (int i = 0; i < nasabah.getJumlahRekening(); i++) {
                            Rekening r = nasabah.getDaftarRekening()[i];
                            System.out.println((i + 1) + ". " + r.getNomorRekening() + " - " + r.getNamaPemilik()
                                    + " - " + r.getSaldo());
                        }
                    } else if (p == 3) { //jika memilih 3, tampilkan menu untuk setor, minta input nomor rekening yang akan disetor, PIN, dan jumlah setor dari pengguna, lalu lakukan proses setor jika PIN benar
                        System.out.print("Pilih rekening (1-" + nasabah.getJumlahRekening() + "): ");
                        int idx = sc.nextInt() - 1;
                        sc.nextLine();
                        System.out.print("PIN: ");
                        String pin = sc.nextLine();
                        Rekening r = nasabah.getDaftarRekening()[idx];
                        if (r.verifikasiPIN(pin)) {
                            System.out.print("Jumlah setor: ");
                            double j = sc.nextDouble();
                            sc.nextLine();
                            r.setor(j);
                            nasabah.getBukuMutasi().catat("Setor " + j + " ke " + r.getNomorRekening());
                        } else {
                            System.out.println("PIN salah.");
                        }
                    } else if (p == 4) {//jika memilih 4, tampilkan menu untuk tarik, minta input nomor rekening yang akan ditarik, PIN, dan jumlah tarik dari pengguna, lalu lakukan proses tarik jika PIN benar
                        System.out.print("Pilih rekening (1-" + nasabah.getJumlahRekening() + "): ");
                        int idx = sc.nextInt() - 1;
                        sc.nextLine();
                        System.out.print("PIN: ");
                        String pin = sc.nextLine();
                        Rekening r = nasabah.getDaftarRekening()[idx];
                        if (r.verifikasiPIN(pin)) {
                            System.out.print("Jumlah tarik: ");
                            double j = sc.nextDouble();
                            sc.nextLine();
                            r.tarik(j);
                            nasabah.getBukuMutasi().catat("Tarik " + j + " dari " + r.getNomorRekening());
                        } else {
                            System.out.println("PIN salah.");
                        }
                    } else if (p == 5) { //jika memilih 5, tampilkan mutasi transaksi nasabah dengan memanggil method tampilkan() dari objek BukuMutasi milik nasabah
                        nasabah.getBukuMutasi().tampilkan();
                    } else if (p == 6) { //jika memilih 6, keluar dari menu rekening dan kembali ke menu utama dengan mengubah nilai variabel login menjadi false
                        login = false;
                        System.out.println("Logout berhasil.");
                    }
                }
            } else if (pilih == 3) { //
                System.out.print("Masukkan keluhan: ");
                String k = sc.nextLine();
                cs.laporkanKeluhan(k);
            } else if (pilih == 4) {
                System.out.println("Terima kasih telah menggunakan NeoBank.");
                break;
            }
        }
        sc.close();
    }
}
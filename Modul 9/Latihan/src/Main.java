public class Main {
    public static void main(String[] args) {
        Dokter drAndi = new Dokter("D001", "dr. Andi Pratama", "Jantung");
        Dokter drSiti = new Dokter("D002", "dr. Siti Rahayu", "Anak");

        System.out.println("=== DOKTER YANG TERSEDIA ===");
        drAndi.tampilkanInfo();
        drSiti.tampilkanInfo();

        RS_Sehat rsSehat = new RS_Sehat("RS Sehat Selalu", 5, 10);

        Ruangan ruangUGD = new Ruangan("101", "UGD");
        Ruangan ruangRawatInap = new Ruangan("102", "Rawat Inap");
        Ruangan ruangOperasi = new Ruangan("201", "Operasi");

        System.out.println("=== MENAMBAH RUANGAN ===");
        rsSehat.tambahRuangan(ruangUGD);
        rsSehat.tambahRuangan(ruangRawatInap);
        rsSehat.tambahRuangan(ruangOperasi);

        System.out.println("=== MENUGASKAN DOKTER ===");
        rsSehat.tugaskanDokter(drAndi);
        rsSehat.tugaskanDokter(drSiti);

        rsSehat.tampilkanRuangan();
        rsSehat.tampilkanDokterBertugas();

        Pasien pasien1 = new Pasien("P001", "Budi Santoso", 45);
        Pasien pasien2 = new Pasien("P002", "Ani Wijaya", 8);

        System.out.println("==== DATA PASIEN ===");
        pasien1.tampilkanInfo();
        pasien2.tampilkanInfo();

        rsSehat.gulungTikar();

        System.out.println("=== DOKTER SETELAH RS GULUNG TIKAR ===");
        drAndi.tampilkanInfo();
        drSiti.tampilkanInfo();

        RS_Sehat rsCabang = new RS_Sehat("RS Sehat Cabang", 3, 10);

        System.out.println("=== MENUGASKAN ULANG DOKTER KE CABANG BARU ===");
        rsCabang.tugaskanDokter(drAndi);

        rsCabang.tampilkanDokterBertugas();

        System.out.println("=== DOKTER TETAP EKSIS DAN BISA DITUGASKAN KEMBALI ===");
        System.out.println("dr. Siti dan dr. Budi masih tersedia untuk cabang lain:");
        drSiti.tampilkanInfo();
    }
}
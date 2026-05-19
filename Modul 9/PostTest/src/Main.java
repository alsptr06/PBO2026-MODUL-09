public class Main {
    public static void main(String[] args) {
        System.out.println("=== SIMULASI PABRIK OTOMOTIF ===\n");

        // 1. Penciptaan 4 ban
        System.out.println("1. Membuat 4 ban mandiri di gudang:");
        Ban[] banGudang = new Ban[4];
        banGudang[0] = new Ban("Michelin", 17);
        banGudang[1] = new Ban("Bridgestone", 17);
        banGudang[2] = new Ban("Pirelli", 18);
        banGudang[3] = new Ban("Dunlop", 18);

        for (int i = 0; i < banGudang.length; i++) {
            System.out.print("Ban ke-" + (i + 1) + ": ");
            banGudang[i].tampilkanInfo();
        }

        // 2. Pembentukan 1 unit mobil
        System.out.println("\n2. Membangun kerangka mobil baru:");
        Mobil mobil1 = new Mobil("Toyota", "Merah", "SN7890123456", 1500);
        mobil1.tampilkanInfo();

        // 3. Pemasangan ban ke mobil
        System.out.println("\n3. Memasang ban ke mobil:");
        mobil1.pasangSetBan(banGudang);
        mobil1.tampilkanInfo();

        // 4. Inspeksi oleh 1 montir
        System.out.println("\n4. Proses inspeksi:");
        Montir montir1 = new Montir("M001", "Budi Santoso");
        boolean hasilUji = montir1.LakukanQuality(mobil1, banGudang);

        // 5. Skenario mobil gagal uji kelayakan
        if (!hasilUji) {
            System.out.println("\n5. Mobil Dihancurkan (set null)");
            mobil1 = null; // Mobil dihancurkan

            System.gc();

            // BUKTI: Ban masih tetap ada di memori
            System.out.println("\n=== BUKTI ===");
            System.out.println("Ban di gudang masih TERSEDIA (tetap ada di memori):");
            for (int i = 0; i < banGudang.length; i++) {
                System.out.print("Ban ke-" + (i + 1) + ": ");
                banGudang[i].tampilkanInfo();
            }

        }

        /*
         * Untuk membuktikan mesin musnah tanpa jejak:
         * - Referensi mesin hanya ada di dalam objek mobil yang sudah null
         * - Tidak ada variabel yang menyimpan referensi mesin secara langsung
         * - Mesin akan otomatis diambil oleh Garbage Collector karena tidak ada yang
         * mereferensi
         * - Mobil sudah null, tidak bisa diakses lagi
         * - Mesin ikut musnah karena merupakan komposisi (part of mobil)
         * 
         * 
         * 
         * 
         */
    }

}


class Mobil {
    private String merk;
    private String warna;
    private Mesin mesin; // Komposisi: mesin dibuat di constructor
    private Ban[] daftarBan; // Agregasi: ban bisa dipasang dan dilepas
    private int jumlahBan;

    public Mobil(String merk, String warna, String nomorSeriMesin, int kapasitasCC) {
        this.merk = merk;
        this.warna = warna;
        // Mesin diinstansiasi langsung saat kerangka mobil dibangun
        this.mesin = new Mesin(nomorSeriMesin, kapasitasCC);
        this.daftarBan = new Ban[4]; // Maksimal 4 ban
        this.jumlahBan = 0;
    }

    // Method untuk memasukkan maksimal 4 ban
    public void pasangSetBan(Ban[] setBan) {
        if (setBan.length > 4) {
            System.out.println("Error: Hanya bisa memasang maksimal 4 ban!");
            return;
        }

        for (int i = 0; i < setBan.length; i++) {
            if (setBan[i] != null && jumlahBan < 4) {
                daftarBan[jumlahBan] = setBan[i];
                jumlahBan++;
                System.out.println("Ban ke-" + (i + 1) + " berhasil dipasang");
            }
        }
        System.out.println("Total ban terpasang: " + jumlahBan);
    }

    public void tampilkanInfo() {
        System.out.println("\n=== Informasi Mobil ===");
        System.out.println("Merk: " + merk);
        System.out.println("Warna: " + warna);
        mesin.tampilkanInfo();
        System.out.println("Ban terpasang: " + jumlahBan + " buah");
        for (int i = 0; i < jumlahBan; i++) {
            System.out.print("  ");
            daftarBan[i].tampilkanInfo();
        }
    }

    public boolean isLayak() {
        return jumlahBan == 4; // Contoh kriteria: harus punya 4 ban
    }
}
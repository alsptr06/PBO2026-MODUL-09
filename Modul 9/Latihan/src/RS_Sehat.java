class RS_Sehat {
    private String nama;
    private Ruangan[] daftarRuangan;
    private Dokter[] daftarDokter;
    private int jumlahRuangan;
    private int jumlahDokter;

    public RS_Sehat(String nama, int kapasitasRuangan, int kapasitasDokter) {
        this.nama = nama;
        this.daftarRuangan = new Ruangan[kapasitasRuangan];
        this.daftarDokter = new Dokter[kapasitasDokter];
        this.jumlahRuangan = 0;
        this.jumlahDokter = 0;
    }

    public void tambahRuangan(Ruangan ruangan) {
        if (jumlahRuangan < daftarRuangan.length) {
            daftarRuangan[jumlahRuangan] = ruangan;
            jumlahRuangan++;
            System.out.println("Ruangan berhasil ditambahkan ke " + nama);
        } else {
            System.out.println("Kapasitas ruangan penuh!");
        }
    }

    public void tugaskanDokter(Dokter dokter) {
        if (jumlahDokter < daftarDokter.length) {
            daftarDokter[jumlahDokter] = dokter;
            jumlahDokter++;
            System.out.println(dokter.getNama() + " ditugaskan di " + nama);
        } else {
            System.out.println("Kapasitas dokter penuh!");
        }
    }

    public Dokter[] getSemuaDokter() {
        Dokter[] dokterAktif = new Dokter[jumlahDokter];
        for (int i = 0; i < jumlahDokter; i++) {
            dokterAktif[i] = daftarDokter[i];
        }
        return dokterAktif;
    }

    public void tarikSemuaDokter() {
        for (int i = 0; i < jumlahDokter; i++) {
            System.out.println(daftarDokter[i].getNama() + " ditarik dari " + nama);
            daftarDokter[i] = null;
        }
        jumlahDokter = 0;
    }

    public void tampilkanDokterBertugas() {
        System.out.println("Daftar dokter di " + nama + ":");
        if (jumlahDokter == 0) {
            System.out.println("Tidak ada dokter yang bertugas");
        } else {
            for (int i = 0; i < jumlahDokter; i++) {
                System.out.print("- ");
                daftarDokter[i].tampilkanInfo();
            }
        }
    }

    public void tampilkanRuangan() {
        System.out.println("Daftar ruangan di " + nama + ":");
        if (jumlahRuangan == 0) {
            System.out.println("Tidak ada ruangan");
        } else {
            for (int i = 0; i < jumlahRuangan; i++) {
                System.out.print("- ");
                daftarRuangan[i].tampilkanInfo();
            }
        }
    }

    public void gulungTikar() {
        System.out.println("!!! " + nama + " GULUNG TIKAR !!!");
        System.out.println("Mentarik semua dokter sebelum RS hancur...");
        tarikSemuaDokter();

        for (int i = 0; i < jumlahRuangan; i++) {
            daftarRuangan[i] = null;
        }
        jumlahRuangan = 0;

        System.out.println(nama + " telah hancur, namun semua dokter selamat!\n");
    }

    public String getNama() {
        return nama;
    }
}
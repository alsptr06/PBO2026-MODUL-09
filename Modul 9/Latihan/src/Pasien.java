class Pasien {
    private String id;
    private String nama;
    private int umur;

    public Pasien(String id, String nama, int umur) {
        this.id = id;
        this.nama = nama;
        this.umur = umur;
    }

    public String getNama() {
        return nama;
    }

    public void tampilkanInfo() {
        System.out.println("Pasien: " + nama + " (" + id + ") - Umur: " + umur);
    }
}
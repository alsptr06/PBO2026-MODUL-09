class Ruangan {
    private String nomor;
    private String tipe;

    public Ruangan(String nomor, String tipe) {
        this.nomor = nomor;
        this.tipe = tipe;
    }

    public void tampilkanInfo() {
        System.out.println("Ruangan " + nomor + " (" + tipe + ")");
    }
}
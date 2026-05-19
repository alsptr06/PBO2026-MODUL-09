class Dokter {
    private String id;
    private String nama;
    private String spesialis;

    public Dokter(String id, String nama, String spesialis) {
        this.id = id;
        this.nama = nama;
        this.spesialis = spesialis;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getSpesialis() {
        return spesialis;
    }

    public void tampilkanInfo() {
        System.out.println("Dokter: " + nama + " (" + id + ") - " + spesialis);
    }
}
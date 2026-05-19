class Mesin {
    private String nomorSeri;
    private int kapasitasCC;

    public Mesin(String nomorSeri, int kapasitasCC) {
        this.nomorSeri = nomorSeri;
        this.kapasitasCC = kapasitasCC;
    }

    public String getNomorSeri() {
        return nomorSeri;
    }

    public int getKapasitasCC() {
        return kapasitasCC;
    }

    public void tampilkanInfo() {
        System.out.println("Mesin [Nomor Seri: " + nomorSeri + ", Kapasitas: " + kapasitasCC + " CC]");
    }
}
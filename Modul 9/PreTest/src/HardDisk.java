public class HardDisk {
    private String merk;
    private int kapasitasGB; 
    private String tipe; 

    public HardDisk(String merk, int kapasitasGB, String tipe) {
        this.merk = merk;
        this.kapasitasGB = kapasitasGB;
        this.tipe = tipe;
    }

    public void tampilkan() {
        System.out.println("HardDisk " + merk + " " + kapasitasGB + "GB (" + tipe + ")");
    }

    public String getMerk() {
        return merk;
    }

    public int getKapasitasGB() {
        return kapasitasGB;
    }

    public String getTipe() {
        return tipe;
    }
}
public class Monitor {
    private String merk;
    private String ukuran;

    public Monitor(String merk, String ukuran) {
        this.merk = merk;
        this.ukuran = ukuran;
    }

    public void tampilkan() {
        System.out.println("Monitor " + merk + " (" + ukuran + " inci)");
    }

    public String getMerk() {
        return merk;
    }

    public String getUkuran() {
        return ukuran;
    }
}
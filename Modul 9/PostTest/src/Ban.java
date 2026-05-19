class Ban {
    private String merk;
    private int ukuranRing;

    public Ban(String merk, int ukuranRing) {
        this.merk = merk;
        this.ukuranRing = ukuranRing;
    }

    public String getMerk() {
        return merk;
    }

    public int getUkuranRing() {
        return ukuranRing;
    }

    public void tampilkanInfo() {
        System.out.println("Ban [Merk: " + merk + ", Ukuran Ring: " + ukuranRing + "]");
    }
}
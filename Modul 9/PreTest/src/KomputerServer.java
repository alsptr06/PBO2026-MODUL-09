public class KomputerServer {
    private String namaServer;
    private String spesifikasi;
    private Monitor[] daftarMonitor; 
    private int jumlahMonitor; 

    public KomputerServer(String namaServer, String spesifikasi, int kapasitasMonitor) {
        this.namaServer = namaServer;
        this.spesifikasi = spesifikasi;
        this.daftarMonitor = new Monitor[kapasitasMonitor]; // Inisialisasi array
        this.jumlahMonitor = 0;
    }


    public boolean tambahMonitor(Monitor monitor) {
        if (jumlahMonitor < daftarMonitor.length) {
            daftarMonitor[jumlahMonitor] = monitor;
            jumlahMonitor++;
            System.out.println("Berhasil menambah " + monitor.getMerk() +
                    " ke server " + namaServer);
            return true;
        } else {
            System.out.println("Kapasitas monitor server " + namaServer + " penuh!");
            return false;
        }
    }

    
    public void tampilkanSemuaMonitor() {
        System.out.println("\nServer: " + namaServer + " (" + spesifikasi + ")");
        System.out.println("Memiliki " + jumlahMonitor + " monitor:");

        for (int i = 0; i < jumlahMonitor; i++) {
            System.out.print("  " + (i + 1) + ". ");
            daftarMonitor[i].tampilkan();
        }
    }

    public String getNamaServer() {
        return namaServer;
    }
}
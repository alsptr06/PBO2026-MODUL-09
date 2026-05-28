public interface Otorisasi { //interface untuk otorisasi nasabah, misalnya verifikasi PIN
    boolean verifikasiPIN(String pin); //method untuk memverifikasi PIN yang dimasukkan oleh nasabah, akan diimplementasikan di kelas Rekening
}
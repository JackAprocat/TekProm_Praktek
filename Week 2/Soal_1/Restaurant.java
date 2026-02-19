

public class Restaurant {
    private String[] nama_makanan;
    private double[] harga_makanan;
    private int[] stok;
    private static byte id = 0;
    
    public Restaurant() {
        nama_makanan = new String[10];
        harga_makanan = new double[10];
        stok = new int[10];
    }

    public void tambahMenuMakanan(String nama, double harga, int stok) {
    this.nama_makanan[id] = nama;
    this.harga_makanan[id] = harga;
    this.stok[id] = stok;   
    }

    public void pesananMenu(int id, double harga, int jumlah) {

        if (jumlah > 0){
            int stokAfterBuy = this.stok[id] - jumlah;
            
            if( stokAfterBuy >= 0){
                this.stok[id] = stokAfterBuy;
                System.out.println(this.nama_makanan[id] + "[" + this.stok[id] + "]");
                double totalHarga = harga * jumlah;
                System.out.println("Total Harga: " + totalHarga);
                System.out.println();
            } else {
                System.out.println("Stok tidak memenuhi pesanan");
            }

        } else {
            System.out.println("Jumlah tidak valid");
        }        
    }

    public boolean validasiStok(int id){
        if (stok[id] <= 0){
            return true;
        } else {
            return false;
        }
    }

    public String getnNamaMakananById(int id){
        return nama_makanan[id];
    }

    public double getHargaMakanan(int id){
        return harga_makanan[id];
    }

    public void tampilkanHarga(){
        double hargaMakanan = getHargaMakanan( 1);
        System.out.println("Harganya adalah: " + hargaMakanan);
    }   

    public void setStockById(int id, int stok){
        if(stok >= 0){
            this.stok[id] = stok;
        }
    }
    public void tampilMenuMakanan() {
        for (int i = 0; i <= id; i++) {
            if (!isOutOfStock(i)) {
                System.out.println(
                    nama_makanan[i] + "[" + stok[i] + "]" + "\tRp. " + harga_makanan[i]
                );
            }
        }
    }

    

    public boolean isOutOfStock(int id) {
        if (stok[id] == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void nextId() {
        id++;
    }

}










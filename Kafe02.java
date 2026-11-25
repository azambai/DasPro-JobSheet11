import java.util.Scanner;
public class Kafe02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== RESTO KAFE =====");
        System.out.print("Masukkan nama anda  : ");
        String nama = sc.nextLine();
        System.out.print("Apakah member? (y/n): ");
        boolean isMember = sc.next().equalsIgnoreCase("y");
        System.out.print("Jam kunjungan       : ");
        int jam = sc.nextInt();

        Menu(nama, isMember, jam);

        int totalHarga = 0;
        boolean pesanLagi = true;

        while (pesanLagi) {
            System.out.print("\nMasukkan nomor menu yang ingin anda pesan: ");
            int pilihanMenu = sc.nextInt();

            if (pilihanMenu < 1 || pilihanMenu > 6) {
                System.out.println("Menu tidak tersedia");
                continue;
            }

            System.out.print("Masukkan jumlah item yang ingin dipesan: ");
            int banyakItem = sc.nextInt();

            totalHarga += hitungTotaalHarga02(pilihanMenu, banyakItem);

            System.out.print("Pesan menu lain? (y/n): ");
            pesanLagi = sc.next().equalsIgnoreCase("y");
        }

        System.out.print("Masukkan kode promo (Ketik - jika tidaj ada): ");
        String kodePromo = sc.next();

        int diskon = hitungDiskon(totalHarga, kodePromo, isMember);
        int totalBayar = totalHarga - diskon;

        System.out.println("\n===== TOTAL JAJAN ANDA =====");
        System.out.println("Total harga     : Rp" + totalHarga);
        System.out.println("Besar diskon    : Rp" + diskon);
        System.out.println("Total bayaar    : Rp" + totalBayar);

        sc.close();
    }
    
    public static void Menu(String namaPelanggan, boolean isMember, int jamKunjung) {
        
        System.out.println("\nSelamat datang, " + namaPelanggan + "!");
        if (isMember) {
            System.out.println("Anda adalah member: Anda mendapatkan diskon 10% untuk setiap pembelian!");
        }
        if (jamKunjung >= 14 && jamKunjung <= 16) {
            System.out.println("Happy Hour! Diskon 20% untuk semua minuman");
        }

        System.out.println("\n===== MENU RESTO KAFE =====");
        System.out.println("1. Kopi Hitam   = Rp 15,000");
        System.out.println("2. Cappuccino   = Rp 20,000");
        System.out.println("3. Latte        = Rp 22,000");
        System.out.println("4. Teh Tarik    = Rp 12,000");
        System.out.println("5. Roti Bakar   = Rp 10,000");
        System.out.println("6. Mie Goreng   = Rp 18,000");
        System.out.println("===========================");
        System.out.println("Silahkan pilih menu yang anda inginkan.");
    }

    public static int hitungTotaalHarga02 (int pilihanMenu, int banyakItem) {
        int[] hargaItem = {15000, 20000, 12000, 10000, 18000};

        int hargaTotal = hargaItem[pilihanMenu - 1] * banyakItem;
        return hargaTotal;
    }

    public static int hitungDiskon (int total, String kodePromo, boolean isMember) {
        int persenPromo = 0;

        if (kodePromo.equalsIgnoreCase("DISKON50")) {
            persenPromo = 0;
        } else if (kodePromo.equalsIgnoreCase("DISKON30")) {
            persenPromo = 30;
        } else {
            System.out.println("Kode promo invalid");
        }

        int diskonPromo = total * persenPromo / 100;

        int diskonMember = 0;
        if (isMember) {
            diskonMember = total * 10 / 100;
        }

        return diskonPromo + diskonMember;
    }
}
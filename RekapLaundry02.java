import java.util.Scanner;

public class RekapLaundry02 {
    static void inputData(int[][] data, Scanner sc) {
        for (int i = 0; i < data.length; i++) {
            System.out.println("Layanan ke-" + (i + 1));

            for (int j = 0; j < data[i].length; j++) {
                System.out.print("Hari ke-" + (j + 1) + " : ");
                data[i][j] = sc.nextInt();
            }
        }
    }

    static void tampilData(int[][] data, String[] layanan) {
        System.out.println("\n-==- DATA BERAT CUCIAN -==-");
        System.out.print("Layanan\t\t");

        for (int i = 0; i < data[0].length; i++) {
            System.out.print("H" + (i + 1) + "\t");
        }

        System.out.println();

        for (int i = 0; i < data.length; i++) {
            if (i == 3) {
                System.out.print(layanan[i] + "\t\t");
            } else {
                System.out.print(layanan[i] + "\t");
            }

            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + "\t");
            }

            System.out.println();
        }
    }

    static int totalPerLayanan(int[][] data, int idxLayanan) {
        int total = 0;
        for (int i = 0; i < data[idxLayanan].length; i++) {
            total += data[idxLayanan][i];
        }
        return total;
    }

    static int hariTersibuk(int[][] data) {
        int maxHari = 0;
        int maxTotal = 0;

        for (int i = 0; i < data[0].length; i++) {
            int total = 0;

            for (int j = 0; j < data.length; j++) {
                total += data[j][i];
            }

            if (total > maxTotal) {
                maxTotal = total;
                maxHari = i;
            }
        }
        return maxHari;
    }

    static void tampilPendapatan(int[][] data, String[] layanan, int[] harga) {
        int totalPendapatan = 0;

        System.out.println("\n-==- PENDAPATAN TIAP LAYANAN -==-");

        for (int i = 0; i < data.length; i++) {
            int totalKg = totalPerLayanan(data, i);
            int pendapatan = totalKg * harga[i];

            totalPendapatan += pendapatan;

            System.out.println(layanan[i] + " : Rp." + pendapatan);
        }

        System.out.println("Total pendapatan : Rp." + totalPendapatan);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] layanan = { "Cuci Kering", "Cuci Setrika", "Setrika Saja", "Express" };

        int[] harga = { 6000, 8000, 5000, 12000 };

        int[][] data = new int[4][6];

        inputData(data, sc);

        tampilData(data, layanan);

        System.out.println("\n===== TOTAL BERAT PER LAYANAN =====");

        for (int i = 0; i < layanan.length; i++) {
            System.out.println(layanan[i] + " : " + totalPerLayanan(data, i) + " Kg");
        }

        int hari = hariTersibuk(data);
        System.out.println("\nHari tersibuk : Hari ke-" + (hari + 1));

        int terbesar = 0;

        for (int i = 1; i < layanan.length; i++) {
            if (totalPerLayanan(data, i) > totalPerLayanan(data, terbesar)) {
                terbesar = i;
            }
        }

        System.out.println("Layanan dengan total berat tertinggi : " + layanan[terbesar] + " ("
                + totalPerLayanan(data, terbesar) + " Kg)");

        tampilPendapatan(data, layanan, harga);

        sc.close();
    }
}
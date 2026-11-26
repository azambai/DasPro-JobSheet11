import java.util.Scanner;
public class BankSampah02 {

    //Fungsi main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("===== BANK SAMPAH =====");
        System.out.print("Masukkan jumlah nasabah: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Jumlah nasabah harus lebih dari 0.");
            return;
        }

        double[] dataSetoran = inputSetoran(sc, n);
        tampilSetoran(dataSetoran);

        double total = totalSetoran(dataSetoran);
        System.out.println("\nTotal berat setoran seluruh nasabah: " + total + " kg");

        double hargaPerKg = 3000;
        System.out.println("\n===== Saldo Setiap Nasabah (Harga: Rp3.000/kg) =====");
        for (int i = 0; i < dataSetoran.length; i++) {
            double saldo = hitungSaldo(dataSetoran[i], hargaPerKg);
            System.out.printf("Nasabah ke-%d: Rp%.0f%n", i + 1, saldo);
        }

        int idxTerbanyak = nasabahTerbanyak(dataSetoran);
        System.out.println("\nNasabah dengan setoran terbesar adalah Nasabah ke-" + (idxTerbanyak + 1) + " dengan berat " + dataSetoran[idxTerbanyak] + " kg.");
    }

    public static double[] inputSetoran(Scanner sc, int n) {
        double[] setoran = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Masukkan berat setoran nasabah ke-" + (i + 1) + " (kg): ");
            setoran[i] = sc.nextDouble();
        }
        return setoran;
    }

    //Fungsi tampilSetoran
    public static void tampilSetoran(double[] setoran) {
        System.out.println("\n===== Daftar Berat Setoran Nasabah =====");
        for (int i = 0; i < setoran.length; i++) {
            System.out.println("Nasabah ke-" + (i + 1) + ": " + setoran[i] + " kg");
        }
    }

    //Fungsi totalSetoran
    public static double totalSetoran(double[] setoran) {
        double total = 0;
        for (int i = 0; i < setoran.length; i++) {
            total += setoran[i];
        }
        return total;
    }

    //Fungsi hitungSaldo
    public static double hitungSaldo(double berat, double hargaPerKg) {
        return berat * hargaPerKg;
    }

    //Fungsi nasabahTerbanyak
    public static int nasabahTerbanyak(double[] setoran) {
        int maxIndex = 0;
        for (int i = 1; i < setoran.length; i++) {
            if (setoran[i] > setoran[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}

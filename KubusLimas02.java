import java.lang.runtime.SwitchBootstraps;
import java.util.Scanner;
public class KubusLimas02 {
    public static int luasPersegi (int s) {
        return s * s;
    }

    public static int volumeKubus (int s) {
        return s * s * s;
    }

    public static int luasPermukaanKubus (int s) {
        return 6 * luasPersegi(s);
    }

    public static double volumeLimasPersegi (int s, int t) {
        return luasPersegi(s) * t /  3.0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int pilihan = -1;

        while (pilihan != 0) {
            System.out.println("\n===== KUBUS LIMAS =====");
            System.out.println("1. Luas Persegi");
            System.out.println("2. Volume Kubus");
            System.out.println("3. Luas Permukaan Kubus");
            System.out.println("4. Volume Limas Persegi");
            System.out.println("0. Keluar");
            System.out.print("Pilih : ");
            pilihan = sc.nextInt();

            switch (pilihan) {
                case 1: 
                    System.out.println("\n===== LUAS PERSEGI =====");
                    System.out.print("Masukkan Sisi Kubus: ");
                        int s1 = sc.nextInt();
                    System.out.println("Luas persegi = " + luasPermukaanKubus(s1));
                    break;

                case 2: 
                    System.out.println("\n===== VOLUME KUBUS =====");
                    System.out.print("Masukkan Sisi Kubus: " );
                        int s2 = sc.nextInt();
                    System.out.println("Volume kubus = " + volumeKubus(s2));
                    break;

                case 3:
                    System.out.println("\n===== LUAS PERMUKAAN KUBUS =====");
                    System.out.print("Masukkan Sisi Kubus: ");
                        int s3 = sc.nextInt();
                    System.out.println("Luas Permukaan Kubus = " + luasPermukaanKubus(s3));
                    break;

                case 4: 
                    System.out.println("\n===== VOLUME LIMAS PERSEGI =====");
                    System.out.print("Masukkan Sisi Alas: ");
                        int s4 = sc.nextInt();            
                    System.out.print("Masukkan Tinggi: ");
                        int t4 = sc.nextInt();
                    System.out.println("Volume Limas Kubus = " + volumeLimasPersegi(s4, t4));
                    break;

                case 0:
                    break;

                default:
                    System.out.println("!! Pilihan Anda Tidak Valid !!");
                    break;
            }
        }
        System.out.println("Program Selesai");
        sc.close();
    }
}

# Postest2_PBO
# Nama: Muhammad Danil Pratama
# NIM: 2309116091

# PROGRAM MANAJEMEN SISTEM PETI KEMAS

# package manajemen/Class MainApp
package manajemen;

import models.Container;
import models.RefrigeratedContainer;
import models.DryStorageContainer;
import models.FlatRackContainer;
import models.ISOTankContainer;
import models.OpenTopContainer;
import models.ContainerManager;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContainerManager manager = new ContainerManager();
        boolean exit = false;

        // Menambahkan 5 container secara otomatis
        manager.addContainer(new RefrigeratedContainer("C001", 1000.5, 25.0));
        manager.addContainer(new DryStorageContainer("C002", 2000.75));
        manager.addContainer(new FlatRackContainer("C003", 1500.3));
        manager.addContainer(new ISOTankContainer("C004", 1800.1));
        manager.addContainer(new OpenTopContainer("C005", 2200.8));

        while (!exit) {
            System.out.println("\n==== Manajemen Sistem Peti Kemas ====");
            System.out.println("1. Tambah Container");
            System.out.println("2. Tampilkan Semua Container");
            System.out.println("3. Update Container");
            System.out.println("4. Hapus Container");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Masukkan ID Container: ");
                    String id = scanner.nextLine();
                    System.out.print("Masukkan Tipe Container (Refrigerated/DryStorage/FlatRack/ISOTank/OpenTop): ");
                    String type = scanner.nextLine();
                    System.out.print("Masukkan Berat Container (kg): ");
                    double weight = scanner.nextDouble();

                    if (type.equalsIgnoreCase("Refrigerated")) {
                        System.out.print("Masukkan Kapasitas Pendingin (kW): ");
                        double coolingCapacity = scanner.nextDouble();
                        manager.addContainer(new RefrigeratedContainer(id, weight, coolingCapacity));
                    } else if (type.equalsIgnoreCase("DryStorage")) {
                        manager.addContainer(new DryStorageContainer(id, weight));
                    } else if (type.equalsIgnoreCase("FlatRack")) {
                        manager.addContainer(new FlatRackContainer(id, weight));
                    } else if (type.equalsIgnoreCase("ISOTank")) {
                        manager.addContainer(new ISOTankContainer(id, weight));
                    } else if (type.equalsIgnoreCase("OpenTop")) {
                        manager.addContainer(new OpenTopContainer(id, weight));
                    } else {
                        System.out.println("Tipe Container tidak valid.");
                    }
                    break;

                case 2:
                    manager.displayAllContainers();
                    break;

                case 3:
                    System.out.print("Masukkan ID Container yang akan di-update: ");
                    String updateId = scanner.nextLine();
                    System.out.print("Masukkan Tipe Baru: ");
                    String newType = scanner.nextLine();
                    System.out.print("Masukkan Berat Baru (kg): ");
                    double newWeight = scanner.nextDouble();
                    manager.updateContainer(updateId, newType, newWeight);
                    break;

                case 4:
                    System.out.print("Masukkan ID Container yang akan dihapus: ");
                    String deleteId = scanner.nextLine();
                    manager.deleteContainer(deleteId);
                    break;

                case 5:
                    exit = true;
                    System.out.println("Keluar dari sistem.");
                    break;

                default:
                    System.out.println("Opsi tidak valid.");
                    break;
            }

            System.out.println("Total container saat ini: " + ContainerManager.totalContainers);
        }

        scanner.close();
    }
}
1. Inisialisasi Program
Program menggunakan beberapa kelas dari package models yang kemungkinan besar berisi definisi untuk berbagai jenis container seperti RefrigeratedContainer, DryStorageContainer, dll.
Objek ContainerManager dibuat untuk mengelola container. Objek ini berfungsi untuk menambah, menampilkan, memperbarui, dan menghapus container.
Awalnya, 5 container dengan berbagai tipe secara otomatis ditambahkan ke manager menggunakan metode addContainer.
2. Menu Utama
Program menampilkan menu utama dalam loop while yang terus berlanjut hingga pengguna memilih untuk keluar. Menu ini memungkinkan pengguna untuk memilih opsi berikut:
Tambah Container:
Pengguna memasukkan ID, tipe container, dan berat container.
Berdasarkan tipe yang dipilih, program meminta input tambahan sesuai tipe container, misalnya untuk tipe Refrigerated, pengguna juga diminta memasukkan kapasitas pendingin.
Setelah input lengkap, container yang sesuai dibuat dan ditambahkan ke manager.
Tampilkan Semua Container:
Memanggil metode displayAllContainers() untuk menampilkan daftar semua container yang ada.
Update Container:
Meminta ID dari container yang akan diupdate, tipe baru, dan berat baru.
Kemudian memanggil metode updateContainer() dengan data baru untuk memperbarui informasi container.
Hapus Container:
Meminta ID container yang ingin dihapus, lalu memanggil metode deleteContainer() untuk menghapus container dari manager.
Keluar:
Mengakhiri loop while dan keluar dari program.
3. Validasi dan Error Handling
Pada saat menambah container, program memverifikasi tipe container yang valid. Jika tipe yang dimasukkan tidak valid, pesan error akan ditampilkan.
Di setiap langkah, program menampilkan jumlah total container yang saat ini ada di sistem dengan memanggil ContainerManager.totalContainers.
4. Penggunaan Scanner
Program menggunakan objek Scanner untuk membaca input dari pengguna melalui konsol. Metode nextLine() digunakan untuk membaca string dan nextDouble() untuk membaca nilai numerik. Metode nextLine() juga digunakan setelah membaca nilai numerik untuk mengkonsumsi karakter newline.
5. Terminasi Program
Program akan berhenti jika pengguna memilih opsi 5 (Keluar), dan scanner.close() dipanggil untuk menutup objek Scanner serta melepaskan sumber daya yang digunakan.


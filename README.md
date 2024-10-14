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

# Struktur Program
Dengan berbagai kelas dan antarmuka yang memfasilitasi manajemen kontainer, struktur kode terdiri dari beberapa paket dan kelas:
1. Package manajemen – Berisi kelas MainAppuntuk menjalankan aplikasi.
2. Package models – Berisi interface CRUDOperations dan beberapa class untuk container dan manajer container:
   - Container (abstract class)
   - Subclass container: RefrigeratedContainer, DryStorageContainer, FlatRackContainer, ISOTankContainer, dan OpenTopContainer.
   - ContainerManager untuk mengelola operasi CRUD.
# Cara Kerja Program
1. MainApp sebagai Entry Point
   Kelas MainApp berfungsi sebagai titik masuk utama yang menangani logika aplikasi melalui input pengguna. Program ini menggunakan Scanner untuk membaca input dari pengguna.
   * Inisialisasi Awal:
     - Scanner dibuka untuk membaca input.
     - Objek ContainerManager dibuat untuk mengelola daftar container.
     - Secara otomatis, 5 container ditambahkan sebagai data awal (contoh instansiasi dari subclass seperti RefrigeratedContainer, DryStorageContainer, dll.).
       manager.addContainer(new RefrigeratedContainer("C001", 1000.5, 25.0));
       manager.addContainer(new DryStorageContainer("C002", 2000.75));
   * Looping Menu Utama: Program menggunakan while untuk menampilkan menu secara berulang hingga pengguna memilih opsi keluar.
2. Operasi CRUD yang Dikelola oleh ContainerManager
   Detail fungsi yang tersedia di menu:
   a. Tambah Container (Opsi 1)
   - Pengguna diminta memasukkan ID, tipe container, dan berat.
   - Berdasarkan tipe yang dipilih, program membuat objek dari subclass yang sesuai.
     if (type.equalsIgnoreCase("Refrigerated")) {
    System.out.print("Masukkan Kapasitas Pendingin (kW): ");
    double coolingCapacity = scanner.nextDouble();
    manager.addContainer(new RefrigeratedContainer(id, weight, coolingCapacity));
}
   b. Tampilkan Semua Container (Opsi 2)
   - ContainerManager memanggil fungsi displayAllContainers().
     * Jika daftar container kosong, program menampilkan pesan bahwa tidak ada container.
     * Jika ada container, setiap container akan memanggil metode displayInfo() miliknya untuk mencetak detailnya.
     * public void displayAllContainers() {
    for (Container container : containers) {
        container.displayInfo();
    }
}
    c. Update Container (Opsi 3)
    - Pengguna memasukkan ID container yang akan di-update, bersama tipe dan berat baru.
    - Program melakukan pencarian berdasarkan ID. Jika ditemukan, data diubah melalui setter yang ada pada class Container.
      for (Container container : containers) {
    if (container.getId().equals(id)) {
        container.setType(newType);
        container.setWeight(newWeight);
    }
}
    - Jika ID tidak ditemukan, pesan error akan muncul.
    d. Hapus Container (Opsi 4)
    - Pengguna memasukkan ID container yang akan dihapus.
    - Jika ID ditemukan, program menghapus container dari list dan mengurangi jumlah total container.
      containers.remove(container);
      totalContainers--;
      - Jika tidak ditemukan, pesan error akan ditampilkan.
    e. Keluar dari Program (Opsi 5)
    - Program menghentikan looping menu dan menampilkan pesan keluar. Scanner ditutup untuk menghindari kebocoran resource.
3. Implementasi Polimorfisme dengan Subclass Container
   Setiap jenis container adalah subclass dari Container, dan setiap subclass memiliki implementasi unik dari displayInfo().
   - Contoh Implementasi Subclass:
     public class RefrigeratedContainer extends Container {
    private final double coolingCapacity;

    @Override
    public void displayInfo() {
        System.out.println("Container ID: " + getId());
        System.out.println("Cooling Capacity: " + coolingCapacity + " kW");
    }
}
    - Ini menunjukkan polimorfisme, di mana setiap objek container memiliki cara berbeda untuk menampilkan informasi.
4. Interface CRUDOperations sebagai Kontrak
   Class ContainerManager mengimplementasikan interface CRUDOperations, yang mendefinisikan operasi dasar CRUD (Create, Read, Update, Delete).
   public interface CRUDOperations {
    void addContainer(Container container);
    void displayAllContainers();
    void updateContainer(String id, String newType, double newWeight);
    void deleteContainer(String id);
}
5. Manajemen List dan Data dengan ContainerManager
   - ArrayList digunakan untuk menyimpan objek container.
   - Setiap kali container ditambahkan atau dihapus, variabel totalContainers diperbarui.
     

# Postest2_PBO
# Nama: Muhammad Danil Pratama
# NIM: 2309116091

# PROGRAM MANAJEMEN SISTEM PETI KEMAS

# Manajemen Sistem Peti Kemas  

## Deskripsi  
Program ini adalah **aplikasi manajemen sistem peti kemas (container management system)** berbasis Java, yang memungkinkan pengguna menambah, melihat, memperbarui, dan menghapus data container. Program ini juga menggunakan konsep OOP (Object-Oriented Programming) seperti inheritance, polymorphism, dan interface. Aplikasi ini mencakup beberapa jenis container: **Refrigerated, Dry Storage, Flat Rack, ISO Tank, dan Open Top**.

---

## Fitur Utama
1. **Tambah Container**: Menambahkan data container baru berdasarkan jenis dan berat.
2. **Tampilkan Semua Container**: Menampilkan daftar semua container yang tersimpan.
3. **Update Container**: Memperbarui tipe dan berat dari container tertentu.
4. **Hapus Container**: Menghapus container berdasarkan ID.
5. **Keluar**: Menutup aplikasi.

---

## Cara Kerja Program

### 1. Struktur Kelas dan Package  
- **`MainApp`**: Berfungsi sebagai entry point aplikasi.
- **Package `models`**: Berisi class-class pendukung, termasuk:
  - `Container`: Abstract class yang mendefinisikan atribut umum dan method untuk semua jenis container.
  - Subclass:
    - `RefrigeratedContainer`
    - `DryStorageContainer`
    - `FlatRackContainer`
    - `ISOTankContainer`
    - `OpenTopContainer`
  - `CRUDOperations`: Interface untuk operasi dasar CRUD (Create, Read, Update, Delete).
  - `ContainerManager`: Mengelola daftar container dan mengimplementasikan interface `CRUDOperations`.

### 2. Alur Program (MainApp)  
1. **Inisialisasi Scanner dan ContainerManager**:  
   - `Scanner` digunakan untuk input pengguna.
   - `ContainerManager` digunakan untuk menyimpan dan mengelola container.

   ```java
   Scanner scanner = new Scanner(System.in);
   ContainerManager manager = new ContainerManager();
   boolean exit = false;

2. **Penambahan Container Otomatis**  
Pada awal program, 5 container dengan tipe berbeda ditambahkan otomatis. Ini membantu memastikan bahwa aplikasi tidak kosong saat dijalankan pertama kali.

```java
manager.addContainer(new RefrigeratedContainer("C001", 1000.5, 25.0));
manager.addContainer(new DryStorageContainer("C002", 2000.75));
manager.addContainer(new FlatRackContainer("C003", 1500.3));
manager.addContainer(new ISOTankContainer("C004", 1800.1));
manager.addContainer(new OpenTopContainer("C005", 2200.8));

3. **Loop Menu Utama**
Aplikasi terus berjalan hingga pengguna memilih opsi **Keluar** (5). Pada setiap iterasi, menu utama ditampilkan, dan pengguna memilih opsi berdasarkan input. Berikut adalah contoh menu utama yang muncul di konsol:
- Jika pengguna memilih opsi selain **Keluar**, aplikasi akan menjalankan fungsi terkait (Tambah, Tampilkan, Update, atau Hapus Container).
- Setelah setiap aksi selesai, menu akan muncul kembali hingga pengguna memilih opsi **Keluar** untuk menghentikan aplikasi.

4. **Operasi CRUD pada Container**  

• Tambah Container:  
Pengguna diminta memasukkan **ID**, **tipe**, dan **berat** container baru. Jika tipe container adalah `Refrigerated`, pengguna juga diminta memasukkan **kapasitas pendingin**. Berikut contoh input untuk menambah container:  

```java
System.out.print("Masukkan ID Container: ");
String id = scanner.nextLine();
System.out.print("Masukkan Tipe Container: ");
String type = scanner.nextLine();
System.out.print("Masukkan Berat Container (kg): ");
double weight = scanner.nextDouble();

### • Tampilkan Semua Container:  
Aplikasi memanggil method `displayAllContainers()`, yang menampilkan setiap container dengan menggunakan method `displayInfo()` untuk setiap instance.  

Contoh pemanggilan:  

```java
manager.displayAllContainers();

• Update Container:
Meminta input ID dan detail baru container. Jika container ditemukan, aplikasinya diperbarui dengan data baru.
System.out.print("Masukkan ID Container: ");
String updateId = scanner.nextLine();
System.out.print("Masukkan Berat Baru: ");
double newWeight = scanner.nextDouble();
manager.updateContainer(updateId, newType, newWeight);

• Hapus Container:
Menghapus container berdasarkan ID, jika ditemukan dalam daftar.
System.out.print("Masukkan ID Container: ");
String deleteId = scanner.nextLine();
manager.deleteContainer(deleteId);

1. Inheritance
Inheritance diimplementasikan melalui kelas Container yang merupakan kelas abstrak. Kelas ini menjadi superclass untuk berbagai jenis kontainer seperti RefrigeratedContainer, DryStorageContainer,           FlatRackContainer, ISOTankContainer, dan OpenTopContainer. Setiap kelas kontainer spesifik mewarisi properti dan metode dari kelas Container, sehingga mengurangi duplikasi kode dan memfasilitasi pemeliharaan.
Struktur Folder dan File
Contoh Penerapan:
public class DryStorageContainer extends Container {
    ...
}

2. Encapsulation
Enkapsulasi diterapkan dengan menggunakan modifier akses untuk membatasi akses ke variabel dan metode. Dalam kelas Container, semua atribut (seperti id, type, dan weight) dideklarasikan sebagai private, sehingga tidak dapat diakses langsung dari luar kelas. Akses ke atribut tersebut dilakukan melalui metode getter dan setter. Contohnya, getId(), getType(), dan setWeight(double weight).
Contoh Penerapan:
private String id;

public String getId() {
    return id;
}

public void setId(String id) {
    this.id = id;
}

3. Abstraction
Abstraksi diterapkan melalui penggunaan antarmuka (interface) dan kelas abstrak. Interface CRUDOperations mendefinisikan metode yang harus diimplementasikan oleh kelas ContainerManager, yang berfungsi untuk operasi CRUD (Create, Read, Update, Delete). Kelas Container juga merupakan kelas abstrak yang mendefinisikan metode displayInfo(), yang diimplementasikan oleh kelas-kelas turunan. Hal ini membantu menyederhanakan kompleksitas dan membuat kode lebih mudah dibaca dan dikelola.
public abstract class Container {
    public abstract void displayInfo();
}

4. Interface
Interface CRUDOperations berisi metode untuk melakukan operasi CRUD pada kontainer. Kelas ContainerManager mengimplementasikan interface ini, yang memaksa kelas tersebut untuk menyediakan implementasi untuk setiap metode yang didefinisikan di interface. Ini membuat kode lebih modular dan terstruktur dengan baik.
public interface CRUDOperations {
    void addContainer(Container container);
    void displayAllContainers();
    void updateContainer(String id, String newType, double newWeight);
    void deleteContainer(String id);
}

5. Final Keyword
Keyword final digunakan dalam kelas ContainerManager dan kelas-kelas kontainer seperti DryStorageContainer, FlatRackContainer, ISOTankContainer, OpenTopContainer, dan RefrigeratedContainer. Menandai kelas dengan final berarti kelas tersebut tidak dapat diturunkan lebih lanjut, sehingga mengamankan fungsionalitas kelas tersebut. Di samping itu, variabel totalContainers dalam kelas ContainerManager juga dideklarasikan sebagai final, menunjukkan bahwa nilai tersebut tidak dapat diubah setelah diinisialisasi.
public final class ContainerManager implements CRUDOperations {
    ...
}


/manajemen-sistem-peti-kemas
│
├── /manajemen
│   └── MainApp.java
│
└── /models
    ├── Container.java
    ├── CRUDOperations.java
    ├── ContainerManager.java
    ├── RefrigeratedContainer.java
    ├── DryStorageContainer.java
    ├── FlatRackContainer.java
    ├── ISOTankContainer.java
    └── OpenTopContainer.java

Contoh Output
==== Manajemen Sistem Peti Kemas ====
1. Tambah Container
2. Tampilkan Semua Container
3. Update Container
4. Hapus Container
5. Keluar
Pilih opsi: 2

Container ID: C001
Type: Refrigerated
Weight: 1000.5 kg
Cooling Capacity: 25.0 kW
------------
Container ID: C002
Type: DryStorage
Weight: 2000.75 kg

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

Struktur Folder dan File
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

import java.util.*;
class dokter{
    Scanner in = new Scanner(System.in);
    int idDokter;
    String namaDokter;
    Boolean sex;
    String email;
    String password;
    Queue<pasien> listPasien = new PriorityQueue<pasien>();
    
    int n = 0;
    public void register(){
        System.out.println("Register:");
        idDokter = n+1;
        System.out.print("Nama dokter = ");
        namaDokter = in.nextLine();
        System.out.print("Jenis kelamin (0 = wanita, 1 = pria) = ");
        int j = in.nextInt();
        if(j == 1){
            sex = true;
        }
        else{
            sex = false;
        }
        in.nextLine();
        System.out.print("Email = ");
        email = in.nextLine();
        System.out.print("Password = ");
        password = in.nextLine();
        System.out.println("Register Success");
    }
    public void login(){
        System.out.println("Login:");
        System.out.print("Email = ");
        String a = in.nextLine();
        System.out.print("Password = ");
        String b = in.nextLine();
        if(a.equals(email) && b.equals(password)){
            System.out.println("Login Success");
        }
        else{
            System.out.println("Login Failed - Wrong email or password");
        }
    }
    
    public void addPasien(pasien pasienBaru){
        listPasien.add(pasienBaru);
    }
    
    public void showPasien(){
       System.out.println("List pasien: ");
       Queue<pasien> tempList;
       tempList = listPasien;
       while (listPasien.isEmpty()==false) {
           System.out.println("ID: "+tempList.peek().idPasien);
           System.out.println("nama: "+tempList.peek().namaPasien);
           tempList.remove();
       }
    } 
}
class pasien{
    Scanner in = new Scanner(System.in);
    int idPasien;
    String namaPasien;
    Boolean sex;
    String email;
    String password;
    int n = 0;
    public void register(){
        System.out.println("Register:");
        idPasien = n+1;
        System.out.print("Nama pasien = ");
        namaPasien = in.nextLine();
        System.out.print("Jenis kelamin (0 = wanita, 1 = pria) = ");
        int j = in.nextInt();
        if(j == 1){
            sex = true;
        }
        else{
            sex = false;
        }
        in.nextLine();
        System.out.print("Email = ");
        email = in.nextLine();
        System.out.print("Password = ");
        password = in.nextLine();
        System.out.println("Register Success");
    }
    public void login(){
        System.out.println("Login:");
        System.out.print("Email = ");
        String a = in.nextLine();
        System.out.print("Password = ");
        String b = in.nextLine();
        if(a.equals(email) && b.equals(password)){
            System.out.println("Login Success");
        }
        else{
            System.out.println("Login Failed - Wrong email or password");
        }
    }
}
class daftarAlergi{
    Scanner in = new Scanner(System.in);
    int idPasien;
    String namaAlergi;
    String bahanMakanan;
    String obat;
    public void tambah(){
        System.out.println("Tambah daftar alergi :");
        System.out.print("ID Pasien = ");
        idPasien = in.nextInt();
        in.nextLine();
        System.out.print("Nama Alergi = ");
        namaAlergi = in.nextLine();
        System.out.print("Bahan Makanan = ");
        bahanMakanan = in.nextLine();
        System.out.print("Obat = ");
        obat = in.nextLine();
        System.out.println("Daftar alergi berhasil ditambah");
    }
    public void update(){
        System.out.println("Update daftar alergi :");
        System.out.print("ID Pasien = ");
        int k = in.nextInt();
        in.nextLine();
        if(k == idPasien){
            System.out.print("Nama Alergi = ");
            namaAlergi = in.nextLine();
            System.out.print("Bahan Makanan = ");
            bahanMakanan = in.nextLine();
            System.out.print("Obat = ");
            obat = in.nextLine();
            System.out.println("Daftar alergi berhasil diupdate");
        }
        else{
            System.out.println("Daftar alergi tidak ditemukan");
        }

    }
}
public class classDiagram{
    public static void main(String[] args){
        pasien pas = new pasien();
        pas.register();
        pas.login();
        daftarAlergi daf = new daftarAlergi();
        daf.tambah();
        daf.update();
        dokter dok = new dokter();
        dok.register();
        dok.login();
        //menambah pasien "pas" sebagai pasien dokter "dok"
        dok.addPasien(pas);
        //menunjukkan list pasien dari dokter "dok"
        dok.showPasien();
    }
}

import java.util.*;
class pasien {
    Scanner in = new Scanner(System.in);
    int idPasien;
    String namaPasien;
    Boolean sex;
    String email;
    String password;
    static int n = 0;
    {
        n += 1;
        idPasien = n;
    }
    public void register(){
        System.out.println("Register:");
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
    ArrayList<String> namaAlergi = new ArrayList<String>();
    ArrayList<String> bahanMakanan = new ArrayList<String>();
    ArrayList<String> obat = new ArrayList<String>();
    {
        System.out.print("ID Pasien = ");
        idPasien = in.nextInt();
        in.nextLine();
    }
    public void tambah(){
        System.out.println("Tambah daftar alergi :");
        System.out.print("Nama Alergi = ");
        String a = in.nextLine();
        namaAlergi.add(a);
        System.out.print("Bahan Makanan = "); 
        String b= in.nextLine();
        bahanMakanan.add(b);
        System.out.print("Obat = ");
        String c = in.nextLine();
        obat.add(c);
        System.out.println("Daftar alergi berhasil ditambah");
        Collections.sort(namaAlergi);
        Collections.sort(bahanMakanan);
        Collections.sort(obat);
    }
    public void update(){
        System.out.println("\nUpdate daftar alergi :");
        System.out.println("1. Nama Alergi\n2. Bahan Makanan\n3. Obat");
        System.out.print("Pilih = ");
        int key = in.nextInt();
        in.nextLine();
        switch(key){
            case 1 : 
                System.out.print("Nama Alergi yang ingin diubah = ");
                String d = in.nextLine();
                for(int i=0; i<namaAlergi.size(); i++){
                    if(namaAlergi.get(i).equalsIgnoreCase(d)){
                        System.out.print("Nama Alergi Baru = ");
                        String e = in.nextLine();
                        namaAlergi.set(i,e);
                        Collections.sort(namaAlergi);
                        System.out.println("Data berhasil diupdate");
                    }
                    else{
                        System.out.println("Data tidak ditemukan");
                    }
                }
            break;
            case 2:
                System.out.print("Bahan Makanan yang ingin diubah = ");
                d = in.nextLine();
                for(int i=0; i<bahanMakanan.size(); i++){
                    if(bahanMakanan.get(i).equalsIgnoreCase(d)){
                        System.out.print("Bahan Makanan Baru = ");
                        String e = in.nextLine();
                        bahanMakanan.set(i,e);
                        Collections.sort(bahanMakanan);
                        System.out.println("Data berhasil diupdate");
                    }
                    else{
                        System.out.println("Data tidak ditemukan");
                    }
                }
            break;
            case 3:
                System.out.print("Obat yang ingin diubah = ");
                d = in.nextLine();
                for(int i=0; i<obat.size(); i++){
                    if(obat.get(i).equalsIgnoreCase(d)){
                        System.out.print("Obat Baru = ");
                        String e = in.nextLine();
                        obat.set(i,e);
                        Collections.sort(obat);
                        System.out.println("Data berhasil diupdate");
                    }
                    else{
                        System.out.println("Data tidak ditemukan");
                    }
                }
            break;
        }
    }
}
class dokter{
    Scanner in = new Scanner(System.in);
    int idDokter;
    String namaDokter;
    Boolean sex;
    String email;
    String password;
    Queue<pasien> listPasien = new LinkedList<pasien>();
    
    static int m = 0;
    {
        m += 1;
        idDokter = m;
    }
    public void register(){
        System.out.println("Register:");
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
        pasien tempPasien = new pasien();
        tempPasien = pasienBaru;
        listPasien.add(tempPasien);
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

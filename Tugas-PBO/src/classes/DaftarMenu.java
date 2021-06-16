/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;
import java.awt.*;
import java.util.ArrayList;
/**
 *
 * @author musa
 */
public class DaftarMenu {
    private ArrayList<Menu> daftarMenu;
    
    public DaftarMenu(){
	    daftarMenu = new ArrayList<>();
	}
    
    public void tambahMenu (Menu menu){
	    daftarMenu.add(menu);
	}
    
    public void getMenuByKategori (String kategori){
	    System.out.println("======= " + kategori + " =======");
	    for (int i = 0; i < daftarMenu.size(); i++){
		Menu m = daftarMenu.get(i);
		if (m.getKategori().equals(kategori)){
		    System.out.println((i+1) + ". " + m.getNama_menu() + "\t" + m.getHarga());
			}
		}
	}
    
    public void tampilDaftarMenu(){
		System.out.println("======= ALDEBARAMEN =======");
		getMenuBykategori ("Ramen");
		getMenuBykategori ("Kuah");
		getMenuBykategori ("Toping");
		getMenuBykategori ("Minuman");
	}

    public Menu pilihanMenu(){
	    try{
		Scanner input = new Scanner(System.in);

		System.out.print("Nomor Menu yang dipesan : ");
		int no_menu = input.nextInt();

		Menu m = daftarMenu.get(no_menu-1);

		if(!m.getKategori().equalsIgnoreCase("Kuah")){
			    return m;
			}else{
				System.out.println("[Err] Pesan dulu Menu Ramen");
				return pilihMenu();
			}
		}catch(IndexOutOfBoundsException err){
		    System.out.println("[Err] Pesanan Tidak Tersedia");
		    return pilihMenu();
		}catch(InputMismatchException err){
		    System.out.println("[Err] Mohon Masukkan Nomor Menu");
		    return pilihMenu();
		}
	}

    public Menu pilihKuah(){
        try{
            Scanner input = new Scanner(System.in);
            
            System.out.println("Kuah : [sesuai nomor menu]");
            int no_menu = input.nextInt();
            
            // Get menu berdasarkan no_menu, di -1 karena arrayList mulai dari 0
            Menu m = daftarMenu.get(no_menu - 1);
            
            // Cek apakah menu kuah?
            if(m.getKategori().equalsIgnoreCase("Kuah")) {
                return m;
            } else {
                System.out.println("[Err] Bukan Menu Kuah");
                return pilihKuah();
            }
        } catch(IndexOutOfBoundsException err) {
            // Jika no_menu tidak ada, maka akan masuk kesini
            // no_menu dianggap tidak ada ketika no_menu diluar dari index pada arrayList
            System.out.println("[Err] Pesanan tidak tersedia");
            return pilihKuah();
        } catch(InputMismatchException err) {
            // Jika input bukan berupa angka akan masuk kesini
            System.out.println("[Err] Mohon masukkan nomor kuah");
            return pilihKuah();
        }
    }
}

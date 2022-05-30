import java.util.ArrayList;
import java.util.Scanner;


// This code is just a foundation for my main program



public class Restoran {

	public static void main(String[] args) {
		
		ArrayList<yemek> yemekler = new ArrayList<yemek>();
		ArrayList<admin> admins = new ArrayList<admin>();
		//default admin
		admin defaultadmin = new admin("admin", "admin");
		admins.add(defaultadmin);
		
		while (true) {
			System.out.println("Restorana Ho� geldiniz.");
			System.out.println("Y�netici giri�i i�in: 1 \tSipari� i�in: 2 \t��k�� i�in: 3");
			Scanner sc = new Scanner(System.in);
			int secim = sc.nextInt();
			if (secim == 1) {
				while(true) {
					System.out.println("Kullan�c� ad�: ");
					String user = sc.next();
					System.out.println("�ifre: ");
					String password = sc.next();
						for (admin admin : admins) {
							if (user.equals(admin.getUsername()) && password.equals(admin.getPass())) {
								while(true) {
									System.out.println("Y�netici aray�z�ne ho�geldiniz. Bir i�lem se�in;");
									System.out.println("Di�er y�neticiler ve i�lemler men�s�: 1 \nMen�y� d�zenle: 2 \n��k��: 3");
									int yoneticisecim = sc.nextInt();
									if (yoneticisecim == 1) {
										while(true) {
											for (admin admin2 : admins) {
												System.out.println(admin2.getUsername());
											}
											System.out.println("Y�netici ekle: 1 \nY�netici ��kar: 2 \nGeri: 3");
											int key = sc.nextInt();
											if (key == 1) {
												System.out.println("Username: ");
												String username = sc.next();
												System.out.println("Password: ");
												String apass = sc.next();
												admin Admin = new admin(username, apass);
												admins.add(Admin);
												System.out.println("Y�netici olu�turuldu.");
											}
											else if (key == 2) {
												System.out.println("��karmak istedi�iniz y�neticinin ad�n� girin: ");
												String username = sc.next();
												for (admin admin2 : admins) {
													if(username == admin2.getUsername()) {
														admins.remove(admin2);
													}
												}
												System.out.println("Y�netici silindi.");
												break;
											}
											else if (key == 3) {
												break;
											}
											else
												System.out.println("L�tfen ge�erli bir i�lem se�iniz.");
										}
									}
									else if (yoneticisecim == 2) {
										while(true) {
											System.out.println("Men�;");
											for (yemek yemek : yemekler) {
												System.out.println(yemek.getYemek() + "   " + yemek.getFiyat() + "   No: " + yemekler.indexOf(yemek));
											}
											System.out.println("Yemek ekle: 1 \nYemek ��kar: 2 \nGeri: 3");
											int key = sc.nextInt();
											if (key == 1) {
												System.out.println("Yeme�in ad�: ");
												String yemek_adi = sc.next();
												System.out.println("Yeme�in fiyat�: ");
												double yemek_fiyat = sc.nextDouble();
												yemek Yemek = new yemek(yemek_adi, yemek_fiyat);
												yemekler.add(Yemek);
												System.out.println("Yemek ba�ar�yla men�ye eklendi.");
											}
											else if (key == 2) {
												System.out.println("Yeme�in ad�: ");
												String yemek_adi = sc.next();
												for (yemek yemek : yemekler) {
													if (yemek_adi == yemek.getYemek()) {
														yemekler.remove(yemek);
													}
												}
												System.out.println("Yemek men�den ��kar�ld�.");
											}
											else if (key == 3) {
												break;
											}
											else
												System.out.println("L�tfen ge�erli bir i�lem se�in.");
										}
									}
									else if (yoneticisecim == 3) {
										System.out.println("��k�� yap�l�yor...");
										break;
									}
									else
										System.out.println("L�tfen ge�erli bir i�lem se�iniz.");
								}
							}
							else if (user != admin.getUsername() && password.equals(admin.getPass())){
								System.out.println("Hatal� kullan�c� ad�.");
								continue;
							}
							else if (user == admin.getUsername() && password != admin.getPass()){
								System.out.println("Hatal� �ifre.");
								continue;
							}
							else if (user != admin.getUsername() && password != admin.getPass()){
								System.out.println("Hatal� kullan�c� ad� ve �ifre.");
								continue;
							}
							else {
								System.out.println("B�yle bir kullan�c� yok.");
								continue;
							}
						}
					break;
					}
			}
			else if (secim == 2) {
				while(true) {
					ArrayList<yemek> sepet = new ArrayList<yemek>();
					double hesap = 0;
					System.out.println("Men�dekiler;");
					for (yemek yemek : yemekler) {
						System.out.println(yemek.getYemek() + "   " + yemek.getFiyat() + "   No: " + yemekler.indexOf(yemek));
					}
					System.out.println("Sipari�e ekle: 1" + "\n" + "Sipari�ten ��kar: 2" + "\n" + "Onayla: 3" + "\n" + "�ptal: 4");
					int siparissecim = sc.nextInt();
					if (siparissecim == 1) {
						while(true) {
							System.out.println("Yemek no girin: ");
							int yemekno = sc.nextInt();
							sepet.add(yemekler.get(yemekno));
							hesap += yemekler.get(yemekno).getFiyat();
							System.out.println("Sipari�e eklendi.");
							break;
						}
					}
					else if (siparissecim == 2) {
						while(true) {
							for (yemek yemek : sepet) {
								System.out.println(yemek.getYemek() + "   " + yemek.getFiyat() + "   No: " + sepet.indexOf(yemek));
							}
							System.out.println("Yemek no girin: ");
							int yemekno = sc.nextInt();
							sepet.remove(sepet.get(yemekno));
							hesap -= sepet.get(yemekno).getFiyat();
							System.out.println("Sipari�ten ��kar�ld�.");
						break;
						}
					}
					else if (siparissecim == 3) {
						System.out.println("Sipari� onayland�, mutfa�a g�nderiliyor...");
						System.out.println("Mutfa�a ba�ar�yla g�nderildi.");
						System.out.println("G�ncel hesap " + hesap + "tl.");
						break;
					}
					else if (siparissecim == 4) {
						System.out.println("�ptal ediliyor...");
						break;
					}
					else
						System.out.println("L�tfen ge�erli bir i�lem se�in.");
				}
			}
			else if (secim == 3) {
				System.out.println("Program kapat�l�yor...");
				break;
			}
			else 
				System.out.println("L�tfen ge�erli bir say� giriniz.");
		}
	
	}

}

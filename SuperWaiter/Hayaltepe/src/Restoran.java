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
			System.out.println("Restorana Hoþ geldiniz.");
			System.out.println("Yönetici giriþi için: 1 \tSipariþ için: 2 \tÇýkýþ için: 3");
			Scanner sc = new Scanner(System.in);
			int secim = sc.nextInt();
			if (secim == 1) {
				while(true) {
					System.out.println("Kullanýcý adý: ");
					String user = sc.next();
					System.out.println("Þifre: ");
					String password = sc.next();
						for (admin admin : admins) {
							if (user.equals(admin.getUsername()) && password.equals(admin.getPass())) {
								while(true) {
									System.out.println("Yönetici arayüzüne hoþgeldiniz. Bir iþlem seçin;");
									System.out.println("Diðer yöneticiler ve iþlemler menüsü: 1 \nMenüyü düzenle: 2 \nÇýkýþ: 3");
									int yoneticisecim = sc.nextInt();
									if (yoneticisecim == 1) {
										while(true) {
											for (admin admin2 : admins) {
												System.out.println(admin2.getUsername());
											}
											System.out.println("Yönetici ekle: 1 \nYönetici çýkar: 2 \nGeri: 3");
											int key = sc.nextInt();
											if (key == 1) {
												System.out.println("Username: ");
												String username = sc.next();
												System.out.println("Password: ");
												String apass = sc.next();
												admin Admin = new admin(username, apass);
												admins.add(Admin);
												System.out.println("Yönetici oluþturuldu.");
											}
											else if (key == 2) {
												System.out.println("Çýkarmak istediðiniz yöneticinin adýný girin: ");
												String username = sc.next();
												for (admin admin2 : admins) {
													if(username == admin2.getUsername()) {
														admins.remove(admin2);
													}
												}
												System.out.println("Yönetici silindi.");
												break;
											}
											else if (key == 3) {
												break;
											}
											else
												System.out.println("Lütfen geçerli bir iþlem seçiniz.");
										}
									}
									else if (yoneticisecim == 2) {
										while(true) {
											System.out.println("Menü;");
											for (yemek yemek : yemekler) {
												System.out.println(yemek.getYemek() + "   " + yemek.getFiyat() + "   No: " + yemekler.indexOf(yemek));
											}
											System.out.println("Yemek ekle: 1 \nYemek çýkar: 2 \nGeri: 3");
											int key = sc.nextInt();
											if (key == 1) {
												System.out.println("Yemeðin adý: ");
												String yemek_adi = sc.next();
												System.out.println("Yemeðin fiyatý: ");
												double yemek_fiyat = sc.nextDouble();
												yemek Yemek = new yemek(yemek_adi, yemek_fiyat);
												yemekler.add(Yemek);
												System.out.println("Yemek baþarýyla menüye eklendi.");
											}
											else if (key == 2) {
												System.out.println("Yemeðin adý: ");
												String yemek_adi = sc.next();
												for (yemek yemek : yemekler) {
													if (yemek_adi == yemek.getYemek()) {
														yemekler.remove(yemek);
													}
												}
												System.out.println("Yemek menüden çýkarýldý.");
											}
											else if (key == 3) {
												break;
											}
											else
												System.out.println("Lütfen geçerli bir iþlem seçin.");
										}
									}
									else if (yoneticisecim == 3) {
										System.out.println("Çýkýþ yapýlýyor...");
										break;
									}
									else
										System.out.println("Lütfen geçerli bir iþlem seçiniz.");
								}
							}
							else if (user != admin.getUsername() && password.equals(admin.getPass())){
								System.out.println("Hatalý kullanýcý adý.");
								continue;
							}
							else if (user == admin.getUsername() && password != admin.getPass()){
								System.out.println("Hatalý þifre.");
								continue;
							}
							else if (user != admin.getUsername() && password != admin.getPass()){
								System.out.println("Hatalý kullanýcý adý ve þifre.");
								continue;
							}
							else {
								System.out.println("Böyle bir kullanýcý yok.");
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
					System.out.println("Menüdekiler;");
					for (yemek yemek : yemekler) {
						System.out.println(yemek.getYemek() + "   " + yemek.getFiyat() + "   No: " + yemekler.indexOf(yemek));
					}
					System.out.println("Sipariþe ekle: 1" + "\n" + "Sipariþten çýkar: 2" + "\n" + "Onayla: 3" + "\n" + "Ýptal: 4");
					int siparissecim = sc.nextInt();
					if (siparissecim == 1) {
						while(true) {
							System.out.println("Yemek no girin: ");
							int yemekno = sc.nextInt();
							sepet.add(yemekler.get(yemekno));
							hesap += yemekler.get(yemekno).getFiyat();
							System.out.println("Sipariþe eklendi.");
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
							System.out.println("Sipariþten çýkarýldý.");
						break;
						}
					}
					else if (siparissecim == 3) {
						System.out.println("Sipariþ onaylandý, mutfaða gönderiliyor...");
						System.out.println("Mutfaða baþarýyla gönderildi.");
						System.out.println("Güncel hesap " + hesap + "tl.");
						break;
					}
					else if (siparissecim == 4) {
						System.out.println("Ýptal ediliyor...");
						break;
					}
					else
						System.out.println("Lütfen geçerli bir iþlem seçin.");
				}
			}
			else if (secim == 3) {
				System.out.println("Program kapatýlýyor...");
				break;
			}
			else 
				System.out.println("Lütfen geçerli bir sayý giriniz.");
		}
	
	}

}

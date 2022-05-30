
public class yemek {

private String yemekismi;
private double yemekfiyat;

public yemek (String Menu, double fiyat) {
	yemekismi = Menu;
	yemekfiyat = fiyat;
}

public String getYemek() {
	return yemekismi;
}

public void setYemek(String yemek) {
	yemekismi = yemek;
}

public double getFiyat() {
	return yemekfiyat;
}

public void setFiyat(double yemek) {
	yemekfiyat = yemek;
}

}

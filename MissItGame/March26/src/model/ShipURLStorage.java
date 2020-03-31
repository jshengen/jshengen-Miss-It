package model;

public enum ShipURLStorage {

	SHIP1("model/resources/SmallJetpng.png");

	private String URL;
	
	ShipURLStorage(String URL) {
		this.URL = URL;
	}
	
	
	public String getURL() {
		return URL;
	}
	
	

}

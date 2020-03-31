package model;

public enum ObstacleURLStorage {

	OBSTACLE1("model/resources/ObtstacleLarge.png");
	
	private String URL;
	

	ObstacleURLStorage(String URL){
		this.URL = URL;
		
	}
	
	public String getURL() {
		return URL;
	}
	
}

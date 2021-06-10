package Model;

public class User {

	private String username;
	private String date;	
	private int puntaje = 0;
	
	public User(String user, String date) {
		// TODO Auto-generated constructor stub
		this.username = user;
		this.date = date;
	}
	
	

	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	
	

}

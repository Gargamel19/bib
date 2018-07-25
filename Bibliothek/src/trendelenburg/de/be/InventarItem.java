package trendelenburg.de.be;

public class InventarItem {

	
	private String id;
	private String titel;
	private String autor;
	private String genre;
	private String verfuegbar = "nein";
	
	public InventarItem(String id, String titel, String autor, String genre, String verfuegbar){
		this.id = id;
		this.titel = titel;
		this.autor = autor;
		this.genre = genre;
		if (verfuegbar.equals("1")) {
			this.verfuegbar = "ja";
		}
	}
	
	public String getTitel() {
		return titel;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public String getId() {
		return id;
	}
	
	public String getVerfuegbar() {
		return verfuegbar;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof InventarItem) {
			InventarItem other = (InventarItem) obj;
			return (this.getId().equals(other.getId()));		
		}
		return false;
	}
	
	@Override
	public String toString() {
		return titel + " von " + autor + genre;
	}
}

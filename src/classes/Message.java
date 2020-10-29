package classes;

public class Message {
	
	private int id ;
	private String username ;
	private String sentname ;
	private String mesg ;
	
	
	public Message() {
		super();
	}
	
	
	
	
	
	public Message(String username, String sentname, String mesg) {
		super();
		this.username = username;
		this.sentname = sentname;
		this.mesg = mesg;
	}


    


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}





	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSentname() {
		return sentname;
	}
	public void setSentname(String sentname) {
		this.sentname = sentname;
	}
	public String getMesg() {
		return mesg;
	}
	public void setMesg(String mesg) {
		this.mesg = mesg;
	}
	
	
	
	

}

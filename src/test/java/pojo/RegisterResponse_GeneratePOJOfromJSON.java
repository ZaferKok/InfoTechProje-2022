package pojo;

import java.util.List;

public class RegisterResponse_GeneratePOJOfromJSON {
	private String lastName;
	private String lastModifiedDate;
	private String lastModifiedBy;
	private String login;
	private List<Object> authorities;
	private String ssn;
	private String firstName;
	private String createdDate;
	private String langKey;
	private String createdBy;
	private String imageUrl;
	private int id;
	private String email;
	private boolean activated;

	public String getLastName(){
		return lastName;
	}

	public String getLastModifiedDate(){
		return lastModifiedDate;
	}

	public String getLastModifiedBy(){
		return lastModifiedBy;
	}

	public String getLogin(){
		return login;
	}

	public List<Object> getAuthorities(){
		return authorities;
	}

	public String getSsn(){
		return ssn;
	}

	public String getFirstName(){
		return firstName;
	}

	public String getCreatedDate(){
		return createdDate;
	}

	public String getLangKey(){
		return langKey;
	}

	public String getCreatedBy(){
		return createdBy;
	}

	public String getImageUrl(){
		return imageUrl;
	}

	public int getId(){
		return id;
	}

	public String getEmail(){
		return email;
	}

	public boolean isActivated(){
		return activated;
	}

	@Override
 	public String toString(){
		return 
			"ResponseGeneratePOJOfromJSON{" + 
			"lastName = '" + lastName + '\'' + 
			",lastModifiedDate = '" + lastModifiedDate + '\'' + 
			",lastModifiedBy = '" + lastModifiedBy + '\'' + 
			",login = '" + login + '\'' + 
			",authorities = '" + authorities + '\'' + 
			",ssn = '" + ssn + '\'' + 
			",firstName = '" + firstName + '\'' + 
			",createdDate = '" + createdDate + '\'' + 
			",langKey = '" + langKey + '\'' + 
			",createdBy = '" + createdBy + '\'' + 
			",imageUrl = '" + imageUrl + '\'' + 
			",id = '" + id + '\'' + 
			",email = '" + email + '\'' + 
			",activated = '" + activated + '\'' + 
			"}";
		}
}
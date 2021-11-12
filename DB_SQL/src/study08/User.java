package study08;

public class User {

	String ID;
	String PW;
	String name;
	String age;
	String gender;
	String email;
	
	

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPW() {
		return PW;
	}

	public void setPW(String pW) {
		PW = pW;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User(String iD, String pW, String name, String age, String gender, String email) {
		super();
		ID = iD;
		PW = pW;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.email = email;
	}
	
	@Override
	public String toString() {
		
		return "아이디 = "+ID+", 비밀번호 = "+PW+", 이름 = "+name+", 나이 = "+age+", 성별 = "+gender+
				 ", 이메일 = "+email;
	}

}

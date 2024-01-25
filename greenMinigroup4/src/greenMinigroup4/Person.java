package greenMinigroup4;

public class Person {
	
	public int idx;
	public String name;
	public String age;
	public String gender;
	public String phoneNumber;
	public String MBTI;
	public String address;
	public String nickName;
	public String category;
	public int u_idx;
	
	public Person(){
		
	}
	
	public Person(String name, String age, String gender, String phoneNumber, String MBTI, String address, String nickName, String category){
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.MBTI = MBTI;
		this.address = address;
		this.nickName = nickName;
		this.category = category;
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getMBTI() {
		return MBTI;
	}
	public void setMBTI(String mBTI) {
		MBTI = mBTI;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getU_idx() {
		return u_idx;
	}
	public void setU_idx(int u_idx) {
		this.u_idx = u_idx;
	}

	@Override
	public String toString() {
		return "Person [idx=" + idx + ", name=" + name + ", age=" + age + ", gender=" + gender + ", phoneNumber="
				+ phoneNumber + ", MBTI=" + MBTI + ", address=" + address + ", nickName=" + nickName + ", category="
				+ category + ", u_idx=" + u_idx + "]";
	}
	
	
}
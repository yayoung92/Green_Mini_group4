package greenMinigroup4;

public class User {
	public int idx;
	public String userId;
	public String userPassword;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	@Override
	public String toString() {
		return "User [idx=" + idx + ", userId=" + userId + ", userPassword=" + userPassword + "]";
	}
	
	
}
package KeTangLianXi3;

public class User {
	private int id;
	private String name;
	private String password;
	private int sole;//权限   0:冻结用户    1：普通用户    2：管理员
	public User() {
		super();
	}
	public User(int id, String name, String password, int sole) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.sole = sole;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getSole() {
		return sole;
	}
	public void setSole(int sole) {
		this.sole = sole;
	}
}

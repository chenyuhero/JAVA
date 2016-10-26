package entity;

import java.util.Date;

public class Students {

	private String sid;// 学号
	private String sname;// 姓名
	private String gender;// 性别
	private Date birthday;// 出生日期
	private String adress;//

	public Students() {

	}

	public Students(String sid, String sname, String gender, Date birthday,
			String adress) {
		// super();
		this.sid = sid;
		this.sname = sname;
		this.gender = gender;
		this.birthday = birthday;
		this.adress = adress;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	// 方便测试，设立tostring方法
	@Override
	public String toString() {
		return "Students [sid=" + sid + ", sname=" + sname + ", gender="
				+ gender + ", birthday=" + birthday + ", adress=" + adress
				+ "]";
	}

}

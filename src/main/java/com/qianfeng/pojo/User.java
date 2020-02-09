package com.qianfeng.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;



public class User {


	private String username;

	private int id;

//	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date birthday;

	private String sex;



	public User() {
	}

	public User(String username, int id, Date birthday, String sex) {
		this.username = username;
		this.id = id;
		this.birthday = birthday;
		this.sex = sex;

	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}



	@Override
	public String toString() {
		return "User{" +
				"username='" + username + '\'' +
				", id=" + id +
				", birthday=" + birthday +
				", sex='" + sex + '\'' +
				'}';
	}
}

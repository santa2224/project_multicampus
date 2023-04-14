package com.team6.jejuana.controller;

public class MemberVO {
	private String id;
	private String password;
	private String name;
	private String nickname;
	private String email;
	private String addr;
	private String profile_img;
	private String profile_text;
	private String sign_date;
	private int blocked;
	private int claim_count;
	private int age;
	private int gender;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getProfile_img() {
		return profile_img;
	}
	public void setProfile_img(String profile_img) {
		this.profile_img = profile_img;
	}
	public String getProfile_text() {
		return profile_text;
	}
	public void setProfile_text(String profile_text) {
		this.profile_text = profile_text;
	}
	public String getSign_date() {
		return sign_date;
	}
	public void setSign_date(String sign_date) {
		this.sign_date = sign_date;
	}
	public int getBlocked() {
		return blocked;
	}
	public void setBlocked(int blocked) {
		this.blocked = blocked;
	}
	public int getClaim_count() {
		return claim_count;
	}
	public void setClaim_count(int claim_count) {
		this.claim_count = claim_count;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "RegisterDTO [id=" + id + ", password=" + password + ", name=" + name + ", nickname=" + nickname
				+ ", email=" + email + ", addr=" + addr + ", profile_img=" + profile_img + ", profile_text="
				+ profile_text + ", sign_date=" + sign_date + ", blocked=" + blocked + ", claim_count=" + claim_count
				+ ", age=" + age + ", gender=" + gender + "]";
	}
	
	
}

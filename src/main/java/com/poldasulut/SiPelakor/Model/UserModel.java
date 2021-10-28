package com.poldasulut.SiPelakor.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private int userId;
	@ManyToOne
	@JoinColumn(name = "id_kota_kab")
	private KotaKabupatenModel kotaKabupatenId;
	@Column(name = "nik_user")
	private String nikUser;
	@Column(name = "name_user")
	private String userName;
	@Column(name = "jobs")
	private String jobs;
	@Column(name = "address_user")
	private String addressUser;
	@Column(name = "nomor_user")
	private String nomorUser;
	@Column(name = "email_user")
	private String userEmail;
	@Column(name = "password_user")
	private String userPassword;
	@Column(name = "status_user")
	private String userStatus;
	@Column(name = "user_ttl")
	private String tanggalLahir;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public KotaKabupatenModel getKotaKabupatenId() {
		return kotaKabupatenId;
	}

	public void setKotaKabupatenId(KotaKabupatenModel kotaKabupatenId) {
		this.kotaKabupatenId = kotaKabupatenId;
	}

	public String getNikUser() {
		return nikUser;
	}

	public void setNikUser(String nikUser) {
		this.nikUser = nikUser;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getJobs() {
		return jobs;
	}

	public void setJobs(String jobs) {
		this.jobs = jobs;
	}

	public String getAddressUser() {
		return addressUser;
	}

	public void setAddressUser(String addressUser) {
		this.addressUser = addressUser;
	}

	public String getNomorUser() {
		return nomorUser;
	}

	public void setNomorUser(String nomorUser) {
		this.nomorUser = nomorUser;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}


	public String getTanggalLahir() {
		return tanggalLahir;
	}

	public void setTanggalLahir(String tanggalLahir) {
		this.tanggalLahir = tanggalLahir;
	}

}

package com.poldasulut.SiPelakor.GetResponse;

import com.poldasulut.SiPelakor.Model.UserModel;
import com.poldasulut.SiPelakor.Model.NoFK.UserModelNew;

public class GetUserModel {

	private String status;
	private UserModel userModel;
	private UserModelNew userModelNew;
	private int userId;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public UserModel getUserModel() {
		return userModel;
	}
	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
	public UserModelNew getUserModelNew() {
		return userModelNew;
	}
	public void setUserModelNew(UserModelNew userModelNew) {
		this.userModelNew = userModelNew;
	}
	
	
}

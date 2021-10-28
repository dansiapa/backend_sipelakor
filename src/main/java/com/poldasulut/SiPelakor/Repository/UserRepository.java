package com.poldasulut.SiPelakor.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poldasulut.SiPelakor.Model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer> {

	UserModel getUserModelByUserEmail(String userEmail);
	UserModel findUserModelByUserEmailAndNomorUser(String userEmail, String nomorUser);
	
	@Query("select u.userEmail from UserModel u")
	List<Object> getEmail();
	

}

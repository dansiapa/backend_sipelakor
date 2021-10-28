package com.poldasulut.SiPelakor.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poldasulut.SiPelakor.Model.UserModel;
import com.poldasulut.SiPelakor.Model.NoFK.UserModelNew;
import com.poldasulut.SiPelakor.Repository.UserRepositories;
import com.poldasulut.SiPelakor.Repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;
	private UserRepositories userRepositories;
	
	@Autowired
	public UserService(UserRepository userRepository, UserRepositories userRepositories) {
		this.userRepository = userRepository;
		this.userRepositories = userRepositories;
	}
	
	public UserModelNew createUser(int kotaKabupaten, String nik, String username, String jobs, String address,
								String nomor, String email, String password, int status, 
								String tanggalLahir) {
		UserModelNew userModelNew = new UserModelNew();
		
		if(Objects.nonNull(userRepositories.findUserModelByUserEmailAndNomorUser(email,nomor))) {
			return null;
		}else {
			userModelNew.setKotaKabupatenId(kotaKabupaten);
			userModelNew.setNikUser(nik);
			userModelNew.setUserName(username);
			userModelNew.setJobs(jobs);
			userModelNew.setAddressUser(address);
			userModelNew.setNomorUser(nomor);
			userModelNew.setUserEmail(email);
			userModelNew.setUserPassword(password);
			userModelNew.setUserStatus(status);
			userModelNew.setTanggalLahir(tanggalLahir);
		}
		return userRepositories.save(userModelNew);
	}
	
	
	public Optional<UserModel> getUser(int id) {
		return userRepository.findById(id);
	}
	
	public Iterable<UserModel> getAllUser() {
		return userRepository.findAll();
	}
	
	public List<Object> getEmail(){
		return userRepository.getEmail();
	}
	
	public UserModel getUserByEmail(String email) {
		return userRepository.getUserModelByUserEmail(email);
	}
	public boolean login(String email, String password) {
		UserModel userModel = userRepository.getUserModelByUserEmail(email);
		if(Objects.nonNull(userModel)) {
			if(userModel.getUserPassword().equals(password)) {
				return true;
			}else {
				return false;
			}
		} else {
			return false;
		}
	}

}

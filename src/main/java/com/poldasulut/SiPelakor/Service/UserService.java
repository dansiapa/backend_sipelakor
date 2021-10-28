package com.poldasulut.SiPelakor.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	public UserModel getUserByNik(String nikUser) {
		return userRepository.getUserModelByNikUser(nikUser);
	}
	public boolean login(String nikUser, String password) {
		UserModel userModel = userRepository.getUserModelByNikUser(nikUser);
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
	
	public ResponseEntity<UserModel> updateData (int id, UserModel userModel){
		Optional<UserModel> userModelUpdate = userRepository.findById(id);
		if(userModelUpdate.isPresent()) {
			UserModel uModel = userModelUpdate.get();
			uModel.setKotaKabupatenId(userModel.getKotaKabupatenId());
			uModel.setNikUser(userModel.getNikUser());
			uModel.setUserName(userModel.getUserName());
			uModel.setJobs(userModel.getJobs());
			uModel.setAddressUser(userModel.getAddressUser());
			uModel.setNomorUser(userModel.getNomorUser());
			uModel.setUserEmail(userModel.getUserEmail());
			uModel.setUserPassword(userModel.getUserPassword());
			uModel.setUserStatus(userModel.getUserStatus());
			uModel.setTanggalLahir(userModel.getTanggalLahir());
			return new ResponseEntity<>(userRepository.save(uModel),HttpStatus.OK);
			
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}

package com.poldasulut.SiPelakor.Controller;

import java.util.List;
import java.util.Objects;

import com.poldasulut.SiPelakor.Model.NoFK.UserModelNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.poldasulut.SiPelakor.GetResponse.GetUserModel;
import com.poldasulut.SiPelakor.Model.UserModel;
import com.poldasulut.SiPelakor.Service.UserService;

@RestController
@RequestMapping(value = "/api/v1/user  ", produces = {"application/json"})
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/register")
	public GetUserModel createPerson(@RequestParam int kotaKabupaten,@RequestParam  String nik,@RequestParam  String username,
			@RequestParam String jobs,@RequestParam  String address,@RequestParam String nomor,@RequestParam  String email,@RequestParam  String password,
			@RequestParam int status, @RequestParam String tanggalLahir) {
		GetUserModel getUserModel = new GetUserModel();
		UserModelNew userModel = userService.createUser(kotaKabupaten, nik, username,jobs, address, nomor, email, password,status,
				tanggalLahir);
		if (Objects.nonNull(userModel)) {
			getUserModel.setStatus("success");
			getUserModel.setUserModelNew(userModel);
			return getUserModel;
		}else {
			getUserModel.setStatus("failed");
			return getUserModel;
		}
	}
	
	
	@GetMapping("/person/{nikUser}")
	public UserModel getUserByNikUser(@PathVariable String nikUser) {
		return userService.getUserByNik(nikUser);
	}
	
	@GetMapping("/login")
	public GetUserModel login(@RequestParam String nikUser, @RequestParam String password) {
		GetUserModel getUserModel = new GetUserModel();
		UserModelNew userModel = new UserModelNew();
		
		if(userService.login(nikUser, password)) {
			getUserModel.setStatus("success");
			getUserModel.setUserModel(getUserByNikUser(nikUser));
			getUserModel.setUserId(userModel.getUserId());
			return getUserModel;
		} else {
			getUserModel.setStatus("failed");
			return getUserModel;
		}
	}
	
	// Get all user
	@GetMapping("/person/all")
	public Iterable<UserModel> getAllUser(){
		return userService.getAllUser();
	}
	
	// Get all email
	@GetMapping("/emails")
	public List<Object> getEmail(){
		return userService.getEmail();
	}
		
	
	// Get user by id
	@GetMapping("/person/id/{id}")
	public UserModel getUser(@PathVariable int id) {
		return userService.getUser(id).get();
	}
	
	//PUT OURBUDGET
	@PutMapping("/update/{id}")
	public ResponseEntity<UserModel> updateData(@PathVariable("id") int id, @RequestBody UserModel uModel) {
		return userService.updateData(id, uModel);	
	}
	


}

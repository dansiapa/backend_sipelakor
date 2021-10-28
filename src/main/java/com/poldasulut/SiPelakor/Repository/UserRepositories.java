package com.poldasulut.SiPelakor.Repository;

import com.poldasulut.SiPelakor.Model.NoFK.UserModelNew;
import com.poldasulut.SiPelakor.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepositories extends JpaRepository<UserModelNew, Integer> {

    UserModelNew getUserModelByUserEmail(String userEmail);
    UserModelNew findUserModelByUserEmailAndNomorUser(String userEmail, String nomorUser);

}

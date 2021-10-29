package com.poldasulut.SiPelakor.Service;

import com.poldasulut.SiPelakor.Model.KotaKabupatenModel;
import com.poldasulut.SiPelakor.Model.UserModel;
import com.poldasulut.SiPelakor.Repository.KotaKabRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KotaKabService {

    private KotaKabRepositories kotaKabRepositories;

    @Autowired
    public KotaKabService (KotaKabRepositories kotaKabRepositories){
        this.kotaKabRepositories =kotaKabRepositories;
    }

    public Iterable<KotaKabupatenModel> getAllKotaKab() {
        return kotaKabRepositories.findAll();
    }
}

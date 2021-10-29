package com.poldasulut.SiPelakor.Controller;

import com.poldasulut.SiPelakor.Model.KotaKabupatenModel;
import com.poldasulut.SiPelakor.Model.UserModel;
import com.poldasulut.SiPelakor.Service.KotaKabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KotaKabController {

    @Autowired
    private KotaKabService kotaKabService;

    // Get all
    @GetMapping("/kotakab/all")
    public Iterable<KotaKabupatenModel> getAllKotaKab(){
        return kotaKabService.getAllKotaKab();
    }
}

package com.poldasulut.SiPelakor.Controller;

import com.poldasulut.SiPelakor.GetResponse.GetFormResponse;
import com.poldasulut.SiPelakor.Model.FormLaporanModel;
import com.poldasulut.SiPelakor.Model.NoFK.FormLaporanModelNew;
import com.poldasulut.SiPelakor.Service.FormLaporanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@RestController
public class FormLaporanController {

    @Autowired
    private FormLaporanService formLaporanService;

    @PostMapping("/add")
    public GetFormResponse createLaporan(@RequestParam int user,@RequestParam String tanggalKejadian,
                                         @RequestParam String lokasi,@RequestParam String dokument1,@RequestParam String dokument2,
                                         @RequestParam String dokument3,@RequestParam String ktp,
                                         @RequestParam String kta,@RequestParam String detail,@RequestParam String statusLaporan,
                                         @RequestParam String statusPelapor) {
        GetFormResponse getFormResponse = new GetFormResponse();
        FormLaporanModelNew formLaporanModelNew = formLaporanService.createFormInvitation(user,
                tanggalKejadian, lokasi, dokument1, dokument2, dokument3, ktp,
                kta, detail, statusLaporan, statusPelapor);
        if (Objects.nonNull(formLaporanModelNew)) {
            getFormResponse.setStatus("success");
            getFormResponse.setFormLaporanModelNew(formLaporanModelNew);
            return getFormResponse;
        }else {
            getFormResponse.setStatus("failed");
            return getFormResponse;
        }
    }

    @GetMapping("/statuslaporan/{userId}")
    public List<FormLaporanModel> getLaporan(@PathVariable int userId){
        return formLaporanService.getByUserId(userId);
    }


}

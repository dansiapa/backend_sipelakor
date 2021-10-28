package com.poldasulut.SiPelakor.Repository;

import com.poldasulut.SiPelakor.Model.FormLaporanModel;
import com.poldasulut.SiPelakor.Model.NoFK.FormLaporanModelNew;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormLaporanRepositories extends JpaRepository<FormLaporanModelNew, Integer> {

    FormLaporanModelNew getFormLaporanModelNewByTanggalKejadian(String tanggalKejadian);


}

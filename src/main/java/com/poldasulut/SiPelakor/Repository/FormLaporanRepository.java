package com.poldasulut.SiPelakor.Repository;

import com.poldasulut.SiPelakor.Model.FormLaporanModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FormLaporanRepository extends JpaRepository<FormLaporanModel, Integer> {


    List<FormLaporanModel> findFormLaporanModelByUserId(int userId);
}

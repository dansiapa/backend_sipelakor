package com.poldasulut.SiPelakor.Service;

import com.poldasulut.SiPelakor.Model.FormLaporanModel;
import com.poldasulut.SiPelakor.Model.NoFK.FormLaporanModelNew;
import com.poldasulut.SiPelakor.Repository.FormLaporanRepositories;
import com.poldasulut.SiPelakor.Repository.FormLaporanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class FormLaporanService {

    private FormLaporanRepository formLaporanRepository;
    private FormLaporanRepositories formLaporanRepositories;
    

    @Autowired
    public FormLaporanService(FormLaporanRepository formLaporanRepository
            , FormLaporanRepositories formLaporanRepositories){
        this.formLaporanRepository = formLaporanRepository;
        this.formLaporanRepositories = formLaporanRepositories;
    }

    private final Path dokumentPendukung = Paths.get("./assets/dokumen_pendukung");
    public boolean saveFile(MultipartFile file) {
        try {
            if (!Files.exists(dokumentPendukung)) {
                Files.createDirectories(dokumentPendukung);
            }
            Files.copy(file.getInputStream(), this.dokumentPendukung.resolve(Objects.requireNonNull(file.getOriginalFilename())));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

//    public boolean saveFile(MultipartFile file, int laporanId) {
//        try {
//            Optional<FormLaporanModelNew> formLaporanModelNew = formLaporanRepositories.findById(laporanId);
//            if (formLaporanModelNew.isPresent()) {
//                if (!Files.exists(dokumentPendukung)) {
//                    Files.createDirectories(dokumentPendukung);
//                }
//
//                String fileName = formLaporanModelNew.get().getDokumentPendukung1()
//                        + filesUtils.getExtension(file.getOriginalFilename());
//                Files.copy(file.getInputStream(), this.dokumentPendukung.resolve(fileName),
//                        StandardCopyOption.REPLACE_EXISTING);
//                String fileName2 = formLaporanModelNew.get().getDokumentPendukung2()
//                        + filesUtils.getExtension(file.getOriginalFilename());
//                Files.copy(file.getInputStream(), this.dokumentPendukung.resolve(fileName),
//                        StandardCopyOption.REPLACE_EXISTING);
//                String fileName3 = formLaporanModelNew.get().getDokumentPendukung3()
//                        + filesUtils.getExtension(file.getOriginalFilename());
//                Files.copy(file.getInputStream(), this.dokumentPendukung.resolve(fileName),
//                        StandardCopyOption.REPLACE_EXISTING);
//                String ktp = formLaporanModelNew.get().getKtpPelapor()
//                        + filesUtils.getExtension(file.getOriginalFilename());
//                String kta = formLaporanModelNew.get().getKtaPelapor()
//                        + filesUtils.getExtension(file.getOriginalFilename());
//                Files.copy(file.getInputStream(), this.dokumentPendukung.resolve(fileName),
//                        StandardCopyOption.REPLACE_EXISTING);
//
//                formLaporanModelNew.get().setDokumentPendukung1(fileName);
//                formLaporanModelNew.get().setDokumentPendukung2(fileName2);
//                formLaporanModelNew.get().setDokumentPendukung3(fileName3);
//                formLaporanModelNew.get().setKtpPelapor(ktp);
//                formLaporanModelNew.get().setKtaPelapor(kta);
//                formLaporanRepositories.save(formLaporanModelNew.get());
//                return true;
//            } else {
//                return false;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }

    public FormLaporanModelNew createFormInvitation(int user, String tanggalKejadian, String lokasi,
                                                    String dokument1, String dokument2, String dokument3, String ktp,
                                                    String kta, String detail, String statusLaporan,
                                                    String statusPelapor) {
        FormLaporanModelNew formInvitation = new FormLaporanModelNew();

        if(Objects.nonNull(formLaporanRepositories.getFormLaporanModelNewByTanggalKejadian(tanggalKejadian))) {
            return null;
        }else {
            formInvitation.setUserId(user);
            formInvitation.setTanggalKejadian(tanggalKejadian);
            formInvitation.setLokasiKejadian(lokasi);
            formInvitation.setDokumentPendukung1(dokument1);
            formInvitation.setDokumentPendukung2(dokument2);
            formInvitation.setDokumentPendukung3(dokument3);
            formInvitation.setKtpPelapor(ktp);
            formInvitation.setKtaPelapor(kta);
            formInvitation.setDetailKejadian(detail);
            formInvitation.setStatusLaporan(statusLaporan);
            formInvitation.setStatusPelapor(statusPelapor);
            formInvitation.setCreatedAt(LocalDateTime.now());
        }
        return formLaporanRepositories.save(formInvitation);
    }

    public List<FormLaporanModel> getByUserId(int userId) {
        return formLaporanRepository.findFormLaporanModelByUserId(userId);
    }
}

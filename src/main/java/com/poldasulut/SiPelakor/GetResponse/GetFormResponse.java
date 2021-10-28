package com.poldasulut.SiPelakor.GetResponse;

import com.poldasulut.SiPelakor.Model.NoFK.FormLaporanModelNew;
import com.poldasulut.SiPelakor.Model.NoFK.UserModelNew;

public class GetFormResponse {
    private String status;
    private FormLaporanModelNew formLaporanModelNew;
    private int userId;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public FormLaporanModelNew getFormLaporanModelNew() {
        return formLaporanModelNew;
    }

    public void setFormLaporanModelNew(FormLaporanModelNew formLaporanModelNew) {
        this.formLaporanModelNew = formLaporanModelNew;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}

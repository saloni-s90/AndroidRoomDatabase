package com.example.displayrecords;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class InfoModel {
    @PrimaryKey(autoGenerate = true)
    private int eid;
    private int userid;
    private String emp_name;

    public InfoModel() {
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public InfoModel(int eid, int userid, String emp_name) {
        this.eid = eid;
        this.userid = userid;
        this.emp_name = emp_name;
    }
}

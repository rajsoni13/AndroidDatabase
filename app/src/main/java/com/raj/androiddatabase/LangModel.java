package com.raj.androiddatabase;

public class LangModel {
    String strFname;
    String strLname;

    public LangModel(String strFname, String strLname) {
    this.strFname=strFname;
    this.strLname=strLname;
    }

    public String getStrFname() {
        return strFname;
    }

    public void setStrFname(String strFname) {
        this.strFname = strFname;
    }

    public String getStrLname() {
        return strLname;
    }

    public void setStrLname(String strLname) {
        this.strLname = strLname;
    }
}

package com.example.helloworld;

public class UserModel {

    public static final String create = "registation";
    public static final String id = "id";
    public static final String username = "username";
    public static final String password = "password";
    public static final String email = "email";
    public static final String age = "age";
    public static final String gender = "gender";

    public static final String Create_Table = "Create Table " +
            create + "( " + id + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            username + " text," + password + " text," + email + " text," + age + " number," +
            gender + " text" + ")";


    private int id1;
    private String usr;
    private String pwd;
    private String el;
    private String ag;
    private String gdr;

    public UserModel() {

    }

    public UserModel(int id1, String usr, String el, String ag, String gdr) {
this.id1=id1;
this.pwd=pwd;
this.usr=usr;
this.el=el;
this.ag=ag;
this.gdr=gdr;
    }
    public int getId1()
    {
        return id1;
    }
    public String getUsr()
    {
        return usr;
    }
    public String getEl()
    {
        return el;
    }

    public String getAg() {
        return ag;
    }

    public String getGdr() {
        return gdr;
    }

    public String getPwd() {
        return pwd;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

    public void setAg(String ag) {
        this.ag = ag;
    }

    public void setEl(String el) {
        this.el = el;
    }

    public void setGdr(String gdr) {
        this.gdr = gdr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }



    }

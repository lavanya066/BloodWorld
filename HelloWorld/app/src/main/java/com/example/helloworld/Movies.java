package com.example.helloworld;
import android.app.Activity;
public class Movies {
    String year, title;

    public  Movies(){}

    public Movies(String title,String year){
        this.title=title;
        this.year=year;

    }
    public void setTitle(String title)
        {
    this.title=title;
    }
public  void setYear(String year)
{
    this.year=year;
}
public String getTitle(){
       return title;
}
public String getYear()
{
    return year;
}
}

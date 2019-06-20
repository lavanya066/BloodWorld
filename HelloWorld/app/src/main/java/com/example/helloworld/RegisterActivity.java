package com.example.helloworld;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.helloworld.database.DatabaseHelper;

public class RegisterActivity extends AppCompatActivity {
    EditText u1,p1,cp1,e1,a1;//
    Spinner g1;
    int f1,f,z,k;
    TextView txt;
   String str,s1,s2,s3,s4,s5;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        u1=findViewById(R.id.usere);
        p1=findViewById(R.id.passe);
        cp1=findViewById(R.id.cpe);
        e1=findViewById(R.id.emaile);
        a1=findViewById(R.id.agee);
        g1=(Spinner)findViewById(R.id.selecter);
        txt=findViewById(R.id.txt);
        final DatabaseHelper  mydb=new DatabaseHelper(this);
        final UserModel u = new UserModel();





        txt.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {

                  str= e1.getText().toString();
                 s1= a1.getText().toString();
                 s2=g1.getSelectedItem().toString();
                 s3=p1.getText().toString();
                 s4=u1.getText().toString();
                 s5=cp1.getText().toString();
                 u.setAg(s1);
                  u.setEl(str);
                  u.setGdr(s2);
                  u.setPwd(s3);
                  u.setUsr(s4);


                  int i,l=str.length();
                  int f=0,f1=0,z=0,k=0;
                  for (i=0;i<l;i++)
                  {

                      if (str.charAt(i)=='@')
                      {
                          f++;
                      }
                      if(str.charAt(i)=='.')
                      {
                          f1++;
                      }


                  }
                  int o=0;
                   if(mydb.checkUser(s4,s3)==2)
                  {
                      Toast.makeText(RegisterActivity.this,"the user name and password already exists",Toast.LENGTH_SHORT).show();
                  }
                 else if(f1<2&&f<2&&Character.isLetter(str.charAt(l-1))&&Character.isLetter(str.charAt(0))&&s1!=null&&s2!=null&&s3!=null&&s4!=null&&s3.equals(s5)) {

                      mydb.insertval(u.getUsr(),u.getPwd(),u.getGdr(),u.getEl(),u.getAg());
                      Intent n = new Intent(RegisterActivity.this, WelcomeActivity.class);
                      startActivity(n);


                  }

                      else
                  {
                      Toast.makeText(RegisterActivity.this,"something entered is incorrect",Toast.LENGTH_SHORT).show();
                  }
              }
          });


    }




}

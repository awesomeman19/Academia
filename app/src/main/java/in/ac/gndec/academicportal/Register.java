package in.ac.gndec.academicportal;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Register extends AppCompatActivity {

    EditText name,id,password,eclass;
    Button register;
    TextView date,login;
    RadioButton student,faculty;
    ContentResolver contentResolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        init();
        date();

        contentResolver=getContentResolver();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.getText().length()<=0||password.getText().length()<=0||id.getText().length()<=0){
                    Toast.makeText(Register.this,"Please Enter All Details",Toast.LENGTH_LONG).show();
                }else{
                    if(student.isChecked()){
                        Student st=new Student();
                        st.setMobile(Long.parseLong(id.getText().toString()));
                        st.setName(name.getText().toString());
                        st.setPassword(password.getText().toString());
                        st.setEclass(eclass.getText().toString());
                        registerStudent(st);
                    }else if(faculty.isChecked()){
                        Teacher teacher=new Teacher();
                        teacher.setPassword(password.getText().toString());
                        teacher.setName(name.getText().toString());
                        teacher.setMobile(Long.parseLong(id.getText().toString()));
                        registerTeacher(teacher);
                    }
                    else {
                        Toast.makeText(Register.this,"Choose Type(Student,Faculty)",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });


        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.radioButtonstudent){
                    eclass.setVisibility(View.VISIBLE);
                }else{
                    eclass.setVisibility(View.GONE);
                }
            }
        });


    }

    void init(){
        date=(TextView)findViewById(R.id.textViewdate);
        name=(EditText) findViewById(R.id.editTextName);
        id=(EditText) findViewById(R.id.editTextidr);
        eclass=(EditText) findViewById(R.id.editTextclass);
        password=(EditText) findViewById(R.id.editTextpasswordr);
        register=(Button) findViewById(R.id.buttonregister);
        student=(RadioButton)findViewById(R.id.radioButtonstudent);
        faculty=(RadioButton)findViewById(R.id.radioButtonfaculty);
        login=(TextView)findViewById(R.id.textViewlogin);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Register.this,LoginActivity.class);
                startActivity(i);
            }
        });
    }

    void date(){
        SimpleDateFormat format=new SimpleDateFormat("dd/MM/yy hh:mm:ss");
        date.setText("Date : "+format.format(new Date())+"");
    }

    void registerStudent(Student st){

        ContentValues values=new ContentValues();
        values.put(Util.name,st.getName());
        values.put(Util.password,st.getPassword());
        values.put(Util.id,st.getMobile());
        values.put(Util.eclass,st.getEclass());

        Uri x=contentResolver.insert(Util.u1,values);
        if(Integer.parseInt(x.getLastPathSegment())>0){
         Toast.makeText(Register.this,"Registered Successfully",Toast.LENGTH_LONG).show();
            Intent i=new Intent(Register.this,LoginActivity.class);
            startActivity(i);
        }else{
            Toast.makeText(Register.this,"Not Registered Try Again!",Toast.LENGTH_LONG).show();
        }
    }

    void registerTeacher(Teacher te){


        ContentValues values=new ContentValues();
        values.put(Util.name,te.getName());
        values.put(Util.password,te.getPassword());
        values.put(Util.id,te.getMobile());

        Uri x=contentResolver.insert(Util.u2,values);

        if(Integer.parseInt(x.getLastPathSegment())>0){
            Toast.makeText(Register.this,"Registered Successfully",Toast.LENGTH_LONG).show();
            Intent i=new Intent(Register.this,LoginActivity.class);
            startActivity(i);
        }else{
            Toast.makeText(Register.this,"Not Registered Try Again!",Toast.LENGTH_LONG).show();
        }
    }

}

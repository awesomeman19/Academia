package in.ac.gndec.academicportal;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText id, password;
    TextView date, register;
    Button student, faculty;
    ContentResolver contentResolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        date();
        contentResolver = getContentResolver();
    }


    //Function to Initalize All Views
    void init() {
        id = (EditText) findViewById(R.id.editTextid);
        password = (EditText) findViewById(R.id.editTextPassword);
        date = (TextView) findViewById(R.id.textViewdate);
        register = (TextView) findViewById(R.id.textView3register);
        student = (Button) findViewById(R.id.buttonStudent);
        faculty = (Button) findViewById(R.id.buttonFaculty);

        student.setOnClickListener(this);
        faculty.setOnClickListener(this);
        register.setOnClickListener(this);
    }


    //Funtion to View Current TimeStamp

    void date(){
        SimpleDateFormat format=new SimpleDateFormat("dd/MM/yy hh:mm:ss");
        date.setText("Date : "+format.format(new Date())+"");
    }


    @Override
    public void onClick(View view) {
        int id = view.getId();


        switch (id) {

            case R.id.buttonFaculty:
                beforeLogin(0);
                break;
            case R.id.buttonStudent:
                beforeLogin(1);
                break;
            case R.id.textView3register:
                Intent intent = new Intent(this, Register.class);
                startActivity(intent);
                break;
        }
    }

    //Function To check Invalid Entries
    void beforeLogin(int i) {
        if (id.getText().length() <= 0) {
            Toast.makeText(LoginActivity.this, "Please Enter Valid Id", Toast.LENGTH_LONG).show();
        } else {
            if (password.getText().length() <= 0) {
                Toast.makeText(LoginActivity.this, "Please Enter Valid Password", Toast.LENGTH_LONG).show();
            } else {
                if (i == 0) {
                    loginFaculty();
                } else {
                    loginStudent();
                }
            }
        }
    }

    //Login as Student
    void loginStudent() {
        String[] projection = {"Mobile", "Name", "Password", "Class"};
        String w = Util.id + " = " + id.getText().toString();
        Cursor c = contentResolver.query(Util.u1, projection, w, null, null);
        if (c != null) {
            while (c.moveToNext()) {
                if(c.getString(c.getColumnIndex(Util.password)).equals(password.getText().toString())){
                Intent i = new Intent(LoginActivity.this, HomeStudent.class);
                i.putExtra("Name", c.getString(c.getColumnIndex(Util.name)));
                c.close();
                startActivity(i);
                }else {
                    Toast.makeText(LoginActivity.this, "Invalid Password", Toast.LENGTH_LONG).show();
                }
            }
        }else{
            Toast.makeText(LoginActivity.this, "Invalid ID", Toast.LENGTH_LONG).show();
        }
    }

    //Login as Faculty
    void loginFaculty() {
        String[] projection = {"Mobile", "Name", "Password"};
        String w = Util.id + " = " + id.getText().toString() ;
        Cursor c = contentResolver.query(Util.u2, projection, w, null, null);
        if (c != null) {
            while (c.moveToNext()) {
                if(c.getString(c.getColumnIndex(Util.password)).equals(password.getText().toString())){
                    Intent i = new Intent(LoginActivity.this, HomeFaculty.class);
                    i.putExtra("Name", c.getString(c.getColumnIndex(Util.name)));
                    c.close();
                    startActivity(i);
                }else {
                    Toast.makeText(LoginActivity.this, "Invalid Password", Toast.LENGTH_LONG).show();
                }
            }
        }else{
            Toast.makeText(LoginActivity.this, "Invalid ID", Toast.LENGTH_LONG).show();
        }
    }

}

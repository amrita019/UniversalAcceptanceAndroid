package com.amrita.universalacceptance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.amrita.universalacceptance.helper.DatabaseUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.et_email)
    EditText et_email;
    @BindView(R.id.et_name)
    EditText et_name;
    @BindView(R.id.button_submit)
    Button button_submit;

    String user_email;
    String user_name;

    private DatabaseUtils databaseUtils;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        databaseUtils = new DatabaseUtils(getBaseContext());

        button_submit.setOnClickListener(v -> {
            user_email = et_email.getText().toString();
            user_name = et_name.getText().toString();

            if(et_email.getText().toString().isEmpty()){
                Toast.makeText(this, "Please enter a name", Toast.LENGTH_SHORT).show();
            }
            else if(!isEmailValid(et_email.getText().toString())){
                Toast.makeText(this, "Please enter a valid email", Toast.LENGTH_SHORT).show();
            } else {
                databaseUtils.insertEmail(user_name, user_email);
                Intent intent=new Intent(getApplicationContext(),ListActivity.class);
                startActivity(intent);
            }


        });

    }

    private boolean isEmailValid(String email) {
        boolean isValid = false;
        String expression = "[^ ]+@[^ ]+\\.[^ ]{2,63}";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

}

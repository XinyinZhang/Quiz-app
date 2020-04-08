package ca.uwaterloo.cs349.a4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.*;
import android.text.*;
import android.graphics.*;
import android.graphics.drawable.*;
public class MainActivity extends AppCompatActivity {

    String Getname; //the name from user input
    Button next; //a button go to next page
    EditText e; //a editText to get the user input
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        next = findViewById(R.id.Next_btn); //find next button
        next.setEnabled(false); //initially, set next button disabled
        e =findViewById(R.id.editTextName);
        e.addTextChangedListener(new TextWatcher(){
            public void afterTextChanged(Editable s) {
               String ss = s.toString();
                if (ss.length() != 0){ //when user name is entered, set next button enabled

                    next.setEnabled(true);
                    next.setBackgroundColor(Color.BLUE);

                } else {

                    next.setEnabled(false);
                }


            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
                next.setEnabled(false);
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                next.setEnabled(false);

            }

        });
    }


    //when next button is clicked, user name is passed from EditText field to next screen
    public void goNextPage(View view) {

        Getname = e.getText().toString();
        Intent intent = new Intent(this, TopicSelection.class);
        intent.putExtra("editTextName", Getname);
        startActivity(intent);


    }


}

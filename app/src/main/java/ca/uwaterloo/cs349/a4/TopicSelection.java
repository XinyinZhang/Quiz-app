package ca.uwaterloo.cs349.a4;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.*;


public class TopicSelection extends AppCompatActivity {


    String GetQnum;
    Button load;
    Spinner spinnerQ;
    String Username;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_selection);
        //received the user name from previous page and print it to the screen
        Intent intent = getIntent();
        TextView welcomeLabel = findViewById(R.id.WelcomeText);
        Username = intent.getStringExtra("editTextName");
        String n = "Welcome "+ Username;

        welcomeLabel.setText(n);

    }


    //when load button is clicked, the selected spinner value is passed to
    //Question screen and opens the screen
    public void goNextPage(View view) {
        // get the selected spinner value
        spinnerQ = findViewById(R.id.QuestionSpinner);
        GetQnum = spinnerQ.getSelectedItem().toString();

       //pass the selected spinner value and user name to next page
       Intent intent = new Intent(this, QuestionPage1.class);

       intent.putExtra("QuestionPageNum", GetQnum);
       intent.putExtra("Username", Username);
       startActivity(intent);


    }
    //go back to Welcome page without passing any values
    public void Logout(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}


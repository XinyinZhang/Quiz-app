package ca.uwaterloo.cs349.a4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Results extends AppCompatActivity {
    String Username; //variable to store user name
    String num; //variable to store the number of questions user selected
    //variables to store all the answers
    String answer1;
    String answer2;
    String answer3;
    String answer4;
    String answer5;
    int score = 0; //variable to calculate the final score
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        //receives all the variables from the previous page
        Intent intent = getIntent();
        Username = intent.getStringExtra("Username");
        num = intent.getStringExtra("QuestionPageNum");
        answer1 = intent.getStringExtra("answer1");
        answer2 = intent.getStringExtra("answer2");
        answer3 = intent.getStringExtra("answer3");
        answer4 = intent.getStringExtra("answer4");
        answer5 = intent.getStringExtra("answer5");

        //calculate the score
        if (answer1 != null && answer1.equals("A")){
            score++;
        }

        if(answer2 != null &&  (answer2.equals("nullAC") || answer2.equals("nullCA"))){
            score++;
        }
        if(answer3 != null &&  answer3.equals("C")){
            score++;
        }
        if(answer4 != null &&  answer4.equals("D")){
            score++;
        }

        if(answer5 != null && (answer5.equals("nullCD") || answer5.equals("nullDC"))){
            score++;
        }
        //a textView showing the user name
        TextView NameTitle = findViewById(R.id.NameR);
        String nm = "Name: " + Username;
        NameTitle.setText(nm);
        //a textView showing the total score
        TextView ScoreTitle = findViewById(R.id.Score);
        String sc = "Your Score: " + String.valueOf(score)+"/"+num;
        ScoreTitle.setText(sc);
    }



    public void goNextPage(View view) { //go to the TopicSelection page


        Intent intent = new Intent(this, TopicSelection.class);
        intent.putExtra("editTextName", Username);
        startActivity(intent);

    }

    public void Logout(View view) {//log out to the welcome page

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }



}
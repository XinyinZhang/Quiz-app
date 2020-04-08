package ca.uwaterloo.cs349.a4;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class QuestionPage1 extends AppCompatActivity {

    Button previous; //a button to go back to previous page
    Button next; //a button to go to next page
    String num; //an variable to remember the number of questions user picked
    String Username; //user's name
    //variables to stores the answers as A, B, C...
    String answer1;
    String answer2;
    String answer3;
    String answer4;
    String answer5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_page1);

        Intent intent = getIntent();
        //received the number of answers from the topic selection page
        num = intent.getStringExtra("QuestionPageNum");
        //received the user name from the welcome page
        Username = intent.getStringExtra("Username");


        //a textView showing the current question number and number of questions user selected
        //in the topic selection page
        TextView QuestionCount = findViewById(R.id.QCount);
        String n = "1/"+num;
        QuestionCount.setText(n);

        //a textView showing the user name
        TextView NameTitle = findViewById(R.id.Name1);
        String nm = "Name: " + Username;
        NameTitle.setText(nm);

        //a button go back to previous page
        previous = findViewById(R.id.btnPre);
        previous.setEnabled(false); //page1: previous unavailable
        previous.setBackgroundColor(Color.GRAY);

        //set the text of next button according to the number of questions user selected
        next = findViewById(R.id.btn);
        if (num.equals("1")){
            next.setText("Finish");
        } else {
            next.setText("Next");
        }

    }
    //received the answers when users go back to page 1
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            if(resultCode == Activity.RESULT_OK){
                answer1 = data.getStringExtra("answer1");
                answer2 = data.getStringExtra("answer2");
                answer3 = data.getStringExtra("answer3");
                answer4 = data.getStringExtra("answer4");
                answer5 = data.getStringExtra("answer5");
            }
        }
    }
    //store the answer user selected in answer1 variable
    public void ClickedAnswer(View view){
        boolean checked = ((RadioButton) view).isChecked();
        //check which radio button was clicked
        switch(view.getId()){
            case R.id.Q1radio1:
                if(checked)
                    answer1 = "A";
                    break;
            case R.id.Q1radio2:
                if(checked)
                    answer1 = "B";
                break;

            case R.id.Q1radio3:
                if(checked)
                    answer1 = "C";
                break;

            case R.id.Q1radio4:
                if(checked)
                    answer1 = "D";
                break;
        }

    }



    //pass the answers to next page
    public void goNextPage(View view) {



        if (num.equals("1")){ //only one page
            Intent intent = new Intent(this, Results.class);
            intent.putExtra("QuestionPageNum", num);

            intent.putExtra("Username", Username);
            //pass all the answers to result page
            intent.putExtra("answer1", answer1);
            intent.putExtra("answer2", answer2);
            intent.putExtra("answer3", answer3);
            intent.putExtra("answer4", answer4);
            intent.putExtra("answer5", answer5);
            startActivityForResult(intent, 1);

        } else { //go to second page
            Intent intent = new Intent(this, QuestionPage2.class);
            intent.putExtra("QuestionPageNum", num);
            intent.putExtra("Username", Username);
            //pass all the answers to next page
            intent.putExtra("answer1", answer1);
            intent.putExtra("answer2", answer2);
            intent.putExtra("answer3", answer3);
            intent.putExtra("answer4", answer4);
            intent.putExtra("answer5", answer5);

            startActivityForResult(intent, 1);

        }

    }
    //go back to previous page, disabled for the first page
    public void goPreviousPage(View view) {


        Intent intent = new Intent(this, TopicSelection.class);
        intent.putExtra("QuestionPageNum", num);
        intent.putExtra("Username", Username);
        startActivity(intent);

    }

    //log out to the welcome page
    public void Logout(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }


}

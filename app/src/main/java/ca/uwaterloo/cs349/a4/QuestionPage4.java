package ca.uwaterloo.cs349.a4;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class QuestionPage4 extends AppCompatActivity {


    Button previous; //a button go to previous pag
    String num; //an variable to store the number of questions that user selected in the topicPage
    Button next; //a button go to next page
    String Username; //an variable store the user name
    //variables to store the answers as A, B, C...
    String answer1;
    String answer2;
    String answer3;
    String answer4;
    String answer5;
    RadioButton current;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_page4);

        //received all the variables from the previous page
        Intent intent = getIntent();
        num = intent.getStringExtra("QuestionPageNum");
        Username = intent.getStringExtra("Username");
        answer1 = intent.getStringExtra("answer1");
        answer2 = intent.getStringExtra("answer2");
        answer3 = intent.getStringExtra("answer3");
        answer4 = intent.getStringExtra("answer4");
        answer5 = intent.getStringExtra("answer5");

        //initial the radio buttons
        if(answer4 != null && answer4.contains("A")){
            current = findViewById(R.id.Q4radio1);
            current.setChecked(true);

        }

        else if(answer4 != null && answer4.contains("B")){
            current = findViewById(R.id.Q4radio2);
            current.setChecked(true);

        }

        else if(answer4 != null && answer4.contains("C")){
            current = findViewById(R.id.Q4radio3);
            current.setChecked(true);

        }

        else if(answer4 != null && answer4.contains("D")){
            current = findViewById(R.id.Q4radio4);
            current.setChecked(true);

        }
        //a textView showing the current question number and number of questions user selected
        //in the topic selection page
        TextView QuestionCount = findViewById(R.id.QCount);
        String n = "4/"+num;
        QuestionCount.setText(n);

        //a textView showing the username
        TextView NameTitle = findViewById(R.id.Name4);
        String nm = "Name: " + Username;
        NameTitle.setText(nm);

        //set the text of next button according to the number of questions user selected

        next = findViewById(R.id.btn);

        if (num.equals("4")){
            next.setText("Finish");
        } else {
            next.setText("Next");
        }

    }
    //received the answers when users go back to page 4
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

    //store the answers to answer4
    public void ClickedAnswer4(View view){
        boolean checked = ((RadioButton) view).isChecked();
        //check which radio button was clicked
        switch(view.getId()){
            case R.id.Q4radio1:
                if(checked)
                    answer4 = "A";
                break;
            case R.id.Q4radio2:
                if(checked)
                    answer4 = "B";
                break;

            case R.id.Q4radio3:
                if(checked)
                    answer4 = "C";
                break;

            case R.id.Q4radio4:
                if(checked)
                    answer4 = "D";
                break;
        }

    }

    public void goNextPage(View view) {

        if (num.equals("4")){ //go to result page
            Intent intent = new Intent(this, Results.class);
            intent.putExtra("QuestionPageNum", num);
            intent.putExtra("Username", Username);
            intent.putExtra("answer1", answer1);
            intent.putExtra("answer2", answer2);
            intent.putExtra("answer3", answer3);
            intent.putExtra("answer4", answer4);
            intent.putExtra("answer5", answer5);

            startActivityForResult(intent, 1);

        } else { //go to next page
            Intent intent = new Intent(this, QuestionPage5.class);
            intent.putExtra("QuestionPageNum", num);
            intent.putExtra("Username", Username);
            intent.putExtra("answer1", answer1);
            intent.putExtra("answer2", answer2);
            intent.putExtra("answer3", answer3);
            intent.putExtra("answer4", answer4);
            intent.putExtra("answer5", answer5);
            startActivityForResult(intent, 1);

        }
    }

    public void goPreviousPage(View view) { //pass all the variables to previous page

        Intent returnIntent = new Intent();
        returnIntent.putExtra("QuestionPageNum", num);
        returnIntent.putExtra("Username", Username);
        returnIntent.putExtra("answer1", answer1);
        returnIntent.putExtra("answer2", answer2);
        returnIntent.putExtra("answer3", answer3);
        returnIntent.putExtra("answer4", answer4);
        returnIntent.putExtra("answer5", answer5);
        setResult(Activity.RESULT_OK, returnIntent);

        finish();

    }

    public void Logout(View view) { //log out to welcome page

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

}
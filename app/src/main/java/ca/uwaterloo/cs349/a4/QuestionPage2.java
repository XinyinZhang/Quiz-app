package ca.uwaterloo.cs349.a4;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;


public class QuestionPage2 extends AppCompatActivity {


    Button previous; //a button go back to the previous page
    Button next; //a button go to the next page
    String num; //an variable to store the number of questions that user selected in the topicPage
    String Username; //an variable to store user's name
    CheckBox currentBox;

    //variables to stores the answers as A, B, C...
    String answer1;
    String answer2;
    String answer3;
    String answer4;
    String answer5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_page2);

        //received all the variables passed by previous page
        Intent intent = getIntent();
        num = intent.getStringExtra("QuestionPageNum");
        Username = intent.getStringExtra("Username");
        answer1 = intent.getStringExtra("answer1");
        answer2 = intent.getStringExtra("answer2");
        answer3 = intent.getStringExtra("answer3");
        answer4 = intent.getStringExtra("answer4");
        answer5 = intent.getStringExtra("answer5");

        //initial the checkBox
        if(answer2 != null && answer2.contains("A")){
            currentBox = findViewById(R.id.Q2CheckBox1);
            currentBox.setChecked(true);

        }

        if(answer2 != null && answer2.contains("B")){
            currentBox = findViewById(R.id.Q2CheckBox2);
            currentBox.setChecked(true);

        }

        if(answer2 != null && answer2.contains("C")){
            currentBox = findViewById(R.id.Q2CheckBox3);
            currentBox.setChecked(true);

        }

        if(answer2 != null && answer2.contains("D")){
            currentBox = findViewById(R.id.Q2CheckBox4);
            currentBox.setChecked(true);

        }

        if(answer2 != null && answer2.contains("E")){
            currentBox = findViewById(R.id.Q2CheckBox5);
            currentBox.setChecked(true);

        }

        //a textView showing the current question number and number of questions user selected
        //in the topic selection page
        TextView QuestionCount = findViewById(R.id.QCount);
        String n = "2/"+num;
        QuestionCount.setText(n);

        //a textView showing the user name
        TextView NameTitle = findViewById(R.id.Name2);
        String nm = "Name: " + Username;
        NameTitle.setText(nm);


        //set the text of next button according to the number of questions user selected
        next = findViewById(R.id.btn);
        if (num.equals("2")){
            next.setText("Finish");
        } else {
            next.setText("Next");
        }


    }
    //received the answers when users go back to page 2
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

    //store the answer user selected in answer2 variable
    public void CheckBox2Answer(View view){
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()){
            case R.id.Q2CheckBox1:
                if (checked)
                    answer2 = answer2+"A";
                else  //remove A
                    answer2 = answer2.replaceAll("A", "");
                    break;

            case R.id.Q2CheckBox2:
                if (checked)
                    answer2 = answer2+"B";
                else //remove B
                    answer2 = answer2.replaceAll("B", "");
                break;
            case R.id.Q2CheckBox3:
                if (checked)
                    answer2 = answer2+"C";
                else //remove C
                    answer2 = answer2.replaceAll("C", "");
                break;
            case R.id.Q2CheckBox4:
                if (checked)
                    answer2 = answer2+"D";
                else //remove D
                    answer2 = answer2.replaceAll("D", "");
                break;
            case R.id.Q2CheckBox5:
                if (checked)
                    answer2 = answer2+"E";
                else //remove E
                    answer2 = answer2.replaceAll("E", "");
                break;

        }
    }


    public void goNextPage(View view) {

        if (num.equals("2")){ //if only 2 pages, finish and go to result page
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

        } else { //if more than 2 pages, go to next page
            Intent intent = new Intent(this, QuestionPage3.class);
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

    //pass all the answers to previous page
    public void goPreviousPage(View view) {

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
    //log out to welcome page
    public void Logout(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}

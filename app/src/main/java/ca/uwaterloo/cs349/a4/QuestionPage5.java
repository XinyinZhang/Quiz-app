package ca.uwaterloo.cs349.a4;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class QuestionPage5 extends AppCompatActivity {


    Button previous; // a button to go to previous page
    String num; //an variable to store the number of questions that user selected in the topicPage
    String Username; //an variable to store the user name

    //stores the answers
    String answer1;
    String answer2;
    String answer3;
    String answer4;
    String answer5;
    CheckBox currentBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_page5);
        //receives all the variables from the previous page
        Intent intent = getIntent();
        num = intent.getStringExtra("QuestionPageNum");
        Username = intent.getStringExtra("Username");

        answer1 = intent.getStringExtra("answer1");
        answer2 = intent.getStringExtra("answer2");
        answer3 = intent.getStringExtra("answer3");
        answer4 = intent.getStringExtra("answer4");
        answer5 = intent.getStringExtra("answer5");

        //initial the checkbox
        if(answer5 != null && answer5.contains("A")){
            currentBox = findViewById(R.id.Q5CheckBox1);
            currentBox.setChecked(true);

        }

        if(answer5 != null && answer5.contains("B")){
            currentBox = findViewById(R.id.Q5CheckBox2);
            currentBox.setChecked(true);

        }

        if(answer5 != null && answer5.contains("C")){
            currentBox = findViewById(R.id.Q5CheckBox3);
            currentBox.setChecked(true);

        }

        if(answer5 != null && answer5.contains("D")){
            currentBox = findViewById(R.id.Q5CheckBox4);
            currentBox.setChecked(true);

        }





        //a textView showing the current question number and number of questions user selected
        //in the topic selection page

        TextView QuestionCount = findViewById(R.id.QCount);
        String n = "5/"+num;
        QuestionCount.setText(n);

        //a textView showing the user name
        TextView NameTitle = findViewById(R.id.Name5);
        String nm = "Name: " + Username;
        NameTitle.setText(nm);


    }
    //received the answers when users go back to page 5
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

    //store the answers to answer5 variable
    public void CheckBox5Answer(View view){
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()){
            case R.id.Q5CheckBox1:
                if (checked)
                    answer5 = answer5+"A";
                else //remove A
                    answer5 = answer5.replaceAll("A", "");

                break;
            case R.id.Q5CheckBox2:
                if (checked)
                    answer5 = answer5+"B";
                else //remove B
                    answer5 = answer5.replaceAll("B", "");

                break;
            case R.id.Q5CheckBox3:
                if (checked)
                    answer5 = answer5+"C";
                else //remove C
                    answer5 = answer5.replaceAll("C", "");

                break;
            case R.id.Q5CheckBox4:
                if (checked)
                    answer5 = answer5+"D";
                else //remove D
                    answer5 = answer5.replaceAll("D", "");

                break;


        }
    }

    public void goNextPage(View view) { //pass all the variables to the result page

        Intent intent = new Intent(this, Results.class);
        intent.putExtra("QuestionPageNum", num);
        intent.putExtra("Username", Username);

        intent.putExtra("answer1", answer1);
        intent.putExtra("answer2", answer2);
        intent.putExtra("answer3", answer3);
        intent.putExtra("answer4", answer4);
        intent.putExtra("answer5", answer5);

        startActivityForResult(intent, 1);

    }

    public void goPreviousPage(View view) { //pass all the variables to the previous page

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
package com.example.sumanth.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView timerTextView;
    TextView addTextView;
    TextView markTextView;
    TextView resultTextView;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button patton;
    int changingi;
    int succesrate=0;
    int totalscore=0;
    ArrayList<Integer> array = new ArrayList<Integer>();
    public void playAgain(View view){
        succesrate=0;
        totalscore=0;
        update();
        new CountDownTimer(30000,1000){
            public void onTick(long l){
                timerTextView.setText((int)l/1000 + "s");
            }
            public void onFinish(){
                patton.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this, "your score is : " + (Integer.toString(succesrate) + "/" + Integer.toString(totalscore)), Toast.LENGTH_SHORT).show();

            }
        }.start();

    }
    public void checkAnswer(View view){
        if(Integer.toString(changingi).equals(view.getTag().toString())) {
            resultTextView.setText("correct!");
            succesrate++;
            update();
        }
        else{
            resultTextView.setText("wrong!");
            update();

        }
        totalscore++;
        markTextView.setText(Integer.toString(succesrate) + "/" + Integer.toString(totalscore));


    }
    public void update(){
        Random rand=new Random();
        int a = rand.nextInt(21);
        int b = rand.nextInt(21);
        addTextView.setText(Integer.toString(a) + "+" + Integer.toString(b));
        int answer = a+b;
        array.clear();

        changingi = rand.nextInt(4);
        for(int i=0;i<4;i++){
            if(i == changingi){
                array.add(answer);
            }
            else{
                int random = rand.nextInt(41);
                while(answer == random)
                {
                    array.add(random);
                }
                array.add(random);
            }

        }
        button0.setText(Integer.toString(array.get(0)));
        button1.setText(Integer.toString(array.get(1)));
        button2.setText(Integer.toString(array.get(2)));
        button3.setText(Integer.toString(array.get(3)));


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timerTextView = findViewById(R.id.timerTextView);
        addTextView = findViewById(R.id.addTextView);
        markTextView = findViewById(R.id.markTextView);
        resultTextView=findViewById(R.id.resultTextView);
        button0=findViewById(R.id.button0);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        patton =findViewById(R.id.pgbutton);
       update();
       patton.setVisibility(View.INVISIBLE);
       new CountDownTimer(30100,1000){
            public void onTick(long l){
                timerTextView.setText(String.valueOf(l/1000) + "s");
            }
            public void onFinish(){
                patton.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this, "your score is : " + (Integer.toString(succesrate) + "/" + Integer.toString(totalscore)), Toast.LENGTH_SHORT).show();

            }
        }.start();


    }
}

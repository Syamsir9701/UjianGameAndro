package com.juaracoding.ujian;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.Toast;

import static java.nio.file.Files.move;

public class MainActivity extends AppCompatActivity {
    Button btn_up, btn_down, btn_right, btn_left;
    CardView[][] cardViews = new CardView[3][3];
    int[][] arry = {{0,0,0}, {0,0,0}, {0,0,0}};
    int[] baris = {0,0}; //pointer//position
    int[] colom = {0,0}; //temp
    private Object color;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_up = findViewById(R.id.btn_up);
        btn_down = findViewById(R.id.btn_down);
        btn_right = findViewById(R.id.btn_right);
        btn_left = findViewById(R.id.btn_left);

        init();
        memulaipermainan();


        btn_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (baris[1] > 0) {
                    for (int i = 0; i < baris.length; i++)
                        colom[i] = baris[i];
                    baris[1]--;
                    move();
                    getColor();
                }
            }
        });

        btn_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (baris[0] > 0){
                    for (int i = 0; i < baris.length; i++)
                        colom[i] = baris[i];
                    baris[0]--;
                    move();
                    getColor();
                }
            }
        });

        btn_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (baris[0] < 2) {
                    for (int i = 0; i < baris.length; i++)
                        colom[i] = baris[i];
                    baris[0]++;
                    move();
                    getColor();
                }
            }
        });

        btn_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (baris[1] < 2) {
                    for (int i = 0; i < baris.length; i++)
                        colom[i] = baris[i];
                    baris[1]++;
                    move();
                    getColor();
                }
            }
        });


        private void init() {
            for (int i =0; i < 3; i++){
                for (int j =0; j < 3; j++){
                    String cardviewsId = "cv" + i + j;
                    cardViews[i][j] = findViewById(getResources().getIdentifier(cardviewsId,"id",getPackageName()));
                }
            }
        }


        private void getColor () {
            if (arry[baris[1]][baris[0]] == 1)
                cardViews[baris[1]][baris[0]].getCardBackgroundColor(getResources().getColor(R.color.black));
            else if (arry[baris[1]][baris[0]] ==0)
                cardViews[baris[1]][baris[0]].getCardBackgroundColor(getResources().getColor(R.color.white));
        }

        private void move() {
            if (arry[baris[1]][baris[0]] == 0){
                arry[baris[1]][baris[0]]++;
            }
            else if (arry[baris[1]][baris[0]] == 1) {
                arry[baris[1]][baris[0]]--;
            }
        }
        }

    private void memulaipermainan() {
        for (int i = 0; i < baris.length; i++) {
            colom[i] = baris[i];
        }
        move();
        getColor();
    }

    public Object getColor() {
        return color;
    }

    public void setColor(Object color) {
        this.color = color;
    }
}
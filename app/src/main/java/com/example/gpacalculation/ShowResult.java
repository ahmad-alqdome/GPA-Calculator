package com.example.gpacalculation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowResult extends AppCompatActivity {

    TextView mark , hours , rate;
    Button done;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_result);

        mark=findViewById(R.id.tv_mark_id);
        hours=findViewById(R.id.tv_hours_id);
        done=findViewById(R.id.btn_done_id);
        rate=findViewById(R.id.tv_rate_id);
        Bundle bundle=getIntent().getExtras();

        float m=bundle.getFloat("mark");
        int h=bundle.getInt("hours");
        float finalMark=m/h;




        if(finalMark>=94)
        {
            rate.setText(getString(R.string.excellence));
            mark.setText(getString(R.string.cumulative)+" : "+finalMark);
            hours.setText(getString(R.string.cumulativeHours)+" : "+ h);
        }
        else if(finalMark>=84&&finalMark<94)
        {
            rate.setText(getString(R.string.excellent));
            mark.setText(getString(R.string.cumulative)+" : "+finalMark);
            hours.setText(getString(R.string.cumulativeHours)+" : "+ h);
        }
        else if(finalMark>=76&&finalMark<84)
        {
            rate.setText(getString(R.string.very_good));
            mark.setText(getString(R.string.cumulative)+" : "+finalMark);
            hours.setText(getString(R.string.cumulativeHours)+" : "+ h);
        }
        else if(finalMark>=68&&finalMark<76)
        {
            rate.setText(getString(R.string.good));
            mark.setText(getString(R.string.cumulative)+" : "+finalMark);
            hours.setText(getString(R.string.cumulativeHours)+" : "+ h);
        }
        else if(finalMark>=60&&finalMark<68)
        {
            rate.setText(getString(R.string.acceptable));
            mark.setText(getString(R.string.cumulative)+" : "+finalMark);
            hours.setText(getString(R.string.cumulativeHours)+" : "+ h);
        }
        else if(finalMark>=50&&finalMark<60)
        {
            rate.setText(getString(R.string.bad));
            mark.setText(getString(R.string.cumulative)+" : "+finalMark);
            hours.setText(getString(R.string.cumulativeHours)+" : "+ h);
        }
        else
        {
          rate.setTextColor(getColor(R.color.red));
            rate.setText(getString(R.string.fail));
            mark.setText(getString(R.string.cumulative)+" : "+finalMark);
            hours.setText(getString(R.string.cumulativeHours)+" : "+ h);
        }


        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}
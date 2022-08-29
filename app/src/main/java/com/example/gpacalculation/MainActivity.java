package com.example.gpacalculation;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {

/******************************** global variable **************************************/

    List <String> hours= Arrays.asList("Select","1","2","3","4");
    Spinner spinner1,spinner2,spinner3,spinner4,spinner5,spinner6,spinner7,spinner8;
    ArrayAdapter adapter;
    Button cal;
    EditText cumulative ,cumulativeHours , article1,article2,article3,article4,article5,article6,article7,article8;
float sumMark=0;
int sumHours=0;


/***************************************************************************************/
   public void connItems() {
       spinner1 = findViewById(R.id.sp_ar_1_id);
       spinner2 = findViewById(R.id.sp_ar_2_id);
       spinner3 = findViewById(R.id.sp_ar_3_id);
       spinner4 = findViewById(R.id.sp_ar_4_id);
       spinner5 = findViewById(R.id.sp_ar_5_id);
       spinner6 = findViewById(R.id.sp_ar_6_id);
       spinner7 = findViewById(R.id.sp_ar_7_id);
       spinner8 = findViewById(R.id.sp_ar_8_id);
       cumulative =findViewById(R.id.cum_avg_id);
       cumulativeHours=findViewById(R.id.cum_avg_hours_id);
       article1 =findViewById(R.id.ed_ar_1_id);
       article2=findViewById(R.id.ed_ar_2_id);
       article3 =findViewById(R.id.ed_ar_3_id);
       article4=findViewById(R.id.ed_ar_4_id);
       article5=findViewById(R.id.ed_ar_5_id);
       article6=findViewById(R.id.ed_ar_6_id);
       article7 =findViewById(R.id.ed_ar_7_id);
       article8=findViewById(R.id.ed_ar_8_id);
       cal=findViewById(R.id.btn_cal_id);
   }


void setAdapter(){
    adapter=new ArrayAdapter(getApplicationContext(), R.layout.select_item, hours);
    adapter.setDropDownViewResource(R.layout.select_item);
    spinner1.setAdapter(adapter);
    spinner2.setAdapter(adapter);
    spinner3.setAdapter(adapter);
    spinner4.setAdapter(adapter);
    spinner5.setAdapter(adapter);
    spinner6.setAdapter(adapter);
    spinner7.setAdapter(adapter);
    spinner8.setAdapter(adapter);
}

void addMark(Spinner sp , String mark)
{
    if(!(sp.getSelectedItemPosition()==0&&mark.isEmpty()))
    {
        sumMark+=sp.getSelectedItemPosition()*Integer.parseInt(mark);
        sumHours+=sp.getSelectedItemPosition();
    }
}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connItems(); //method for connected items
        setAdapter();//method for spinner and adapter



cal.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        sumHours=0;
        sumMark=0;
        String strCumulativeMark=cumulative.getText().toString();
        String strCumulativeHours=cumulativeHours.getText().toString();
     if(strCumulativeMark.isEmpty())
     {
         Toast.makeText(getApplicationContext(),R.string.massage_mark,Toast.LENGTH_SHORT).show();
     }
     if(strCumulativeHours.isEmpty())
     {
            Toast.makeText(getApplicationContext(),R.string.massage_hours,Toast.LENGTH_SHORT).show();
     }
     boolean isFound=!(strCumulativeHours.isEmpty())&&!(strCumulativeMark.isEmpty());
     if(isFound)
     {
         sumMark=Float.parseFloat(strCumulativeMark) * Integer.parseInt(strCumulativeHours);
         sumHours=Integer.parseInt(strCumulativeHours);
     }

        addMark(spinner1,article1.getText().toString());
        addMark(spinner2,article2.getText().toString());
        addMark(spinner3,article3.getText().toString());
        addMark(spinner4,article4.getText().toString());
        addMark(spinner5,article5.getText().toString());
        addMark(spinner6,article6.getText().toString());
        addMark(spinner7,article7.getText().toString());
        addMark(spinner8,article8.getText().toString());
if(isFound)
{
    Intent intent=new Intent(MainActivity.this,ShowResult.class);

    intent.putExtra("mark",sumMark);
    intent.putExtra("hours",sumHours);
    startActivity(intent);
   // Toast.makeText(getApplicationContext(), sumMark/sumHours+"", Toast.LENGTH_SHORT).show();
}
    }
});





    }



}
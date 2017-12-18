package com.example.dheeraj.teacher;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class cgpa_activity extends AppCompatActivity {

    EditText c1,c2,c3,c4,c5,c6,c7,c8;
    Button b3;
    float sg1,sg2,sg3,sg4,sg5,sg6,sg7,sg8,cg;
    int g1=28,g2=28,g3=28,g4=28,g5=28,g6=28,g7=28,g8=28;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgpa);
            c1=(EditText)findViewById(R.id.c1);
            c2=(EditText)findViewById(R.id.c2);
            c3=(EditText)findViewById(R.id.c3);
            c4=(EditText)findViewById(R.id.c4);
            c5=(EditText)findViewById(R.id.c5);
            c6=(EditText)findViewById(R.id.c6);
            c7=(EditText)findViewById(R.id.c7);
            c8=(EditText)findViewById(R.id.c8);
            b3=(Button)findViewById(R.id.b3);
//            TextView t=(TextView)findViewById(R.id.tv);
//            t.setVisibility(View.INVISIBLE);


            b3.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    sg1=read(c1);
                    sg2=read(c2);
                    sg3=read(c3);
                    sg4=read(c4);
                    sg5=read(c5);
                    sg6=read(c6);
                    sg7=read(c7);
                    sg8=read(c8);
                    if(sg1==0)
                        g1=0;

                    if(sg2==0)
                        g2=0;

                    if(sg3==0)
                        g3=0;

                    if(sg4==0)
                        g4=0;

                    if(sg5==0)
                        g5=0;

                    if(sg6==0)
                        g6=0;

                    if(sg7==0)
                        g7=0;

                    if(sg8==0)
                        g8=0;



                    cg=((sg1*g1)+(sg2*g2)+(sg3*g3)+(sg4*g4)+(sg5*g5)+(sg6*g6)+(sg7*g7)+(sg8*g8))/(g1+g2+g3+g4+g5+g6+g7+g8);
                    if(sg1==0 && sg2==0 && sg3==0 && sg4==0 && sg5==0 && sg6==0 && sg7==0 && sg8==0)
                     //   Toast.makeText(getApplicationContext(), "Insufficient Data ", Toast.LENGTH_LONG).show();
                        Toasty.error(getApplicationContext(), "Insufficient Data ", Toast.LENGTH_LONG).show();

                    else if((sg1>10.0)||sg2>10.0||sg3>10.0||sg4>10.0||sg5>10.0||sg6>10.0||sg7>10.0 ||sg8>10.0   )
                    {
                       // Toast.makeText(getApplicationContext(), " Invalid SGPA", Toast.LENGTH_SHORT).show();
                        Toasty.error(getApplicationContext(), " Invalid SGPA", Toast.LENGTH_SHORT).show();

                    }

                    else
                    {

                        Intent i3=new Intent(getApplicationContext(), Result_activity.class);
                        i3.putExtra("final_sgpa",cg);
                        i3.putExtra("flag", 0);
                        i3.putExtra("final_perc", 0);
                        startActivity(i3);

                    }


                    // TODO Auto-generated method stub

                }


            });

        }


    private float read(EditText c) {

        if(c.getText().toString().matches(""))
        {		return 0;

        }
        else
        {
            return (Float.valueOf(c.getText().toString()).floatValue());
        }

        // TODO Auto-generated method stub
    }

}
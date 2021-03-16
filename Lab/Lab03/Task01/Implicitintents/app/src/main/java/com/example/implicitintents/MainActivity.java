package com.example.implicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final int TEXT_REQUEST = 1;
    private TextView itemText1;
    private TextView itemText2;
    private TextView itemText3;
    private TextView itemText4;
    private TextView itemText5;
    private TextView itemText6;
    private TextView itemText7;
    private TextView itemText8;
    private TextView itemText9;
    private TextView itemText10;
    private int count=0;
    private EditText mLocationEditText;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent2=getIntent();
        String message=intent2.getStringExtra(SecondActivity.EXTRA_MESSAGE);
        itemText1=findViewById(R.id.item1);
        itemText2=findViewById(R.id.item2);
        itemText3=findViewById(R.id.item3);
        itemText4=findViewById(R.id.item4);
        itemText5=findViewById(R.id.item5);
        itemText6=findViewById(R.id.item6);
        itemText7=findViewById(R.id.item7);
        itemText8=findViewById(R.id.item8);
        itemText9=findViewById(R.id.item9);
        itemText10=findViewById(R.id.item10);
        mLocationEditText = findViewById(R.id.location_edittext);
        if(savedInstanceState != null){
            itemText1.setText(savedInstanceState.getString("item1"));
            itemText2.setText(savedInstanceState.getString("item2"));
            itemText3.setText(savedInstanceState.getString("item3"));
            itemText4.setText(savedInstanceState.getString("item4"));
            itemText5.setText(savedInstanceState.getString("item5"));
            itemText6.setText(savedInstanceState.getString("item6"));
            itemText7.setText(savedInstanceState.getString("item7"));
            itemText8.setText(savedInstanceState.getString("item8"));
            itemText9.setText(savedInstanceState.getString("item9"));
            itemText10.setText(savedInstanceState.getString("item10"));
            count = savedInstanceState.getInt("count");
        }
    }

    public void launchSecondActivity(View view) {
        Intent intent = new Intent(this,SecondActivity.class);
        startActivityForResult(intent, TEXT_REQUEST);

    }

    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String itemList =
                        data.getStringExtra(SecondActivity.EXTRA_MESSAGE);
                switch (count){
                    case 0: {
                        itemText1.setText(itemList);
                        count++;
                        Log.d("CC", String.valueOf(count));
                    }
                    break;
                    case 1: {
                        itemText2.setText(itemList);
                        count++;
                    }
                    break;
                    case 2: {
                        itemText3.setText(itemList);
                        count++;
                    }
                    break;
                    case 3: {
                        itemText4.setText(itemList);
                        count++;
                    }
                    break;
                    case 4: {
                        itemText5.setText(itemList);
                        count++;
                    }
                    break;
                    case 5: {
                        itemText6.setText(itemList);
                        count++;
                    }
                    break;
                    case 6: {
                        itemText7.setText(itemList);
                        count++;
                    }
                    break;
                    case 7: {
                        itemText8.setText(itemList);
                        count++;
                    }
                    break;
                    case 8: {
                        itemText9.setText(itemList);
                        count++;
                    }
                    break;
                    case 9: {
                        itemText10.setText(itemList);
                        count++;
                    }
                    break;
                }

            }
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString("item1",itemText1.getText().toString());
        outState.putString("item2",itemText2.getText().toString());
        outState.putString("item3",itemText3.getText().toString());
        outState.putString("item4",itemText4.getText().toString());
        outState.putString("item4",itemText4.getText().toString());
        outState.putString("item5",itemText5.getText().toString());
        outState.putString("item6",itemText6.getText().toString());
        outState.putString("item7",itemText7.getText().toString());
        outState.putString("item8",itemText8.getText().toString());
        outState.putString("item9",itemText9.getText().toString());
        outState.putString("item10",itemText10.getText().toString());
        outState.putInt("count",count);
    }


    public void openLocation(View view) {
        String loc = mLocationEditText.getText().toString();
        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }

    }
}
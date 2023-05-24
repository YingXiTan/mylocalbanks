package sg.edu.rp.c346.id22023689.mylocalbanksps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textViewDBS;
    TextView textViewOCBC;
    TextView textViewUOB;

    TextView tvTranslatedText;
    TextView tvTranslatedText2;
    TextView tvTranslatedText3;

    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewDBS = findViewById(R.id.textViewDBS);
        textViewOCBC = findViewById(R.id.textViewOCBC);
        textViewUOB = findViewById(R.id.textViewUOB);

        registerForContextMenu(tvTranslatedText);
        registerForContextMenu(tvTranslatedText2);
        registerForContextMenu(tvTranslatedText3);

        textViewDBS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);

                Intent intent2 = new Intent(Intent.ACTION_DIAL, Uri.parse("Tel: " + 18001111111));
                startActivity(intent);
            }
        });

        textViewOCBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intent);

                Intent intent2 = new Intent(Intent.ACTION_DIAL, Uri.parse("Tel: " + 18003633333));
                startActivity(intent);

            }
        });

        textViewUOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);

                Intent intent2 = new Intent(Intent.ACTION_DIAL, Uri.parse("Tel: " + 18002222121));
                startActivity(intent);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu; this adds items to the action bar if it is present
        getMenuInflater().inflate(R.menu.menu_bankdetails, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "English");
        menu.add(0, 1, 1, "Chinese");

        if (v == tvTranslatedText) {
            wordClicked = "DBS";
        } else if (v == tvTranslatedText2) {
            wordClicked = "OCBC";
        } else if (v == tvTranslatedText3) {
            wordClicked = "UOB";
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase("DBS")) {
            if (item.getItemId() == 0) { //Checked whether the selected menu item ID is 0
                tvTranslatedText.setText("DBS");
                //Toast.makeText(MainActivity.this, "English is chosen", Toast.LENGTH_SHORT).show();
                return true; //Menu item successfully handled
            } else if (item.getItemId() == 1) { //Check if the selected menu item ID is 1
                tvTranslatedText.setText("星展银行");
                //Toast.makeText(MainActivity.this, "Italian is chosen", Toast.LENGTH_SHORT).show();
                return true; //Menu item successfully handled
            }

            return false; //Pass menu item to the superclass implementation

        } else if (wordClicked.equalsIgnoreCase("OCBC")) {
            if (item.getItemId() == 0) { //Checked whether the selected menu item ID is 0
                tvTranslatedText2.setText("OCBC");
                //Toast.makeText(MainActivity.this, "English is chosen", Toast.LENGTH_SHORT).show();
                return true; //Menu item successfully handled
            } else if (item.getItemId() == 1) { //Check if the selected menu item ID is 1
                tvTranslatedText2.setText("华侨银行");
                //Toast.makeText(MainActivity.this, "Italian is chosen", Toast.LENGTH_SHORT).show();
                return true; //Menu item successfully handled
            }
            return false;

        } else {
            if (item.getItemId() == 0) {
                tvTranslatedText3.setText("UOB");
                return true;
            } else if (item.getItemId() == 1) {
                tvTranslatedText3.setText("大华银行");
                return true;
            }
            return false;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvTranslatedText.setText("DBS");
            tvTranslatedText2.setText("OCBC");
            tvTranslatedText3.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            tvTranslatedText.setText("星展银行");
            tvTranslatedText2.setText("华侨银行");
            tvTranslatedText2.setText("大华银行");
            return true;
        } else {
            tvTranslatedText.setText("Error translation");
        }
        return super.onOptionsItemSelected(item);
    }

}







package exampledomain.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class EditItemActivity extends AppCompatActivity {

    TextView txtview;
    int index;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        String oldtext = getIntent().getStringExtra("oldvalue");
        index = getIntent().getIntExtra("index", -1);

        txtview = (TextView) findViewById(R.id.editText);
        txtview.setText(oldtext);


    }

    public void onclicksave(View v) {
        txtview = (TextView) findViewById(R.id.editText);
        String newtext = txtview.getText().toString();

        Intent intent = new Intent(EditItemActivity.this, MainActivity.class);
        intent.putExtra("newvalue", newtext);
        intent.putExtra("index", index);


        setResult(RESULT_OK, intent);
        finish();
    }
}

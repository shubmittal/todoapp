package exampledomain.todoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ArrayList<String> items;
    ArrayAdapter<String> itemsadaptor;
    ListView lvlitems;
    int REQUESTID = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvlitems = (ListView) findViewById(R.id.lvItems);
        items = new ArrayList<>();
        items = readitems();
        itemsadaptor = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        lvlitems.setAdapter(itemsadaptor);
        setupListViewListener();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == REQUESTID) {
            int index = data.getIntExtra("index", -1);
            String newvalue = data.getStringExtra("newvalue");
            items.set(index, newvalue);
            writeitems(items);
            itemsadaptor.notifyDataSetChanged();
        }
    }

    public void onAddItem(View V) {

        EditText edittext = (EditText) findViewById(R.id.etNewItem);

        String newtext = edittext.getText().toString();

        if(newtext.length() >0) {
            items.add(newtext);
            writeitems(items);
            itemsadaptor.notifyDataSetChanged();
            edittext.setText("");
        }

    }

    public void setupListViewListener() {
        lvlitems.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapter, View item, int pos, long id) {
                        items.remove(pos);
                        writeitems(items);
                        itemsadaptor.notifyDataSetChanged();
                        return true;
                    }
                }
        );

        lvlitems.setOnItemClickListener(

                new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {

                        String item = items.get(pos);
                        Intent intent = new Intent(MainActivity.this, EditItemActivity.class);
                        intent.putExtra("oldvalue", item);
                        intent.putExtra("index", pos);
                        startActivityForResult(intent, REQUESTID);

                    }
                }
        );
    }


    private ArrayList<String> readitems() {
        File filedir = getFilesDir();
        File file = new File(filedir, "todo.txt");
        ArrayList<String> todoitems = new ArrayList<String>();

        try {
            todoitems = (ArrayList<String>) FileUtils.readLines(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return todoitems;


    }

    private void writeitems(ArrayList<String> todoitems) {
        File filedir = getFilesDir();
        Log.v("filedir", filedir.toString());
        File file = new File(filedir, "todo.txt");

        try {
            FileUtils.writeLines(file, todoitems);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

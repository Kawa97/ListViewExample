package accademia.lynxspa.com.listviewexample.ul.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import accademia.lynxspa.com.listviewexample.R;
import accademia.lynxspa.com.listviewexample.data.Contatto;
import accademia.lynxspa.com.listviewexample.data.Singleton;
import accademia.lynxspa.com.listviewexample.logic.DataAccessUtils;
import accademia.lynxspa.com.listviewexample.ul.activity.DetailActivity;
import accademia.lynxspa.com.listviewexample.ul.adapter.CustomArrayAdapter;

public class MainActivity extends AppCompatActivity {

    CustomArrayAdapter adapter;

    public final static String EXTRA_SELECTED_ITEM = "accademia.lynxspa.com.SELECTED_ITEM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataAccessUtils.initDataSource(getApplicationContext());

        List<Contatto> contactList = new ArrayList<Contatto>(Singleton.getInstance().getItemList());

        adapter = new CustomArrayAdapter(this, contactList);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setTextFilterEnabled(true);

        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // Start detail Activity
                String selectedItem = Singleton.getInstance().getItemList().get(position);

                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                intent.putExtra(EXTRA_SELECTED_ITEM, selectedItem);
                startActivity(intent);
            }
        });*/

        /*
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                showRemoveAlertDialog(position);
                return true;
            }
        });*/
DataAccessUtils.addIgnorante();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_add: {

                Intent intent = new Intent(getApplicationContext(), AddContactActivity.class);
                startActivity(intent);


                return true;
            }
            default: {
                return super.onOptionsItemSelected(item);

            }
        }
    }

    /*AlertDialog with add function with EditText */

    /*
    public void showAddAlertDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add item");

        //Creazione di un input text
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        builder.setPositiveButton(R.string.alert_ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //aggiungi elemento

                DataAccessUtils.addItem(input.getText().toString().toUpperCase());

                // update and refresh list view
                adapter.setValues();
                dialog.cancel();
            }
        });
        builder.setNegativeButton(R.string.alert_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Annulla operazione
                dialog.cancel();
            }
        });
        builder.show();
    }*/

    public void showRemoveAlertDialog(final int position) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Remove item");

        //Creazione di un messaggio
        builder.setMessage("Do you want to remove this item?");

        builder.setPositiveButton(R.string.alert_ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //rimuovi elemento

                DataAccessUtils.removeItem(getApplicationContext(), position);

                // update and refresh list view
                adapter.setValues();
                dialog.cancel();
            }
        });
        builder.setNegativeButton(R.string.alert_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Annulla operazione
                dialog.cancel();
            }
        });
        builder.show();
    }



}


/*  public static int getColorForPosition(Context context,int position){
if(position % 2==0)
{return context.getColor(R.color.light_blue);
}
else {
return context.getColor(R.color.light_gray)
}
}
}*/
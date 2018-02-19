package accademia.lynxspa.com.listviewexample.ul.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import accademia.lynxspa.com.listviewexample.R;
import accademia.lynxspa.com.listviewexample.data.Contatto;
import accademia.lynxspa.com.listviewexample.data.Singleton;
import accademia.lynxspa.com.listviewexample.logic.DataAccessUtils;

public class AddContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);


        View button = findViewById(R.id.addButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Contatto c1=null;
                String nome= String.valueOf(R.id.nomeCognome);
                String telefono= String.valueOf(R.id.nomeCognome);

                c1=new Contatto(nome,telefono);
                DataAccessUtils.addItem(c1);
                finish();
            }
        });
    }
}

package accademia.lynxspa.com.listviewexample.logic;

import android.content.Context;
import android.provider.ContactsContract;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import accademia.lynxspa.com.listviewexample.R;
import accademia.lynxspa.com.listviewexample.data.Contatto;
import accademia.lynxspa.com.listviewexample.data.Singleton;


public class DataAccessUtils {


    public static void initDataSource(Context context) {
        List <Contatto> contactList = new ArrayList<Contatto>();

        Singleton.getInstance().setItemList(contactList);


    }
    public static List<Contatto> getDataSourceItemList(Context context){
        return Singleton.getInstance().getItemList();
    }

    public static void addItem(Contatto item){

        Singleton.getInstance().getItemList().add(item);
    }
    public static void removeItem(Context context, int index){

        Singleton.getInstance().getItemList().remove(index);
    }

    public static void addIgnorante(){
        Contatto c1=new Contatto("Paolo Rossi","3241543663");
        Singleton.getInstance().getItemList().add(c1);

        Contatto c2=new Contatto("Lorenzo Shish","4537544337");
        Singleton.getInstance().getItemList().add(c2);

        Contatto c3=new Contatto("Asia Feffoli","3574456456");
        Singleton.getInstance().getItemList().add(c3);
    }
}

package accademia.lynxspa.com.listviewexample.data;

import java.util.ArrayList;
import java.util.List;

public class Singleton {
    private static Singleton ourInstance = new Singleton();

    private List<Contatto> itemList;

    public static Singleton getInstance() {
        return ourInstance;
    }

    private Singleton() {
        this.itemList = new ArrayList<Contatto>();
    }

    public void setItemList(List<Contatto> itemList) {
        this.itemList = itemList;
    }

    public List<Contatto> getItemList() {
        return itemList;
    }


}


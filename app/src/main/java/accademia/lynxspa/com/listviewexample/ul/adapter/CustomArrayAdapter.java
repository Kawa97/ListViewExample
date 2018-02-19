package accademia.lynxspa.com.listviewexample.ul.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import accademia.lynxspa.com.listviewexample.R;
import accademia.lynxspa.com.listviewexample.data.Contatto;
import accademia.lynxspa.com.listviewexample.data.Singleton;

public class CustomArrayAdapter extends ArrayAdapter<Contatto> {

    private final Context context;
    private  List<Contatto> values;

    public CustomArrayAdapter(Context context,List<Contatto> values) {
        super(context, R.layout.item_layout,Singleton.getInstance().getItemList());
        this.values = Singleton.getInstance().getItemList();
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.item_layout, parent, false);

        TextView textView = (TextView) rowView.findViewById(R.id.labelnome);
        Contatto itemName = this.values.get(position);
        textView.setText(itemName.getNomeCognome());

        TextView textView2 = (TextView) rowView.findViewById(R.id.labeltelefono);
        textView2.setText(itemName.getTelefono());
        // Set icon
        ImageView imageView = (ImageView) rowView.findViewById(R.id.logo);
        imageView.setImageResource(R.drawable.ic_fruit);
        return rowView;

    }

    public View getViewOptimized(int position, View convertView, ViewGroup parent){
        ViewHolder viewHolder =null;
        if(convertView== null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_layout,null);
            viewHolder= new ViewHolder();
            viewHolder.name= (TextView) convertView.findViewById(R.id.labelnome);
            viewHolder.number= (TextView) convertView.findViewById(R.id.labeltelefono);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Contatto contatto= getItem(position);
        viewHolder.name.setText(contatto.getNomeCognome());
        viewHolder.number.setText(contatto.getTelefono());
        return convertView;

    }

    public void setValues(){
        values = Singleton.getInstance().getItemList();
        notifyDataSetChanged();
    }

    private class ViewHolder{
        private TextView name;
        private TextView number;
    }


    @Override
    public int getCount() {
        return values.size();
    }
}
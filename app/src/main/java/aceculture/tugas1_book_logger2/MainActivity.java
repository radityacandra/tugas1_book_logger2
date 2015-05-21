package aceculture.tugas1_book_logger2;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity   {
    Button inputButton;
    ListView listOfBook;
    EditText inputJudulBuku, inputPengarangBuku, inputJmlHlmBuku;

    ArrayAdapter<String> adapter;


    ListBookAdapter listItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputJudulBuku= (EditText) findViewById(R.id.inputJudul);
        inputPengarangBuku= (EditText) findViewById(R.id.inputPengarang);
        inputJmlHlmBuku= (EditText) findViewById(R.id.inputJmlHlm);
        inputButton= (Button) findViewById(R.id.inputBtn);

        //listOfBook.setAdapter(adapter);
        listItem = new ListBookAdapter();
        ListView listItemView = (ListView)findViewById(R.id.listBook);
        listItemView.setAdapter(listItem);

    }

    public class listViewBook
    {
        String JudulBuku;
        String PengarangBuku;
        String JmlHlmBuku;
    }

    public List<listViewBook> DataListBook = getDatafromListBook();
    public class ListBookAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return DataListBook.size();
        }

        @Override
        public Object getItem(int arg0) {
            return DataListBook.get(arg0);
        }

        @Override
        public long getItemId(int arg0) {
            return arg0;
        }

        @Override
        public View getView(int arg0, View arg1, ViewGroup arg2) {
            if (arg1==null){
                LayoutInflater inflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                arg1 = inflater.inflate(R.layout.listitem, arg2,false);
            }
            TextView judul = (TextView)arg1.findViewById(R.id.judul);
            TextView pengarang = (TextView)arg1.findViewById(R.id.pengarang);
            TextView jumlahBuku = (TextView)arg1.findViewById(R.id.jumlah);

            listViewBook item = DataListBook.get(arg0);
            judul.setText(item.JudulBuku);
            pengarang.setText(item.PengarangBuku);
            jumlahBuku.setText(item.JmlHlmBuku);
            return arg1;
        }

        public listViewBook getListViewBook(int position){
            return DataListBook.get(position);
        }
    }


    public List<listViewBook> getDatafromListBook()
    {
        List<listViewBook> ListOfViewBook = new ArrayList<listViewBook>();
        if (true){
            listViewBook item = new listViewBook();
            item.JudulBuku = "Naruto";
            item.PengarangBuku = "Masashi Kishimoto";
            item.JmlHlmBuku = "60";
            ListOfViewBook.add(item);
        }
        return ListOfViewBook;

    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

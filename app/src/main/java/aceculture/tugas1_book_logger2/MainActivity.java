package aceculture.tugas1_book_logger2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity   {
    Button inputButton;
    ListView listofBook;
    EditText inputJudulBuku, inputPengarangBuku, inputJmlHlmBuku;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listofBook= (ListView) findViewById(R.id.listBook);
        inputJudulBuku= (EditText) findViewById(R.id.inputJudul);
        inputPengarangBuku= (EditText) findViewById(R.id.inputPengarang);
        inputJmlHlmBuku= (EditText) findViewById(R.id.inputJmlHlm);
        inputButton= (Button) findViewById(R.id.inputBtn);
    }

    public class listViewBook
    {
        String JudulBuku;
        String PengarangBuku;
        String JmlHlmBuku;
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

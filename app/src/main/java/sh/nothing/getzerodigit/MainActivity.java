package sh.nothing.getzerodigit;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final String[] COLUMNS = new String[] { "_id", "key", "value" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListAdapter((ListView) findViewById(R.id.listView));
    }

    private void setListAdapter(ListView listView) {
        listView.setAdapter(
                new SimpleCursorAdapter(this,
                        android.R.layout.simple_list_item_2,
                        getNumbersCursor(),
                        COLUMNS,
                        new int[] { 0, android.R.id.text1, android.R.id.text2 },
                        0
                )
        );
    }

    private Cursor getNumbersCursor() {
        Locale[] locales = Locale.getAvailableLocales();
        MatrixCursor mc = new MatrixCursor(COLUMNS, locales.length);
        Integer i = 0;
        for (Locale l : locales) {
            String localized = String.format(l, "%d", 1234567890L);
            mc.addRow(new Object[]{
                    i++,
                    l.getDisplayName(),
                    localized
            });
        }
        return mc;
    }
}

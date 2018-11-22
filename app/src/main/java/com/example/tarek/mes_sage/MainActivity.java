package com.example.tarek.mes_sage;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    //public ArrayList<Message> messageList = new ArrayList<>();
    ListAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), BuildMessageActivity.class);
                startActivity(intent);
            }
        });


        Context context = getApplicationContext();
        MessageController.loadMessageList(context);

        /*Context context2 = getApplicationContext();
        CharSequence text = MessageController.getMessageList().toString();
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context2, text, duration);
        toast.show();*/


       /* messageList.add(new Message("A", "B", "C", "D", 1, 1, 1, 1, 2));
        messageList.add(new Message("a", "B", "C", "D", 1, 1, 1, 1, 2));
        messageList.add(new Message("A", "B", "C", "D", 1, 1, 1, 1, 2));
        messageList.add(new Message("a", "B", "C", "D", 1, 1, 1, 1, 2));
        messageList.add(new Message("A", "B", "C", "D", 1, 1, 1, 1, 2));
        messageList.add(new Message("a", "B", "C", "D", 1, 1, 1, 1, 2));
        messageList.add(new Message("A", "B", "C", "D", 1, 1, 1, 1, 2));
        messageList.add(new Message("a", "B", "C", "D", 1, 1, 1, 1, 2));
        messageList.add(new Message("A", "B", "C", "D", 1, 1, 1, 1, 2));
*/
        //if(messageList.isEmpty()){
        if(MessageController.getMessageList().isEmpty()){
            TextView ProgrammaticallyTextView = findViewById(R.id.no_message);
            ProgrammaticallyTextView.setText(R.string.no_messages);
            ProgrammaticallyTextView.setTextSize(20);
        }
        else {
            ListView listView = findViewById(R.id.message_list_view);
            // get data from the table by the ListAdapter
            //ListAdapter customAdapter = new ListAdapter(this, R.layout.list_message, messageList);
            customAdapter = new ListAdapter(this, R.layout.list_message, MessageController.getMessageList());
            listView.setAdapter(customAdapter);
            customAdapter.notifyDataSetChanged();

            registerForContextMenu(listView);
        }

    }

    @Override
    public void onResume() {
        super.onResume();  // Always call the superclass method first
        customAdapter.notifyDataSetChanged();

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
    @Override
    public void onPause() {
        super.onPause();
        MessageController.saveMessageList(this);
    }
    @Override
    protected void onStop() {
        super.onStop();
        MessageController.saveMessageList(this);

    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v.getId()==R.id.message_list_view) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu_list, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch(item.getItemId()) {
            case R.id.edit:
                Context context2 = getApplicationContext();
                CharSequence text = String.valueOf(info.position) +" "+String.valueOf(info.id);
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context2, text, duration);
                toast.show();
                return true;
            case R.id.delete:
                MessageController.getMessageList().remove(info.position);
                customAdapter.notifyDataSetChanged();
            default:
                return super.onContextItemSelected(item);
        }
    }
}

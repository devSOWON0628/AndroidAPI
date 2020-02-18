package kr.hs.emirim.dgh09053.mirimbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //private ArrayList<Dictionary> mArrayList;


    Button Bu1;
    public EditText searching;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bu1=findViewById(R.id.b1);
        searching=findViewById(R.id.search2);
        Bu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Show s=new Show();
                Intent intent=new Intent(MainActivity.this,Show.class);
                intent.putExtra("name",searching.getText().toString());
                startActivity(intent);
//                intent=getIntent();
//                search=intent.getStringExtra("name");
            }
        });
    }

    public List<User> userList ;

    private void initLoadDB() {

        DataAdapter mDbHelper = new DataAdapter(getApplicationContext());
        mDbHelper.createDatabase();
        mDbHelper.open();

        // db에 있는 값들을 model을 적용해서 넣는다.
        userList = mDbHelper.getTableData(searching.getText().toString());
        if(userList.size()==0){
            Toast.makeText(getApplicationContext(), "도서결과가 없습니다.", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this,
                    "제목:"+userList.get(0).getTitle()+
                            ", 저자:"+userList.get(0).getAuther()+
                            ", 번호:"+userList.get(0).getBookNum()
                    , Toast.LENGTH_SHORT).show();
        }

        // db 닫기
        mDbHelper.close();
    }
}

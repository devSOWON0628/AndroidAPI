package kr.hs.emirim.dgh09053.mirimbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Show extends AppCompatActivity {
    public List<User>userList;
    public String search;
    Intent intent;

    private ArrayList<User> mArrayList;
    private CustomAdapter mAdapter;
    @Override
    public Intent getIntent() {
        return super.getIntent();
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        intent=getIntent();
        search=intent.getStringExtra("name");
        initLoadDB();

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView2);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mAdapter = new CustomAdapter( userList);
        mRecyclerView.setAdapter(mAdapter);


        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(),
                mLinearLayoutManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);

    }

    private void initLoadDB() {

        DataAdapter mDbHelper = new DataAdapter(getApplicationContext());
        mDbHelper.createDatabase();
        mDbHelper.open();

        // db에 있는 값들을 model을 적용해서 넣는다.
        userList = mDbHelper.getTableData(search);
        if(userList.size()==0){
            Toast.makeText(getApplicationContext(), "도서결과가 없습니다.", Toast.LENGTH_LONG).show();
        }
        else{
//            Toast.makeText(this,
//                    "제목:"+userList.get(0).getTitle()+
//                            ", 저자:"+userList.get(0).getAuther()+
//                            ", 번호:"+userList.get(0).getBookNum()
//                    , Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(), search, Toast.LENGTH_LONG).show();
        }

        // db 닫기
        mDbHelper.close();
    }
}

package com.amrita.universalacceptance;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import com.amrita.universalacceptance.helper.DatabaseUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.amrita.universalacceptance.helper.DatabaseUtils.INPUT_COLUMN_Email;
import static com.amrita.universalacceptance.helper.DatabaseUtils.INPUT_COLUMN_ID;
import static com.amrita.universalacceptance.helper.DatabaseUtils.INPUT_COLUMN_Name;

public class ListActivity extends AppCompatActivity {


    @BindView(R.id.tv_list)
    TextView tv_list;

    private DatabaseUtils databaseUtils;
    private List<ListDetails> dataList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ButterKnife.bind(this);

        databaseUtils = new DatabaseUtils(getBaseContext());

        databaseUtils.getAllEmail();
        Cursor cursor = databaseUtils.getAllEmail();
        if(cursor.moveToFirst()){
            while(!cursor.isAfterLast()) {
                ListDetails listDetails = new ListDetails(
                        cursor.getString(cursor.getColumnIndex(INPUT_COLUMN_ID)),
                        cursor.getString(cursor.getColumnIndex(INPUT_COLUMN_Name)),
                        cursor.getString(cursor.getColumnIndex(INPUT_COLUMN_Email))
                );
                dataList.add(listDetails);
                cursor.moveToNext();
            }
        }

        for(int i =0; i < dataList.size() -1; i++){
            tv_list.append(dataList.get(i).getEmail() + "\n");
        }


    }
}

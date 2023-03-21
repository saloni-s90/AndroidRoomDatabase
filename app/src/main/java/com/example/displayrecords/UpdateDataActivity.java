package com.example.displayrecords;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.displayrecords.databinding.ActivityUpdateDataBinding;

import java.util.List;

public class UpdateDataActivity extends AppCompatActivity {

    ActivityUpdateDataBinding binding;

    private UserModel userModel;

    private MyAdapter myAdapter;

    private MyDatabase myDatabase;

    private AllDao allDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUpdateDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        userModel = (UserModel) getIntent().getSerializableExtra("userm");

        myDatabase = MyDatabase.getMyDatabase(this);
        allDao = myDatabase.getMyDao();

        List<InfoModel> infoModelList  =allDao.getMyEmployName(userModel.getId());

        for (InfoModel infoModel : infoModelList)
        {
            binding.empList.append(infoModel.getEmp_name()+"\n\n");
        }

        binding.b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.e1.getText().toString();

                saveDatas(new InfoModel(0,userModel.getId(),name));
                Toast.makeText(UpdateDataActivity.this,"Employee Added",Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void saveDatas(InfoModel infoModel) {
        allDao.insertEmploy(infoModel);

    }
}
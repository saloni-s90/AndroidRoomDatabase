package com.example.displayrecords;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.example.displayrecords.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private MyDatabase myDatabase;
    private AllDao allDao;
    private List<UserModel> userModelList;
    private MyAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        myDatabase = MyDatabase.getMyDatabase(this);
        allDao = myDatabase.getMyDao();

        myAdapter = new MyAdapter(this);

        binding.dataRecycler.setAdapter(myAdapter);
        binding.dataRecycler.setLayoutManager(new LinearLayoutManager(this));

        userModelList = allDao.getAllUsers();

        for(UserModel userModel:userModelList){
            myAdapter.addUser(userModel);
        }

        binding.saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nm = binding.name.getText().toString();

                saveAllData(new UserModel(0,nm));

            }
        });

    }

    private void saveAllData(UserModel userModel) {

        long id = allDao.insertUser(userModel);
        userModel.setId(Integer.parseInt(id + ""));
        myAdapter.addUser(userModel);

    }
}
package com.example.rudym.firstmessagingapp_rm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference myDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDataBase = FirebaseDatabase.getInstance().getReference("Message");

        final TextView myText = findViewById(R.id.text1);
        myDataBase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot){
            myText.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError){
            myText.setText("CANCELLED");
            }
        });
    }
    public void sendMessage(View view){
        EditText myEditText = findViewById(R.id.editText);

//        myDataBase.child("Name").setValue(myEditText.getText().toString());
        myDataBase.setValue(myEditText.getText().toString());
        myEditText.setText("");
    }
}

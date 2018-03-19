package com.gmail.sowmiyanagarajan98.aakhyaan;

/**
 * Created by Sowmiya Nagarajan on 18-03-2018.
 */

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class FragmentOne extends Fragment {

    RecyclerView recyclerView;
    CustomAdapter adapter;
    private ArrayList<User> listContentArr= new ArrayList<>();
    private ArrayList<String> contacts = new ArrayList<>();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference contact = database.getReference("contacts");
    DatabaseReference users = database.getReference("users");
    static final String LOG_TAG="Tagged";

    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_fragment_one, container,false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        adapter=new CustomAdapter(this.getActivity());

        populateRecyclerViewValues();
        adapter.setListContent(listContentArr);
        recyclerView.setAdapter(adapter);
        Log.d(FragmentOne.LOG_TAG,"Application started");

        return view;
    }

    private void populateRecyclerViewValues() {
        //We set the array to the adapter
        contact.addValueEventListener(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot childDataSnapshot : dataSnapshot.child("1").getChildren()) {
                    Long val= childDataSnapshot.getValue(Long.class);
                    contacts.add(String.valueOf(val));
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        users.addValueEventListener(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (int i = 0; i < contacts.size(); i++) {
                    User u = dataSnapshot.child(contacts.get(i)).getValue(User.class);
                    String name = u.getName();
                    String email = u.getEmail();
                    System.out.println(name+" "+email);
                    listContentArr.add(u);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        }

    interface OnFragmentInteractionListener {
    }
}
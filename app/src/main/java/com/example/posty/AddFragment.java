package com.example.posty;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AddFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_add, container, false);

        Button addBtn = (Button)view.findViewById(R.id.addNewPostBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText namtET = view.findViewById(R.id.enterNameET);
                EditText contentET = view.findViewById(R.id.enterContentET);
                EditText usernameET = view.findViewById(R.id.usernameET);

                String name = namtET.getText().toString();
                String content = contentET.getText().toString();
                String username = "@" + usernameET.getText().toString();

                Post tempPost = new Post(username, name, content);

                Context context = getContext().getApplicationContext();
                Toast toast = Toast.makeText(context, "Post added", Toast.LENGTH_SHORT);
                toast.show();

                int position = MainActivity.posts.size();
                MainActivity.posts.add(position, tempPost);

                namtET.setText(null);
                usernameET.setText(null);
                contentET.setText(null);
            }
        });

        //TODO: Add functionality for adding pictures, remove name and username fields

        return view;
    }
}

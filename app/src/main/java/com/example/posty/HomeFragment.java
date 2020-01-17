package com.example.posty;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);


        Context context = getContext();
        RecyclerView recyclerView = view.findViewById(R.id.mainRecView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);

        PostAdapter postAdapter = new PostAdapter(context, MainActivity.posts);
        recyclerView.setHasFixedSize(true);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), ((LinearLayoutManager) layoutManager).getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        String text = Integer.toString(MainActivity.posts.size());

        Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        toast.show();

        if(MainActivity.posts.isEmpty()){

        }else{
            postAdapter.notifyDataSetChanged();
            recyclerView.setAdapter(postAdapter);
        }





//        return super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

}

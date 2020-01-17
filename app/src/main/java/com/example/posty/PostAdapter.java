package com.example.posty;

import android.content.Context;
import android.graphics.Typeface;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

//import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.postViewHolder> {
    private Context context;
    private ArrayList<Post> posts;

    public PostAdapter(Context context, ArrayList<Post> objects){
        //super(context, resource, objects);

        this.posts = objects;
        this.context = context;

    }

    public class postViewHolder extends RecyclerView.ViewHolder{

        public TextView nameTV;
        public TextView contentTV;
        public TextView displayNameTV;
        ConstraintLayout constraintLayout;

        public postViewHolder(View view){
            super(view);

            nameTV = view.findViewById(R.id.usernameTextView);
            nameTV.setTypeface(null, Typeface.ITALIC);
            contentTV = view.findViewById(R.id.contentTextView);
            displayNameTV = view.findViewById(R.id.displayNameTV);
            displayNameTV.setTypeface(null, Typeface.BOLD);
            constraintLayout = view.findViewById(R.id.constraintLayout);
        }
    }

    @Override
    public PostAdapter.postViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View postView = inflater.inflate(R.layout.post_detail, parent, false);

        postViewHolder viewHolder = new postViewHolder(postView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PostAdapter.postViewHolder viewHolder, int position){
        Post post = posts.get(position);
        TextView nameTV = viewHolder.nameTV;
        TextView contentTV = viewHolder.contentTV;

        //Assuming we have ArrayList images and an imageview image
        //Glide.with(context).asBitmap().load(images.get(position)).into(viewHolder.image);

        String username = post.getUsername().toString();
        String displayName = post.getDisplayName().toString();
        String content = post.getContent().toString();


        viewHolder.displayNameTV.setText(displayName);
        viewHolder.nameTV.setText(username);
        viewHolder.contentTV.setText(content);

        //You can add OnClickListeners here!!!!
    }

    @Override
    public int getItemCount(){
        return posts.size();
    }

}

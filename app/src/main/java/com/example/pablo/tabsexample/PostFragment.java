package com.example.pablo.tabsexample;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.pablo.tabsexample.adapter.PostAdapter;
import com.example.pablo.tabsexample.network.RetrievePostsAsyncTask;


public class PostFragment extends Fragment {
    private ListView listView;
    private PostAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post, container, false);
        // Inflate the layout for this fragment
        listView = (ListView)view.findViewById(R.id.posts_list_view);
        adapter = new PostAdapter(getActivity());
        listView.setAdapter(adapter);

        RetrievePostsAsyncTask task = new RetrievePostsAsyncTask(this);
        task.execute();

        return view;
    }

    public PostAdapter getAdapter() {
        return adapter;
    }
}

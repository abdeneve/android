package com.example.pablo.tabsexample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.pablo.tabsexample.adapter.UserAdapter;
import com.example.pablo.tabsexample.network.RetrieveUsersAsyncTask;

/**
 * Created by Alex on 6/16/2016.
 */
public class UserFragment extends Fragment {
    private ListView listView;
    private UserAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post, container, false);
        // Inflate the layout for this fragment
        listView = (ListView)view.findViewById(R.id.posts_list_view);
        adapter = new UserAdapter(getActivity());
        listView.setAdapter(adapter);

        RetrieveUsersAsyncTask task = new RetrieveUsersAsyncTask(this);
        task.execute();

        return view;
    }

    public UserAdapter getAdapter() {
        return adapter;
    }
}

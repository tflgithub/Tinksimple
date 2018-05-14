package com.cn.tink.simpledemo;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class BlankFragment extends Fragment {
    private RecyclerViewAdapter recyclerViewAdapter;

    public BlankFragment() {
    }

    public static BlankFragment newInstance(List<ServerData> list) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("data", (ArrayList<? extends Parcelable>) list);
        BlankFragment blankFragment = new BlankFragment();
        blankFragment.setArguments(bundle);
        return blankFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        final SwipeRefreshLayout mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        List<ServerData> list = getArguments().getParcelableArrayList("data");
        recyclerViewAdapter = new RecyclerViewAdapter(getActivity(), list);
        recyclerView.addItemDecoration(new SpaceItemDecoration(DensityUtils.dp2px(getActivity(), 10)));
        recyclerView.setAdapter(recyclerViewAdapter);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadMore();
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }


    public void loadMore() {
        List<ServerData> list = Utils.getServerData("data.json", getActivity().getApplication());
        recyclerViewAdapter.addAll(list);
    }
}

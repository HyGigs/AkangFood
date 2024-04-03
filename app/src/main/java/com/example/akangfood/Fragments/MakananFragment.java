package com.example.akangfood.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.akangfood.R;
import com.example.akangfood.RecyclerView.FnBAdapter;
import com.example.akangfood.RecyclerView.FnBModel;

import java.util.ArrayList;

public class MakananFragment extends Fragment implements FnBAdapter.FnBAdapterListener {

    RecyclerView rvFood;
    ArrayList<FnBModel> fnbList;
    private FnBAdapter adapterFnBList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_fnb, container, false);

        fnbList = new ArrayList<>();
        rvFood = view.findViewById(R.id.rvFood);

        fnbList.add(new FnBModel("Batagor", "500cal", "Asin","Rp. 10.000 - 20.000" ,R.drawable.batagor, false));
        fnbList.add(new FnBModel("Mie Kocok", "350cal", "Asin","Rp. 30.000 - 50.000" ,R.drawable.mie_kocok, false));
        fnbList.add(new FnBModel("Seblak", "262cal", "Pedas","Rp. 5.000 - 20.000" ,R.drawable.seblak, false));
        fnbList.add(new FnBModel("Cuanki", "218cal", "Asin","Rp. 5.000 - 15.000" ,R.drawable.cuanki, false));
        fnbList.add(new FnBModel("Surabi", "108cal", "Manis","Rp. 5.000 - 10.000" ,R.drawable.surabi, false));

        adapterFnBList = new FnBAdapter(fnbList, this);
        rvFood.setAdapter(adapterFnBList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        rvFood.setLayoutManager(mLayoutManager);

        return view;
    }

    @Override
    public void onFnBSelected(FnBModel fnbSelect) {

    }
}

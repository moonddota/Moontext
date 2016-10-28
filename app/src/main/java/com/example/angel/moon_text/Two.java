package com.example.angel.moon_text;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.angel.moon_text.adapter.TwoRAdapter;
import com.example.angel.moon_text.info.PhoneInfo;
import com.example.angel.moon_text.network.NetApi;
import com.example.angel.moon_text.network.NetClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Angel on 2016/10/28.
 */

public class Two extends Fragment {
    private TwoRAdapter adapter;
    private RecyclerView recyclerView;
    String phone;
    String AppKey = "6978b1f7fed65bbb4d0d2ad96c73f191";
    private List<PhoneInfo.ResultBean> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.twof, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.two_recycle);
       NetApi netApi = NetClient.getInstance(getContext()).getNetApi();
        Call<PhoneInfo> call=netApi.getClassify(phone,AppKey);
        call.enqueue(callback_find);
        adapter = new TwoRAdapter(getContext());
    }
    private Callback<PhoneInfo> callback_find=new Callback<PhoneInfo>() {
        @Override
        public void onResponse(Call<PhoneInfo> call, Response<PhoneInfo> response) {
            list = response.body().getResult();
            setListData();
        }
        @Override
        public void onFailure(Call<PhoneInfo> call, Throwable t) {
            Toast.makeText(getContext(),"没有获取到数据:"+t.getMessage(),Toast.LENGTH_SHORT).show();
        }
    };
    //设置集合数据，填充Item的方法
    private void setListData(){
        if (list.size()<=0){
            Toast.makeText(getContext(),"数据异常",Toast.LENGTH_SHORT).show();
            return;
        }
//            cookItemList.add(response.body().getResult().getData().get(0));
        adapter.clear();
        adapter.addData(list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

    }


    }


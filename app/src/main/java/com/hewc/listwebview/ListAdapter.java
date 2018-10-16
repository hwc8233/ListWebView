package com.hewc.listwebview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.List;

/**
 * Created by hewc(破天) on 2018/10/15.
 */

public class ListAdapter extends RecyclerView.Adapter<ListHolder> {


    private List<String> mList;

    public ListAdapter(List<String> list) {
        mList = list;
    }

    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ListHolder(v);
    }

    @Override
    public void onBindViewHolder(ListHolder holder, int position) {
        holder.title.setText(mList.get(position));
        holder.title.setVisibility(View.GONE);
        holder.webView.getSettings().setJavaScriptEnabled(true);
        holder.webView.getSettings().setDomStorageEnabled(true);
        holder.webView.requestFocus();
        holder.webView.loadUrl(mList.get(position));
        holder.webView.getSettings().setAppCacheMaxSize(1024 * 1024 * 25);//设置缓冲大小，我设的是8M
        /** 使webview自己处理打开网页事件，不调用系统浏览器打开*/
        holder.webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}

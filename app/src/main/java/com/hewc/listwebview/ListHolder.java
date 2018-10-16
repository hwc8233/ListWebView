package com.hewc.listwebview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

/**
 * Created by hewc(破天) on 2018/10/15.
 */

public class ListHolder extends RecyclerView.ViewHolder {

    public WebView webView;
    public TextView title;

    public ListHolder(View itemView) {
        super(itemView);
        webView = (WebView) itemView.findViewById(R.id.web_view);
        title = (TextView) itemView.findViewById(R.id.title);
    }
}

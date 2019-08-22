package com.example.searchsample.ui.main;

import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.searchsample.R;
import com.example.searchsample.base.BaseViewHolder;

import java.text.Normalizer;

import androidx.annotation.NonNull;

public class SampleViewHolder extends BaseViewHolder<String> {
    private SampleListener listener;
    private TextView textView;
    private String searchText;

    public SampleViewHolder(@NonNull View itemView, SampleListener listener) {
        super(itemView);
        textView = itemView.findViewById(R.id.textView);
        this.listener = listener;
    }

    public void setSearchText(String searchText) {
        if(!TextUtils.isEmpty(searchText)) {
            this.searchText = searchText.toLowerCase();
        }
    }

    @Override
    public void bind(final String data) {
        textView.setText(highlight(data));
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClickItem(data);
            }
        });
    }

    @Override
    public void unbind() {
        textView.setText(null);
    }

    private CharSequence highlight(String originalText) {
        if (!TextUtils.isEmpty(searchText)) {
            String normalizedText = Normalizer.normalize(originalText, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "").toLowerCase();
            int start = normalizedText.indexOf(searchText);
            if (start < 0) {
                return originalText;
            } else {
                Spannable highlighted = new SpannableString(originalText);
                while (start >= 0) {
                    int spanStart = Math.min(start, originalText.length());
                    int spanEnd = Math.min(start + searchText.length(), originalText.length());
                    highlighted.setSpan(new ForegroundColorSpan(Color.BLUE), spanStart, spanEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    start = normalizedText.indexOf(searchText, spanEnd);
                }
                return highlighted;
            }
        }
        return originalText;
    }
}

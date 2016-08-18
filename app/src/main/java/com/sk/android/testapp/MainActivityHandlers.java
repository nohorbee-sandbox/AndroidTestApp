package com.sk.android.testapp;


import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

public class MainActivityHandlers extends BaseObservable {
    public ObservableField<String> textFieldValue = new ObservableField<>();
    private Context context;

    public void onClick(View view) {
        context = view.getContext();
        Toast.makeText(context, textFieldValue.get(), Toast.LENGTH_SHORT).show();
    }

    @Bindable
    public String getName() {
        return textFieldValue.get();
    }

    public void setName(String name) {
        textFieldValue.set(name);
        notifyPropertyChanged(com.sk.android.testapp.BR.name);
    }

    public final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) { }

        @Override
        public void afterTextChanged(Editable s) {
            if(!s.toString().equalsIgnoreCase(getName()))
                setName(s.toString());
        }
    };


}

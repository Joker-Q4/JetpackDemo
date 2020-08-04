package com.joker.ui.publish;

import android.os.Bundle;
import android.os.PersistableBundle;

import com.joker.R;
import com.joker.libnavannotation.ActivityDestination;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author Joker
 * @since 2020/08/03
 */
@ActivityDestination(pageUrl = "main/tabs/publish")
public class PublishActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_layout_publish);
    }
}

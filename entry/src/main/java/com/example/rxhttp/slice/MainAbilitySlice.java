package com.example.rxhttp.slice;

import android.util.Log;
import com.example.rxhttp.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import rxhttp.wrapper.param.RxHttp;

public class MainAbilitySlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        Button button = (Button) findComponentById(ResourceTable.Id_button);
        button.setClickedListener(component -> {
            RxHttp.setDebug(true);
            RxHttp.get("https://www.wanandroid.com/article/list/0/json")
                    .asString()
                    .subscribe(s -> {
                        //成功回调
                        Log.e("RxHttp", s);
                    }, error -> {
                        //异常回调
                    });
        });

    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}

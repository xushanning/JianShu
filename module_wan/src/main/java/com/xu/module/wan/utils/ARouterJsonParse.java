package com.xu.module.wan.utils;

import android.content.Context;
import android.os.Build;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.SerializationService;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.io.IOException;
import java.lang.reflect.Type;

@Route(path = "/yourservicegroupname/json")
public class ARouterJsonParse implements SerializationService {
    Moshi moshi = new Moshi.Builder().build();

    @Override
    public <T> T json2Object(String input, Class<T> clazz) {
        return null;
    }

    @Override
    public String object2Json(Object instance) {
        JsonAdapter adapter = moshi.adapter(instance.getClass());
        return adapter.toJson(instance);
    }

    @Override
    public <T> T parseObject(String input, Type clazz) {
        JsonAdapter adapter = moshi.adapter(clazz);
        try {
            return (T) adapter.fromJson(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void init(Context context) {

    }
}

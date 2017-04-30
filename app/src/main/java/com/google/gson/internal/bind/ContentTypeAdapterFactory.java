package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.$Gson$Types;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * 解析Content类型
 * Created by huangzhe on 2017/4/18.
 */

public class ContentTypeAdapterFactory implements TypeAdapterFactory {

    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Type type = typeToken.getType();
        Class<? super T> rawType = typeToken.getRawType();
        Type elementType = null;
        TypeAdapter<T> result = null;
        if (List.class.isAssignableFrom(rawType)) {
            elementType = $Gson$Types.getCollectionElementType(type, rawType);
            TypeAdapter<?> elementTypeAdapter = gson.getAdapter(TypeToken.get(elementType));
            result = new Adapter(gson, elementType, elementTypeAdapter);
       }else{
            elementType = $Gson$Types.getRawType(type);
            TypeAdapter<?> elementTypeAdapter = gson.getAdapter(TypeToken.get(elementType));
            result = new ObjectAdapter(gson, elementType, elementTypeAdapter);
        }
        return result;
    }

    private static final class ObjectAdapter<E> extends TypeAdapter<E>{

        private final TypeAdapter<E> elementTypeAdapter;

        public ObjectAdapter(Gson context, Type elementType, TypeAdapter<E> elementTypeAdapter){
            this.elementTypeAdapter = new TypeAdapterRuntimeTypeWrapper<E>(
                    context, elementTypeAdapter, elementType);
        }
        @Override
        public void write(JsonWriter out, E e) throws IOException {
            if (e == null) {
                out.nullValue();
                return;
            }

            out.beginObject();
            elementTypeAdapter.write(out, e);
            out.endObject();
        }

        @Override
        public E read(JsonReader in) throws IOException {
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            E instance=null;
            //新建一个空的列表
            try {
                in.beginObject();
                while (in.hasNext()) {
                    instance = elementTypeAdapter.read(in);
                }
                in.endObject();
                //正常解析成为列表
            } catch (IllegalStateException e){ //如果是空字符串，会有BEGIN_ARRAY报错
                //此时尝试解析成字符串，如果不是空字符串，则依旧抛出异常
                //如果是空字符串，则不抛出异常，使最终返回一个空的列表
                if (!"".equals(in.nextString())){
                    throw e;
                }
            }
            return instance;
        }
    }

    private static final class Adapter<E> extends TypeAdapter<List<E>> {
        private final TypeAdapter<E> elementTypeAdapter;

        public Adapter(Gson context, Type elementType,
                       TypeAdapter<E> elementTypeAdapter) {
            this.elementTypeAdapter = new TypeAdapterRuntimeTypeWrapper<E>(
                    context, elementTypeAdapter, elementType);
        }

        //关键部分是这里，重写解析方法
        public List<E> read(JsonReader in) throws IOException {
            //null值返回null
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            //新建一个空的列表
            List<E> list = new ArrayList<>();
            try {
                in.beginArray();
                while (in.hasNext()) {
                    E instance = elementTypeAdapter.read(in);
                    list.add(instance);
                }
                in.endArray();
                //正常解析成为列表
            } catch (Exception e){ //如果是空字符串，会有BEGIN_ARRAY报错
                //此时尝试解析成字符串，如果不是空字符串，则依旧抛出异常
                //如果是空字符串，则不抛出异常，使最终返回一个空的列表
                if (!"".equals(in.nextString())){
                    throw e;
                }
            }

            return list;
        }

        public void write(JsonWriter out, List<E> list) throws IOException {
            if (list == null) {
                out.nullValue();
                return;
            }

            out.beginArray();
            for (E element : list) {
                elementTypeAdapter.write(out, element);
            }
            out.endArray();
        }
    }

}

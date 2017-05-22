package com.xinluqishi.parkingcar.base.utils.view;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.xinluqishi.parkingcar.R;
import com.xinluqishi.parkingcar.base.model.service.CommonCallback;
import com.xinluqishi.parkingcar.base.model.service.RxApiManager;
import com.xinluqishi.parkingcar.base.utils.Validator;
import com.xinluqishi.parkingcar.base.view.BaseActivity;
import com.xinluqishi.parkingcar.base.view.widget.CustomProgressDialog;

import java.io.File;

/**
 * 窗口工具类,提供可重用的窗口
 */
public class DialogUtil {

    private static CustomProgressDialog progressDialogMy;
    private static ProgressDialog progDialog;
    private static Toast mToast;//为了实现疯狂模式下toast延时消失的问题
    private static Toast mToastCust ;

    /**
     * 显示等待条
     * @param ctx
     * @param msg
     */
    public static void showProgress(Activity ctx,String msg) {
        if (progDialog == null){
            progDialog = new ProgressDialog(ctx);
        }else{
            if(progDialog.isShowing()){
                return;
            }
        }
        progDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progDialog.setIndeterminate(false);
        //progDialog.setCancelable(false);//按返回取消
        progDialog.setCanceledOnTouchOutside(false);//点区域外不取消quxiao
        if(!Validator.isBlank(msg)){
            progDialog.setMessage(msg);
        }
        progDialog.show();
    }

    /**
     * 显示等待条
     * Context == Activity
     */
    public static void showProgress(Context ctx,final boolean isKeyBack) {
        progressDialogMy = CustomProgressDialog.createDialog(ctx);
        progressDialogMy.setCanceledOnTouchOutside(false);//点区域外quxiao
        // 添加按键监听
        progressDialogMy.setOnKeyListener(new DialogInterface.OnKeyListener() {
            public boolean onKey(DialogInterface arg0, int arg1, KeyEvent arg2) {
                if(isKeyBack) {
                    if (arg1 == KeyEvent.KEYCODE_BACK) {
                        if ((progressDialogMy != null) && progressDialogMy.isShowing()) {
                            progressDialogMy.cancel();
                        }
                    }
                }
                return false;
            }
        });
        progressDialogMy.show();
    }

    /**
     * 等待条用于访问HTTP，可取消访问
     * @param activity
     * @param isKeyBack
     */
    public static void showProgressByApi(final BaseActivity activity, final boolean isKeyBack){
        progressDialogMy = CustomProgressDialog.createDialog(activity);
        progressDialogMy.setCanceledOnTouchOutside(false);  //点区域外取消
        // 添加按键监听
        progressDialogMy.setOnKeyListener(new DialogInterface.OnKeyListener() {
            public boolean onKey(DialogInterface arg0, int arg1, KeyEvent arg2) {
                if(isKeyBack) {
                    if (arg1 == KeyEvent.KEYCODE_BACK) {
                        if ((progressDialogMy != null) && progressDialogMy.isShowing()) {
                            progressDialogMy.cancel();
                            RxApiManager.getRxInstance().cancel(activity.hashCode());
                        }
                    }
                }
                return false;
            }
        });
        progressDialogMy.show();
    }

    /**
     * 隐藏progress
     */
    public static void dismissProgress() {
        if ((progressDialogMy != null) && progressDialogMy.isShowing()) {
            progressDialogMy.dismiss();
        }
        if(progDialog!=null){
            progDialog.dismiss();
        }
    }

    /**
     * 显示并自动关闭
     * @param act
     * @param msg
     */
    public static void showToastOnUIThread(final Activity act,final String msg) {
        act.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                showToastCust(act,msg);
            }
        });

    }

    /**
     * 此方法可以避免疯狂模式下点击按钮造成的长时间显示toast的问题
     * @param ctx
     * @param msg
     */
    public static void showToastCust(Context ctx, String msg) {
        if(mToast==null){
            mToast = new Toast(ctx);
            mToast.setGravity(Gravity.CENTER, 0, 0);
            mToast.setDuration(Toast.LENGTH_LONG);
            View toastRoot = LayoutInflater.from(ctx).inflate(R.layout.toast_my, null);
            mToast.setView(toastRoot);
        }
        TextView message = (TextView) mToast.getView().findViewById(R.id.tv_toast);
        message.setText(msg);
        mToast.show();
    }

    public static void showToastCust(Context ctx, int resId) {
        if(mToast==null){
            mToast = new Toast(ctx);
            mToast.setGravity(Gravity.CENTER, 0, 0);
            mToast.setDuration(Toast.LENGTH_LONG);
            View toastRoot = LayoutInflater.from(ctx).inflate(R.layout.toast_my, null);
            mToast.setView(toastRoot);
        }
        TextView message = (TextView) mToast.getView().findViewById(R.id.tv_toast);
        message.setText(resId);
        mToast.show();
    }

    public static void showNoNet(Context ctx) {
        showToastCust(ctx, "网络不可用，请检查网络！");
    }



    public static void showToastNoNet(Context ctx) {
        View toastRoot =  LayoutInflater.from(ctx).inflate(R.layout.toast_my, null);
        TextView message = (TextView) toastRoot.findViewById(R.id.tv_toast);
        message.setText("网络不可用！");

        Toast toastStart = new Toast(ctx);
        toastStart.setGravity(Gravity.CENTER, 0, 0);
        toastStart.setDuration(Toast.LENGTH_SHORT);
        toastStart.setView(toastRoot);
        toastStart.show();
    }

//    public static void showAlertOnUIThread(final Activity ctx,final String msg,final CommonCallback callback) {
//        ctx.runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                showAlert(ctx, msg, callback);
//            }
//        });
//    }
    public static void showAdvertByFile(final Activity ctx, final File file, final CommonCallback<Boolean> callback ){
        final AlertDialog mAlertDialog = new AlertDialog.Builder(ctx).create();
//        mAlertDialog.setCancelable(false);

        final View view=ctx.getLayoutInflater().inflate(R.layout.alert_dialog_advert,null);
        ImageView alert_dialog_iv_advert=(ImageView)view.findViewById(R.id.alert_dialog_iv_advert);
//        ImageView alert_dialog_iv_close=(ImageView)view.findViewById(R.id.alert_dialog_iv_close);
//
//        alert_dialog_iv_close.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mAlertDialog.dismiss();
//            }
//        });
        alert_dialog_iv_advert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAlertDialog.dismiss();
            }
        });
        alert_dialog_iv_advert.setImageURI(Uri.fromFile(file));
        mAlertDialog.show();
        mAlertDialog.getWindow().setContentView(view);
        mAlertDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        callback.onCallBack(true);
    }
    /**
     * 显示广告信息
     */
//    public static void showAdvert(final Activity ctx,final String src,final File saveFile,final CommonCallback<Boolean> callback) throws IOException {
//        final AlertDialog mAlertDialog = new AlertDialog.Builder(ctx).create();
////        mAlertDialog.setCancelable(false);
//
//        final View view=ctx.getLayoutInflater().inflate(R.layout.alert_dialog_advert,null);
//        ImageView alert_dialog_iv_advert=(ImageView)view.findViewById(R.id.alert_dialog_iv_advert);
////        ImageView alert_dialog_iv_close=(ImageView)view.findViewById(R.id.alert_dialog_iv_close);
////
////        alert_dialog_iv_close.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                mAlertDialog.dismiss();
////            }
////        });
//        alert_dialog_iv_advert.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mAlertDialog.dismiss();
//            }
//        });
//        CreateBitmap createBitmap=new CreateBitmap(alert_dialog_iv_advert, saveFile,new CommonCallback<Boolean>() {
//            @Override
//            public void onCallBack(Boolean data) {
//                try {
//                    if(data==null||!data){//如果图片加载失败不显示控件
//                        mAlertDialog.dismiss();
//                        callback.onCallBack(false);
//                        return;
//                    }
//                    mAlertDialog.show();
//                    mAlertDialog.getWindow().setContentView(view);
//                    mAlertDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
//                    callback.onCallBack(true);
//                }catch(Exception ex){
//                    callback.onCallBack(false);
//                }
//            }
//        });
//        createBitmap.execute(src);
//
//
//    }
//
//    /**
//     * 圆角提示框
//     * @param ctx
//     * @param msg
//     * @param callback
//     */
//    public static void showAlert(final Activity ctx, final String msg,final CommonCallback<Boolean> callback) {
//        final AlertDialog mAlertDialog = new AlertDialog.Builder(ctx).create();
//        mAlertDialog.setCancelable(false);
//
//        View view=ctx.getLayoutInflater().inflate(R.layout.alert_dialog_warn,null);
//        TextView tv=(TextView)view.findViewById(R.id.alert_id);
//        tv.setText(ctx.getString(R.string.warn));
//
//        TextView tc=(TextView)view.findViewById(R.id.alert_context);
//        tc.setText(msg);
//
//        Button btn=(Button)view.findViewById(R.id.alert_ok);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(callback!=null) {
//                    callback.onCallBack(true);
//                }
//                mAlertDialog.dismiss();
//            }
//        });
//
//        mAlertDialog.show();
//        mAlertDialog.getWindow().setContentView(view);
//        mAlertDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
//
//    }
//    public static void showAlertYesNo(final Activity ctx,final String msg,final CommonCallback callback) {
//        final AlertDialog mAlertDialog = new AlertDialog.Builder(ctx).create();
//        mAlertDialog.setCancelable(false);
//
//        View view=ctx.getLayoutInflater().inflate(R.layout.alert_dialog_warn,null);
//        TextView tv=(TextView)view.findViewById(R.id.alert_id);
//        tv.setText(ctx.getString(R.string.warn));
//
//        TextView tc=(TextView)view.findViewById(R.id.alert_context);
//        tc.setText(msg);
//
//        Button yesBtn=(Button)view.findViewById(R.id.alert_yes);
//        yesBtn.setText(ctx.getString(R.string.btn_yes));
//        yesBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                callback.onCallBack(true);
//            }
//        });
//
//        Button onBtn=(Button)view.findViewById(R.id.alert_no);
//        onBtn.setText(ctx.getString(R.string.btn_no));
//        onBtn.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View v) {
//                callback.onCallBack(false);
//                mAlertDialog.dismiss();
//            }
//        });
//
//        mAlertDialog.show();
//        mAlertDialog.getWindow().setContentView(view);
//        mAlertDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
//    }
//    public static void showAlertYesOrNoOnUIThread(final Activity ctx,final String msg,final CommonCallback callback) {
//        ctx.runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                showAlertYesNo(ctx, msg, callback);
//            }
//        });
//    }
//    public static void showAlertOkCancel(final Activity ctx,final String msg,final CommonCallback<Boolean> callback) {
//        showAlertCusTitlel(ctx,ctx.getString(R.string.warn),msg,ctx.getString(R.string.btn_ok),ctx.getString(R.string.btn_cancel),callback);
//    }
//
//    /**
//     * 自定义
//     * @param ctx
//     * @param msg
//     * @param callback
//     */
//    public static void showAlertCusTitlel(final Activity ctx,final String title,final String msg,final String okName,final String cancelName,final CommonCallback<Boolean> callback) {
//        final AlertDialog mAlertDialog = new AlertDialog.Builder(ctx).create();
//        mAlertDialog.setCancelable(false);
//
//        View view=ctx.getLayoutInflater().inflate(R.layout.alert_dialog_ok,null);
//        TextView tv=(TextView)view.findViewById(R.id.alert_id);
//        tv.setText(title);
//
//        TextView tc=(TextView)view.findViewById(R.id.alert_context);
//        tc.setText(msg);
//
//        Button yesBtn=(Button)view.findViewById(R.id.alert_yes);
//        yesBtn.setText(ctx.getString(R.string.btn_ok));
//        yesBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                callback.onCallBack(true);
//                mAlertDialog.dismiss();
//            }
//        });
//
//        Button onBtn=(Button)view.findViewById(R.id.alert_no);
//        onBtn.setText(ctx.getString(R.string.btn_cancel));
//        onBtn.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View v) {
//                callback.onCallBack(false);
//                mAlertDialog.dismiss();
//            }
//        });
//
//        mAlertDialog.show();
//        mAlertDialog.getWindow().setContentView(view);
//        mAlertDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
//    }
//
//    /**
//     * 菜单形式
//     * @param ctx
//     * @param title
//     * @param arr
//     * @param callback
//     */
//    public static void showAlertMenu(final Activity ctx,String title,final String[] arr,final CommonCallback<Integer> callback){
//        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
//        if(Validator.isNotEmpty(title)){
//            builder.setTitle(title);
//        }
//        builder.setCancelable(true);
//        /**
//         * 第一个参数指定我们要显示的一组下拉单选框的数据集合
//         * 第二个参数代表索引，指定默认哪一个单选框被勾选上，0表示默认选中第一个
//         * 第三个参数给每一个单选项绑定一个监听器
//         */
//        builder.setItems(arr, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                callback.onCallBack(which);
//                dialog.cancel();
//            }
//        });
//        builder.show();
//    }
//
//    public static void showAlertMenuCust(final Activity ctx, String title, final String[] itemList, final Integer selectIndex, final CommonCallback<Integer> callback) {
//        try{
//            final AlertDialog mAlertDialog = new AlertDialog.Builder(ctx).create();
//            //内容
//            ListAdapter mAdapter = new ArrayAdapter(ctx, R.layout.alertdialog_item, itemList);
//            LayoutInflater inflater = LayoutInflater.from(ctx);
//            View view = inflater.inflate(R.layout.alertdialog, null);
//            view.setTranslationX(mAlertDialog.getWindow().getAttributes().width);
//            //标题
//            TextView titleView = (TextView)view.findViewById(R.id.tv_title);
//            if(Validator.isNotEmpty(title)){
//                titleView.setText(title);
//                titleView.setVisibility(View.VISIBLE);
//            }else{
//                titleView.setVisibility(View.GONE);
//            }
//            //取消
//            TextView btn=(TextView) view.findViewById(R.id.alert_cancel);
//            btn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    mAlertDialog.cancel();
//                }
//            });
//            final ListView listview = (ListView)view.findViewById(android.R.id.list);
//            listview.setAdapter(mAdapter);
//            if(selectIndex!=null) {
//                listview.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        TextView tv = (TextView) listview.getChildAt(selectIndex);
//                        tv.setTextColor(Color.parseColor("#fdb12c"));
//                    }
//                });
//            }
//            listview.setOnItemClickListener(new OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> arg0, View arg1, int pos,long arg3) {
//                    callback.onCallBack(pos);
//                    mAlertDialog.cancel();
//                }
//            });
//
//            mAlertDialog.getWindow().getAttributes().gravity=Gravity.BOTTOM;
//            mAlertDialog.getWindow().setWindowAnimations(R.style.alertTranStyle);
//            mAlertDialog.show();
//            mAlertDialog.getWindow().setContentView(view);
//
//            mAlertDialog.getWindow().setLayout(ctx.getResources().getDisplayMetrics().widthPixels,mAlertDialog.getWindow().getAttributes().height);
//
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    public static void showAlertMenuCust(final Activity ctx,String title,final List<String> itemList,final CommonCallback<Integer> callback) {
//        try{
//            final AlertDialog mAlertDialog = new AlertDialog.Builder(ctx).create();
//            //内容
//            ListAdapter mAdapter = new ArrayAdapter(ctx, R.layout.alertdialog_item, itemList);
//            LayoutInflater inflater = LayoutInflater.from(ctx);
//            View view = inflater.inflate(R.layout.alertdialog, null);
//
//            TextView titleView = (TextView)view.findViewById(R.id.tv_title);
//            if(Validator.isNotEmpty(title)){
//                titleView.setText(title);
//                titleView.setVisibility(View.VISIBLE);
//            }else{
//                titleView.setVisibility(View.GONE);
//            }
//
//            ListView listview = (ListView)view.findViewById(android.R.id.list);
//            listview.setAdapter(mAdapter);
//            listview.setOnItemClickListener(new OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> arg0, View arg1, int pos,long arg3) {
//                    callback.onCallBack(pos);
//                    mAlertDialog.cancel();
//                }
//            });
//
//            mAlertDialog.show();
//            mAlertDialog.getWindow().setContentView(view);
//            //mAlertDialog.getWindow().setLayout(150, 320);
//
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }
//
//
//    //va 引用了 ContextUtil
//    /**
//     *
//     * @param msg
//     */
//    public static void showToastCust(String msg){
//        showToastCust(ContextUtil.getAppContext(),msg);
//    }
}
//package com.xinluqishi.parkingcar.base.view.compnent;
//
//import android.content.Context;
//import android.content.res.TypedArray;
//import android.util.AttributeSet;
//import android.view.View;
//import android.widget.Button;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//
//import com.xinluqishi.parkingcar.base.view.event.HeaderBtnOnClickListener;
//import com.xinluqishi.parkingcar.R;
//
//
///**
// * 头部
// * Created by huangzhe on 2017/4/18.
// */
//
//public class CPCommonHeader extends BaseLinearLayout {
//    private Button cp_common_header_btn;//右按钮
//    private HeaderBtnOnClickListener headerBtnOnClickListener;//操作按钮
//    private TextView cp_common_header_tv_title;
//    public CPCommonHeader(Context context, AttributeSet attrs) {
//        super(context, attrs);
//    }
//
//    @Override
//    protected int getLayoutId() {
//        return R.layout.cp_common_header;
//    }
//
//    @Override
//    protected void init(Context context, AttributeSet attrs) {
//        cp_common_header_tv_title=(TextView)findViewById(R.id.cp_common_header_tv_title);//中标题
//        RelativeLayout cp_common_header_rl_back=(RelativeLayout)findViewById(R.id.cp_common_header_rl_back);//左返回
//        cp_common_header_btn=(Button)findViewById(R.id.cp_common_header_btn);//右按钮
//        TypedArray typedArray=context.obtainStyledAttributes(attrs, R.styleable.cp_common_header);
//        cp_common_header_tv_title.setText(typedArray.getString(R.styleable.cp_common_header_header_title));
//        cp_common_header_rl_back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(headerBtnOnClickListener!=null) {
//                    headerBtnOnClickListener.goHisClick();
//                }
//                getActivity().finish();
//            }
//        });
//        //是否显示按钮
//        cp_common_header_btn.setText(typedArray.getString(R.styleable.cp_common_header_btn_name));
//        if(typedArray.getBoolean(R.styleable.cp_common_header_btn_visibility,true)){
//            cp_common_header_btn.setVisibility(View.VISIBLE);
//        }else{
//            cp_common_header_btn.setVisibility(View.GONE);
//        }
//        cp_common_header_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(headerBtnOnClickListener!=null){
//                    headerBtnOnClickListener.SubmitClick();
//                }
//            }
//        });
//    }
//
//    /**
//     * 设置事件
//     * @param btnOnClickListener
//     */
//    public void setBtnOnClickListener(HeaderBtnOnClickListener btnOnClickListener){
//        this.headerBtnOnClickListener=btnOnClickListener;
//    }
//
//    /**
//     * 设置是否显示按钮
//     * @param isVisibility
//     */
//    public void setBtnVisibility(boolean isVisibility){
//        if(isVisibility){
//            cp_common_header_btn.setVisibility(View.VISIBLE);
//        }else{
//            cp_common_header_btn.setVisibility(View.GONE);
//        }
//    }
//
//    /**
//     * 设置名称
//     * @param title
//     */
//    public void setTitle(String title){
//        cp_common_header_tv_title.setText(title);
//    }
//}

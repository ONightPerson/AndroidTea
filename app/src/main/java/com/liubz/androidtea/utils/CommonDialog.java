package com.liubz.androidtea.utils;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.liubz.androidtea.R;


/**
 * 美团企业版通用的dialog原型，按钮的样式固定
 * @author meisong03
 * @motifier liubaozhu02
 * @date 8/22/22
 */
public class CommonDialog extends Dialog {

    private View mContainer;
    //标题
    private TextView mTitle;
    //内容
    private TextView mContent;
    //同意按钮
    private Button mPositiveButton;
    //不同意按钮
    private Button mNegativeButton;
    // 取消按钮
    private ImageView mCancelButton;
    //上下文
    private Context mContext;

    public CommonDialog(@NonNull Context context) {
        super(context, R.style.CommonDialog);
        this.mContext = context;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mContainer = inflater.inflate(R.layout.common_dialog, null);
        mTitle = mContainer.findViewById(R.id.tv_mt_enterprise_dialog_title);
        mContent = mContainer.findViewById(R.id.tv_mt_enterprise_dialog_content);
        mPositiveButton = mContainer.findViewById(R.id.btn_mt_enterprise_dialog_positive_button);
        mNegativeButton = mContainer.findViewById(R.id.btn_mt_enterprise_dialog_negative_button);
        mCancelButton = mContainer.findViewById(R.id.mt_enterprise_dialog_close_btn);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setCancelable(false);  // 是否可以撤销
        setContentView(mContainer);
    }

    public CommonDialog title(String titleText) {
        if (TextUtils.isEmpty(titleText)) {
            mTitle.setVisibility(View.GONE);
        } else {
            mTitle.setVisibility(View.VISIBLE);
            mTitle.setText(titleText);
        }
        return this;
    }

    public CommonDialog content(SpannableStringBuilder contentText) {
        mContent.setMovementMethod(LinkMovementMethod.getInstance());
        mContent.setText(contentText);
        mContent.setHighlightColor(mContext.getResources().getColor(R.color.transparent));
        return this;
    }

    public CommonDialog contentGravity(int gravity) {
        mContent.setGravity(gravity);

        return this;
    }

    public CommonDialog content(String content) {
        mContent.setText(content);
        return this;
    }

    public CommonDialog positiveBtnText(String positiveButtonText) {
        if (TextUtils.isEmpty(positiveButtonText)) {
            mPositiveButton.setVisibility(View.GONE);
        } else {
            mPositiveButton.setVisibility(View.VISIBLE);
            mPositiveButton.setText(positiveButtonText);
        }
        return this;
    }

    public CommonDialog negativeBtnText(String negativeButtonText) {
        if (TextUtils.isEmpty(negativeButtonText)) {
            mNegativeButton.setVisibility(View.GONE);
        } else {
            mNegativeButton.setVisibility(View.VISIBLE);
            mNegativeButton.setText(negativeButtonText);
        }
        return this;
    }

    public CommonDialog onPositiveBtnClick(View.OnClickListener positiveButtonClick) {
        mPositiveButton.setOnClickListener(positiveButtonClick);
        return this;
    }

    public CommonDialog onNegativeBtnClick(View.OnClickListener negativeButtonClick) {
        mNegativeButton.setOnClickListener(negativeButtonClick);
        return this;
    }

    public CommonDialog showCancelBtn() {
        mCancelButton.setVisibility(View.VISIBLE);
        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        return this;
    }
}
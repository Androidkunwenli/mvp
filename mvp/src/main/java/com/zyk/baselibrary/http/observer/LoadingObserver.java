package com.zyk.baselibrary.http.observer;

import android.content.Context;

import com.othershe.nicedialog.BaseNiceDialog;
import com.othershe.nicedialog.NiceDialog;
import com.zyk.baselibrary.activity.BaseActivity;
import com.zyk.baselibrary.R;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.Disposable;


public abstract class LoadingObserver<E> extends BaseObserver<E> {
    private BaseNiceDialog dialog;
    private WeakReference<Context> wrContext;

    /**
     * 显示loading的构造函数
     */
    public LoadingObserver(Context context, boolean showLoading, boolean showErrorTip) {
        super(showErrorTip);
        if (showLoading) {
            wrContext = new WeakReference<>(context);
            initLoading();
        }
    }

    @Override
    public void onSubscribe(Disposable d) {
        showLoading();
        super.onSubscribe(d);
    }

    @Override
    public void onNext(E o) {
        hideLoading();
        super.onNext(o);
    }

    @Override
    public void onError(Throwable e) {
        hideLoading();
        super.onError(e);
    }

    /**
     * 初始化loading
     */
    private void initLoading() {
        dialog = NiceDialog.init()
                .setLayoutId(R.layout.loading_layout)
                .setWidth(100)
                .setHeight(100)
                .setOutCancel(false)
                .setDimAmount(0);
    }

    /**
     * 显示loading
     */
    private void showLoading() {
        if (dialog != null) {
            dialog.show(((BaseActivity) wrContext.get()).getSupportFragmentManager());
        }
    }

    /**
     * 取消loading
     */
    private void hideLoading() {
        if (dialog != null) {
            dialog.dismiss();
            dialog = null;
        }
    }
}

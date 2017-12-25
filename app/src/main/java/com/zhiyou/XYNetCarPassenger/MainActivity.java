package com.zhiyou.XYNetCarPassenger;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jpay.JPay;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.wxpay);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Activity mContext=MainActivity.this;
                JPay.getIntance(mContext).toPay(JPay.PayMode.WXPAY, "{'appid':'wx79cc19454ba2e253','noncestr':'32746497175732391081','package':'Sign=WXPay','partnerid':'1403463602','prepayid':'wx201712221634106056b47d0d0944216168','sign':'6B1FD3C185C235E8C1D42B3008218B24','timestamp':'1513931635'}", new JPay.JPayListener() {
                    @Override
                    public void onPaySuccess() {
                        Toast.makeText(mContext, "支付成功", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onPayError(int error_code, String message) {
                        Toast.makeText(mContext, "支付失败"+error_code+" "+ message, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onPayCancel() {
                        Toast.makeText(mContext, "取消了支付", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onUUPay(String s, String s1, String s2) {

                    }
                });
            }
        });

    }
}

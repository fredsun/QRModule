package com.qrmodule;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.WriterException;
import com.qrmodule.qrcode.CaptureActivity;
import com.qrmodule.qrcode.ZxingBuildQRCode;

import java.io.UnsupportedEncodingException;

public class QRMainActivity extends AppCompatActivity implements View.OnClickListener {
    private Dialog mDialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);
        Button btn_qr = (Button) findViewById(R.id.btn_qr);
        btn_qr.setOnClickListener(this);
        Button btn_scan = (Button) findViewById(R.id.btn_scan);
        btn_scan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_qr){
            showQRCode();
        }else if (v.getId() == R.id.btn_scan){
            Intent intent = new Intent(this, CaptureActivity.class);
            startActivity(intent);
        }
    }

    /**
     * 显示二维码dialog
     */
    private void showQRCode() {
        View dialogView = LayoutInflater.from(this).inflate(
                R.layout.show_qrcode_dialog, null);
        mDialog = new AlertDialog.Builder(this).create();
        mDialog.show();
        mDialog.getWindow().setContentView(dialogView);
        int width = this.getWindowManager().getDefaultDisplay()
                .getWidth();// 得到当前显示设备的宽度，单位是像素
        android.view.WindowManager.LayoutParams params = mDialog.getWindow()
                .getAttributes();// 得到这个dialog界面的参数对象
        params.width = width - (width / 4);// 设置dialog的界面宽度
        params.height = android.view.ViewGroup.LayoutParams.WRAP_CONTENT;// 设置dialog高度为包裹内容
        params.gravity = Gravity.CENTER;// 设置dialog的重心
        mDialog.getWindow().setAttributes(params);
        dialogView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mDialog.cancel();
            }
        });
        mDialog.setCanceledOnTouchOutside(true);
        ImageView iv_qr_avatar = (ImageView) dialogView.findViewById(R.id.iv_qr_avatar);
        TextView tv_qr_user_name = (TextView) dialogView.findViewById(R.id.tv_qr_user_name);
        TextView tv_qr_user_id = (TextView) dialogView.findViewById(R.id.tv_qr_user_id);
        TextView tv_qr_area = (TextView) dialogView.findViewById(R.id.tv_qr_area);
        iv_qr_avatar.setImageResource(R.drawable.ic_launcher);
        tv_qr_user_name.setText("userName");
        tv_qr_user_id.setText("id");
        tv_qr_area.setText("area");

        ImageView qr_code = (ImageView) dialogView.findViewById(R.id.iv_qr_code);
        Bitmap mIcon = BitmapFactory.decodeResource(getResources(),
                R.drawable.ic_launcher);
        String content = "aaa";
        Bitmap bitmap;
        try {
            bitmap = ZxingBuildQRCode.cretaeBitmap(
                    new String(content.getBytes(), "UTF-8"), mIcon, 40, 450,
                    450);
            // 生成的二维码
            qr_code.setImageBitmap(bitmap);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (WriterException e) {
            e.printStackTrace();
        }

    }
}

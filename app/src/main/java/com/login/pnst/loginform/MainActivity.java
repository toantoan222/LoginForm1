package com.login.pnst.loginform;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText userb,pWb;
    Button login,register;
    String ten,mk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        ControlButton();
    }
    private void ControlButton() {
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setTitle("Đăng ký");
                dialog.setContentView(R.layout.customdialog);
                dialog.setCancelable(false);
                final EditText editTextUNDialog = (EditText) dialog.findViewById(R.id.editTextUNDialog);
                final EditText editTextPWDialog = (EditText) dialog.findViewById(R.id.editTextPWDialog);
                Button registerDialog = (Button) dialog.findViewById(R.id.RegisterDialog);
                Button cancelDialog = (Button) dialog.findViewById(R.id.CancelDialog);
                registerDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ten = editTextUNDialog.getText().toString().trim();
                        mk = editTextPWDialog.getText().toString().trim();
                        userb.setText(ten);
                        pWb.setText(mk);
                        dialog.cancel();
                    }
                });
                cancelDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userb.getText().length() != 0 && pWb.getText().length() != 0) {
                    if (userb.getText().toString().equals(ten) && pWb.getText().toString().equals(mk)) {
                        Toast.makeText(MainActivity.this, "Bạn đã đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(i);
                    }
                    else{
                        Toast.makeText(MainActivity.this,"Mật khẩu hoặc Username không đúng",Toast.LENGTH_SHORT).show();
                    }

                }
                else if(userb.getText().length()==0&&pWb.getText().length() != 0){
                    Toast.makeText(MainActivity.this,"Vui lòng điền Username",Toast.LENGTH_SHORT).show();
                }
                else if(userb.getText().length()!=0&&pWb.getText().length() == 0)
                {
                    Toast.makeText(MainActivity.this,"Vui lòng điền Password",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"Vui lòng điền Username và Password",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void Anhxa(){
        userb=(EditText)findViewById(R.id.UserBox);
        pWb=(EditText)findViewById(R.id.PWBox);
        login=(Button)findViewById(R.id.Login);
        register=(Button)findViewById(R.id.Register);
    }
}

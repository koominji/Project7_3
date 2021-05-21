package com.kmj.project7_3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView text1,text2;
    Button btn1;
    EditText dlgEdt1,dlgEdt2;
    TextView toastText;
    View dialogView, toastView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (TextView)findViewById(R.id.text1);
        text2 = (TextView)findViewById(R.id.text2);
        btn1 = (Button)findViewById(R.id.btn1);
        dlgEdt1 = (EditText)findViewById(R.id.dlgEdt1);
        dlgEdt2=(EditText)findViewById(R.id.dlgEdt2);
        toastText = (TextView)findViewById(R.id.toastText);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //layout > dialog1.xml 파일을 인플레이트하여 dialogView에 대입
                dialogView=(View) View.inflate(MainActivity.this,R.layout.dialog1,null);

                //AlertDialog.Builer 생성
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("사용자 정보 입력");
                dlg.setIcon(R.drawable.ic_launcher_background);
                dlg.setView(dialogView);

                //setPositiveButton(문자열, 리스너)메서드 만들기
                dlg.setPositiveButton("확인",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //사용자 이름(dlgEdit1), 이메일(dlgEdit2) 위젯을 변수에 대입
                                dlgEdt1 = (EditText)dialogView.findViewById(R.id.dlgEdt1);
                                dlgEdt2 = (EditText)dialogView.findViewById(R.id.dlgEdt2);

                                //사용자 이름(dlgEdit1), 이메일(dlgEdit2) 가져와 설정(tvName, tvEmail)하기
                                text1.setText(dlgEdt1.getText().toString());
                                text2.setText(dlgEdt2.getText().toString());
                            }
                        });

                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast toast = new Toast(MainActivity.this);

                        toastView = (View) View.inflate(MainActivity.this,R.layout.toast1,null);
                        toastText = (TextView) toastView.findViewById(R.id.toastText);
                        toastText.setText("취소했습니다");
                        toast.setView(toastView);
                        toast.show();;

                    }
                });
                dlg.show();
            }
        });
    }
}
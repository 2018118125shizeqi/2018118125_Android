package com.example.servicedemo;

        import com.example.servicedemo.BindService.LocalService;

        import android.os.Bundle;
        import android.os.IBinder;
        import android.app.Activity;
        import android.content.ComponentName;
        import android.content.Intent;
        import android.content.ServiceConnection;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.widget.Button;
        import android.widget.Toast;
/**
 * Describe:</br>
 * Service实例
 * 本实例简单实现了绑定Service并与之通信
 * @author JPH
 * Date:2014.07.21
 * */
public class ServiceDemo extends Activity {
    Button btnBind, btnUnBind, btnGetServiceStatus;
    BindService bindService;
    LocalService localService;
    private boolean isBind = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        btnBind = (Button) findViewById(R.id.btnBind);
        btnUnBind = (Button) findViewById(R.id.btnUnBind);
        btnGetServiceStatus = (Button) findViewById(R.id.btnGetServiceStatus);
        OnClickListener listener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                switch (v.getId()) {
                    case R.id.btnBind:
//					Intent intent=new Intent();
//					intent.setAction("com.jph.servicedemo.BIND_SERVICE"); //隐式启动Service
                        Intent intent = new Intent(ServiceDemo.this, BindService.class);//显示启动Service
                        //绑定指定的Service
                        bindService(intent, serviceConnection, BIND_AUTO_CREATE);
                        isBind = true;
                        break;
                    case R.id.btnUnBind:
                        if (isBind) {
                            //解除绑定Service
                            unbindService(serviceConnection);
                            isBind = false;
                            bindService = null;
                            Toast.makeText(ServiceDemo.this, "--Service is Unbind.--"
                                    , Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(ServiceDemo.this, "--你还未绑定Service--"
                                    , Toast.LENGTH_LONG).show();
                        }
                        break;
                    case R.id.btnGetServiceStatus:
                        if (bindService == null) {
                            Toast.makeText(ServiceDemo.this, "请先绑定Service"
                                    , Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(ServiceDemo.this, "App name:" +
                                    bindService.getDemoName() + "\n count:" +
                                    localService.getCount(), Toast.LENGTH_LONG).show();
                        }
                        break;
                }
            }
        };
        btnBind.setOnClickListener(listener);
        btnGetServiceStatus.setOnClickListener(listener);
        btnUnBind.setOnClickListener(listener);
    }

    //定义一个ServiceConnection对象
    private ServiceConnection serviceConnection = new ServiceConnection() {
        //当Activity与Service通过非UnBind()方法断开连接的时候回调该方法
        @Override
        public void onServiceDisconnected(ComponentName name) {
            // TODO Auto-generated method stub
            bindService = null;
            Toast.makeText(ServiceDemo.this, "--Service UnConnected.--"
                    , Toast.LENGTH_LONG).show();
        }

        //当Activity与Service连接成功的时候回调该方法
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            // TODO Auto-generated method stub
            //获取getService()方法返回的BindService对象
            localService = ((LocalService) service);
            bindService = localService.getService();
            Toast.makeText(ServiceDemo.this, "--Service Connected.--"
                    , Toast.LENGTH_LONG).show();
            System.out.println("--Service Connected.--");
        }
    };
}


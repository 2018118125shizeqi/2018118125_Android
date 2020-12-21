package com.example.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
/**
 * Describe:</br>
 * Service子类
 * BindService实现了Service并重写了父类的
 * onBind、onCreate、onDestroy、onUnbind
 * 以及onDestroy等方法。
 * 并在onCreate方法中创建并启动一个线程，动态修改count变量值,
 * 创建Binder的子类LocalService类，用于作为绑定该Service时，
 * 回调方法的返回对象。
 * @author JPH
 * Date:2014.07.21
 * */
public class BindService extends Service {
    private int count=0;
    private boolean	isQuit=false;
    //定义getService方法返回的对象
    public  LocalService localService=new LocalService();
    //创建Binder子类
    public class LocalService extends Binder{
        public int getCount() {
            return count;
        }
        public BindService getService() {
            return BindService.this;
        }
    }
    //Service子类必须实现的方法，绑定该Service时回调的方法
    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return localService;
    }
    //Service被创建是调用该方法
    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        System.out.println("Service is Created.");
        //创建并启动一个线程，动态修改count变量值
        new Thread(){
            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (!isQuit) {
                    try {
                        Thread.sleep(1000);//使得当前线程休眠1000毫秒
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    count++;
                }
            }
        }.start();
        super.onCreate();
    }
    //在所有onUnbind被回调之后调用
    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        System.out.println("Service is Destroyed.");
        isQuit=true;
        super.onDestroy();
    }
    //定义一个返回实例名的方法
    public String getDemoName() {
        return "Service实例";
    }
    //在所有与Service绑定的客户端都解除绑定之后被回调
    @Override
    public boolean onUnbind(Intent intent) {
        // TODO Auto-generated method stub
        System.out.println("Service is Unbind.");
        return true;//表示下次客户端绑定的时候接受一个onRebind()的调用（而不是调用 onBind()）
    }

}

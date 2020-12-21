import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {
    /**
     * 应用程序标记
     */
    private static final String TAG = "bind_unbind_service";
    /**
     * 服务连接对象
     */
    private ServiceConnection conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 利用布局资源文件设置用户界面
        setContentView(R.layout.activity_main);
    }

    /**
     * 绑定服务按钮单击事件处理方法
     *
     * @param view
     */
    public void doBindService(View view) {
        // 创建意图，显式指定要绑定的服务
        Intent intent = new Intent(MainActivity.this, CustomService.class);
        // 让意图携带数据
        intent.putExtra("message", "安卓开发真有趣~");
        // 创建服务连接对象
        conn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.d(TAG, "服务已经连接~");
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.d(TAG, "服务断开连接~");
            }
        };
        // 按意图绑定服务
        bindService(intent, conn, Service.BIND_AUTO_CREATE);
    }

    /**
     * 解绑服务按钮单击事件处理方法
     *
     * @param view
     */
    public void doUnbindService(View view) {
        // 判断是否建立了服务连接
        if (conn != null) {
            // 解绑服务
            unbindService(conn);
        }
    }

    /**
     * 销毁窗口时解绑服务
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 判断是否建立了服务连接
        if (conn != null) {
            // 解绑服务
            unbindService(conn);
        }
    }
}

package com.example.inter;

import org.jetbrains.annotations.NotNull;

public class IntentUtils {
    //从google搜索内容
    public static void searchGoogle(Context context, String searchString) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, "searchString");
        context.startActivity(intent);
    }

    //浏览网页
    public static void openUrl(Context context, String url) {
        Uri uri = Uri.parse(url);
        Intent it = new Intent(Intent.ACTION_VIEW, uri);
        context.startActivity(it);
    }

    //拨打电话
    //需要添加权限<uses-permission id=”android.permission.CALL_PHONE” >
    public static void tel(Context context, String telUrl) {
        Uri uri = Uri.parse(telUrl);//tel:xxxxxx
        Intent it = new Intent(Intent.ACTION_DIAL, uri);
        context.startActivity(it);
    }

    //调用发短信的程序
    public static void openMsgEdit(Context context) {
        Intent it = new Intent(Intent.ACTION_VIEW);
        it.putExtra("sms_body", "The SMS text");
        it.setType("vnd.android-dir/mms-sms");
        context.startActivity(it);
    }

    //发送短信
    //<uses-permission android:name="android.permission.SEND_SMS" />
    public static void sendMsg(Context context) {
        Uri uri = Uri.parse("smsto:0800000123");
        Intent it = new Intent(Intent.ACTION_SENDTO, uri);
        it.putExtra("sms_body", "The SMS text");
        context.startActivity(it);
    }

    //通话记录
    public static void callHistory(Context context) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL_BUTTON);
        context.startActivity(intent);
    }

    //到联系人界面
    public static void contactsList(Context context) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Contacts.People.CONTENT_URI);
        context.startActivity(intent);
    }

    //播放多媒体
    public static void startMedia(Context context) {
        Intent it = new Intent(Intent.ACTION_VIEW);
        Uri uri = Uri.parse("file:///sdcard/song.mp3");
        it.setDataAndType(uri, "audio/mp3");
        context.startActivity(it);

//        // 通过Intent安装APK文件
//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        intent.setDataAndType(Uri.parse("file://" + apkfile.toString()),
//                "application/vnd.android.package-archive");
//        context.startActivity(intent);
    }

    //卸载程序
    public static void unInstallFile(Context context) {
        Uri uri = Uri.parse("package:com.gameclient");
        Intent intent = new Intent(Intent.ACTION_DELETE, uri);
        context.startActivity(intent);
    }

    // 跳转系统的辅助功能界面
    public static void auxiliarySettings(Context context) {
        Intent intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
        context.startActivity(intent);
    }

    // 飞行模式，无线网和网络设置界面
    public static void internetModeSetting(Context context) {
        Intent intent = new Intent(Settings.ACTION_AIRPLANE_MODE_SETTINGS);
        context.startActivity(intent);
//        Intent intent =  new Intent(Settings.ACTION_WIFI_SETTINGS);
//        startActivity(intent);
    }

    // 根据包名跳转到系统自带的应用程序信息界面
    public static void appSetting(Context context) {
        Uri packageURI = Uri.parse("package:" + "com.tencent.WBlog");
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, packageURI);
        context.startActivity(intent);
    }
}
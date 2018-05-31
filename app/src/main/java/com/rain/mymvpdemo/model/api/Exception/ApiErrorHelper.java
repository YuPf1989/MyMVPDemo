package com.rain.mymvpdemo.model.api.Exception;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.a51ehealth.healthmanagement.activity.LoginActivity;
import com.a51ehealth.healthmanagement.db.UserInfoDao;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import org.json.JSONException;

import java.net.ConnectException;


/**
 * 统一错误的处理类
 *
 * http://www.jianshu.com/p/c105a4177982
 */

public class ApiErrorHelper {

    private static final String TAG  = ApiErrorHelper.class.getSimpleName();


    public static void handleCommonError(Context context, Throwable e) {

        if (e instanceof ConnectException) {    // 网络连接错误
            Toast.makeText(context, "网络连接异常！", Toast.LENGTH_SHORT).show();

        } else if (e instanceof JSONException) {    // gson数据转换错误

            Toast.makeText(context, "json数据异常！", Toast.LENGTH_SHORT).show();

        } else if (e instanceof ApiException) {     // 后台定义的错误
            // ApiException处理
            ApiException exception=(ApiException)e;

            if (exception.getErrorCode() == 8) {
                // 删除原有的用户信息
                SQLite.delete(UserInfoDao.class).execute();
                // 重新登录
                context.startActivity(new Intent(context, LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
            } else {
                Toast.makeText(context, "error_code:"+exception.getErrorCode()+";"+"msg:"+exception.getMessage(), Toast.LENGTH_SHORT).show();
            }

        } else {
//            Log.e(TAG,e.getMessage());
            Toast.makeText(context, "服务器开小差了！", Toast.LENGTH_SHORT).show();
        }
    }
}



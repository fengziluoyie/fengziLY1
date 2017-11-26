package com.fengziLY.FZtools;

import android.app.*;
import android.content.*;
import android.os.*;
import android.support.v4.view.*;
import android.view.*;
import android.widget.*;
import java.util.*;
import android.graphics.*;
import java.io.*;
import org.apache.http.util.*;

public class Logo extends Activity 
{
	public static Logo instance = null;
		public static int randownum,maxtextnum;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
		overridePendingTransition(R.anim.abc_slide_in_bottom,R.anim.abc_slide_out_bottom);
		
		if (Build.VERSION.SDK_INT >= 21)
			{
				View decorView = getWindow().getDecorView();
				int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
					| View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
				decorView.setSystemUiVisibility(option);
				getWindow().setStatusBarColor(Color.TRANSPARENT); //也可以设置成灰色透明的，比较符合Material Design的风格
			}
			
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logo);
		//设置无标题
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		//设置全屏
		//getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		instance=this;
		Timer timer=new Timer();
		//设置启动的时间
		timer.schedule(task, 2000);
		
		TextView logotext=(TextView) findViewById(R.id.logoText);
		String yijuh=assetsRead("YiJuHua.txt");
		String[] yijuhua=yijuh.split("[\\n]");
		
		for (int i = 0; i < yijuh.length(); i++)
			{
				if (yijuh.charAt(i) == '\n')
					{
						randownum++;
					}
			}
			maxtextnum=randownum;
		randownum=textRandom(randownum);
		logotext.setText(yijuhua[randownum]);
		
	}
		private String assetsRead(String fileName){
				//String fileName = "test/my_assets_test.txt";// assets下子目录文件
				String ret = "";
				try {
						InputStream is = getResources().getAssets().open(fileName);
						int len = is.available();
						byte []buffer = new byte[len];
						is.read(buffer);
						ret = EncodingUtils.getString(buffer, "utf-8");
						is.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				return ret;
			}
			
		private int textRandom(int max)
			{
				Random random=new Random(); 
				return random.nextInt(max);

			}
			
	//实例化
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		// TODO: Implement this method
		if(keyCode==KeyEvent.KEYCODE_BACK)
		{
			toast("别急~~~");
			return false;
		}
		
		return super.onKeyDown(keyCode,event);
	}
	
	TimerTask task=new TimerTask()
	{
        //开始运行
		@Override
		public void run()
		{
			//跳转界面
			Intent intent=new Intent(Logo.this, MainActivity.class);
			startActivity(intent);
		}
	};

public void toast (String msg)
{
	LayoutInflater inflater = getLayoutInflater();
	View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.llToast));
	TextView text = (TextView) layout.findViewById(R.id.tvTextToast);
	text.setText(msg);
	Toast toast = new Toast(getApplicationContext());
	//toast1.setGravity(Gravity.CENTER, 0, 0);
	toast.setDuration(Toast.LENGTH_SHORT);
	toast.setView(layout);
	toast.show();
}
	
}

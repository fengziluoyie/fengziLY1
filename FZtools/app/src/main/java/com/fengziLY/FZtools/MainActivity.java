package com.fengziLY.FZtools;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import java.util.*;
import android.content.*;
import android.util.*;
import java.io.*;
import org.apache.http.util.*;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {	
		overridePendingTransition(R.anim.abc_fade_in,R.anim.abc_fade_out);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);	

		TextView yijutext=(TextView) findViewById(R.id.main_yiju);
		String yijuh=assetsRead("YiJuHua.txt");
		String[] yiju_text=yijuh.split("[\\n]");
		/*
		int randownum=0;
		for (int i = 0; i < yijuh.length(); i++)
		{
				if (yijuh.charAt(i) == '\n')
					{
						randownum++;
					}
			}
			*/
		Logo.randownum=textRandom(Logo.maxtextnum);
		yijutext.setText(yiju_text[Logo.randownum]);
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
	
	public int getStatusBarHeight() {
		int result = 0;
		int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
		if (resourceId > 0) {
			result = getResources().getDimensionPixelSize(resourceId);
		}
		return result;
	}
		private int textRandom(int max)
			{
				Random random=new Random(); 
				return random.nextInt(max);

			}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		// TODO: Implement this method
		if(keyCode==KeyEvent.KEYCODE_BACK)
		{
			finish();
			overridePendingTransition(R.anim.abc_slide_in_bottom,R.anim.abc_slide_out_bottom);
			Timer stopr=new Timer();
			//设置启动的时间
			stopr.schedule(estop, 300);
			super.onStop ( );
			
			
		}
		return super.onKeyDown(keyCode, event);
	}
	
	
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
	public void vtoast (View v)
	{
		LayoutInflater inflater = getLayoutInflater();
		View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.llToast));
		TextView text = (TextView) layout.findViewById(R.id.tvTextToast);
		text.setText(" null~~~ ");
		
		Toast toast = new Toast(getApplicationContext());
		//toast1.setGravity(Gravity.CENTER, 0, 0);
		toast.setDuration(Toast.LENGTH_SHORT);
		toast.setView(layout);
		toast.show();
	}
	public void yiju_ot(View v)
	{
		
	}
	public void Click_tools (View v)
	{
		Intent intent=new Intent(MainActivity.this, Tools.class);
		startActivity(intent);
	}
	public void exit(View v)
	{
		finish();
		overridePendingTransition(R.anim.abc_slide_in_bottom,R.anim.abc_slide_out_bottom);
		
		Timer stopr=new Timer();
		//设置启动的时间
		stopr.schedule(estop, 300);
		super.onStop ( );
		
		
	}
		TimerTask estop=new TimerTask()
			{
				//开始运行
				@Override
				public void run()
					{
						System.exit(0);
					}
			};
		
}

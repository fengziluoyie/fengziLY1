package com.fengziLY.FZtools;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import java.util.*;
import android.content.*;

public class Tools extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
		overridePendingTransition(R.anim.abc_slide_in_bottom,R.anim.abc_slide_out_bottom);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tools);
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		// TODO: Implement this method
		if(keyCode==KeyEvent.KEYCODE_BACK)
		{
			finish();
			overridePendingTransition(R.anim.abc_slide_in_bottom,R.anim.abc_slide_out_bottom);
		}
		return super.onKeyDown(keyCode, event);
	}
	public void 判断勾股数(View v)
	{
		Intent intent=new Intent(Tools.this, PanDuanGGS.class);
		startActivity(intent);
	}
	public void 进制转换(View v)
	{
		Intent intent=new Intent(Tools.this, JinZhiZH.class);
		startActivity(intent);
	}
}

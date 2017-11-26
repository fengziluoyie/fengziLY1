package com.fengziLY.FZtools;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import java.util.*;
import java.io.*;

public class PanDuanGGS extends Activity 
	{
		@Override
		protected void onCreate ( Bundle savedInstanceState )
			{
				overridePendingTransition ( R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_bottom );
				super.onCreate ( savedInstanceState );
				setContentView ( R.layout.panduanggs );
				getWindow ( ).setSoftInputMode ( WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN );
				
			}
		
		@Override
		public boolean onKeyDown ( int keyCode, KeyEvent event )
			{
				// TODO: Implement this method
				if ( keyCode == KeyEvent.KEYCODE_BACK )
					{
						finish ( );
						overridePendingTransition ( R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_bottom );
					}
					
				return super.onKeyDown ( keyCode, event );
			}
		public void 按键 ( View v )
			{
				switch ( v.getId ( ) )
					{
						case R.id.key_1:
							keyon ( 8 );
							break;
						case R.id.key_0:
							keyon ( 7 );
							break;
						case R.id.key_2:
							keyon ( 9 ); 
							break;
						case R.id.key_3:
							keyon ( 10 );
							break;
						case R.id.key_4:
							keyon ( 11 );
							break;
						case R.id.key_5:
							keyon ( 12 );
							break;
						case R.id.key_6:
							keyon ( 13 );
							break;
						case R.id.key_7:
							keyon ( 14 );
							break;
						case R.id.key_8:
							keyon ( 15 );
							break;
						case R.id.key_9:
							keyon ( 16 );
							break;
						case R.id.clear:
							clrall();
							break;
						case R.id.deng:
							jieguo();
							break;
					}

			}
			
			public void jieguo()
			{
				
					TextView jieguo=(TextView) findViewById(R.id.ggs_jieguo);
					EditText ggs_s=(EditText) findViewById ( R.id.ggs_s );
					EditText ggs_m=(EditText) findViewById ( R.id.ggs_m );
					EditText ggs_l=(EditText) findViewById ( R.id.ggs_l );
					String ggss=ggs_s.getText().toString();
					String ggsm=ggs_m.getText().toString();
					String ggsl=ggs_l.getText().toString();
					
					int sggs = strtoint(ggss,0);
					int mggs = strtoint(ggsm,0);
					int lggs = strtoint(ggsl,0);
					
					
					if(sggs==0 || mggs== 0 || lggs==0)
					{
							toast("请在上面三个编辑框中输入正确的数字!!");
					}
						else if(ggss!=""&&ggsm!=""&&ggsl!="")
					{
						
						if(sggs*sggs+mggs*mggs==lggs*lggs)
						{
							jieguo.setText("此数乃勾股数!");
							jieguo.setTextColor(this.getResources().getColor(R.color.ggs_jieguo_true));
						}
						else if(sggs<1 || mggs<1 || lggs<1)
						{
							toast("请正确输入!");
							clrall();
						}
						else
						{
							jieguo.setText("此数非勾股数!");
							jieguo.setTextColor(this.getResources().getColor(R.color.ggs_jieguo_false));
						}
					}
					
			}
		public static int strtoint(String value, int defaultValue) { 
				try { 
						return Integer.valueOf(value); 
					} catch (Exception e) { 
						return defaultValue; 
					} 
			} 
			public void clrall()
			{
					final EditText ggs_s=(EditText) findViewById ( R.id.ggs_s );
					final EditText ggs_m=(EditText) findViewById ( R.id.ggs_m );
					final EditText ggs_l=(EditText) findViewById ( R.id.ggs_l );
					ggs_s.setText("");
					ggs_m.setText("");
					ggs_l.setText("");
			}
		public void toast (String msg)
			{
				LayoutInflater inflater = getLayoutInflater();
				View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.llToast));
				TextView text = (TextView) layout.findViewById(R.id.tvTextToast);
				text.setText(msg);
				Toast toast = new Toast(getApplicationContext());
				toast.setGravity(Gravity.CENTER, 0, 0);
				toast.setDuration(Toast.LENGTH_SHORT);
				toast.setView(layout);
				toast.show();
			}
		public static void keyon(final int KeyCode) {
				new Thread() {     //不可在主线程中调用
						public void run() {
								try {
										Instrumentation inst = new Instrumentation();
										inst.sendKeyDownUpSync(KeyCode);
									} catch (Exception e) {
										e.printStackTrace();
									}
							}

					}.start();
			}
	}

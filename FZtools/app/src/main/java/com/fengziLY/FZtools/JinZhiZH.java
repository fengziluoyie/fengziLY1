package com.fengziLY.FZtools;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import java.util.*;
public class JinZhiZH extends Activity 
{
		@Override
		protected void onCreate ( Bundle savedInstanceState )
		{
			overridePendingTransition ( R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_bottom );
			super.onCreate ( savedInstanceState );
			setContentView ( R.layout.jinzhizh );
			
		}

}

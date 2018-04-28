qhLibrary
============

[![](https://jitpack.io/v/qiuh1016/qhLibrary.svg)](https://jitpack.io/#qiuh1016/qhLibrary)

<!-- ![](pic.png =100*80) -->

<img src="pic.png" width="540" height="380">

Install
------------

Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

    allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}

Step 2. Add the dependency

	dependencies {
	        compile 'com.github.qiuh1016:qhLibrary:1.3.2'
	}



Usage-Dialog
--------------

        QHDialog qhDialog = new QHDialog(this,"Title", "Message");
        qhDialog.setPositiveButton("ok", 0, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                Toast.makeText(MainActivity.this, "toast", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        qhDialog.setNegativeButton("cancel", 0, null);
        qhDialog.show();

If there's only one button and no clickListener:

        QHDialog qhDialog = new QHDialog(this,"Title", "Message");
        qhDialog.setOnlyOneButtonText("OK");
        qhDialog.show();


If you need one EditText：
        
        qhDialog.setEditText("hint text");

and to get the String：

        qhDialog.getEditTextText();

Usage-TitleView
--------------
color：

        <color name="QHTitleColor">#0FA474</color>
xml：
        
        <com.qiuhong.qhlibrary.QHTitleView.QHTitleView
            android:id="@+id/main_QHTitleView"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"/>

Activity：

        qhTitleView = (QHTitleView) findViewById(R.id.main_QHTitleView);
        qhTitleView.setTitle("main");
        qhTitleView.setBackView(0);
        qhTitleView.setRightView(0);
        qhTitleView.setClickCallback(new QHTitleView.ClickCallback() {
            @Override
            public void onBackClick() {
                //
            }
            
            @Override
            public void onRightClick() {
                //
            }
        });

Usage-QHTabBarActivity
--------------
First: 
    make your Activity extends QHTabBarActivity
    
Then:

    @Override
    protected String[] initTabText() {
        return new String[] {"SOS", "位置", "消息", "好友"};
    }

    @Override
    protected int[] initTabNormalImages() {
        return new int[] {
                R.mipmap.tab_icon_chat_normal,
                R.mipmap.tab_icon_chat_normal,
                R.mipmap.tab_icon_chat_normal,
                R.mipmap.tab_icon_chat_normal,
                R.mipmap.tab_icon_chat_normal
        };
    }

    @Override
    protected int[] initTabFocusImages() {
        return new int[] {
                R.mipmap.tab_icon_chat_focus,
                R.mipmap.tab_icon_chat_focus,
                R.mipmap.tab_icon_chat_focus,
                R.mipmap.tab_icon_chat_focus,
                R.mipmap.tab_icon_chat_focus,
        };
    }

    @Override
    protected boolean setScrollEnable() {
        return true;
    }

    @Override
    protected List<Fragment> initFragments() {
        List<Fragment>  fragments = new ArrayList<>();
        fragments.add(BlankFragment.newInstance(1));
        fragments.add(BlankFragment.newInstance(2));
        fragments.add(BlankFragment.newInstance(3));
        fragments.add(BlankFragment.newInstance(4));
        return fragments;
    }


Contact me
-------------
E-mail: qiuh1016@126.com
QQ: 276655503
WeChat: qiuh1016

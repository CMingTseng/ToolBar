#ToolBar

![image](https://github.com/diamondlin2016/ToolBar/blob/master/toolbar.gif)


##简介

Android 3.0之后，Google引入了ActionBar，想统一安卓应用的导航栏样式。但由于ActionBar难以定制，很大程度上限制了开发人员，比如标题文字大小、间距等不易实现个性化，很多开发者放弃了ActionBar的使用，而是使用普通的ViewGroup来封装自己的App Bar，或者使用JakeWharton大神的ActionBarSherlock库。
后来，自2014年Google I/O 上Material Design横空出世后，市场上的应用又逐步趋向了样式的风格统一，support library中很快就出来了Toolbar控件，一个定制化的ViewGroup，来完善ActionBar的使用，App Bar又迎来了春天。

##基本使用

**第一步：在 Theme 中隐藏现有的 ActionBar**

	使用这两个属性隐藏
	<style name="AppTheme.Base" parent="Theme.AppCompat">
	<item name="windowActionBar">false</item>
	<item name="android:windowNoTitle">true</item>
	......
	</style>
	
	或者继承 NoActionBar
	<style name="AppTheme.Base" parent="heme.AppCompat.Light.NoActionBar">
	......
	</style>
	
**第二步，在布局中添加v7包中的Toolbar控件**

⚠️（注意在builde.gradle文件中添加support.v7包的依赖：compile ‘com.android.support:appcompat-v7:24.2.1’
	
	<android.support.v7.widget.Toolbar
    	xmlns:app="http://schemas.android.com/apk/res-auto"
    	android:id="@+id/tb_toolbar"
    	android:layout_width="match_parent"
    	android:layout_height="?attr/actionBarSize"
    	app:title="@string/app_name"
    	app:titleTextColor="@android:color/white"
    	android:background="@color/colorPrimary">

	</android.support.v7.widget.Toolbar>

**第三步，在Activity代码中使用Toolbar对象替换ActionBar：**

	Toolbar mToolbarTb = (Toolbar) findViewById(R.id.tb_toolbar);
	//setSupportActionBar(mToolbarTb);//替换 actionBar 才需要

##ToolBar元素
![image](http://ac-myg6wstv.clouddn.com/85e3cb51a7a3d1f97d1c.jpg)

从左到右，依次是：

* 导航按钮
* logo
* 标题与子标题
* 自定义的view（Toolbar本身继承自ViewGroup）
* Action Menu

##ToolBar方法详解

* navigationIcon：设置Navigation Button的图标。
* logo：设置出现在Toolbar开始位置的logo（位于Navigation Button之后）。
* title、subtitle：设置Toolbar的title、subtitle。
* titleTextAppearance subtitleTextAppearance：设置title和subtitle的文字样式。
* titleTextColor subtitleTextColor：设置title和subtitle的文字颜色。
* titleMargin titleMarginStart titleMarginEnd titleMarginTop titleMarginBottom：设置title的Margin，如果同时设置titleMargin和titleMarginStart(End,Top,Bottom)，则优先取后面的属性值。对应方法：getTitleMargin()、getTitleMargin()、getTitleMargin()、getTitleMargin()、getTitleMargin()获取相应的Margin值。
* contentInsetLeft、contentInsetRight、contentInsetStart、contentInsetEnd：Toolbar的左右两侧都是默认有16dp的padding的，如果你需要让Toolbar上的内容与左右两侧的距离有变化，便可以通过以上四个属性来进行相应的设置。
比如要让内容紧贴左侧或起始侧便可以将contentInsetLeft或contentInsetStart设为0。

对应方法：setContentInsetsRelative(int,int)——对应start和end
setContentInsetsAbsolute(int,int)——对应left和right

* contentInsetStartWithNavigation：同样的，如果该Toolbar有Navigation button的话，同样也默认有16dp的距离。如果你希望navigation button右侧的内容与button之间的距离有变化，便可以通过该属性来进行相应的设置。

对应方法：setContentInsetStartWithNavigation(int)

* contentInsetEndWithActions：详情见上。该属性是设置Action菜单与其左侧内容的距离的，默认为16dp。

对应方法：setContentInsetEndWithActions(int) 

* popupTheme：设置Toolbar上弹出菜单的Theme


##Fragment中使用

与Activity中使用Toolbar有所不同。替换ActionBar时，需要给setSupportActionBar方法添加作用对象：

	((AppCompatActivity)getActivity()).setSupportActionBar((Toolbar) mContentView.findViewById(R.id.tb_toolbar));

##标题居中

Toolbar就是一个定制化的ViewGroup，所以可以在Toolbar里面放置一个TextView控件作为居中的标题来使用，再将Toolbar的Title隐藏起来即可实现Toolbar标题居中的效果。

	<android.support.v7.widget.Toolbar
    	xmlns:app="http://schemas.android.com/apk/res-auto"
    	android:id="@+id/tb_toolbar"
    	android:layout_width="match_parent"
    	android:layout_height="?attr/actionBarSize"
    	app:popupTheme="@style/OverFlowMenuTheme"
    	app:theme="@style/ThemeOverlay.AppCompat.Dark.ActionBar"
    	android:background="@color/colorPrimary">

    	<TextView
    	    android:layout_width="wrap_content"
        	android:layout_height="wrap_content"
        	android:layout_gravity="center"
        	android:text="SecondActivity"
        	style="@style/TextAppearance.AppCompat.Widget.ActionBar.Title"/>

	</android.support.v7.widget.Toolbar>

这里给TextView设置了style属性，与ActionBar.Title保持一致，然后还需要去除Toolbar自有的Title，在布局中使用app:title=""是不会起作用的，会显示ActionBar的标题，所以在代码中隐藏ActionBar的标题即可：

	getSupportActionBar().setDisplayShowTitleEnabled(false);
	
	
	
##踩坑

ToolBar 节点上的属性无效

		android:navigationIcon="@mipmap/abc_ic_ab_back_mtrl_am_alpha"
        android:subtitle="456"
        android:title="123"

解决： 把所有用 android:xxx 设置无效的，都用 toolbar：xxx 设置即可生效。








# AIDLDemo
AIDL的小demo

app是服务service端

clientapp是客户端，客户端启动service里面的服务，然后通过AIDL进行传值

重点：service的适配：
clientapp是客户端里面添加：

    <queries>
        <package android:name="com.hunter.aidldemo" />
        <intent>
            <action android:name="com.hunter.aidldemo.AidlService" />
        </intent>
    </queries>


service服务端：
        <service android:name=".AidlService"
            android:exported="true"
            android:enabled="true">
            <intent-filter>
                <action android:name="com.hunter.aidldemo.AidlService"/>
                <category android:name="android.intent.category.DEFAULT" />
            </intent-filter>
        </service>

推荐好文：
https://blog.csdn.net/xianrenli38/article/details/128186973
# react-native-get-channel
React Native bridging library for android to get app channel

## install

```
npm install react-native-get-channel --save
```

## Android

### Automatic

```
react-native link react-native-get-channel
```

### Manually

* android/settings.gradle

```
include ':react-native-get-channel'
project(':react-native-get-channel').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-get-channel/android')
```

* android/app/build.gradle

```
dependencies {
    compile project(':react-native-get-channel')
}
```

* register module (in MainActivity.java)

```java
...

import com.superhao.react_native_get_channel.GetChannelPackage; // <--- IMPORT

public class MainActivity extends ReactActivity {

    ...

    @Override
    protected List<ReactPackage> getPackages() {
        return Arrays.<ReactPackage>asList(
            new MainReactPackage(),
            new GetChannelPackage() // <--- ADD HERE
        );
    }
    
    ...

```

## General Usage

* Add channel information into AndroidManifest.xml
```xml
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.ownmoduletest">
    ...
    <application
      ...
      <meta-data android:name="JPUSH_APPKEY" android:value="12.324"/> // <--- ADD HERE
      ...
    </application>
    ...
</manifest>

```

```javascript
import {getAppMetaData} from 'react-native-get-channel';
```

```javascript
  _getChannel = ()=> {
    getAppMetaData('JPUSH_APPKEY').then((data)=>{
      alert(data);
    }).catch((error)=>{
      alert('获取失败');
    });
  }

```

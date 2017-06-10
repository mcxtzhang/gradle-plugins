package com.mcxtzhang.plugins.jiagu

/**
 * Intro: 
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/6/9.
 * History:
 */
class JiaguExtension {
    String javaPath//360包里的java的全路径
    //"C:\\Users\\Administrator\\Desktop\\360jiagubao_windows_64\\jiagu\\java\\bin\\java.exe"
    String jiaguJarPath //360包里的jiagu.jar的全路径
    // "C:\\Users\\Administrator\\Desktop\\360jiagubao_windows_64\\jiagu\\jiagu.jar"

    String account//360账号
    String password//密码

    String keystorePath//签名的全路径
    //"E:\\abc.keystore"
    String keystorePassword//签名密码
    String alias//签名别名
    String aliasPassword//别名密码

    String srcApkPath//代加固的包的全路径
    String outApkPath//加固、zip优化、签名后的包的全路径

    //zip优化 签名用
    String zipalignPath//zipalign的全路径
    //"C:\\Users\\Administrator\\Desktop\\Anlaiye.apk"
    String apksignerPath//apksignerd 的全路径
    //project.rootDir.absolutePath+"\\app\\build\\outputs\\360_jiagued_ziped_signed.apk"

/*    String srcUnzipedUnsignedApk
    String outputApk*/


}

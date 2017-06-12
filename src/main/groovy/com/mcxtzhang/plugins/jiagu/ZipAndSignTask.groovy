package com.mcxtzhang.plugins.jiagu

import com.mcxtzhang.plugins.GroovyUtils
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * Intro: 
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/6/10.
 * History:
 */
class ZipAndSignTask extends DefaultTask {
    @TaskAction
    def zipAndSign() {
        String zipalignPath = project.Jiagu.zipalignPath
        //"C:\\Users\\Administrator\\AppData\\Local\\Android\\sdk1\\build-tools\\25.0.2\\zipalign"
        String srcUnzipedUnsignedApk = project.rootDir.absolutePath + "/temp360/temp.apk"
//project.Jiagu.srcUnzipedUnsignedApk
        //"C:\\Users\\Administrator\\Desktop\\Anlaiye.apk"
        String outApkPath = project.Jiagu.outApkPath
        //project.rootDir.absolutePath + "\\app\\build\\outputs\\360_signed.apk"
        String apksignerPath = project.Jiagu.apksignerPath
        //"C:\\Users\\Administrator\\AppData\\Local\\Android\\sdk1\\build-tools\\25.0.2\\apksigner.bat"

        String keystorePath = project.Jiagu.keystorePath
        //"E:\\ChongGou3\\anlaiye\\Android_Aly\\abc.keystore"
        String keystorePassword = project.Jiagu.keystorePassword

        //zip优化
        println 'zxt begin ziped.....................'
        project.exec {
            commandLine zipalignPath, "-v", "4", srcUnzipedUnsignedApk, outApkPath
        }
        //签名
        println 'zxt begin signed.....................'
        //println "aaA:"+stopTomcat.output()
        String result = "$apksignerPath sign --ks $keystorePath  --ks-pass pass:$keystorePassword $outApkPath".execute(null, project.rootDir).text.trim()
        GroovyUtils.deleteDir(project.rootDir.absolutePath + "/temp360/")
        println "result+$result"


    }
}

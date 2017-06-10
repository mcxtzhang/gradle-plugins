package com.mcxtzhang.plugins.jiagu

import groovy.io.FileType
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * Intro: 
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/6/9.
 * History:
 */
class Jiagu360Task extends DefaultTask {
    @TaskAction
    def jiagu() {
        String javaPath = project.Jiagu.javaPath
        //"C:\\Users\\admin\\Desktop\\360jiagubao_windows_64\\jiagu\\java\\bin\\java.exe"
        String jiaguJarPath = project.Jiagu.jiaguJarPath
        //"C:\\Users\\admin\\Desktop\\360jiagubao_windows_64\\jiagu\\jiagu.jar"

        String account = project.Jiagu.account
        String password = project.Jiagu.password

/*        String keystorePath = project.Jiagu.keystorePath
        //"E:\\ChongGou3\\anlaiye\\Android_Aly\\anlaiye.keystore"
        String keystorePassword = project.Jiagu.keystorePassword//"anlaiye123465"
        String alias = project.Jiagu.alias//"anlaiye"
        String aliasPassword = project.Jiagu.aliasPassword//"anlaiye123465"*/

        String srcApkPath = project.Jiagu.srcApkPath
        //"E:\\ChongGou3\\anlaiye\\Android_Aly\\app\\build\\outputs\\apk\\app-release.apk"
/*        String outApkPath = project.Jiagu.outApkPath
        //"E:\\ChongGou3\\anlaiye\\Android_Aly\\app\\build\\outputs\\apk\\jiagued\\"*/

        //登录
        project.exec {
            commandLine javaPath, "-jar", jiaguJarPath, "-login", account, password
        }
        //记录签名
/*        project.exec {
            commandLine javaPath, "-jar", jiaguJarPath, "-importsign", keystorePath, keystorePassword, alias, aliasPassword
        }*/
        //配置
        project.exec {
            commandLine javaPath, "-jar", jiaguJarPath, "-config", "-"
        }
        //1 创建目录
        String tempDirPath = project.rootDir.absolutePath + "/temp360/";
        File dir = new File(tempDirPath)
        if (!dir.exists()) {
            dir.mkdirs()
        }
        //加固 (2 将360加固后apk放入该目录)
        project.exec {
            commandLine javaPath, "-jar", jiaguJarPath, "-jiagu", srcApkPath, tempDirPath, "-autosign"
        }

        //3 从该目录取出apk，重命名
        dir.traverse(type: FileType.FILES,
                nameFilter: ~/.*\.apk/
        ) {
            println it
            String newFilePath = tempDirPath
            String newFilename = "temp.apk"
            it.renameTo(newFilePath + newFilename)
        }
        //4 删除目录
/*        if (dir.exists()) {
            dir.delete()
        }*/
    }
}

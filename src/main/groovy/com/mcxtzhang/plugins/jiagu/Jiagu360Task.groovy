package com.mcxtzhang.plugins.jiagu

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
        String java = "C:\\Users\\admin\\Desktop\\360jiagubao_windows_64\\jiagu\\java\\bin\\java.exe"
        String jiaguJar = "C:\\Users\\admin\\Desktop\\360jiagubao_windows_64\\jiagu\\jiagu.jar"

        String account = "13938422051"
        String password = "q0q0q0"

        String keystorePath = "E:\\ChongGou3\\anlaiye\\Android_Aly\\anlaiye.keystore"
        String keystorePassword = "anlaiye123465"
        String alias = "anlaiye"
        String aliasPassword = "anlaiye123465"

        String srcApkPath = "E:\\ChongGou3\\anlaiye\\Android_Aly\\app\\build\\outputs\\apk\\app-release.apk"
        String outApkPath = "E:\\ChongGou3\\anlaiye\\Android_Aly\\app\\build\\outputs\\apk\\jiagued\\"

        project.exec {
            commandLine java, "-jar", jiaguJar, "-login", account, password
        }
        project.exec {
            commandLine java, "-jar", jiaguJar, "-importsign", keystorePath, keystorePassword, alias, aliasPassword
        }
        project.exec {
            commandLine java, "-jar", jiaguJar, "-config", "-"
        }
        project.exec {
            commandLine java, "-jar", jiaguJar, "-jiagu", srcApkPath, outApkPath
        }
    }
}

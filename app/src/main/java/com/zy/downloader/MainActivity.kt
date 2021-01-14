package com.zy.downloader

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.functions.Consumer
import rxhttp.RxHttp

class MainActivity : AppCompatActivity() {
    private val downloadUrl = arrayOf(
        "https://imtt.dd.qq.com/16891/apk/B1BEC9C0F55FAC27DF930B5EE6F11DEC.apk",  //喵播
        "https://imtt.dd.qq.com/16891/apk/67D754B22B42B8750E04769E5156A205.apk",  //探探
        "https://imtt.dd.qq.com/16891/apk/28984FDA5E0AEB2B50FBC972A4739432.apk"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val path = getExternalFilesDir("apk")?.absolutePath
        downloadUrl.forEach {
            Downloader.addTask(
                DownloadTaskEntity(url = it, localPath = "$path/${it}.apk")
            )
        }

    }
}
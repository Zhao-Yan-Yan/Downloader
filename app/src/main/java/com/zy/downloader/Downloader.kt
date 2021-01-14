package com.zy.downloader

import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers

import rxhttp.RxHttp
import rxhttp.wrapper.entity.Progress
import java.io.File


object Downloader {
    val data by lazy { MutableLiveData<MutableList<DownloadTaskEntity>>() }

    fun addTask(task: DownloadTaskEntity) {
        val file = File(task.localPath)
        file.length()
        //task.totalSize == file.length()
        //与本地文件 length对比 最好md5比较

        RxHttp.get(task.url)
            .asAppendDownload(
                task.localPath, AndroidSchedulers.mainThread()
            ) { progress: Progress ->
                task.progress = progress.progress
                task.currentSize = progress.currentSize
                task.totalSize = progress.totalSize
            }
            .subscribe({
                task.state = DownloadTaskEntity.DownloadState.COMPLETED
            }, {
                task.state = DownloadTaskEntity.DownloadState.FAIL
            })
    }
}
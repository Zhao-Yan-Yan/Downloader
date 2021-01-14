package com.zy.downloader

data class DownloadTaskEntity(
    var url: String,
    var localPath: String,
    var progress: Int = 0,
    var totalSize: Long = 0,
    var currentSize: Long = 0,
    var state: DownloadState = DownloadState.IDLE
) {
    enum class DownloadState {
        IDLE,
        WAITING,
        DOWNLOADING,
        PAUSE,
        COMPLETED,
        FAIL,
        CANCEL;
    }
}
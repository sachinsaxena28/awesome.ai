package com.doubtnut.awesomeai.socket

interface SocketService {

    fun connect()

    fun disconnect()

    fun send(message: String)
}
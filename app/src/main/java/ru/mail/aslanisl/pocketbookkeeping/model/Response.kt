package ru.mail.aslanisl.pocketbookkeeping.model

import android.support.annotation.Nullable


class Response <T> (
        val status: Status,
        val data: T?,
        val error: Throwable?
){
    companion object {
        fun <T> success (data: T) : Response<T>{
            return Response(Status.SUCCESS, data, null)
        }

        fun <T> error (error: Throwable?) : Response<T>{
            return Response(Status.ERROR, null, error)
        }
    }
}
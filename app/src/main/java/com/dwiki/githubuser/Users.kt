package com.dwiki.githubuser

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Users(
    var username:String,
    var nama:String,
    var location:String,
    var repository:String,
    var company:String,
    var followers:String,
    var following:String,
    var avatar:Int
):Parcelable
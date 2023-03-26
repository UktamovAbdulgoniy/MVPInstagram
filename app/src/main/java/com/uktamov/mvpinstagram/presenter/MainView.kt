package com.uktamov.mvpinstagram.presenter

import com.uktamov.mvpinstagram.model.Data
import com.uktamov.mvpinstagram.model.UserResponse


interface MainView {
    fun onUserListSuccess(data: UserResponse)
    fun onUserListFailure(error: String)
}

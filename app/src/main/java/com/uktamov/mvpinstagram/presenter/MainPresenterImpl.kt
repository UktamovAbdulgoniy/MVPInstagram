package com.uktamov.mvpinstagram.presenter

import com.uktamov.mvpinstagram.model.Data
import com.uktamov.mvpinstagram.model.UserResponse
import com.uktamov.mvpinstagram.network.RetroInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenterImpl(private val mainView: MainView):MainPresenter {

    override fun getAllUserList() {
        RetroInstance.apiService().getUsers().enqueue(object : Callback<UserResponse>{
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                mainView.onUserListSuccess(response.body()!!)
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                mainView.onUserListFailure(t.message!!)
            }
        })
    }
}
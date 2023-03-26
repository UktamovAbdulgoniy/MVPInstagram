package com.uktamov.mvpinstagram.network

import com.uktamov.mvpinstagram.model.Data
import com.uktamov.mvpinstagram.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/api/users")
    fun getUsers(): Call<UserResponse>
}
package com.friendsapp.github.network

import com.friendsapp.github.network.model.NetworkUserListItem
import retrofit2.Response
import retrofit2.http.GET

interface UserListService {

    //https://api.github.com/repos/square/retrofit/stargazers
    //@GET("/repos/square/retrofit/stargazers")
    @GET("?results=10")
    suspend fun getUserList(): Response<NetworkUserListItem>
}
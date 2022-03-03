package com.friendsapp.github.domain

data class UserListItem(
    val id: Int,
    val avatar: String,
    val username: String,
    val city: String,
    val state: String,
    val country: String,
    val email: String,
    val cellPhone: String,
    val largeAvatar: String
)
package com.friendsapp.github.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.friendsapp.github.domain.UserDetails
import com.friendsapp.github.domain.UserListItem

@Entity
data class DatabaseUserListItem constructor(
    @PrimaryKey
    val id: Int,
    val avatar: String,
    val username: String,
    val city: String,
    val state: String,
    val country: String,
    val email: String,
    val cellPhone: String,
    val largeAvatar : String

)

fun List<DatabaseUserListItem>.asDomainModel(): List<UserListItem> {
    return map {
        UserListItem(
            id = it.id,
            avatar = it.avatar,
            username = it.username,
            city = it.city,
            state = it.state,
            country = it.country,
            email = it.email,
            cellPhone = it.cellPhone,
            largeAvatar = it.largeAvatar
        )
    }
}

fun DatabaseUserListItem.asDomainModel(): UserDetails {
    return UserDetails(
        //id = id,
        avatar = largeAvatar,
        username = username,
        city = city,
        state = state,
        country = country,
        email = email,
        cellPhone = cellPhone
    )
}
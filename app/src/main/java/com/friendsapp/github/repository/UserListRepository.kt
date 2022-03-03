package com.friendsapp.github.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.friendsapp.github.database.DatabaseUserListItem
import com.friendsapp.github.database.UsersDatabase
import com.friendsapp.github.database.asDomainModel
import com.friendsapp.github.domain.UserListItem
import com.friendsapp.github.network.UserListService

import timber.log.Timber
import java.util.ArrayList
import javax.inject.Inject

class UserListRepository @Inject constructor(
    private val userListService: UserListService,
    private val database: UsersDatabase
) {
    var itemsArray: ArrayList<DatabaseUserListItem> = ArrayList()
    val users: LiveData<List<UserListItem>> =
        Transformations.map(database.usersDao.getDatabaseUsers()) {
            it.asDomainModel()
        }

    suspend fun refreshUserList() {
        try {

            val users = userListService.getUserList()
            if (users.isSuccessful) {
                val items = users.body()?.result
                if (items != null) {
                    for (i in 0 until items.count()) {
                        // ID
                        val id = i

                        // Avatar
                        val avatar = items[i].picture.thumb ?: "N/A"
                        Log.d("Avatar: ", avatar)

                        // UserName
                        val firstName = items[i].name.first?: "N/A"
                        val lastName = items[i].name.last?: "N/A"
                        val userName = firstName + "" + lastName

                        val city = items[i].location.city?: "N/A"
                        val state = items[i].location.state?: "N/A"
                        val country = items[i].location.country?: "N/A"

                        val email = items[i].email?: "N/A"
                        val cellPhone = items[i].cell?: "N/A"


                        val model =
                        DatabaseUserListItem(
                            id,
                            avatar,
                            userName,
                            city,
                            state,
                            country,
                            email,
                            cellPhone
                        )

                        itemsArray.add(model)

                    }
                }
                database.usersDao.insertAll(itemsArray)
            }
        } catch (e: Exception) {
            Timber.w(e)
        }
    }
}
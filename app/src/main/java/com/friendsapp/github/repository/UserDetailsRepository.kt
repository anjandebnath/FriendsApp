package com.friendsapp.github.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.friendsapp.github.database.UsersDatabase
import com.friendsapp.github.database.asDomainModel
import com.friendsapp.github.domain.UserDetails
import javax.inject.Inject

class UserDetailsRepository @Inject constructor(
    private val database: UsersDatabase
) {

    fun getUserDetails(userId: Int): LiveData<UserDetails> {
        return Transformations.map(database.usersDao.getUserDetails(userId)) {
            it?.asDomainModel()
        }
    }


}
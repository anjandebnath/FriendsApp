package com.friendsapp.github.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UsersDao {

    // user List
    @Query("select * from DatabaseUserListItem")
    fun getDatabaseUsers(): LiveData<List<DatabaseUserListItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: List<DatabaseUserListItem>)

    // single user
    @Query("select * from DatabaseUserListItem WHERE id LIKE :userId")
    fun getUserDetails(userId: Int): LiveData<DatabaseUserListItem>


}

@Database(entities = [DatabaseUserListItem::class], version = 1)
abstract class UsersDatabase : RoomDatabase() {
    abstract val usersDao: UsersDao
}
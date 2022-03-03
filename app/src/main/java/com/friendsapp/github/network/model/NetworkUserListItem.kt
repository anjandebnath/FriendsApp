package com.friendsapp.github.network.model




import com.friendsapp.github.database.DatabaseUserListItem
import com.google.gson.annotations.SerializedName


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import retrofit2.Response

data class NetworkUserListItem(
    @SerializedName("results")
    val result: List<Result>
)


data class Result(

    @SerializedName("name")
    val name: Name,
    @SerializedName("location")
    val location: Location,
    @SerializedName("email")
    val email: String,
    @SerializedName("picture")
    val picture : Picture,
    @SerializedName("cell")
    val cell : String
)

data class Name(
    @SerializedName("title")
    val title: String,
    @SerializedName("first")
    val first: String,
    @SerializedName("last")
    val last: String
)

data class Location(

    @SerializedName("city")
    val city: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("country")
    val country: String
)



data class Picture(
    @SerializedName("medium")
    val medium: String,
    @SerializedName("large")
    val large: String,
    @SerializedName("thumbnail")
    val thumb: String
)


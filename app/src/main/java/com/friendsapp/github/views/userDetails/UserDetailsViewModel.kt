package com.friendsapp.github.views.userDetails

import androidx.databinding.ObservableParcelable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.friendsapp.github.domain.UserDetails
import com.friendsapp.github.repository.UserDetailsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDetailsViewModel @Inject constructor(
    private val userDetailsRepository: UserDetailsRepository
) : ViewModel() {

    val rqstUserDetails = ObservableParcelable(UserDetails())

    fun getUserDetails(userId: Int) = userDetailsRepository.getUserDetails(userId)


}
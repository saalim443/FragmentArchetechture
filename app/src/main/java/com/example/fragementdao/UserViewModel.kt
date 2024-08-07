package com.example.fragementdao


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fragementdao.dao.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {
    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>> = _users
    fun registerUser(user: User, onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            userRepository.registerUser(user)
            onResult(true)
        }
    }

    fun loginUser(email: String, password: String, onResult: (User?) -> Unit) {
        viewModelScope.launch {
            val user = userRepository.loginUser(email, password)
            onResult(user)
        }
    }

    fun fetchAllUsers() {
        viewModelScope.launch {
            val userList = userRepository.getAllUsers()
            _users.value = userList
        }
    }

}

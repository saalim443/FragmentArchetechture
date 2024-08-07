package com.example.fragementdao




import com.example.fragementdao.dao.User
import com.example.fragementdao.dao.UserDao
import javax.inject.Inject

class UserRepository @Inject constructor(private val userDao: UserDao) {

    suspend fun registerUser(user: User) {
        userDao.insertUser(user)
    }

    suspend fun loginUser(email: String, password: String): User? {
        return userDao.getUser(email, password)
    }

    suspend fun getAllUsers(): List<User> {
        return userDao.getAllUsers()
    }
}


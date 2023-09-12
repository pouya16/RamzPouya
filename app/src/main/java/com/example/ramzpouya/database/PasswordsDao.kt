package com.example.ramzpouya.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface PasswordsDao {

    @Query("SELECT * FROM passwods WHERE url LIKE :url")
    fun searchUrl(url: String): Flow<List<PasswordsModel>>

    @Insert
    fun insertPass(pass : PasswordsModel)

    @Insert
    fun insertAllPass(passes: List<PasswordsModel>)

    @Delete
    fun deletePass(pass: PasswordsModel)

    @Update
    fun updatePass(pass: PasswordsModel)

}
package com.example.ramzpouya.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "passwords")
data class PasswordsModel (
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val url: String,
    val pass: ByteArray)
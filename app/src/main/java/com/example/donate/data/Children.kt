package com.example.donate.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Children(@PrimaryKey val id: String, val name: String, val age: String)
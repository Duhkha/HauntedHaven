package com.example.hauntedhaven.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface HauntedDao {


    @Query("SELECT * FROM HauntedLocation")
    fun getAll(): Flow<List<HauntedPlace>>

    @Query("SELECT * FROM HauntedLocation WHERE category= :categorys ")
    fun getByCategory(categorys: String): Flow<List<HauntedPlace>>



}
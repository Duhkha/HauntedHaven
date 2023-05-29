package com.example.hauntedhaven.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface HauntedDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg places: HauntedPlace)

    @Query("SELECT * FROM haunted_places")
    suspend fun getAllHauntedPlaces(): List<HauntedPlace>

    @Insert
    suspend fun insertHauntedPlace(hauntedPlace: HauntedPlace)

    @Update
    suspend fun updateHauntedPlace(hauntedPlace: HauntedPlace)


}
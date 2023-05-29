package com.example.hauntedhaven.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "HauntedLocation")
data class HauntedPlace(

    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name") val names: String,
    @ColumnInfo(name = "location") val locations: String,
    @ColumnInfo(name = "price") val current_price: Double,
    @ColumnInfo(name = "quick_desc") val quick_description: String,
    @ColumnInfo(name = "sleep_available") val sleep: String,
    @ColumnInfo(name = "date") val available_date: String,
    @ColumnInfo(name = "available_ppl") val people: Int,
    @ColumnInfo(name = "desc") val description: String,
    @ColumnInfo(name = "category") val categorys: String,
    @ColumnInfo(name = "imgUri") val img: String

)
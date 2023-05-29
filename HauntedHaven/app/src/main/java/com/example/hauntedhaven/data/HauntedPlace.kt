package com.example.hauntedhaven.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "haunted_places")
data class HauntedPlace(

    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "image_uri") val imageUri: String,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "location") val location: String,
    @ColumnInfo(name = "price") val price: Double,
    @ColumnInfo(name = "date") val availableDates: List<String>,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "details") val details: String,
    @ColumnInfo(name = "category") val category: String,
    @ColumnInfo(name = "sleepover") val sleepoverAvailability: Boolean



) {
    init {
        if (name.isBlank()) {
            name = location
        }
    }
}

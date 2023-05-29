package com.example.hauntedhaven

import android.app.Application
import com.example.hauntedhaven.data.HauntedDatabase

class HauntedHavenApplication : Application() {
    val database: HauntedDatabase by lazy {HauntedDatabase.getDatabase(this)}

}

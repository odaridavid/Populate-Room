package com.github.odaridavid.pre_poplatr

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import java.util.*
import java.util.concurrent.Executors

internal class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val usersSampleData: List<User> = listOf(
        User("David", "kiribwa@gmail.com"),
        User("Eli", "eli@gmail.com"),
        User("June", "june@gmail.com"),
        User("Oped", "oped@gmail.com")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val userDb = Room.databaseBuilder(this, UserDatabase::class.java, UserDatabase.NAME)
            .addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    UserPrepoplatr(db).insert(usersSampleData)
                }

                override fun onOpen(db: SupportSQLiteDatabase) {
                    super.onOpen(db)
                    Log.i("Db opened on", "${Date()}")
                }
            })
            .build()

        Executors.newSingleThreadExecutor().execute {
            val users = userDb.userDao().getAll()
            Log.i("Users", "$users")
        }

    }

}

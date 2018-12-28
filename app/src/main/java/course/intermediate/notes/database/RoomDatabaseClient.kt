package course.intermediate.notes.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

const val DATABASE_SCHEMA_VERSION = 1
const val DB_NAME = "local-db"

@Database(version = DATABASE_SCHEMA_VERSION, entities = [])
abstract class RoomDatabaseClient : RoomDatabase() {

    // Insert DAOs below


    companion object {

        private var instance: RoomDatabaseClient? = null

        fun getInstance(context: Context): RoomDatabaseClient {
            if (instance == null) {
                instance = createDatabase(context)
            }
            return instance!!
        }

        fun createDatabase(context: Context): RoomDatabaseClient {
            return Room.databaseBuilder(context, RoomDatabaseClient::class.java, DB_NAME).build()
        }

    }

}
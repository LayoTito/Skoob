import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object{

        private const val DATABASE_NAME = "DataBaseSkoob.db"
        private const val DATABASE_VERSION = 1

        private const val TABLE_NAME = "dados"
        private const val LIBRARY = "library"

        private const val COLUMN_ID = "id"
        private const val COLUMN_USERNAME = "username"
        private const val COLUMN_PASSWORD = "password"
        private const val COLUMN_EMAIL = "email"

        private const val LIBRARY_ID = "libraryId"
        private const val LIBRARY_TITLE = "libraryTitle"
        private const val LIBRARY_IMAGE = "libraryImage"
        private const val LIBRARY_DESCRIPTION = "libraryDescription" +
                ""
    }

    override fun onCreate(db: SQLiteDatabase?) {

        val createTableQuery = ("CREATE TABLE $TABLE_NAME (" +
                "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_USERNAME TEXT," +
                "$COLUMN_PASSWORD TEXT," +
                "$COLUMN_EMAIL TEXT)")

        db?.execSQL(createTableQuery)

        val createLibraryQuery = ("CREATE TABLE $LIBRARY (" +
                "$LIBRARY_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$LIBRARY_TITLE TEXT," +
                "$LIBRARY_IMAGE IMAGE," +
                "$LIBRARY_DESCRIPTION TEXT,"
                )

        db?.execSQL(createLibraryQuery)

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

        val dropTableQuery = "DROP TABLE IF EXISTS $TABLE_NAME"
        db.execSQL(dropTableQuery)
        onCreate(db)

    }

    fun inserirUsuario(username:String, password:String, email:String): Long
    {
        val values = ContentValues().apply {
            put(COLUMN_USERNAME, username)
            put(COLUMN_PASSWORD, password)
            put(COLUMN_EMAIL, email)
        }
        val db = writableDatabase
        return db.insert(TABLE_NAME, null, values)

    }

}
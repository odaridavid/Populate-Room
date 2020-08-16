/*
*
* Copyright 2020 David Odari
*
* Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except 
* in compliance with the License. You may obtain a copy of the License at
*
*          http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software distributed under the License 
* is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
* or implied. See the License for the specific language governing permissions and limitations under
* the License.
*
*/
package com.github.odaridavid.pre_poplatr

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

interface PrePoplatr<T> {
    val sqLiteDatabase: SupportSQLiteDatabase
    val tableName: String
    fun insert(data: T)
}

internal class UserPrepoplatr(
    override val sqLiteDatabase: SupportSQLiteDatabase,
    override val tableName: String = User.Table.NAME
) : PrePoplatr<List<User>> {
    override fun insert(data: List<User>) {
        for (user in data) {
            val cv = ContentValues()
            cv.put(User.Table.Columns.USER_NAME, user.name)
            cv.put(User.Table.Columns.USER_EMAIL, user.email)
            sqLiteDatabase.insert(tableName, SQLiteDatabase.CONFLICT_REPLACE, cv)
        }
    }
}

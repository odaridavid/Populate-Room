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

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = User.Table.NAME)
data class User(
    val name: String,
    val email: String,
    @PrimaryKey(autoGenerate = true) val id: Long = 0L
) {
    object Table {
        const val NAME: String = "users"

        object Columns {
            const val USER_NAME: String = "name"
            const val USER_EMAIL: String = "email"
        }
    }
}
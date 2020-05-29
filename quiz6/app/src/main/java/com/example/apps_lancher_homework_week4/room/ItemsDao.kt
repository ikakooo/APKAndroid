package com.example.apps_lancher_homework_week4.room

import androidx.room.*


@Dao
interface ItemsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItemsModel(itemsModel: ItemsModel)

    @Update
    fun updateItemsModel(itemsModel: ItemsModel)

    @Delete
    fun deleteItemsModel(itemsModel: ItemsModel)

    @Query("SELECT * FROM ItemsModel WHERE title == :title")
    fun getItemByTitle(title: String): List<ItemsModel>

    @Query("SELECT * FROM ItemsModel WHERE description == :description")
    fun getItemByDescription(description: String): List<ItemsModel>

    @Query("SELECT * FROM ItemsModel")
    fun getGenders(): List<ItemsModel>
}
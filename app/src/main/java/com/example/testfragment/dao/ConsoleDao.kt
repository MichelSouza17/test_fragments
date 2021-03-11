package com.example.testfragment.dao

import androidx.room.*
import com.example.testfragment.model.Console


@Dao
interface ConsoleDao {

    @Insert
    fun salvar(console: Console)

    @Update
    fun atualizar(console: Console)

    @Query("SELECT * FROM console ORDER BY date ASC")
    fun listarTodos(): List<Console>

    @Query( "SELECT * FROM console WHERE id = :id")
    fun listarPorId(id: Int) : Console

    @Delete
    fun excluir(console: Console)



}
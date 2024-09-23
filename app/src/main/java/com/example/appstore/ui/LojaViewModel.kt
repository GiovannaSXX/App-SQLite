package com.example.appstore.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appstore.data.LojaRepository
import com.example.appstore.data.Loja
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class LojaViewModel(private val repository: LojaRepository) : ViewModel() {

    val lojaList: Flow<List<Loja>> = repository.getRoupas()

    fun getPessoaById(id: Int): Flow<Loja> = repository.getRoupaById(id)

    fun addOrUpdatePessoa(id: Int? = null, nome: String, tamanho: String, genero: String, profissao: String, nacionalidade: String) {
        val loja = Loja(id = id ?: 0, marca = nome,  tamanho = tamanho, cor = genero, material = profissao, tipo = nacionalidade)
        viewModelScope.launch {
            repository.insertRoupa(loja)
        }
    }

    fun deleteSpider(loja: Loja) {
        viewModelScope.launch {
            repository.deleteRoupa(loja)
        }
    }
}

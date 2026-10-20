package com.permuta.ejemploclase.viewmodel

import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

data class PantallaPrincipalUIState(
    val datosTarjeta: List<DatosTarjeta> = listOf()

)

private const val TAG = "PantallaPrincipalVM"

class PantallaPrincipalVM: ViewModel() {

    private val _uiState = MutableStateFlow(PantallaPrincipalUIState())
    val uiState = _uiState.asStateFlow();

    fun load(){
        //cargo lo datos

        _uiState.value = _uiState.value.copy(datosTarjeta = listOf(
            DatosTarjeta("Titulo 1", "Descripcion 1"),
            DatosTarjeta("Titulo 2", "Descripcion 2"),
            DatosTarjeta("Titulo 3", "Descripcion 3"),
        ))
    }

    fun onBorrar(item: DatosTarjeta) {

        Log.d(TAG, "accion borrar ${item.titulo}")
    }

    fun onVerMas(item: DatosTarjeta){
        Log.d(TAG, "accion verMas ${item.titulo}")
    }

}



data class DatosTarjeta(
    val titulo: String,
    val descripcion: String
)
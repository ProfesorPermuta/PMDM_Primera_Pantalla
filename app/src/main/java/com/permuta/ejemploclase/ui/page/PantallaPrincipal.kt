package com.permuta.miprimerapantalla.ui.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.permuta.ejemploclase.R
import com.permuta.ejemploclase.ui.component.TarjetaItem
import com.permuta.ejemploclase.ui.component.TarjetaItemData
import com.permuta.ejemploclase.viewmodel.PantallaPrincipalVM
import com.permuta.miprimerapantalla.ui.CabeceraImagen
import com.permuta.miprimerapantalla.ui.CabeceraImagenData


@Composable
fun PantallaPrincipal(modifier: Modifier = Modifier, vm: PantallaPrincipalVM = viewModel() ) {

    var state = vm.uiState.collectAsState()

    LaunchedEffect(Unit) {
        vm.load()
    }
    Column(modifier = modifier) {
        CabeceraImagen(
            data = CabeceraImagenData(
                imagen = R.drawable.cabecera,
                onIconoIzquierdo = {},
                onIconoDerecho = {}
            ))
    }
    Column(modifier = modifier) {
        CabeceraImagen(
            CabeceraImagenData(
                imagen = R.drawable.cabecera,
                onIconoIzquierdo = { },
                onIconoDerecho = { })
        )
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(state.value.datosTarjeta) { item ->
                TarjetaItem(
                    TarjetaItemData(
                    titulo = item.titulo,
                    descripcion = item.descripcion,
                    onBorrar = { vm.onBorrar(item) },
                    onVerMas = { vm.onVerMas(item) }
                ))
            }
        }
    }

}

@Preview
@Composable
fun MiPrimeraPaginaPreview() {
    MaterialTheme() {
        PantallaPrincipal()
    }
}

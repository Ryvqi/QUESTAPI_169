package com.example.week12.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.week12.navigation.DestinasiNavigasi
import com.example.week12.ui.CostumeTopAppBar
import com.example.week12.ui.viewmodel.PenyediaViewModel
import com.example.week12.ui.viewmodel.UpdateViewModel
import kotlinx.coroutines.launch

object DestinasiUpdate: DestinasiNavigasi{
    override val route = "update"
    override val titleRes = "Update Mhs"
    const val NIM = "nim"
    val routeWithArg = "$route/{$NIM}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateScreen(
    modifier: Modifier = Modifier,
    navigateBack: () -> Unit,
    viewModel: UpdateViewModel = viewModel(factory = PenyediaViewModel.Factory)
){
    val coroutineScope = rememberCoroutineScope()
    val inserUiState = viewModel.uiState

    Scaffold(modifier = modifier, topBar = {
        CostumeTopAppBar(
            title = DestinasiUpdate.titleRes,
            canNavigateBack = true,
            navigateUp = navigateBack,
        )
    }) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(18.dp)
        ) {
            EntryBody(
                inserUiState = inserUiState,
                onSiswaValueChange = {updateEvent ->
                    viewModel.updateState(updateEvent)
                },
                onSaveClick = {
                    coroutineScope.launch {
                        viewModel.updateMahasiswa()
                        navigateBack()
                    }
                }
            )
        }
    }
}
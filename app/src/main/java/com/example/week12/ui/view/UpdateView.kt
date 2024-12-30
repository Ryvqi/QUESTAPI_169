package com.example.week12.ui.view

import com.example.week12.navigation.DestinasiNavigasi

object DestinasiUpdate: DestinasiNavigasi{
    override val route = "update"
    override val titleRes = "Update Mhs"
    const val NIM = "nim"
    val routeWithArg = "$route/{$NIM}"
}
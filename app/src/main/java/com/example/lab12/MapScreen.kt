package com.example.lab12

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.Marker


@Composable
fun MapScreen() {
    val arequipaLocation = LatLng(-16.4040102, -71.559611)

    val cameraPositionState = rememberCameraPositionState {
        position = com.google.android.gms.maps.model.CameraPosition.fromLatLngZoom(arequipaLocation, 12f)
    }

    val locations = listOf(
        LatLng(-16.433415, -71.5442652) to "JLByR (Azul)",
        LatLng(-16.4205151, -71.4945209) to "Paucarpata (Verde)",
        LatLng(-16.3524187, -71.5675994) to "Zamacola (Rojo)"
    )

    val markerColors = listOf(
        BitmapDescriptorFactory.HUE_BLUE,     // Azul
        BitmapDescriptorFactory.HUE_GREEN,    // Verde
        BitmapDescriptorFactory.HUE_RED       // Rojo
    )

    Box(modifier = Modifier.fillMaxSize()) {
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState
        ) {
            Marker(
                state = rememberMarkerState(position = arequipaLocation),
                icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE),
                title = "Centro de Arequipa (Naranja)"
            )

            locations.forEachIndexed { index, (location, name) ->
                val color = markerColors.getOrElse(index) { BitmapDescriptorFactory.HUE_AZURE }

                Marker(
                    state = rememberMarkerState(position = location),
                    title = name,
                    snippet = "Punto de interés #${index + 1}",

                    icon = BitmapDescriptorFactory.defaultMarker(color)
                )
            }
        }
    }
}
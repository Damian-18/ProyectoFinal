package com.example.proyectofinal.ui.reportes

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

// Modelo de datos mock
data class ReporteMock(
    val folio: String,
    val categoria: String,
    val estado: String,
    val fecha: String
)

class ReportesViewModel : ViewModel() {
    
    // Estado interno mutable
    private val _reportes = MutableStateFlow<List<ReporteMock>>(emptyList())
    // Estado inmutable público para que la UI lo observe
    val reportes: StateFlow<List<ReporteMock>> = _reportes.asStateFlow()

    init {
        cargarReportesMock()
    }

    private fun cargarReportesMock() {
        // Datos falsos (mock) de ejemplo
        _reportes.value = listOf(
            ReporteMock(
                folio = "REP-001",
                categoria = "Bache en vía pública",
                estado = "Pendiente",
                fecha = "07/10/2026"
            ),
            ReporteMock(
                folio = "REP-002",
                categoria = "Alumbrado público fundido",
                estado = "En proceso",
                fecha = "05/10/2026"
            ),
            ReporteMock(
                folio = "REP-003",
                categoria = "Fuga de agua",
                estado = "Resuelto",
                fecha = "02/10/2026"
            ),
            ReporteMock(
                folio = "REP-004",
                categoria = "Semáforo descompuesto",
                estado = "Pendiente",
                fecha = "06/10/2026"
            )
        )
    }
}

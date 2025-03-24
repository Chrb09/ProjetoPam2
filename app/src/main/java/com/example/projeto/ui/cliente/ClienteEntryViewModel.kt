package com.example.projeto.ui.cliente

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.projeto.data.Cliente
import com.example.projeto.data.ClienteRepository


class ClienteEntryViewModel(private val clienteRepository: ClienteRepository) : ViewModel() {

    var clienteUiState by mutableStateOf(ClienteUiState())
        private set

    fun updateUiState(clienteDetails: ClienteDetails) {
        clienteUiState =
            ClienteUiState(clienteDetails = clienteDetails, isEntryValid = validateInput(clienteDetails))
    }

    suspend fun saveCliente() {
        if (validateInput()) {
            clienteRepository.insert(clienteUiState.clienteDetails.toCliente())
        }
    }

    private fun validateInput(uiState: ClienteDetails = clienteUiState.clienteDetails): Boolean {
        return with(uiState) {
            nome.isNotBlank() && endereco.isNotBlank() && bairro.isNotBlank() && cep.isNotBlank() && cidade.isNotBlank() && estado.isNotBlank()
        }
    }
}

data class ClienteUiState(
    val clienteDetails: ClienteDetails = ClienteDetails(),
    val isEntryValid: Boolean = false
)

data class ClienteDetails(
    val id: Int = 0,
    val nome: String = "",
    val endereco: String = "",
    val bairro: String = "",
    val cep: String = "",
    val cidade: String = "",
    val estado: String = "",
)

fun ClienteDetails.toCliente(): Cliente = Cliente(
    id = id,
    nome = nome,
    endereco = endereco,
    bairro = bairro,
    cep = cep,
    cidade = cidade,
    estado = estado
)

fun Cliente.toClienteUiState(isEntryValid: Boolean = false): ClienteUiState = ClienteUiState(
    clienteDetails = this.toClienteDetails(),
    isEntryValid = isEntryValid
)
fun Cliente.toClienteDetails(): ClienteDetails = ClienteDetails(
    id = id,
    nome = nome,
    endereco = endereco,
    bairro = bairro,
    cep = cep,
    cidade = cidade,
    estado = estado
)
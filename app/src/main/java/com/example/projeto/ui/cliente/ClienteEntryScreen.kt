package com.example.projeto.ui.cliente

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projeto.ui.theme.ProjetoTheme

@Composable
fun AppAula(){
    Column(
        Modifier.fillMaxSize(),

        ){
        Row( modifier =
            Modifier.fillMaxWidth()
                .padding(0.dp, 24.dp),
            Arrangement.Center,

            ){
            Text(
                text = "App Aula",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Row( modifier = Modifier.fillMaxWidth(),
            Arrangement.Center
        ){
            OutlinedTextField("Nome")
        }
        Row( modifier = Modifier.fillMaxWidth(),
            Arrangement.Center
        ){
            OutlinedTextField("Endereço")
        }
        Row( modifier = Modifier.fillMaxWidth(),
            Arrangement.Center
        ){
            OutlinedTextField("Bairro")
        }
        Row( modifier = Modifier.fillMaxWidth(),
            Arrangement.Center
        ){
            OutlinedTextField("CEP")
        }
        Row( modifier = Modifier.fillMaxWidth(),
            Arrangement.Center
        ){
            OutlinedTextField("Cidade")
        }
        Row( modifier = Modifier.fillMaxWidth(),
            Arrangement.Center
        ){
            OutlinedTextField("Estado")
        }
        Row( modifier = Modifier.fillMaxWidth()
            .padding(0.dp, 18.dp),
            Arrangement.Center
        ){
            Column( Modifier.fillMaxWidth(0.35f)) {
                Button(
                    onClick = {  },
                ) {
                    Text(
                        text = "Salvar",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Column() {
                Button(
                onClick = {  },
            ) {
                Text(
                    text = "Cancelar",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            }
        }
    }
}

@Composable
fun OutlinedTextField(label:String) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    return androidx.compose.material3.OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text(label) }
    )
}


@Preview
@Composable
fun AppAulaPreview(){
    ProjetoTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) {
            AppAula()
        }
    }
}
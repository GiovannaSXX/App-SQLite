package com.example.appstore.ui

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LojaScreen(viewModel: LojaViewModel) {
    var marca by remember { mutableStateOf("") }
    var tamanho by remember { mutableStateOf("") }
    var cor by remember { mutableStateOf("") }
    var material by remember { mutableStateOf("") }
    var tipo by remember { mutableStateOf("") }
    var selectedRoupaId by remember { mutableStateOf<Int?>(null) }

    val roupaList by viewModel.lojaList.collectAsState(initial = emptyList())

    val isFormValid = marca.isNotBlank() && tamanho.isNotBlank() && cor.isNotBlank() && material.isNotBlank() && tipo.isNotBlank()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE53F77))
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                //.background(Color.White.copy(alpha = 0.9f), RoundedCornerShape(16.dp)) // Fundo branco translúcido
                .padding(32.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Registro de Roupas",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFF8F4BA),
                    fontSize = 28.sp
                )
            )

            TextField(
                value = marca,
                onValueChange = { marca = it },
                label = { Text("Marca", color = Color.Black) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = Color.White.copy(alpha = 0.9f),
                    unfocusedContainerColor = Color.White.copy(alpha = 0.9f),
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = tamanho,
                onValueChange = { tamanho = it },
                label = { Text("Tamanho", color = Color.Black) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = Color.White.copy(alpha = 0.9f),
                    unfocusedContainerColor = Color.White.copy(alpha = 0.9f),
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = tipo,
                onValueChange = { tipo = it },
                label = { Text("Tipo", color = Color.Black) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = Color.White.copy(alpha = 0.9f),
                    unfocusedContainerColor = Color.White.copy(alpha = 0.9f),
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = cor,
                onValueChange = { cor = it },
                label = { Text("Cor", color = Color.Black) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = Color.White.copy(alpha = 0.9f),
                    unfocusedContainerColor = Color.White.copy(alpha = 0.9f),
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = material,
                onValueChange = { material = it },
                label = { Text("Material", color = Color.Black) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = Color.White.copy(alpha = 0.9f),
                    unfocusedContainerColor = Color.White.copy(alpha = 0.9f),
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    if (isFormValid) {
                        viewModel.addOrUpdatePessoa(selectedRoupaId, marca, tamanho, cor, material, tipo)
                        marca = ""
                        tamanho = ""
                        cor = ""
                        material = ""
                        tipo = ""
                        selectedRoupaId = null
                    }
                },
                modifier = Modifier
                    .padding(top = 16.dp)
                    .align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF8F4BA).copy(alpha = 0.5f), disabledContainerColor = Color(0xFFF8F4BA).copy(alpha = 0.9f)),
                enabled = isFormValid
            ) {
                Text(if (selectedRoupaId == null) "Adicionar Roupa" else "Atualizar Roupa", color = Color.White)
            }

            LazyColumn (
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(roupaList) { time ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White, RoundedCornerShape(8.dp))
                            .padding(5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(text = "Marca: ${time.marca}", color = Color.Black)
                            Text(text = "Tamanho: ${time.tamanho}", color = Color.Black)
                            Text(text = "Tipo: ${time.tipo}", color = Color.Black)
                            Text(text = "Cor: ${time.cor}", color = Color.Black)
                            Text(text = "Material: ${time.material}", color = Color.Black)
                        }

                        Row {
                            // Botão de editar
                            IconButton(onClick = {
                                marca = time.marca
                                tamanho = time.tamanho.toString()
                                cor = time.cor
                                material = time.material
                                tipo = time.tipo
                                selectedRoupaId = time.id
                            }) {
                                Icon(
                                    imageVector = Icons.Outlined.Edit,
                                    modifier = Modifier.size(32.dp),
                                    contentDescription = "Editar Roupa",
                                    tint = Color.Unspecified
                                )
                            }
                        }
                        IconButton(onClick = { viewModel.deleteSpider(time) }) {
                            Icon(
                                imageVector = Icons.Outlined.Delete,
                                modifier = Modifier.size(32.dp),
                                contentDescription = "Excluir Roupa",
                                tint = Color.Unspecified
                            )
                        }
                    }
                }
            }
        }
    }
}

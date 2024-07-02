package pe.edu.idat.myapplication

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun Entrar(navController: NavHostController) {
    var Ejem1 by rememberSaveable { mutableStateOf("") }
    var Ejem2 by rememberSaveable { mutableStateOf("") }
    var Ejem3 by rememberSaveable { mutableStateOf("Hombre") }
    var Ejem4 by rememberSaveable { mutableStateOf(false) }
    var Ejem5 by rememberSaveable { mutableStateOf(false) }
    var Ejem6 by rememberSaveable { mutableStateOf(false) }
    var Ejem7 by rememberSaveable { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 25.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Información",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                style = TextStyle(
                    fontSize = 30.sp,
                    color = Color.Black
                )
            )

            OutlinedTextField(
                value = Ejem1,
                onValueChange = { Ejem1 = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("DNI", color = Color.Black) },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            OutlinedTextField(
                value = Ejem1,
                onValueChange = { Ejem1 = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Nombre", color = Color.Black) },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )

            OutlinedTextField(
                value = Ejem1,
                onValueChange = { Ejem1 = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Apellidos", color = Color.Black) },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )

            Sps(16)

            OutlinedTextField(
                value = Ejem2,
                onValueChange = { Ejem2 = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Email", color = Color.Black) },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )
            OutlinedTextField(
                value = Ejem1,
                onValueChange = { Ejem1 = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Contraseña", color = Color.Black) },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            Sps(16)

            Text(text = "Sexo", fontSize = 20.sp, color = Color.Black)
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = Ejem3 == "Hombre",
                    onClick = { Ejem3 = "Hombre" }
                )
                Text(text = "Hombre")
                Spacer(modifier = Modifier.width(16.dp))
                RadioButton(
                    selected = Ejem3 == "Mujer",
                    onClick = { Ejem3 = "Mujer" }
                )
                Text(text = "Mujer")
            }

            Sps(16)

            Text(text = "Hobbies", fontSize = 20.sp, color = Color.Black)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = Ejem4,
                    onCheckedChange = { Ejem4 = it }
                )
                Text(text = "Deporte")
                Spacer(modifier = Modifier.width(16.dp))
                Checkbox(
                    checked = Ejem5,
                    onCheckedChange = { Ejem5 = it }
                )
                Text(text = "Pintura")
                Spacer(modifier = Modifier.width(16.dp))
                Checkbox(
                    checked = Ejem6,
                    onCheckedChange = {
                        Ejem6 = it
                        Ejem7 = it
                    }
                )
                Text(text = "Otro")
            }

            Sps(16)

            Button(
                onClick = {
                    // Toggle books visibility
                    Ejem7 = !Ejem7
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(imageVector = Icons.Default.Check, contentDescription = "Check")
                Spacer(modifier = Modifier.width(8.dp))
                Text("Acceder")
            }

            if (Ejem7) {
                ListaLibros()
            }
        }
    }
}
@Composable
fun ListaLibros() {
    val books = listOf(
        Book("Clínica General y Diagnóstico", "Guía esencial para el diagnóstico en medicina general.", "15/03/2020"),
        Book("Endocrinología Avanzada", "Estudios y tratamientos de las enfermedades endocrinas.", "07/09/2021"),
        Book("Gastroenterología Práctica", "Tratamiento y diagnóstico de enfermedades gastrointestinales.", "12/11/2019"),
        Book("Manual de Terapia Intensiva", "Protocolo y tratamiento en unidades de cuidados intensivos.", "30/06/2018"),
        Book("Otorrinolaringología Integral", "Guía completa sobre enfermedades de oído, nariz y garganta.", "05/02/2017"),
        Book("Traumatología y Ortopedia", "Diagnóstico y tratamiento de lesiones musculoesqueléticas.", "22/04/2021"),
        Book("Psiquiatría Moderna", "Avances y estudios en salud mental.", "13/08/2020"),
        Book("Reumatología Clínica", "Guía sobre enfermedades reumáticas y su tratamiento.", "29/01/2019"),
        Book("Nefrología y Urología", "Estudios y tratamiento de enfermedades renales y urológicas.", "18/12/2016"),
        Book("Ginecología y Obstetricia", "Guía completa sobre salud femenina y embarazo.", "09/07/2015")
    )

    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(books) { book ->
            Crd(book)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun Crd(book: Book) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = book.title,
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = book.description)
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Fecha de publicación: ${book.publishDate}",
                style = TextStyle(color = Color.Gray)
            )
        }
    }
}

@Composable
fun Sps(espacio: Int) {
    Spacer(modifier = Modifier.size(espacio.dp))
}
data class Book(val title: String, val description: String, val publishDate: String)
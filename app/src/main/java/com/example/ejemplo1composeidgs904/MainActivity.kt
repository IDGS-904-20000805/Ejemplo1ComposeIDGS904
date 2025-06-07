package com.example.ejemplo1composeidgs904

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ejemplo1composeidgs904.ui.theme.Ejemplo1ComposeIDGS904Theme


// hacemos una lista para los diferentes personajes
private val personajes: List<Personaje> = listOf(
    Personaje("Goku", "El protagonista de la serie, conocido por su gran poder y personalidad amigable. Originalmente enviado a la Tierra como un infante volador con la misión de conquistarla")
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // borramos lineas de codigo hasta tenerla asi
        setContent { //set content es como el main, la parte principal

            //creamos un mensaje
            // Text("Hola mundo")

            //usando composable solo pedimos que nos mande la pantalla
//            MessageCard("Cesar");
//            PreviewMessageCard()

            //Como Usamos los temas
            Ejemplo1ComposeIDGS904Theme {
              //usaremos el ejemplo de uso de imagen de padreBall
            Tarjeta()
            }
        }
    }
}


//creamos un metodo
// para que una funcion pueda usar los componentes tiene que agregar un decorador composable
//@Composable
//fun MessageCard(nombre: String){ //nos permite pasar parametros
//    Text("Hola mundo $nombre")
//    Text("Hola mundo 2 $nombre")
//
//}

/*crearemos una clase, es una especie de interfaz que solo tendra dos componentes, apartir de ella podemos pasarle
como parametro los valores de la clase a un elemento */
data class Personaje(val nombre: String, val descripcion: String)
@Composable
fun Tarjeta(){ //Hacemos un metodo par ael API de padreball
    //como se empalmo crearemos una column
//    Column {
//    Text("Nombre: Goku")
//    Text("Descripcion: El protagonista de la serie, conocido por su gran poder y personalidad amigable. Originalmente enviado a la Tierra como un infante volador con la misión de conquistarla")
//    }

    //hacemos una row para anidar todo
    Row (
        //usamos los temas ahora aqui
        modifier = Modifier.padding(8.dp)
            .background(MaterialTheme.colorScheme.background)
    ){
        //importamos personaje e imagen para anidar todo para dar diseño
        ImagenHeroe()
        Personaje()
        //importa el orden, aqui mostramos primero la imagen y despues el texto
    }


}

//creamos un nuevo metodo, la idea es que tarjeta contenga las dos cosas, imagen y personaje
@Composable
fun Personaje(){
    Column {
        Text("Nombre: Goku")
        Text("Descripcion: El protagonista de la serie, conocido por su gran poder y personalidad amigable. Originalmente enviado a la Tierra como un infante volador con la misión de conquistarla")
    }
}



// importamos a goku en el resource manager solo es buscarlo y darle add e importar
// creamos un composable para la imagen
@Composable
fun ImagenHeroe(){
    Image(
        painterResource(id = R.drawable.goku_normal),
        contentDescription = "Goku",
        // agregamos los modificadores, nos permite generar los diferentes tamaños para el componente
        modifier = Modifier
            .padding(16.dp)
            .size(100.dp)
            .clip(CircleShape)
            //.background(Color.Gray)
            .background(MaterialTheme.colorScheme.primary) // usando el theme y su paleta de colores

    )
}

//usamos el componente previre para ver lo que hacemos en tiempo real
@Preview
@Composable
fun PreviewMessageCard(){ //nos permite pasar parametros
//    //mandamos a llamar el metodo para que se muestre en el preview
//    MessageCard("Cesar")  (Comente esto porque vamos a hacer lo de padre ball)
//  Importamos la imgen del kokun
 //   ImagenHeroe() lo comente porque se supone que esta anidado en el metodo tarjeta

    Tarjeta() //Se empalmo en el preview message, ver el metodo para ver la solucion

}

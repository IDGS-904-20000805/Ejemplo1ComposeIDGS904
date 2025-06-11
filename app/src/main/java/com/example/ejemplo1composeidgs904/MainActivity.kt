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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp



// hacemos una lista para los diferentes personajes
private val tarjetas: List<PersonajeTarjeta> = listOf(
    PersonajeTarjeta("goku", "El protagonista de la serie, conocido por su gran poder y personalidad amigable. Originalmente enviado a la Tierra como un infante volador con la misión de conquistarla"),
    PersonajeTarjeta("gohan", "Es el primer hijo de Son Goku y Chi-Chi"),
    PersonajeTarjeta("androide17", "Antes de ser secuestrado, es el hermano mellizo de la Androide Número 18, quien al igual que ella antes de ser Androide era un humano normal hasta que fueron secuestrados por el Dr. Gero, y es por eso que lo odian."),
    PersonajeTarjeta("androide18", "Es la hermana melliza del Androide Número 17 y una androide creada a partir de una base humana por el Dr. Gero con el único fin de destruir a Goku."),
    PersonajeTarjeta("Cell", "Cell conocido como Célula en España, es un bioandroide creado por la computadora del Dr. Gero, quien vino del futuro de la línea 3 con la intención de vengarse de Goku por haber acabado con el Ejército del Listón Rojo"),
    PersonajeTarjeta("gogeta", "Gogeta es la fusión resultante de Son Goku y Vegeta, cuando realizan la Danza de la Fusión correctamente para enfrentarse a Broly"),
    PersonajeTarjeta("gotenks", " Gotenks también conocido inicialmente como Gotrunk en el doblaje al español de España, es el resultado de la Danza de la Fusión llevada a cabo correctamente por Goten y Trunks"),
    PersonajeTarjeta("jiren", "Jiren es un poderoso luchador del Universo 11 y uno de los oponentes más formidables en el torneo."),
    PersonajeTarjeta("daishinkan", "El Gran Sacerdote es el supervisor del torneo y uno de los seres más poderosos. Gran Ministro de los Omni-Reyes , es un ángel que actúa como asesor cercano y figura guía de Zenón y del Futuro Zenón ."),
    PersonajeTarjeta("vegetto", "Vegetto es el personaje más fuerte dentro del manga original y uno de los personajes más poderosos de toda la serie en general."),
    PersonajeTarjeta("vegeta", "Príncipe de los Saiyans, inicialmente un villano, pero luego se une a los Z Fighters. A pesar de que a inicios de Dragon Ball Z, Vegeta cumple un papel antagónico, poco después decide rebelarse ante el Imperio de Freeza, volviéndose un aliado clave para los Guerreros Z.")
)

/*crearemos una clase, es una especie de interfaz que solo tendra dos componentes, apartir de ella podemos pasarle
como parametro los valores de la clase a un elemento */
data class PersonajeTarjeta(val nombre: String, val descripcion: String)

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
            Tarjeta(tarjetas) //pasamos la lista de los diferentes personajes
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


@Composable
fun Tarjeta(personajes: List<PersonajeTarjeta>){//pasamos como parametro la lista de personajes que se hicieron
    //Hacemos un metodo par ael API de padreball
    //como se empalmo crearemos una column
//    Column {
//    Text("Nombre: Goku")
//    Text("Descripcion: El protagonista de la serie, conocido por su gran poder y personalidad amigable. Originalmente enviado a la Tierra como un infante volador con la misión de conquistarla")
//    }

    //hacemos una row para anidar todo
//    Row (
//        //usamos los temas ahora aqui
//        modifier = Modifier.padding(8.dp)
//            .background(MaterialTheme.colorScheme.background)
//    ){
//        //importamos personaje e imagen para anidar todo para dar diseño
//        ImagenHeroe()
//        Personaje()
//        //importa el orden, aqui mostramos primero la imagen y despues el texto
//    }
    // EDITAMOS ESTO PARA SEGUIR CON LA CLASE

    LazyColumn {
        items(personajes){ personaje->
            MyPersonajes(personaje)

        }
    }
}

//hacemos un nuevo metodo
@Composable
fun MyPersonajes(personaje: PersonajeTarjeta){

    Card (
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ){

    Row (
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(8.dp)
    ){
        ImagenHeroe(personaje.nombre)
        Personajes(personaje)
        }
    }
}
//siguiendo el metodo de arriba, hacemos otro metodo
@Composable
fun Personajes(personaje: PersonajeTarjeta){
    Column {
        Personaje(personaje.nombre,
            MaterialTheme.colorScheme.primary,
            MaterialTheme.typography.titleLarge)
        Personaje(personaje.descripcion,
            MaterialTheme.colorScheme.onBackground,
            MaterialTheme.typography.bodyMedium)
    }
}
//ahora otro metodo?
@Composable
fun Personaje(name:String,color:Color,style: TextStyle){

    Text(text = name,color=color,style=style)

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
fun ImagenHeroe(imageName: String){
    //para que las imagenes se adecuen a los personajes agregamos el parametro y lo siguiente
    val context = LocalContext.current
    val ImageResid = remember(imageName){
        context.resources.getIdentifier(imageName.lowercase(),"drawable",context.packageName)
    }

    Image(
        painterResource(id = ImageResid), //cambiamos de drawable a imageresid para que tome la imagen correcta
        contentDescription = imageName, //antes esatba "goku", pero ahora sera dinamico
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

    Tarjeta(tarjetas) //Se empalmo en el preview message, ver el metodo para ver la solucion

}

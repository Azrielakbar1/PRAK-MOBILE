package com.example.listapp_compose.model
import com.example.listapp_compose.R

data class Player (
    val id: Int,
    val name: String,
    val jerseyNum: String,
    val position: String,
    val imageRes: Int,
    val btnExternal: String, //to Player Instagram
    val btnInternal: String,
    val instagramUrl: String,
    val description: String
)

val gswPlayers = listOf(
    Player(1, "Stephen Curry", "30","Best Point Guard Right Now, Please Guard Him !", R.drawable.curry,"Instagram", "About Me", "https://www.instagram.com/stephencurry30/",
        "Curry was born on March 14, 1988, at Akron General Medical Center in downtown Akron, Ohio. His father, Dell Curry was a professional basketball player, and his mother, Sonya Adams, is an educator and author."),
    Player(2, "Klay Thompson", "11", "Washed Shooting Guard, he can't even shoot in gameee", R.drawable.thompson,"Instagram", "About Me", "https://www.instagram.com/klaythompson/",
        "Thompson was born in Los Angeles to Julie and Mychal Thompson. His mother was a volleyball player in college for the University of Portland and University of San Francisco, while his father was the first overall pick of the 1978 NBA draft."),
    Player(3, "Draymond Green", "23","Dirty Power Forward, Play like a Shiiii ", R.drawable.green,"Instagram", "About Me","https://www.instagram.com/money23green/",
        "Green is the son of Mary Babers and Wallace Davis. His stepfather is Raymond Green, and he has two brothers, Torrian Harris and Braylon Green, and three sisters, LaToya Babers, Jordan Davis and Gabby Davis."),
    Player(4, "Kevin Durant", "35","Shooting Forward, he known as Slim Reaper, that nickname thooo", R.drawable.durant,"Instagram", "About Me", "https://www.instagram.com/easymoneysniper/",
        "Kevin Wayne Durant (born September 29, 1988), also known by his initials KD, is an American professional basketball player for the Houston Rockets of the National Basketball Association (NBA)."),
    Player(5, "Demarcus Cousins", "0", "Monster Center, he played well with this Roster, No need to much Comments ", R.drawable.cousins,"Instagram", "About Me", "https://www.instagram.com/boogiecousins/",
        "DeMarcus Amir Cousins (born August 13, 1990) is an American professional basketball player for the Selenge Bodons of the Mongolian Basketball League. Nicknamed \"Boogie\", he played college basketball for the Kentucky Wildcats, earning consensus second-team All-American honors in 2010. ")
)



package com.example.travelphotoapp

import android.os.Bundle
import android.widget.ImageButton
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.travelphotoapp.ui.theme.TravelPhotoAppTheme
import android.widget.ImageView
import android.widget.TextView

class MainActivity : ComponentActivity() {

    var currentImage=1
    lateinit var  image: ImageView
    var places =arrayOf("India Gate","Lotus Temple","Red Fort","Akshar Dham Temple")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            setContentView(R.layout.activity_main)

            val next= findViewById<ImageButton>(R.id.btnNext)
            val prev = findViewById<ImageButton>(R.id.btnPrev)
            val placeName = findViewById<TextView>(R.id.tvName)

            next.setOnClickListener{
                //I want to go to the next button
                var idCurrentImageString = "pic$currentImage"

                //I have to get the integer associated with each view

                var idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString,"id",packageName)
                image= findViewById(idCurrentImageInt)
                image.alpha= 0f

                if (currentImage==4){
                    currentImage =1
                    var idImageToShowString = "pic$currentImage"
                    var idImageToShowInt = this.resources.getIdentifier(idImageToShowString,"id",packageName)
                    image= findViewById(idImageToShowInt)
                    image.alpha= 1f
                    placeName.text= places[currentImage-1]
                }
                else{
                    currentImage += 1
                    var idImageToShowString = "pic$currentImage"
                    var idImageToShowInt = this.resources.getIdentifier(idImageToShowString,"id",packageName)
                    image= findViewById(idImageToShowInt)
                    image.alpha= 1f
                    placeName.text= places[currentImage-1]
                }


            }

            prev.setOnClickListener{
                //I want to go to the previous image
                var idCurrentImageString="pic$currentImage"

                var idCurrentImageInt= this.resources.getIdentifier(idCurrentImageString,"id", packageName)
                image= findViewById(idCurrentImageInt)
                image.alpha=0f

                if(currentImage==1){
                    currentImage = 5-currentImage
                    var idImageToShowString="pic$currentImage"

                    var idImageToShowInt= this.resources.getIdentifier(idImageToShowString,"id", packageName)
                    image= findViewById(/* id = */ idImageToShowInt)
                    image.alpha=1f
                    placeName.text= places[currentImage-1]
                }
                else{
                    currentImage -=1
                    var idImageToShowString="pic$currentImage"

                    var idImageToShowInt= this.resources.getIdentifier(idImageToShowString,"id", packageName)
                    image= findViewById(/* id = */ idImageToShowInt)
                    image.alpha=1f
                    placeName.text= places[currentImage-1]
                }




            }
        }
    }
}

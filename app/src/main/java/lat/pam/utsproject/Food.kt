package lat.pam.utsproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.ImageView

class FoodActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)

        // You can dynamically populate this layout with food items
        val foodList = listOf(
            Food("Batagor", "Delicious fried tofu and fish dumplings.", R.drawable.batagor),
            Food("Nasi Goreng", "Fried rice with a mix of spices.", R.drawable.nasi_goreng),
            Food("Sate", "Grilled skewered meat served with peanut sauce.", R.drawable.sate)
        )

        val linearLayout = findViewById<LinearLayout>(R.id.foodListLayout)

        for (food in foodList) {
            val itemView = layoutInflater.inflate(R.layout.item_layout_food, linearLayout, false)
            val foodName = itemView.findViewById<TextView>(R.id.foodName)
            val foodDescription = itemView.findViewById<TextView>(R.id.foodDescription)
            val foodImage = itemView.findViewById<ImageView>(R.id.foodImage)

            foodName.text = food.name
            foodDescription.text = food.description
            foodImage.setImageResource(food.imageResId)

            linearLayout.addView(itemView)
        }
    }
}

data class Food(val name: String, val description: String, val imageResId: Int)

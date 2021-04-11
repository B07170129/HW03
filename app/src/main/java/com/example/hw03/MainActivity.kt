package com.example.hw03


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.ListView
import android.widget.Spinner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val names = arrayOf("apple", "avocado", "banana", "cherries", "coconut")

        val listView = findViewById<ListView>(R.id.listView)
        val count = ArrayList<String>() //儲存購買數量資訊
        val item = ArrayList<Item>() //儲存水果資訊
        val priceRange = IntRange(10, 100) //建立價格範圍
        val array =
            resources.obtainTypedArray(R.array.image_list) //從 R 類別讀取圖檔
        for(i in 0 until array.length()) {
            val photo = array.getResourceId(i,0) //水果圖片 Id
            val fname=names[i]
            val name = "$fname" //水果名稱
            val price = priceRange.random() //亂數產生價格
            count.add("${i+1}個") //新增可購買數量資訊
            item.add(Item(photo, name, price)) //新增水果資訊
        }
        array.recycle() //釋放圖檔資源
        //建立 ArrayAdapter 物件，並傳入字串與 simple_list_item_1.xml

        //設定橫向顯示列數

        //建立 MyAdapter 物件，並傳入 adapter_vertical 作為畫面

        //建立 MyAdapter 物件，並傳入 adapter_horizontal 作為畫面
        listView.adapter = MyAdapter(this, item,
            R.layout.adapter)
    }
}
data class Item(
    val photo: Int, //圖片
    val name: String, //名稱
    val price: Int //價格
)
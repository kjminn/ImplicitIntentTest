package kr.hs.emirim.kjminn.implicitintenttest

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var btnCall:Button
    lateinit var btnHome:Button
    lateinit var btnMap:Button
    lateinit var btnSearch:Button
    lateinit var btnSms:Button
    lateinit var btnPicture:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "암시적 인텐트 연습"

        btnCall = findViewById(R.id.btnCall)
        btnHome = findViewById(R.id.btnHome)
        btnMap = findViewById(R.id.btnMap)
        btnSearch = findViewById(R.id.btnSearch)
        btnSms = findViewById(R.id.btnSms)
        btnPicture = findViewById(R.id.btnPicture)

        btnCall.setOnClickListener {
            var uri = Uri.parse("tel:010-3335-1234")
            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        btnHome.setOnClickListener {
            var uri = Uri.parse("https://m.naver.com")
            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        btnMap.setOnClickListener {
            var uri = Uri.parse("https://maps.google.com/maps?q="+37.4663507+","+126.9328951)
            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        btnSearch.setOnClickListener {
            var intent = Intent(Intent.ACTION_WEB_SEARCH)
            intent.putExtra(SearchManager.QUERY, "미림정보과학고")
            startActivity(intent)
        }

        btnSms.setOnClickListener {
            var intent = Intent(Intent.ACTION_SENDTO)
            intent.putExtra("sms_body", "여러분은 무궁무진한 가능성을 가진 학생들입니다.")
            intent.data = Uri.parse("smsto:" + Uri.encode("02-777-3333"))
            startActivity(intent)
        }

        btnPicture.setOnClickListener {
            var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }
    }
}
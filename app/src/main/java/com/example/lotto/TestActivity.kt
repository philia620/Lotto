package com.example.lotto

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_test.*

class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        // 코드에서 View 에 이븐트 리스너를 설정하는 방법
        // kotlin 에서는 Android Extension 덕분에 findViewById 없이 바로 접근 가능하다
        // 버튼과 같은 View 가 클릭되었을때 실행될 listener 를 등록하는 메소드가 setOnClickListener 이다
        button.setOnClickListener {
            // MainActivity 를 시작하는 Intent 를 생성한다
            val intent = Intent(this@TestActivity, MainActivity::class.java)
            // intent 를 사용하여 Activity 를 시작한다
            startActivity(intent)
        }
        button2.setOnClickListener {
            val intent = Intent(this@TestActivity, ConstellationActivity::class.java)
            startActivity(intent)
        }
        button3.setOnClickListener {
            val intent = Intent(this@TestActivity, NameActivity::class.java)
            startActivity(intent)
        }
        button4.setOnClickListener {
            val intent = Intent(this@TestActivity, ResultActivity::class.java)
            startActivity(intent)
        }
    }


    // xml 에서 참조할 수 있게 메소드를 정의한다.
    fun goConstellation(view: View) {
        // constellationActivity 로 화면전환을 하는 코드
        val intent = Intent(this@TestActivity, ConstellationActivity::class.java)
        startActivity(intent)
    }

    // 암시적 인텐트를 사용해 웹브라우저를 호출한다
    fun callWeb(view: View) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.naver.com"))
        startActivity(intent)
    }
}

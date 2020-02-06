package com.example.lotto

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 랜덤으로 번호 생성 카드의 클릭 이벤트 리스너
        randomCard.setOnClickListener {
            // ResultActivity 를 시작하는 Intent 생성
            val intent = Intent(this, ResultActivity::class.java)

            // intent 의 결과 데이터 전달, int 의 리스트를 전달하므로 putIntegerArrayListExtra 를 사용
            intent.putIntegerArrayListExtra("result", ArrayList(LottoNumberMaker.getShuffleLottoNumbers()))

            // ResultActivity 를 시작하는 Intent 를 만들고 startActivity 로 실행
            startActivity(intent)
        }
        // 별자리
        constellationCard.setOnClickListener {
            startActivity(Intent(this, ConstellationActivity::class.java))
        }
        // 이름
        nameCard.setOnClickListener {
            startActivity(Intent(this, NameActivity::class.java))
        }
    }
}

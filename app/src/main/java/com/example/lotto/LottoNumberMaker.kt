package com.example.lotto

import java.text.SimpleDateFormat
import java.util.*

object LottoNumberMaker {
    /**
     * 랜덤으로 추출하여 6개의 로또 번호를 만드는 함수
     */
    fun getRandomLottoNumbers(): MutableList<Int> {
        // 무작위로 생성된 로또 번호를 저장할 가변 리스트 생성
        val lottoNumbers = mutableListOf<Int>()

        // 6번 반복하는 for 문
        for (i in 1..6) {
            // 랜덤한 번호를 임시로 저장할 변수를 생성
            var number = 0
            do {
                // 랜덤한 번호를 추출해 number 변수에 저장
                number = getRandomLottoNumber()

                // lottoNumbers 에 number 변수의 값이 없을때까지 반복
            } while (lottoNumbers.contains(number))

            // 이미 뽑은 리스트에 없는 번호가 나올때까지 반복했으므로 중복이 없는 상태, 추출된 번호를 뽑은 리스트에 추가
            lottoNumbers.add(number)
        }
        return lottoNumbers
    }

    /**
     * 랜덤으로 1 ~ 45 번호중 하나의 번호를 생성하는 함수
     */
    private fun getRandomLottoNumber(): Int {
        return Random().nextInt(45) + 1
    }

    /**
     *  Shuffle 을 사용해 로또 번호 생성
     */
    fun getShuffleLottoNumbers(): MutableList<Int> {
        val list = mutableListOf<Int>()

        for (number in 1..45) {
            list.add(number)
        }

        list.shuffle()
        return list.subList(0, 6)
    }

    /**
     * 입력받은 이름에 대한 해시코드를 사용하여 로또 번호를 섞고 결과를 반환한다
     */
    fun getLottoNumbersFromHash(name: String): MutableList<Int> {
        val list = mutableListOf<Int>()

        for (number in 1..45) {
            list.add(number)
        }

        // SimpleDataFormat 은 날짜의 시간값을 포맷화된 텍스트 형태로 바꿔주는 클래스
        val targetString = SimpleDateFormat("yyyy-MM-dd", Locale.KOREA).format(Date()) + name

        // 리스트를 무작위로 섞는다. SEED 값은 전달받은 이름의 해시코드를 사용
        list.shuffle(Random(targetString.hashCode().toLong()))

        return list.subList(0, 6)
    }
}
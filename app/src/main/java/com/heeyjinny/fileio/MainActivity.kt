package com.heeyjinny.fileio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.FileUtils

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //1
        //Reader 계열의 스트림을 사용하여 파일 데이터 읽기
        //파일 경로를 파라미터로 전달받아 파일정보를 읽은 후 스트림을 사용하여 파일의 실제 데이터 읽기

        //1-1
        //app - java디렉터리 밑 패키지명 우클릭 - New - Kotlin Class/File
        //FileUtil.kt 클래스 생성

        //1-2
        //FileUtil.kt 클래스에 생성한 파일 데이터를 읽어오는 메서드 readTextFile(경로) 사용하기
        //내부 저장소 파일을 읽을 때 내부저장소인 filesDir과 파일명 조합으로 경로 지정
        //디렉터리와 파일명 사이를 슬래시(/)로 구분
        var readTextFIle = FileUtil()
        var content = readTextFIle.readTextFile("${filesDir}/파일명.txt")

    }//onCreate
}//MainActivity
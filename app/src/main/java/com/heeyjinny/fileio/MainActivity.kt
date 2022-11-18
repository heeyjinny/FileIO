package com.heeyjinny.fileio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.FileUtils
import android.util.Log

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
        var read = FileUtil()
        val content = read.readTextFile("${filesDir}/파일명.txt")

        //1-3
        //지정한 경로에 있는 텍스트파일 데이터를 읽어온 변수 content의 내용확인
        //Log.d("read","$content")

        //2
        //Writer 계열의 스트림을 사용하여 파일 데이터 쓰기
        //FileUtil.kt 클래스에 writeTextFile()메서드 생성

        //2-1
        //내부 저장소 파일에 텍스트 파일 쓰기
        //writeTextFile() 메서드 파라미터 3개 : 생성할 디렉터리명, 파일명, 쓸 내용
        //var write = FileUtil()
        //write.writeTextFile("newDir", "newFilename.txt", "글의 내용")

    }//onCreate
}//MainActivity
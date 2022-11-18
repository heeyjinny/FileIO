package com.heeyjinny.fileio

import android.content.Context
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



        //3
        //내부저장소 텍스트 파일 읽고 쓰는 코드 축약 ****************
        //안드로이드는 파일을 읽거나 쓸 때 스트림으로 반환해주는 메서드를 제공함
        //이 메서드들을 조합하면 앞서 만든 1,2번의 코드를 작성하지 않고
        //짧은 코드로 내부저장소의 텍스트파일을 읽고 쓸 수 있음

        //openFileInput() : 파일을 읽어서 스트림으로 반환해주는 메서드
        //openFileOutput() : 스트림으로 파일을 쓰는 메서드

        //3-1
        //파일 읽기 openFileInput()
        //파일을 읽어서 저장할 변수(readContent)선언
        var readContent = ""
        //lines에는 줄 단위의 텍스트가 저장됨
        //joinToString() 메스드로 줄마다 새줄 \n 추가 후 사용가능
//        openFileInput("파일경로").bufferedReader().useLines { lines ->
//            readContent = lines.joinToString("\n")
//        }

        //3-2
        //파일 쓰기 openFileOutput()
        //파일내용을 담을 변수(writeContent) 선언
        val writeContent = "Hello\nworld!!"
        //Context.MODE_PRIVATE : 기존 동일한 파일명 있을 시 덮어쓰기
        //Context.MODE_PRIVATE 대신에 Context.MODE_APPEND를 사용하면
        //기존에 동일한 파일명이 있을 경우 기존 내용에 이어서 새로운 내용 저장 가능
//        openFileOutput("파일명", Context.MODE_PRIVATE).use { stream ->
            //내용이 담긴 변수(writeContent)는 스트림에 쓸 때 바이트 배열로 변환해야 함(toByteArray())
//            stream.write(writeContent.toByteArray())
//        }

    }//onCreate
}//MainActivity
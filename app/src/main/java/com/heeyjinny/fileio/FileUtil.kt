package com.heeyjinny.fileio

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.FileReader
import java.io.FileWriter

class FileUtil {

    //1
    //Reader 계열의 스트림을 사용하여 파일 데이터 읽기

    //1-1
    //파라미터(fullPath)로 파일의 경로를 전달받는 메서드 생성(는)
    fun readTextFile(fullPath: String): String{

        //1-2
        //먼저 파라미터로 전달된 변수 fullPath 의 경로를 File()클래스에 넣어 파일정보를 생성하고
        //실제 경로안에 파일이 있는지 검사(exsits())
        val file = File(fullPath)
        //만약 파일경로 안에 파일이 없다면(!) 공백 값 리턴
        if (!file.exists()) return ""

        //1-3
        //스트림 파이프 생성!
        //FileReader()메서드로 파일(변수 file)을 읽어 변수(reader)에 저장하고
        //BufferedReader()에 담아 속도 향상시켜 변수(buffer)에 저장
        val reader = FileReader(file)
        val buffer = BufferedReader(reader)

        //1-4
        //한 줄씩 읽은 내용을 임시저장할 변수(temp)를 먼저 선언하고
        //모든내용을 저장하는 StringBuffer()클래스를 생성한 변수(result)선언
        var temp = ""
        val result = StringBuffer()

        //1-5
        //while 반복문을 사용해 파일의 데이터를 한줄씩 읽어 모든내용을 저장하는 코드 작성
        while (true){

            //1-6
            //파일을 읽고 속도향상까지 시켜 저장했던 파일의 데이터를 읽어서 가지고 있는
            //변수 buffer에서 데이터 한 줄을 꺼내 읽고(readLine()) 임시저장할 변수(temp)에 저장
            temp = buffer.readLine()

            //1-7
            //if 조건문을 사용해 그 값(temp)이 null이라면 더이상 읽을 데이터가 없는 뜻이므로 반복문을 빠져나가고
            //값이 있다면(null이 아니라면) 모든내용을 저장하는 클래스를 가진 result변수에 buffer를 저장 append()함
            if (temp == null) break
            else result.append(buffer)

        }

        //1-8
        //스트림 파이프 제거!
        //buffer를 닫고(close()) 결과값을 문자열로 리턴
        buffer.close()
        return result.toString()

    }//readTextFile

    //2
    //Writer 계열의 스트림을 사용하여 파일 데이터 쓰기
    //쓰기파일은 총3개의 파라미터를 사용(파일생성할 디렉터리, 파일명, 작성할내용)

    //2-1
    //3개의 파라미터를 가진 메서드(writeTextFile()) 생성
    fun writeTextFile(directory: String, filename: String, content: String){

        //2-2
        //디렉터리에 생성할 디렉터리 이름인 directory가 존재하는지 검사하고 없으면 생성
        //파일 기본 정보를 사용하는 File()클래스를 생성하여 사용
        val dir = File(directory)
        if (!dir.exists()) {
            //만약 directory이름의 파일이 존재하지 않는다면
            //디렉터리 생성 mkdirs()
            dir.mkdirs()
        }

        //2-3
        //생성된 디렉터리(directory)에 파일명(filename)을 합해
        //FileWriter 파라미터로 생성하여 변수(writer)에 저장
        //쓰기속도 향상을 위해 BufferedWriter()하여 변수(buffer)에 저장
        val writer = FileWriter("$directory/$filename")
        val buffer = BufferedWriter(writer)

        //2-4
        //변수 buffer로 내용을 쓰고 닫기 close()
        buffer.write(content)
        buffer.close()

    }//writeTextFile


}//FileUtil
package kr.co.fastcampus.part4.chapter4_8

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kr.co.fastcampus.part4.chapter4_8.ui.theme.DialogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DialogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DialogEx()
                }
            }
        }
    }
}

@Composable
fun DialogEx() {
    var openDialog by remember { mutableStateOf(false) }
    var counter by remember { mutableStateOf(0) }

    Column {
        Button(onClick = { openDialog = !openDialog }) {
            Text("다이얼로그 열기")
        }
        Text("카운터: $counter")
    }

    if (openDialog) {
        AlertDialog(onDismissRequest = {
            // 단계 1: `openDialog`를 이용해 다이얼로그를 끌 수 있게 합니다.
            openDialog = false
        }, confirmButton = {
            // 단계 2: "더하기" 버튼을 만들고 `counter`를 증가시킵니다.
            // 다이얼로그도 끕니다.
            Button(onClick = {
                counter++
                openDialog = false
            }) {
                Text("더하기")
            }

        }, dismissButton = {
            // 단계 3: "취소" 버튼을 만들고 다이얼로그를 끕니다.
            Button(onClick = {
                openDialog = false
            }) {
                Text("취소")
            }
        }, title = {
            // 단계 4: 타이틀을 만듭니다. "더하기" 정도로 해봅시다.
            Text("더하기")
        }, text = {
            // 단계 5: 다이얼로그에서 설명할 문구를 출력합니다.
            Text("더하기버튼을 누르면 카운터가 증가합니다.")
        })
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DialogTheme {
        DialogEx()
    }
}
package kr.co.fastcampus.part4.chapter4_10

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
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
import kr.co.fastcampus.part4.chapter4_10.ui.theme.DropDownMenuTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DropDownMenuTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DropDownMenuEx()
                }
            }
        }
    }
}

@Composable
fun DropDownMenuEx() {
    var expandDropDownMenu by remember { mutableStateOf(false) }
    var counter by remember { mutableStateOf(0) }

    Column {
        Button(onClick = { expandDropDownMenu = true }) {
            Text("드롭다운 메뉴 열기")
        }
        Text("카운터: $counter")
    }

    // 단계 1: `DropdownMenu`를 만들고 `expanded`를 `expandDropDownMenu`로
    // 등록합시다.
    // `onDismissRequest`에 대해서는 `expandDropDownMenu`를 `false`로 바꿉니다.
    DropdownMenu(
        expanded = expandDropDownMenu,
        onDismissRequest = {
            expandDropDownMenu = false
        }
    ) {
        DropdownMenuItem(onClick = {
            counter++
        }) {
            Text("증가")
        }
        DropdownMenuItem(onClick = {
            counter--
        }) {
            Text("감소")
        }
    }

    // 단계 2: 두개의 `DropdownMenuItem`을 등록합시다. `onClick`을 구현하고
    // 내용물은 `Text`로 채워봅시다.
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DropDownMenuTheme {
        DropDownMenuEx()
    }
}
package com.liubz.androidtea

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * @Desc: 使用 Jetpack Compose 框架编写的演示页面
 * @Author: liubaozhu
 */
class ComposeDemoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // 应用 Material 主题
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeMainScreen()
                }
            }
        }
    }
}

@Composable
fun ComposeMainScreen() {
    // 状态管理：点击计数
    var count by remember { mutableIntStateOf(0) }
    
    // 模拟数据列表
    val teaList = remember {
        listOf("西湖龙井", "碧螺春", "普洱茶", "大红袍", "铁观音", "安溪铁观音", "信阳毛尖")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Jetpack Compose 实验室",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4CAF50)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 交互按钮
        Button(
            onClick = { count++ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
        ) {
            Text("点击点赞: $count")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "名茶推荐 (LazyColumn 演示):",
            modifier = Modifier.align(Alignment.Start),
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        // 相当于高效的 RecyclerView
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(teaList) { teaName ->
                TeaItemCard(teaName)
            }
        }
    }
}

@Composable
fun TeaItemCard(name: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "🍵", fontSize = 20.sp)
            Spacer(modifier = Modifier.width(12.dp))
            Text(text = name, style = MaterialTheme.typography.bodyLarge)
        }
    }
}

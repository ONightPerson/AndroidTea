package com.liubz.androidtea.hilt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * @Desc: Hilt 注入演示 Activity
 * @Author: liubaozhu
 */
@AndroidEntryPoint
class HiltDemoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HiltMainScreen()
                }
            }
        }
    }
}

@Composable
fun HiltMainScreen(viewModel: TeaViewModel = hiltViewModel()) {
    // 观察 ViewModel 中的数据
    val teaList by viewModel.uiState.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Hilt 注入演示: 名茶录",
            style = MaterialTheme.typography.headlineMedium,
            color = Color(0xFF388E3C)
        )
        Spacer(modifier = Modifier.height(16.dp))
        
        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(teaList) { tea ->
                TeaCard(tea)
            }
        }
    }
}

@Composable
fun TeaCard(tea: TeaInfo) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "名称: ${tea.name}", style = MaterialTheme.typography.titleMedium)
            Text(text = "产地: ${tea.origin}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "种类: ${tea.type}", style = MaterialTheme.typography.bodySmall, color = Color.Gray)
        }
    }
}

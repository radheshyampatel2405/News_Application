package com.example.newsapplication.presentation.component

import android.annotation.SuppressLint
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.newsapplication.domain.model.Article

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomSheetContent(
        article: Article,
        onReadFullStoryButtonClicked: () -> Unit
                      ) {


      Surface(modifier = Modifier.padding(16.dp)) {
          Column(horizontalAlignment = Alignment.CenterHorizontally) {
              Text(text = article.title, style = MaterialTheme.typography.titleMedium)
              Spacer(modifier = Modifier.height(8.dp))
              Text(text = article.description ?: "", style = MaterialTheme.typography.bodyMedium)
              Spacer(modifier = Modifier.height(8.dp))
              ImageHolder(imageUrl = article.urlToImage)
              Spacer(modifier = Modifier.height(8.dp))
              Text(text = article.content ?: "", style = MaterialTheme.typography.bodyMedium)
              Spacer(modifier = Modifier.height(8.dp))
              Row(modifier = Modifier.fillMaxWidth(),
                  horizontalArrangement = Arrangement.SpaceBetween) {
                  Text(text = article.author ?: "",
                       style = MaterialTheme.typography.bodySmall,
                       fontWeight = FontWeight.Bold)
                  Text(text = article.source.name ?: "",
                       style = MaterialTheme.typography.bodySmall,
                       fontWeight = FontWeight.Bold)
              }
              Spacer(modifier = Modifier.height(8.dp))
              Button(modifier = Modifier.fillMaxWidth(), onClick = onReadFullStoryButtonClicked) {
                  Text(text = "Read Full Story")
              }
          }
      }
  }

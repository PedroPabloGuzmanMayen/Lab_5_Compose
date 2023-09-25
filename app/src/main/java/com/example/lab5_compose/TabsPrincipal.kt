package com.example.lab5_compose
import androidx.compose.foundation.layout.Column
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material3.Icon

import androidx.compose.material3.LeadingIconTab
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.example.lab5_compose.Navigation.TabItems
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import androidx.compose.material3.TabPosition
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import com.google.accompanist.pager.HorizontalPager
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabsPrincipal() {
    val tabs = listOf(TabItems.item_principal, TabItems.item_perfil, TabItems.item_lugares, TabItems.item_favoritos)
    val pagerState = rememberPagerState()
    Column() {
        Tabs(tabs, pagerState)
        TabsContent(tabs, pagerState)
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Tabs(tabs: List<TabItems>, pagerState: PagerState) {

    val scope = rememberCoroutineScope()
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        indicator = {
            tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
                )
        }
    ) {
        tabs.forEachIndexed { index, tabItems ->
            LeadingIconTab(selected = pagerState.currentPage==index ,
                onClick = {scope.launch{
                    pagerState.animateScrollToPage(index)
                }},
                icon = {
                       Icon(painter = rememberVectorPainter(image = tabItems.Icon), contentDescription = "")
                },
                text = { Text(tabItems.Title)})
        }

    }
}
@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabsContent(tabs: List<TabItems>, pagerState: PagerState){
    HorizontalPager(state = pagerState,count = tabs.size ) {
        page ->
        tabs[page].screen()
    }
}
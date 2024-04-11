package com.igor_shaula.complex_api_client_sample.ui.elements

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.igor_shaula.complex_api_client_sample.R
import com.igor_shaula.complex_api_client_sample.ui.MainViewModel

@Composable
fun TheAppScreen(hideKeyboard: () -> Unit) {

    val viewModel: MainViewModel = viewModel()
    viewModel.setFreshStart()

    Scaffold(
        topBar = {
            TopBarUI(viewModel.searchQueryForUI) { query, isForced ->
                viewModel.updateSearchRequest(query, isForced)
            }
        }
    ) { innerPadding -> // use this thing somehow - because warning emerges if it's not used
        println("innerPadding = $innerPadding")
        // decided to not to use "when" statement as it takes more space
        if (viewModel.isBusyState) {
            CustomizedBusyIndicator()
        } else if (viewModel.isFreshStart) {
            CustomizedExplanation(theText = stringResource(R.string.firstLaunchExplanation))
        } else if (viewModel.errorInfo.isNotBlank()) {
            CustomizedExplanation(
                theText = stringResource(id = R.string.errorStateInfo) + viewModel.errorInfo
            )
        } else if (viewModel.vehiclesList.isEmpty()) {
            CustomizedExplanation(theText = stringResource(R.string.emptyListExplanation))
        } else {
            VehiclesList(viewModel.vehiclesList, hideKeyboard)
        }
    }
}
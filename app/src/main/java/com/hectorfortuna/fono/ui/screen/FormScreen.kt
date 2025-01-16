package com.hectorfortuna.fono.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.hectorfortuna.fono.R
import com.hectorfortuna.fono.ui.components.BirthDateTextField
import com.hectorfortuna.fono.ui.theme.FonoTheme
import com.hectorfortuna.fono.viewmodel.FormViewModel

@Composable
fun FormScreen(viewModel: FormViewModel = hiltViewModel<FormViewModel>()) {

    Column(
        modifier = Modifier
            .padding(16.dp, 16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = stringResource(id = R.string.form_title),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.displaySmall
        )
        Spacer(modifier = Modifier.padding(8.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = stringResource(id = R.string.add_name),
                    style = MaterialTheme.typography.bodyLarge
                )


                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = viewModel.patientName,
                    onValueChange = { viewModel.patientName = it },
                    placeholder = { Text(text = "Nome") }
                )
            }

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = stringResource(id = R.string.add_age),
                    style = MaterialTheme.typography.bodyLarge
                )


                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = viewModel.patientAge,
                    onValueChange = { viewModel.patientAge = it },
                    placeholder = { Text(text = "Idade") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
            }


        }
        Spacer(modifier = Modifier.padding(4.dp))

        BirthDateTextField { viewModel.birthDate = it }

        Spacer(modifier = Modifier.padding(4.dp))

        Text(
            text = stringResource(id = R.string.add_parents),
            style = MaterialTheme.typography.bodyLarge
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            TextField(
                modifier = Modifier
                    .weight(1f),
                value = viewModel.fatherName,
                onValueChange = { viewModel.fatherName = it },
                placeholder = { Text(text = "Nome do pai") }
            )

            TextField(
                modifier = Modifier
                    .weight(1f),
                value = viewModel.motherName,
                onValueChange = { viewModel.motherName = it },
                placeholder = { Text(text = "Nome da mãe") }
            )
        }

        Spacer(modifier = Modifier.padding(4.dp))

        Text(
            text = stringResource(id = R.string.add_career),
            style = MaterialTheme.typography.bodyLarge
        )

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = viewModel.career,
            onValueChange = { viewModel.career = it },
            placeholder = { Text(text = "Profissão") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.padding(4.dp))

        Text(
            text = stringResource(id = R.string.add_address),
            style = MaterialTheme.typography.bodyLarge
        )

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = viewModel.address,
            onValueChange = { viewModel.address = it },
            placeholder = { Text(text = "Endereço") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.padding(4.dp))
        Text(
            text = stringResource(id = R.string.add_phone),
            style = MaterialTheme.typography.bodyLarge
        )

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = viewModel.phone,
            onValueChange = { viewModel.phone = it },
            placeholder = { Text(text = "Telefone") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.padding(16.dp))

        Button(
            onClick = { viewModel.sendFormData() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Enviar")
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun FormScreenPreview() {
    FonoTheme {
        FormScreen()
    }
}
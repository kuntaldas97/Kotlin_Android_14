package com.example.unitconveter

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unitconveter.ui.theme.UnitConveterTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConveterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnitConverter()
                }
            }
        }
    }
}
@Composable
fun UnitConverter(){
    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var inputUnit by remember { mutableStateOf("Meters") }
    var outputUnit by remember { mutableStateOf("Meters") }
    var iExpand by remember { mutableStateOf(false) }
    var oExpand by remember { mutableStateOf(false) }
    var conversionFactor =remember { mutableStateOf(1.00) }
    var oConversionFactor=remember{ mutableStateOf(1.00) }


    val customTextStyle = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontSize = 32.sp,
        color = Color.Red
    )
    fun convertUnit(){
        //:? elvis operator
        val inputValueDouble = inputValue.toDoubleOrNull() ?: 0.0
        val result = (inputValueDouble * conversionFactor.value * 100.0/oConversionFactor.value).roundToInt()/100.0
        outputValue=result.toString()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
      // Here all UI elements will be stacked below each other
        Text(text = "Unit Converter",style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = inputValue ,
            onValueChange = {
                inputValue=it
                convertUnit()
            // Here goes what should happen when the OutlinedTextField Changes
        },
            label = {Text("Enter Value")})
        Spacer(modifier = Modifier.height(16.dp))
        Row {
        //  Here all UI elements will be stacked beside each other
            //Input Box
            Box {
                // Input Button
                Button(onClick = { iExpand=true }) {
                    Text(text=inputUnit)
                    Icon(Icons.Default.ArrowDropDown,
                        contentDescription ="Arrow Down")
                }
                DropdownMenu(expanded = iExpand, onDismissRequest = { iExpand=false }) {
                    DropdownMenuItem(text = { Text("Millimeters") },
                        onClick = {
                            iExpand=false
                            inputUnit="Millimeters"
                            conversionFactor.value=0.001
                            convertUnit()
                        })
                    DropdownMenuItem(text = { Text("Centimeters") },
                        onClick = {
                            iExpand=false
                            inputUnit="Centimeters"
                            conversionFactor.value=0.01
                            convertUnit()
                        })
                    DropdownMenuItem(text = { Text("Meters") },
                        onClick = {
                            iExpand=false
                            inputUnit="Meters"
                            conversionFactor.value=1.00
                            convertUnit()
                        })
                    DropdownMenuItem(text = { Text("Feet") },
                        onClick = {
                            iExpand=false
                            inputUnit="Feet"
                            conversionFactor.value=0.3048
                            convertUnit()
                        })
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            //Output Box
            Box {
                // Output Button
                Button(onClick = { oExpand=true }) {
                    Text(text=outputUnit)
                    Icon(Icons.Default.ArrowDropDown,
                        contentDescription ="Arrow Down")
                }
                DropdownMenu(expanded = oExpand, onDismissRequest = { oExpand=false }) {
                    DropdownMenuItem(text = { Text("Millimeters") },
                        onClick = {
                            oExpand=false
                            outputUnit="Millimeters"
                            oConversionFactor.value=0.001
                            convertUnit()
                        })
                    DropdownMenuItem(text = { Text("Centimeters") },
                        onClick = {
                            oExpand=false
                            outputUnit="Centimeters"
                            oConversionFactor.value=0.01
                            convertUnit()
                        })
                    DropdownMenuItem(text = { Text("Meters") },
                        onClick = {
                            oExpand=false
                            outputUnit="Meters"
                            oConversionFactor.value=1.00
                            convertUnit()
                        })
                    DropdownMenuItem(text = { Text("Feet") },
                        onClick = {
                            oExpand=false
                            outputUnit="Feet"
                            oConversionFactor.value=0.3048
                            convertUnit()
                        })
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Result: ${outputValue} ${outputUnit}",
            style = MaterialTheme.typography.headlineMedium)
    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview(){
    UnitConverter()
}
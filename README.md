<h2 align="center">Searchable-Dropdown-Menu-Jetpack-Compose</h2> </br>

<p align="center">
:rocket: A Jetpack Compose Multiplatform Library to create a dropdown menu that is searchable.
</p> </br>
<p align="center">
    Forked from <a href="https://github.com/Breens-Mbaka/Searchable-Dropdown-Menu-Jetpack-Compose/">Searchable Dropdown Compose</a>
</p> <br>

I found the original library and thought it was pretty cool, I wanted to use it on iOS so decided to migrate it to Compose Multiplatform.

## Implementation

### Version catalog

If you're using a version catalog then add the following to your `libs.versions.toml` file:

```toml
[versions]
#...
dropdown = "1.1.0"

[libraries]
#...
searchable-dropdown = { module = "io.github.user154lt:searchable-dropdown", version.ref = "dropdown" }
```

Then add the following to your module level `build.gradle.kts` dependencies block

```gradle
dependencies {
    implementation(libs.searchable.dropdown)
}  
```

### Gradle

Alternatively you can add the following to your module level `build.gradle.kts` dependencies block 

```gradle
dependencies {
    implementation("io.github.user154lt:searchable-dropdown:1.1.0")
}
```
---
*Original readme follows:*
---

### Usage

``` Kotlin
val sports = mutableListOf("Basketball", "Rugby", "Football", "MMA", "Motorsport", "Snooker", "Tennis")

SearchableExpandedDropDownMenu(
listOfItems = sports // provide the list of items of any type you want to populated in the dropdown,
modifier = Modifier.fillMaxWidth(),
onDropDownItemSelected = { item -> // Returns the item selected in the dropdown
      Toast.makeText(applicationContext, item, Toast.LENGTH_SHORT).show()
    },
enable = // controls the enabled state of the OutlinedTextField
placeholder = "Select option" // Add your preferred placeholder name,
openedIcon = // Add your preffered icon when the dropdown is opened,
closedIcon = // Add your preffered icon when the dropdown is closed,
parentTextFieldCornerRadius = // By default the corner radius is 12.dp but you can customize it,
colors = // Customize the colors of the input text, background and content used in a text field in different states
dropdownItem = { name -> // Provide a Composable that will be used to populate the dropdown and that takes a type i.e String,Int or even a custom type
      Text(name)
   },
selectedDisplayText = {} // Optional: Returns the selected item and allow mapping it to a custom display text. If no mapping provided, item.toString() will be used by default   
)
```

``` Kotlin
LargeSearchableDropdownMenu(
    // List of options to display in the dropdown menu
    options = listOf("Option 1", "Option 2"),

    // Currently selected option; null means no option is selected initially
    selectedOption = null,

    // Lambda function to handle when an item is selected
    // The selected item is passed as a parameter to this function
    onItemSelected = { selected -> 
        println("Selected: $selected") // Replace with your desired action
    },

    // Placeholder text shown when no item is selected
    placeholder = "Select an option",

    // Title displayed at the top of the dropdown menu
    title = "Dropdown Title",

    // Custom drawing of dropdown items
    // Each item can have its own appearance and behavior
    drawItem = { item, _, _, onClick ->
        // Define how each dropdown item looks and behaves
        DropdownMenuItem(onClick = onClick) {
            Text(item.toString()) // Display the item's string representation
        }
    }
)
```


### Who's using Searchable-Dropdown-Menu-Jetpack-Compose?
If your project uses Searchable-Dropdown-Menu-Jetpack-Compose, please let me know by creating a new issue! 😊

### Inspiration

> The library was majorly created out of necessity at work by my colleagues and I, since they isn't an out of the box solution in Jetpack compose to have a searchable dropdown menu.

### Find this repository useful? :heart:
Support it by joining __[stargazers](https://github.com/Breens-Mbaka/Searchable-Dropdown-Menu-Jetpack-Compose/stargazers)__ for this repository. :star: <br>
Also __[follow](https://github.com/Breens-Mbaka)__ me for my next creations! 🤩

### License

```
Copyright 2022 Breens-Mbaka

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

# amphibians-compose
This project for learning Jetpack Compose #JuaraAndroid

![Screenshot_20231105_121347](https://github.com/primajatnika27/amphibians-compose/assets/51253537/20c2aa9e-6259-47aa-90a8-b452750cd698)

# Project Tree
```bash
app/src/main/java/com/prima/amphibians
├── AmphibiansApplication.kt
├── MainActivity.kt
├── data
│   ├── AmphibiansRepository.kt
│   └── AppContainer.kt
├── model
│   └── Amphibians.kt
├── network
│   └── ApiService.kt
└── ui
    ├── AmphibiansApp.kt
    ├── screen
    │   └── HomeScreen.kt
    ├── theme
    │   ├── Color.kt
    │   ├── Theme.kt
    │   └── Type.kt
    ├── uistate
    │   └── AmphibiansUiState.kt
    └── viewmodel
        └── AmphibiansViewModel.kt
```

# LIBRARY USSING
| Category                | Library Name                                                             | Link |
|-------------------------|--------------------------------------------------------------------------|------|
| Viewmodel               | androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1                     |      |
| Serialization Converter | com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:1.0.0 |      |
| OK HTTP                 | com.squareup.okhttp3:okhttp:4.11.0                                       |      |
| Retrofit                | com.squareup.retrofit2:retrofit:2.9.0                                    |      |
| Coil                    | io.coil-kt:coil-compose:2.4.0                                            |      |
| Serialization JSON      | org.jetbrains.kotlinx:kotlinx-serialization-json                         |      |

# CREATE DI
Create AppContainer
![Pasted Graphic](https://github.com/primajatnika27/amphibians-compose/assets/51253537/3672c669-1cba-42be-89d6-413f99017724)

Create Repository
![Pasted Graphic 1](https://github.com/primajatnika27/amphibians-compose/assets/51253537/e8583221-36c9-463d-bd54-193826d40386)

Create Service
![Pasted Graphic 2](https://github.com/primajatnika27/amphibians-compose/assets/51253537/c24a3644-90ea-4b2b-b5e7-f923fcdc528c)

Create Application from DI
![Pasted Graphic 3](https://github.com/primajatnika27/amphibians-compose/assets/51253537/1834f481-2c75-48a2-ab03-2019d2f7c584)

**DATA AND UI LAYER STRUCTURE**
![Data Layer](https://github.com/primajatnika27/amphibians-compose/assets/51253537/818dbf56-3336-458f-8516-1cc713750efd)


Create Viewmodel
![Pasted Graphic 5](https://github.com/primajatnika27/amphibians-compose/assets/51253537/12196bb5-7a2f-4c73-a029-7b24e122d025)

Viewmodel init 
![Pasted Graphic 6](https://github.com/primajatnika27/amphibians-compose/assets/51253537/388cc97b-8ab6-4c95-a2c6-1fe2750f62a3)


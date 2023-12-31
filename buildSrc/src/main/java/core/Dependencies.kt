package core

internal object Dependencies {
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtxVersion}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val activity = "androidx.activity:activity-ktx:1.7.0"

    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}"
    const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleVersion}"
    const val lifecycleCommon = "androidx.lifecycle:lifecycle-common:${Versions.lifecycleVersion}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleVersion}"
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleExtensionVersion}"

    val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hiltVersion}"
    val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hiltVersion}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.moshiConverter}"
    const val okhHttp3 = "com.squareup.okhttp3:okhttp:${Versions.okhttp3Version}"
    const val okhHttp3Interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp3Version}"

    const val moshi = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    const val moshiCodegen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"

    const val kotlinCoroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVersion}"
    const val kotlinCoroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesVersion}"
    const val leakcanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakcanaryVersion}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timberVersion}"


    const val room = "androidx.room:room-runtime:2.5.1"
    const val roomCompiler = "androidx.room:room-compiler:2.5.1"
    const val roomKtx = "androidx.room:room-ktx:2.5.1"
    const val roomPaging = "androidx.room:room-paging:2.5.1"

    const val multidex = "androidx.multidex:multidex:2.0.1"

    //const val jUnit = "androidx.compose.ui:ui-test-junit4:${Versions.composeVersion}"
    const val jUnit = "junit:junit:4.13.2"
    const val jUnitExt = "androidx.test.ext:junit:${Versions.jUnitExtVersion}"
    const val jUnitExtKtx = "androidx.test.ext:junit-ktx:1.1.3"
    //const val jUnitTestUi = "androidx.compose.ui:ui-test-junit4:${Versions.composeVersion}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoCoreVersion}"
//    const val composeTooling = "androidx.compose.ui:ui-tooling:${Versions.composeVersion}"
//    const val composeTestManifest = "androidx.compose.ui:ui-test-manifest:${Versions.composeVersion}"

    const val googleTruth = "com.google.truth:truth:1.1.3"
    const val mockitoCore = "org.mockito:mockito-core:3.11.2"
    const val mockitoInline = "org.mockito:mockito-inline:3.11.2"
    const val archCore = "androidx.arch.core:core-testing:2.1.0"
    const val archTestCore = "androidx.test:core-ktx:1.4.0"
    const val roboelectric = "org.robolectric:robolectric:4.7"
    const val testRunner = "androidx.test:runner:1.4.0"
    const val testRules = "androidx.test:rules:1.4.0"

    const val kotlinCoroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.4.2"
    const val dexmakerMockito = "com.linkedin.dexmaker:dexmaker-mockito-inline:2.28.1"
    const val mockitoAndroid = "org.mockito:mockito-android:3.11.2"

}
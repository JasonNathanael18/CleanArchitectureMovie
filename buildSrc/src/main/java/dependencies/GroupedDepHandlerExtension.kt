package dependencies
import core.Dependencies
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.addAndroidUiDependencies(){
    androidUiDependencies.forEach {
        add("implementation",it)
    }
}

fun DependencyHandler.addAndroLifeCycleDependencies(){
    androidxLifeCycleDependencies.forEach {
        add("implementation",it)
    }
}

fun DependencyHandler.addHiltDependencies() {
    add("implementation",Dependencies.hiltAndroid)
    add("kapt",Dependencies.hiltCompiler)
}

fun DependencyHandler.addNetworkDependencies(configurationName:String = "implementation"){
    networkDependencies.forEach {
        add(configurationName,it)
    }
}

fun DependencyHandler.addMoshiDependencies() {
    add("implementation",Dependencies.moshi)
    add("kapt",Dependencies.moshiCodegen)
}

fun DependencyHandler.addCoroutinesAndroidDependencies(){
    coroutinesAndroidDependencies.forEach {
        add("implementation",it)
    }
}

fun DependencyHandler.addRoomDependencies() {
    add("implementation",Dependencies.room)
    add("implementation",Dependencies.roomKtx)
    add("implementation",Dependencies.roomPaging)
    add("kapt",Dependencies.roomCompiler)
}

fun DependencyHandler.addMultiDexDependencies(configurationName:String = "implementation"){
    add(configurationName,Dependencies.multidex)
}

fun DependencyHandler.addTimberDependencies(configurationName:String = "implementation"){
    add(configurationName,Dependencies.timber)
}

fun DependencyHandler.addLeakcanaryDependencies(){
    add("debugImplementation",Dependencies.leakcanary)
}

fun DependencyHandler.addAndroidTestsDependencies() {
    add("testImplementation",Dependencies.jUnit)
    //add("androidTestImplementation",Dependencies.jUnitTestUi)
    add("androidTestImplementation",Dependencies.jUnitExt)
    add("androidTestImplementation",Dependencies.espresso)
    //add("debugImplementation",Dependencies.composeTooling)
    //add("debugImplementation",Dependencies.composeTestManifest)
}

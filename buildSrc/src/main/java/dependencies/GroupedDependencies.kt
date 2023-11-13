package dependencies
import core.Dependencies

internal val androidUiDependencies = listOf(
    Dependencies.coreKtx,
    Dependencies.appcompat,
    Dependencies.material,
    Dependencies.constraintLayout,
    Dependencies.activity
)

internal val androidComposeDependencies = listOf(
    Dependencies.coreKtx,
    Dependencies.composeMaterial,
    Dependencies.composeActivity,
    Dependencies.composeUi,
    Dependencies.composePreviewUi,
    Dependencies.composeNavigation,
    Dependencies.material3,
)

internal val androidxLifeCycleDependencies = listOf(
    //Dependencies.lifecycleViewModel,
    Dependencies.viewModel,
    Dependencies.lifecycleLiveData,
    Dependencies.lifecycleCommon,
   // Dependencies.lifecycleRuntime,
    Dependencies.runtimeCompose,
    Dependencies.lifecycleExtensions,
)

internal val coroutinesAndroidDependencies = listOf(
    Dependencies.kotlinCoroutines,
    Dependencies.kotlinCoroutinesCore
)

internal val networkDependencies = listOf(
    Dependencies.retrofit,
    Dependencies.moshiConverter,
    Dependencies.okhHttp3,
    Dependencies.okhHttp3Interceptor,
)



